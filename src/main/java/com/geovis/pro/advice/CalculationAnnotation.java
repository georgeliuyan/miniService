
/**
 * @Title: CalculationAnnotation.java   
 * @Package: com.geovis.pro.advice   
 * @Description: AOP测试
 * @author: liuyan     
 * @date: 2018年10月29日 上午11:09:18   
 * @version: v1.0 
 *
 */

package com.geovis.pro.advice;

import java.util.Arrays;
import java.util.List;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.context.annotation.Configuration;

/**
 * @author: liuyan
 *
 */
@Aspect    //AOP声明注解,表示声明这个类是一个切面
@Configuration  //springBoot 配置AOP时需要添加@Configuration配置类
public class CalculationAnnotation {

	/*----------对整个类进行切入----------*/
	/**
	 * Func  	: before
	 * Params	: @param join
	 * Descr 	: 定义前置通知 execution(* biz.ClassName.*(..)) 表示  所有修饰符的所有返回值类型  biz.ClassName 包下的所有方法
     * 			在方法执行之前执行
	 */
	@Before("execution(* com.geovis.pro.service.impl.CalculationImpl.*(..))")
    public void before(JoinPoint join){
        //获取方法名
        String mathName=join.getSignature().getName();
        //获取参数列表
        List<Object> args = Arrays.asList(join.getArgs());
        System.out.println("前置通知---->before   方法名是:"+mathName+"\t参数列表是:"+args);
    }
	
    /**
     * Func  	: after
     * Params	: 
     * Descr 	: 后置通知，在方法返回后执行，无论是否发生异常，不能访问到返回值
     */
    @After("execution(* com.geovis.pro.service.impl.CalculationImpl.*(..))")
    public void after(){
        System.out.println("后置通知---->after....");
    }

    /*------------自定义一个切入点------------*/
    /**
     * Descr: 自定义切入点
     */
    @Pointcut("execution(public * com.geovis.pro.rest.CacheableRest.getCacheable(..))")
    public void myMethod(){};
    
    
    /**
     * Descr:开始函数
     */
    @Before("myMethod()")
    public void myBefore(JoinPoint join){
        //获取方法名
        String mathName=join.getSignature().getName();
        //获取参数列表
        List<Object> args = Arrays.asList(join.getArgs());
        System.out.println("前置通知---->before   方法名是:"+mathName+"\t参数列表是:"+args);
    }
    
    
    @After("myMethod()")
    public void myAfter(){
        System.out.println("后置通知---->after....");
    }
}
