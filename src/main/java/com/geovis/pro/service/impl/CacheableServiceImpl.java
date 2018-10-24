package com.geovis.pro.service.impl;

import javax.annotation.Resource;

import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import com.geovis.pro.dao.SysUserDao;
import com.geovis.pro.model.SysUserEntity;
import com.geovis.pro.service.CacheableService;

@Service
public class CacheableServiceImpl implements CacheableService {

	@Resource
    private SysUserDao userDao;
	
	@Override
	@Cacheable(value = "SysUserEntity", key = "''+#id", condition = "#id!=null")
//	@Cacheable(value = "SysUserEntity",key = "#id") //这样写redis中可能会有重复的key=id
	public SysUserEntity queryById(Long id) {
		System.out.println("search from database...");
		SysUserEntity entity = userDao.queryById(Long.valueOf(id));
		return entity;
	}

}
