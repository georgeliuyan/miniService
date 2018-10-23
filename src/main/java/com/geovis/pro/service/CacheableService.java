package com.geovis.pro.service;

import org.springframework.cache.annotation.Cacheable;

import com.geovis.pro.model.SysUserEntity;

public interface CacheableService {
	SysUserEntity queryById(Long id);
}
