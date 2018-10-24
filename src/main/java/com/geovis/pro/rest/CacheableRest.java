package com.geovis.pro.rest;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.geovis.pro.common.ResultEntity;
import com.geovis.pro.model.SysUserEntity;
import com.geovis.pro.service.CacheableService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/rest")
@Api("CacheableRest相关的api")
public class CacheableRest {
	
//	@Autowired
	@Resource
	CacheableService cacheableService;
	
	@ApiOperation(value = "getCacheable", notes = "getCacheable")
	@GetMapping("/getCacheable")
	public ResultEntity getCacheable(@RequestParam(required = false) Long id) {  
	     //这里不用写缓存的逻辑，直接按正常业务逻辑走即可，
	     //缓存通过切面自动切入  
		System.out.println("into func getCacheable");
		SysUserEntity user = cacheableService.queryById(id);
	    return ResultEntity.success(user);
	}
	
	@ApiOperation(value = "deleteCacheable", notes = "deleteCacheable")
	@CacheEvict(value = "SysUserEntity", key = "'SysUserEntity:'+#id")
	@GetMapping("/deleteCacheable")
	public ResultEntity deleteCacheable(@RequestParam(required = false) Long id) {  
	     //这里不用写缓存的逻辑，直接按正常业务逻辑走即可，
	     //缓存通过切面自动切入  
		System.out.println("into func deleteCacheable");
//		SysUserEntity user = cacheableService.queryById(id);
	    return ResultEntity.success(id);
	}
}
