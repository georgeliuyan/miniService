package com.geovis.pro.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

@PropertySource(value = { "classpath:localConfig.properties" })
@Component
@ConfigurationProperties(prefix = "file")
public class LocalConfigProperties {
	public String filename;

	public String getFilename() {
		return filename;
	}

	public void setFilename(String filename) {
		this.filename = filename;
	}

	public LocalConfigProperties(String filename) {
		super();
		this.filename = filename;
	}

	public LocalConfigProperties() {
	}
	
	

}
