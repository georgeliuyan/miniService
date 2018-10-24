package com.geovis.pro.dao;

import java.util.List;
import org.apache.ibatis.annotations.Mapper;
import org.mybatis.spring.annotation.MapperScan;

import com.geovis.pro.model.SysUserEntity;

//从mybatis3.4.0开始加入了@Mapper注解，目的就是为了不再写mapper映射文件
//mybatis-spring-boot-starter的1.1.1版本以后新增的，之前为@MapperScan
@Mapper
public interface SysUserDao {
    void save(SysUserEntity user);
    /**
     * 根据条件查询User
     * @param user User
     * @return 符合条件列表
     */
    List<SysUserEntity> query(SysUserEntity user);
    List<SysUserEntity> queryAll();
    SysUserEntity queryById(Long id);
    
}
