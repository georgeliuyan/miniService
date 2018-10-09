package com.geovis.pro.rest;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.geovis.pro.common.ResultEntity;
import com.geovis.pro.model.Girl;
import com.geovis.pro.service.RedisService;
import com.geovis.pro.util.OkHttpUtil;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import okhttp3.HttpUrl;

@Controller
@RequestMapping("/rest")
@Api("swaggerDemoController相关的api")
public class redisRest {
	@Autowired
	RedisService redisService;
	
	@ApiOperation(value = "redisRead", notes = "redisRead")
	@GetMapping("/redisRead")
	@ResponseBody
	public ResultEntity redisRead(){
		Girl g = redisService.findOne(1);
		return ResultEntity.success(g);
	}
}
