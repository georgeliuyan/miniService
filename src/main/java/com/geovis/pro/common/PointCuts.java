
/**
 * @Title		: PointCuts.java   
 * @Package		: com.geovis.pro.common   
 * @Description	: AOP测试
 * @author		: liuyan     
 * @date		: 2018年11月2日 下午5:22:58   
 * @version		: V1.0 
 */

package com.geovis.pro.common;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

/**
 * @class : PointCuts
 * @author: liuyan
 * @Descr : 切点类
 */

public class PointCuts {
	@Pointcut(value = "within(com.geovis.pro.service.impl.*)")
    public void aopDemo() {

    }
}
