
/**
 * @Title		: Aspect1.java   
 * @Package		: com.geovis.pro.advice   
 * @Description	: 
 * @author		: liuyan     
 * @date		: 2018年11月2日 下午5:28:40   
 * @version		: V1.0 
 */

package com.geovis.pro.advice;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

/**
 * @class : Aspect1
 * @author: liuyan
 * @Descr : Aspect1
 */
@Order(1)
@Component
@Aspect
public class Aspect1 {
	@Before(value = "com.geovis.pro.common.PointCuts.aopDemo()")
    public void before(JoinPoint joinPoint) {
        System.out.println("[Aspect1] Before");
    }

	//当目标函数有返回值时，@Around通知的返回值不能是void，应该是Object
    @Around(value = "com.geovis.pro.common.PointCuts.aopDemo()")
    public Object around(ProceedingJoinPoint pjp) throws  Throwable{
        System.out.println("[Aspect1] Around start");
        Object[] args = pjp.getArgs();
        Object rvt = pjp.proceed(args);
        
        System.out.println("[Aspect1] Around over");
        if(rvt != null && rvt instanceof Integer)
        	return rvt;
        return 0;
    }

    @AfterReturning(value = "com.geovis.pro.common.PointCuts.aopDemo()")
    public void afterReturning(JoinPoint joinPoint) {
        System.out.println("[Aspect1] AfterReturning");
    }

    @AfterThrowing(value = "com.geovis.pro.common.PointCuts.aopDemo()")
    public void afterThrowing(JoinPoint joinPoint) {
        System.out.println("[Aspect1] AfterThrowing advise");
    }

    @After(value = "com.geovis.pro.common.PointCuts.aopDemo()")
    public void after(JoinPoint joinPoint) {
        System.out.println("[Aspect1] After");
    }
}
