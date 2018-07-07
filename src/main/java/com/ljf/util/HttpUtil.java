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
        httpPost.setHeaders(buildHeader(headerMap));
        try {
            CloseableHttpResponse response = closeableHttpClient.execute(httpPost);
            HttpEntity entity = response.getEntity();
            InputStream is = entity.getContent();
            String content = IOUtils.toString(is);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    private Header[] buildHeader(Map<String,Object> headerMap) {
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
}
