package com.ljf.util;

import org.apache.http.client.HttpClient;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.log4j.Logger;

import java.util.List;
import java.util.Map;

public class HttpUtil {
    private static final Logger log = Logger.getLogger(HttpUtil.class);

    public Object sendPost(String url, Map<String, Object> headerMap){
        headerMap.forEach((key, value) ->{
            log.info("header**"+key+ ";value**"+value);
        });
        RequestConfig requestConfig = RequestConfig.custom().setConnectTimeout(5000).setConnectionRequestTimeout(5000)
                .setSocketTimeout(5000).build();
        CloseableHttpClient closeableHttpClient = HttpClients.custom().setDefaultRequestConfig(requestConfig).build();
        HttpPost httpPost = new HttpPost(url);
        buildHeader(headerMap);
        return null;
    }

    private void buildHeader(Map<String,Object> headerMap) {
        if(headerMap == null){
            return null;
        }
        List<Header> headerList = new ArrayList<Header>();
    }
}
