package com.geovis.pro.dao;

import java.util.List;
import org.apache.ibatis.annotations.Mapper;
import com.geovis.pro.model.SysUserEntity;

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
}
