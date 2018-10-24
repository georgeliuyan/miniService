package com.geovis.pro.rest;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.geovis.pro.common.ResultEntity;
import com.geovis.pro.dao.SysUserDao;
import com.geovis.pro.model.SysUserEntity;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@Controller
@RequestMapping("/rest")
@Api("MybatisTest相关的api")
public class MybatisTest {
	@Resource
    private SysUserDao userDao;
	
	@ApiOperation(value = "UserSave", notes = "UserSave")
//	@ApiImplicitParam(name = "SysUserEntity", dataType="SysUserEntity.class",paramType="body", required = true)
	@PostMapping("/UserSave")
	@ResponseBody
	public ResultEntity UserSave(@RequestBody SysUserEntity user) {
        userDao.save(user);
        return ResultEntity.success(user);
    }
	
	@ApiOperation(value = "getAllUser", notes = "getAllUser")
	@GetMapping("/getAllUser")
	@ResponseBody
	public ResultEntity getAllUser() {
        List<SysUserEntity> list = userDao.queryAll();
        return ResultEntity.success(list);
    }

}
