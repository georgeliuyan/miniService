package com.geovis.pro.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import org.apache.ibatis.annotations.Update;
import org.hibernate.validator.constraints.NotBlank;

@Entity
public class SysUserEntity implements Serializable{
	private static final long serialVersionUID = -4165045211576395840L;
	
	//主键
	@Id
    private Long id;
    //用户名
    @NotBlank(message = "用户名不能为空")
    private String username;
    //密码
    private String password;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public SysUserEntity(Long id, String username, String password) {
		super();
		this.id = id;
		this.username = username;
		this.password = password;
	}
	public SysUserEntity() {
		// TODO Auto-generated constructor stub
	}
	
	
    
}
