package com.geovis.pro;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.cache.annotation.EnableCaching;

@SpringBootApplication  
/*
 * Spring Boot 应用标注某个类上说明这个类是SpringBoot主配置类,注解包括如下：
 * 
 * @SpringBootConfiguration ：Spring Boot配置类，标注上某个类上，表示这个一个SpringBoot 配置类
 * @EnableAutoConfiguration ：开启自动配置功能，以前需要配置的东西，SpringBoot帮我们自动配置；
 * @ComponentScan(excludeFilters={@Filter(type=CUSTOM, classes={TypeExcludeFilter.class})})
 * @Target(value={TYPE})
 * @Retention(value=RUNTIME)
 * @Documented
 * @Inherited
 */
@EnableCaching //缓存机制
@ServletComponentScan
public class application {
	
 	public static void main(String[] args) {
 		SpringApplication.run(application.class, args);
 	}
}
