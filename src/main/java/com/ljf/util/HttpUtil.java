package com.ljf.util;

import org.apache.commons.io.IOUtils;
import org.apache.http.Header;
import org.apache.http.HttpEntity;
import org.apache.http.client.HttpClient;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicHeader;
import org.apache.log4j.Logger;

import javax.swing.text.html.parser.Entity;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class HttpUtil {
    private static final Logger log = Logger.getLogger(HttpUtil.class);

    public static String sendPost(String url, Map<String, Object> headerMap){
        headerMap.forEach((key, value) ->{
            log.info("header**"+key+ ";value**"+value);
        });
        RequestConfig requestConfig = RequestConfig.custom().setConnectTimeout(5000).setConnectionRequestTimeout(5000)
                .setSocketTimeout(5000).build();
        CloseableHttpClient closeableHttpClient = HttpClients.custom().setDefaultRequestConfig(requestConfig).build();
        HttpPost httpPost = new HttpPost(url);
        httpPost.setHeaders(buildHeader(headerMap));
        try {
            CloseableHttpResponse response = closeableHttpClient.execute(httpPost);
            HttpEntity entity = response.getEntity();
            InputStream is = entity.getContent();
            String content = IOUtils.toString(is);
            return content;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    private static Header[] buildHeader(Map<String,Object> headerMap) {
        if(headerMap == null){
            return null;
        }
        List<Header> headerList = new ArrayList<Header>();
        for(Map.Entry<String, Object> entry :headerMap.entrySet()){
            Header header = new BasicHeader(entry.getKey(), entry.getValue().toString());
            headerList.add(header);
        }
        return headerList.toArray(new Header[headerMap.size()]);
    }

    public static void queryLxxiangInfo(){
        Map<String, Object>header = new HashMap<>();
        header.put("Cookie","test_ccwv_session2=1; ccwv_session=g2fkokie4xzheprdk64o0a00");
        header.put("Upgrade-Insecure-Requests","1");
        header.put("Accept","text/html,application/xhtml+xml,application/xml;q=0.9,*/*;q=0.8");
        header.put("User-Agent","Mozilla/5.0 (iPhone; CPU iPhone OS 12_1_4 like Mac OS X) AppleWebKit/605.1.15 (KHTML, like Gecko) Mobile/16D57 MicroMessenger/7.0.3(0x17000321) NetType/WIFI Language/zh_CN");
        header.put("Referer","http://www.lzxxiang.com/love/wap/mxzone.aspx?id=18644");
        header.put("Accept-Language","zh-cn");
        String content = sendPost("http://www.lzxxiang.com/love/wap/showself.aspx?UserId=18640",header);
        System.out.println(content);
    }

    public static void main(String[]args){
        queryLxxiangInfo();
    }
}
