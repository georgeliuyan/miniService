package com.geovis.pro.rest;

import java.io.IOException;
import java.util.HashMap;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.geovis.pro.resultEntity.ResultEntity;
import com.geovis.pro.util.OkHttpUtil;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import okhttp3.HttpUrl;
import okhttp3.MediaType;
import okhttp3.OkHttpClient;

@Controller
@RequestMapping("/rest")
@Api("swaggerDemoController相关的api")
public class okHttpRest {
	public static final MediaType JSON = MediaType.parse("application/json; charset=utf-8");
	OkHttpClient client = new OkHttpClient();
	
	@ApiOperation(value = "根据id查询学生信息", notes = "查询数据库中某个的学生信息")
//    @ApiImplicitParam(name = "id", value = "学生ID", paramType = "path", required = true, dataType = "Integer")
//    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
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
