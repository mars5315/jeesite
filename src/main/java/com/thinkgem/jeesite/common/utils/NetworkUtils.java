package com.thinkgem.jeesite.common.utils;

import java.io.IOException;

import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

public class NetworkUtils {
	
	public static String sendGet(String url) {
		CloseableHttpClient httpCilent = HttpClients.createDefault();
		RequestConfig config = RequestConfig.custom().
        		setConnectionRequestTimeout(10000 ).setConnectTimeout(10000 )
        		.setSocketTimeout(10000 )
        		.build();
		HttpGet httpGet = new HttpGet(url);
        httpGet.setConfig(config);
        String srtResult = "";
        try {
        	CloseableHttpResponse httpResponse = httpCilent.execute(httpGet);
            if(httpResponse.getStatusLine().getStatusCode() == 200){
                srtResult = EntityUtils.toString(httpResponse.getEntity(),"UTF-8");//获得返回的结果
            }else if(httpResponse.getStatusLine().getStatusCode() == 400){
                //..........
            }else if(httpResponse.getStatusLine().getStatusCode() == 500){
                //.............
            }
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            try {
                httpCilent.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
		return srtResult;
	}

}
