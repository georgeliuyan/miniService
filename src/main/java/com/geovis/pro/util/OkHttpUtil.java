package com.geovis.pro.util;

import java.io.IOException;

import okhttp3.HttpUrl;
import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

/**
 * @author 
 * @description okHttpClient封装
 * @date 2018-10-08 14:47
 * @created by eclipse
 */
public class OkHttpUtil {
	public static final MediaType type = MediaType.parse("application/x-www-form-urlencoded;charset=utf-8");
    public static final OkHttpClient httpClient = new OkHttpClient();
    //Get方法调用服务
    public static String httpGet(HttpUrl url) throws IOException{
        Request request = new Request.Builder()
                .url(url)
                .build();
        Response response = httpClient.newCall(request).execute();
        return response.body().string();// 返回的是string 类型
    }
    //Post方法调用服务
    public static String httpPost(HttpUrl url,String content) throws IOException{
        RequestBody requestBody = RequestBody.create(type,content);
        Request request = new Request.Builder()
                .url(url)
                .post(requestBody)
                .build();
        Response response = httpClient.newCall(request).execute();
        return response.body().string();
    }	
}
