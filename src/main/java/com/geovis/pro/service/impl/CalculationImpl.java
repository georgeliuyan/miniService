/**
 * @Title: CalculationImpl.java   
 * @Package: com.geovis.pro.service.impl   
 * @Description: AOP测试
 * @author: liuyan     
 * @date: 2018年10月29日 上午11:01:46   
 * @version: V1.0 
 */
package com.geovis.pro.service.impl;

import org.springframework.stereotype.Service;

import com.geovis.pro.service.Calculation;

/**
 * @author: liuyan
 *
 */
@Service
public class CalculationImpl implements Calculation {

	/**
	 * Descr:
	 */
	@Override
	public int add(int i, int j) {
		
		return i + j;
	}

	/**
	 * Descr:
	 */
	@Override
	public int sub(int i, int j) {
		return i - j;
	}

	/**
	 * Descr:
	 */
	@Override
	public int mul(int i, int j) {
		return i * j;
	}

	/**
	 * Descr:
	 */
	@Override
	public int div(int i, int j) {
		return i / j;
	}

}
