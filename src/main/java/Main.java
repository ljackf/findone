import com.mongodb.*;

import java.io.IOException;
import java.sql.*;
import java.util.Date;
import java.util.concurrent.Future;
import java.util.concurrent.FutureTask;


public class Main {

    public static void main(String[] args) throws IOException, InterruptedException {
//        Exchange bitstamp = ExchangeFactory.INSTANCE.createExchange(BitstampExchange.class.getName());
//
//        MarketDataService marketDataService = bitstamp.getMarketDataService();
//
//        Ticker ticker = marketDataService.getTicker(CurrencyPair.BTC_USD);
//        System.out.println(ticker.toString());

//        File file = new File("/Users/liujiefeng/Downloads/chbtcCNY.csv");
//        FileInputStream fileInputStream = new FileInputStream(file);
//        BufferedInputStream bufferedInputStream = new BufferedInputStream(fileInputStream);
//        byte[]buffer = new byte[1024];
        MongoClient mongoClient = new MongoClient("localhost", 27017);
        DB mongoDatabase = mongoClient.getDB("ecds");
        DBCollection mongoCollection = mongoDatabase.getCollection("bitaloEUR");
        String map = "function(){\n" +
                " var date = new Date(this.timestamp*1000);\n" +
                "    var dateKey = \"\"+date.getFullYear()+\"-\"+(date.getMonth()+1)+\"-\"+date.getDate();\n" +
                "    emit(dateKey, 1); \n" +
                "}";
        String reduce = "function (key, values) {\n" +
                "var count=0;"+
                " for (var i = 0; i < values.length; i++) {\n" +
                "        count +=1;\n" +
                "    }\n" +
                "return count;"+
                "}";
        MapReduceCommand cmd = new MapReduceCommand(mongoCollection, map, reduce,
                null, MapReduceCommand.OutputType.INLINE, null);

        MapReduceOutput out = mongoCollection.mapReduce(cmd);
        System.out.println(out.results().toString());
        Statement statement = null;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection connection = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/ecds?user=root&password=6zeb4s3mt");
            statement = connection.createStatement();
            for (DBObject o : out.results()) {
                System.out.println(o.toString());
                statement.execute("insert btc_data_history (date, amount) VALUES ('"+ o.get("_id") +"',"+ o.get("value") +")");
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }catch (SQLException e) {
            e.printStackTrace();
        }
        Future a = new FutureTask(new Runnable() {
            @Override
            public void run() {

            }
        },"") ;
//        try {
//            Scheduler scheduler = StdSchedulerFactory.getDefaultScheduler();
//            scheduler.start();
//        } catch (SchedulerException e) {
//            e.printStackTrace();
//        }
//        StreamingExchange streamingExchange = StreamingExchangeFactory.INSTANCE.createExchange(BitfinexStreamingExchange.class.getName());
//        streamingExchange.connect().blockingAwait();
//        streamingExchange.getStreamingMarketDataService().getTicker(CurrencyPair.BTC_USD).subscribe(ticker1 ->{
//               System.out.println(ticker1);
//        },Throwable->{
//
//        });
//        StreamingExchange exchange = StreamingExchangeFactory.INSTANCE.createExchange(OkCoinStreamingExchange.class.getName());

// Connect to the Exchange WebSocket API. Blocking wait for the connection.
//        exchange.connect().blockingAwait();
// Subscribe to live trades update.
//        exchange.getStreamingMarketDataService()
//                .getTicker(CurrencyPair.BTC_USD)
//                .subscribe(trade -> {
//                    System.out.println(new Date()+"Incoming trade: {}"+ trade);
//                }, throwable -> {
//                    LOG.error("Error in subscribing trades.", throwable);
//                });
// Subscribe order book data with the reference to the subscription.
//        Disposable subscription = exchange.getStreamingMarketDataService()
//                .getOrderBook(CurrencyPair.BTC_USD)
//                .subscribe(orderBook -> {
//                    // Do something
//                });

// Unsubscribe from data order book.
//        subscription.dispose();

// Disconnect from exchange (non-blocking)
//        exchange.disconnect().subscribe(() -> LOG.info("Disconnected from the Exchange"));
    }


}
