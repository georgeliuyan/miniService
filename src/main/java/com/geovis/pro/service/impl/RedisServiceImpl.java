package com.geovis.pro.service.impl;

import java.util.concurrent.TimeUnit;

import javax.annotation.Resource;

import org.apache.log4j.Logger;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import com.geovis.pro.common.RedisKeyPrefix;
import com.geovis.pro.model.Girl;
import com.geovis.pro.service.RedisService;

@Service
public class RedisServiceImpl implements RedisService {

	private Logger logger = Logger.getLogger(RedisServiceImpl.class);
	
	@Resource
    private RedisTemplate<String, Girl> redisTemplate;
    // private RedisTemplate<String, Object> redisTemplate;根据实际情况取泛型
	
	@Override
	public Girl findOne(Integer id) {
		String key = RedisKeyPrefix.GIRL + id;
        // 缓存存在
        boolean hasKey = redisTemplate.hasKey(key);
        if (hasKey) { // 从缓存中取
            Girl girl = redisTemplate.opsForValue().get(key);
            logger.info("从缓存中获取了用户！");
            return girl;
        }
        // 从数据库取，并存回缓存
        Girl girl = new Girl(1, "haha", 20); //girlRepository.findOne(id);
        // 放入缓存，并设置缓存时间
        redisTemplate.opsForValue().set(key, girl, 600, TimeUnit.SECONDS);
        return girl;
	}

}
