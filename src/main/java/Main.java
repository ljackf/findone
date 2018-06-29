import com.mongodb.BasicDBObject;
import com.mongodb.DBCollection;
import com.mongodb.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import info.bitrich.xchangestream.bitfinex.BitfinexStreamingExchange;
import info.bitrich.xchangestream.bitmex.BitmexStreamingExchange;
import info.bitrich.xchangestream.core.StreamingExchange;
import info.bitrich.xchangestream.core.StreamingExchangeFactory;
import org.bson.conversions.Bson;
import org.knowm.xchange.Exchange;
import org.knowm.xchange.ExchangeFactory;
import org.knowm.xchange.bitstamp.BitstampExchange;
import org.knowm.xchange.currency.CurrencyPair;
import org.knowm.xchange.dto.marketdata.Ticker;
import org.knowm.xchange.service.marketdata.MarketDataService;
import org.quartz.Scheduler;
import org.quartz.SchedulerException;
import org.quartz.SchedulerFactory;
import org.quartz.impl.StdScheduler;
import org.quartz.impl.StdSchedulerFactory;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Date;

public class Main {

    public static void main(String[] args) throws IOException {
        Exchange bitstamp = ExchangeFactory.INSTANCE.createExchange(BitstampExchange.class.getName());

        MarketDataService marketDataService = bitstamp.getMarketDataService();

        Ticker ticker = marketDataService.getTicker(CurrencyPair.BTC_USD);
        System.out.println(ticker.toString());

//        File file = new File("/Users/liujiefeng/Downloads/chbtcCNY.csv");
//        FileInputStream fileInputStream = new FileInputStream(file);
//        BufferedInputStream bufferedInputStream = new BufferedInputStream(fileInputStream);
//        byte[]buffer = new byte[1024];
//        MongoClient mongoClient = new MongoClient("localhost", 27017);
//        MongoDatabase mongoDatabase = mongoClient.getDatabase("ecd");
//        MongoCollection mongoCollection = mongoDatabase.getCollection("chbtccny");
//        while (bufferedInputStream.read(buffer,0,1023)!=-1) {
//            String r = new String(buffer);
//            System.out.println(r);
//            BasicDBObject basicDBObject = new BasicDBObject();
//            mongoCollection.insertOne(basicDBObject.append("data", ).append("price", ).append("amount", ));
//        }

//        try {
//            Scheduler scheduler = StdSchedulerFactory.getDefaultScheduler();
//            scheduler.start();
//        } catch (SchedulerException e) {
//            e.printStackTrace();
//        }
        StreamingExchange streamingExchange = StreamingExchangeFactory.INSTANCE.createExchange(BitfinexStreamingExchange.class.getName());
        streamingExchange.connect().blockingAwait();
        streamingExchange.getStreamingMarketDataService().getTicker(CurrencyPair.BTC_USD).subscribe(ticker1 ->{
               System.out.println(ticker1);
        },Throwable->{

        });
    }


}
