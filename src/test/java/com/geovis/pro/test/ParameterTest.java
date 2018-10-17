package com.geovis.pro.test;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;  
import static org.hamcrest.CoreMatchers.*;  //引入的匹配符Matcher，见下面的is方法
import static org.junit.matchers.JUnitMatchers.*; 
import org.junit.runner.RunWith;
import org.junit.Ignore;

import org.junit.Test;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

//1.更改默认的测试运行器为RunWith(Parameterized.class),这里集成了TestBase类，TestBase这个类定义了Parameterized.class注解
@RunWith(Parameterized.class) //构造参数化运行的测试类
public class ParameterTest extends TestBase {
	// 2.声明变量存放预期值和测试数据
    private String firstName;
    private String lastName;

    //3.声明一个返回集合的公共静态方法，返回的集合作为测试，并使用@Parameters进行注解
    @Parameters //
    public static List<Object[]> param() {
        // 这里我给出两个测试用例
        return Arrays.asList(new Object[][]{{"Mike", "Black"}, {"Cilcln", "Smith"}});
    }

    //4.为测试类声明一个带有参数的公共构造函数，并在其中为之声明变量赋值
    public ParameterTest(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }
    // 5. 进行测试，发现它会将所有的测试用例测试一遍
    @Test
    public void test() {
        String name = firstName + " " + lastName;
        assertThat("Mike Black", is(name));
    }
}
