package com.geovis.pro.test;

import org.junit.After;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import com.geovis.pro.application;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = application.class)
@WebAppConfiguration
public class TestBase{
	@BeforeClass //针对所有测试，只执行一次，且必须为static void，每个测试类都会执行一次
    public static void testBeforeClass() {
        System.out.println("@BeforeClass 测试");
    }
	
	@Before //初始化方法，执行当前测试类的每个测试方法前执行。
    public void init() {
        System.out.println("开始测试-----------------");
    }
 
    @After //释放资源，执行当前测试类的每个测试方法后执行。
    public void after() {
        System.out.println("测试结束-----------------");
    }
}