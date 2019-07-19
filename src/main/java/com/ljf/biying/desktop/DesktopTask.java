package com.ljf.biying.desktop;

import com.sun.xml.internal.messaging.saaj.util.ByteInputStream;
import org.apache.http.HttpEntity;
import org.apache.http.NameValuePair;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;

import java.io.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Random;

/**
 * @author liujf05
 * @date 2019/7/15
 */
public class DesktopTask {
    public static void main(String[] args) throws IOException {
        RequestConfig requestConfig = RequestConfig.custom().setConnectTimeout(8000)
                .setConnectionRequestTimeout(8000).setSocketTimeout(8000).build();
        CloseableHttpClient httpclient = HttpClients.custom().setDefaultRequestConfig(requestConfig).build();
        HttpGet httpGet = new HttpGet("https://area.sinaapp.com/bingImg");
        CloseableHttpResponse response1 = httpclient.execute(httpGet);
        try {
            System.out.println(response1.getStatusLine().getStatusCode());
            HttpEntity entity1 = response1.getEntity();
            InputStream in = entity1.getContent();


            Date now = new Date();
            StringBuffer fileName = new StringBuffer();
            String fileNameStr = fileName.append(now.getYear()).append(now.getMonth()).append(now.getDay()).toString();
            File file = new File("C:\\Users\\liujf05\\Desktop\\biyingimg\\"+fileNameStr+".png");
            if(!file.exists()){
                file.createNewFile();
                byte b[] = new byte[32*1024];
                int j = 0;
                FileOutputStream os = new FileOutputStream(file);
                while( (j = in.read(b)) != -1 )
                {
                    os.write(b,0,j);
                }

                if (os != null)
                {
                    os.close();
                }
                os.close();
            }
            in.close();
        } finally {
            response1.close();
        }

    }
}
