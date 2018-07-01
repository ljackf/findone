<%@ page import="java.sql.Connection" %>
<%@ page import="java.sql.DriverManager" %>
<%@ page import="java.sql.Statement" %>
<%@ page import="java.sql.ResultSet" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="java.util.List" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html lang="en">
<head>
    <title>Title</title>
    <script src="/js/echarts.js"></script>
</head>
<%!
    String x_date;
    String y_amount;
%>
<%
    try{
        Class.forName("com.mysql.cj.jdbc.Driver");
        Connection connection = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/ecds?user=root&password=6zeb4s3mt&serverTimezone=UTC");
        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery("select * from btc_data_history ORDER by date");
        List dates = new ArrayList<>();
        List amounts = new ArrayList();
        while (resultSet.next()){
            String date = resultSet.getString("date");
            dates.add(date);
            String amount = resultSet.getString("amount");
            amounts.add(amount);
        }
        x_date = dates.toString();
        y_amount = amounts.toString();
    }catch (Exception r){
        r.printStackTrace();
    }
%>
<body>
    <div id="main" style="width: 100%;height:100%;"></div>
    <script type="text/javascript">
        // 基于准备好的dom，初始化echarts实例
        var myChart = echarts.init(document.getElementById('main'));
        // 指定图表的配置项和数据
        var option = {
            xAxis: {
                type: 'category',
                axisLabel:{
                    interval:0
                },
                data: <%= x_date%>
            },
            yAxis: {
                type: 'value'
            },
            series: [{
                data: <%= y_amount%>,
                type: 'line'
            }]
        };

        // 使用刚指定的配置项和数据显示图表。
        myChart.setOption(option);
    </script>
</body>
</html>