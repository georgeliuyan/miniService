package com.geovis.pro.rest;

import java.io.IOException;
import java.util.HashMap;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.geovis.pro.resultEntity.ResultEntity;
import com.geovis.pro.util.OkHttpUtil;

import okhttp3.HttpUrl;
import okhttp3.MediaType;
import okhttp3.OkHttpClient;

@Controller
@RequestMapping("/rest")
public class okHttpRest {
	public static final MediaType JSON = MediaType.parse("application/json; charset=utf-8");
	OkHttpClient client = new OkHttpClient();
	
	
	@GetMapping("/okhttppost")
	@ResponseBody
    public ResultEntity okhttppost(){
		try {
			HttpUrl url = new HttpUrl.Builder()
				.scheme("http")
				.host("127.0.0.1")
				.port(18080)
				.addPathSegments("pro/rest/getJpegByPath2")
				.build();
			System.out.print(url.toString());
		
			String res = OkHttpUtil.httpGet(url);
			return ResultEntity.success(res);
		} catch (IOException e) {
			e.printStackTrace();
			return ResultEntity.fail(e.getMessage());
		}
	        
    }

}
