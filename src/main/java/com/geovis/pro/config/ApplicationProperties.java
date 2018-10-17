package com.geovis.pro.config;

import javax.validation.constraints.NotNull;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Component
@ConfigurationProperties(prefix="server")
public class ApplicationProperties {
	
	@NotNull
	public String port;
	
	@NotNull
	public String contextPath;
	/*
	 *  contextPath可以使用的属性名如下：
	 *  
	 *	server.contextPath，标准的驼峰式命名
	 *	server.context-path，虚线（-）分割方式，推荐在.properties和.yml配置文件中使用
	 *	SERVER_CONTEXT_PATH，大写下划线形式，建议在系统环境变量中使用
	 * 
	 */
	
	public String getPort() {
		return port;
	}
	public void setPort(String port) {
		this.port = port;
	}
	public String getContextPath() {
		return contextPath;
	}
	public void setContextPath(String contextPath) {
		this.contextPath = contextPath;
	}
	public ApplicationProperties() {
		// TODO Auto-generated constructor stub
	}
	
	
}
