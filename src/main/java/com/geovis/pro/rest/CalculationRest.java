
/**
 * @Title: CalculationRest.java   
 * @Package: com.geovis.pro.rest   
 * @Description: AOP测试
 * @author: liuyan     
 * @date: 2018年10月29日 上午11:19:25   
 * @version: V1.0 
 */

package com.geovis.pro.rest;

import org.junit.runners.Parameterized.Parameter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.geovis.pro.common.ResultEntity;
import com.geovis.pro.service.Calculation;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

/**
 * @author: liuyan
 *
 */
@RestController
@RequestMapping("/rest")
@Api("miniService api")
public class CalculationRest {
	
	@Autowired
	Calculation calculation;
	
	@ApiOperation(value = "getAdd", notes = "getAdd")
	@GetMapping("/getAdd")
    public ResultEntity getAdd(@RequestParam int i,@RequestParam int j){
		int result = calculation.add(i, j);
		return ResultEntity.success(result);
    }

}
