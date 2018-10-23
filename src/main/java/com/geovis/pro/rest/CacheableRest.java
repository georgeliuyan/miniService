package com.geovis.pro.rest;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.geovis.pro.common.ResultEntity;
import com.geovis.pro.dao.SysUserDao;
import com.geovis.pro.model.SysUserEntity;
import com.geovis.pro.service.CacheableService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/rest")
@Api("MybatisTest相关的api")
public class CacheableRest {
	
	@Autowired
	CacheableService cacheableService;
	
//	@Cacheable(value="UserCache")// 使用了一个缓存名叫 accountCache
	@ApiOperation(value = "getCacheable", notes = "getCacheable")
	@GetMapping("/getCacheable")
	public ResultEntity getCacheable(@RequestParam(required = false) Long id) {  
	     //这里不用写缓存的逻辑，直接按正常业务逻辑走即可，
	     //缓存通过切面自动切入  
		System.out.println("into func getCacheable");
		SysUserEntity user = cacheableService.queryById(id);
	    return ResultEntity.success(user);
	} 

}
