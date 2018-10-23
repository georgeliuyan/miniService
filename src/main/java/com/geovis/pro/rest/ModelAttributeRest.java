package com.geovis.pro.rest;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.geovis.pro.common.ResultEntity;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/rest")
@Api("MybatisTest相关的api")
public class ModelAttributeRest {
	
	/* 
	 * 1）在函数上配置@ModelAttribute
	 */
	//标注不带返回值的函数
//	@ModelAttribute
//	public void init1(@RequestParam(required = false) Integer age,Model model){
//		model.addAttribute("age", age);
//		System.out.println("init1 : "+age);
//	}
	
	//标注带返回值的Model函数，指定了user_name的话，会以user_name:name的形式保存model
//	@ModelAttribute(value="user_name")
//	public String init2(@RequestParam(required = false) String name, Model model) {
//		System.out.println("init2 :" + name);
//		return name;
//	}
	
	//标注带返回值的Model函数，没有指定value的话，会以string:name的形式保存model
//	@ModelAttribute
//	public String init3(@RequestParam(required = false) String name2, Model model) {
//		System.out.println("init3 :" + name2);
//		return name2;
//	}
	
	//测试函数
	@ApiOperation(value = "testWithModelFunc", notes = "testWithModelFunc")
	@GetMapping("/testWithModelFunc")
	public ResultEntity test1(
			@RequestParam(required = false) Integer age, 
			@RequestParam(required = false) String name,
			@RequestParam(required = false) String name2,
			Model model){
		return ResultEntity.success(model);
	}
	
	//测试函数
	@ApiOperation(value = "testNoParam", notes = "testNoParam")
	@GetMapping("/testNoParam")
	public ResultEntity testNoParam(Model model){
		return ResultEntity.success(model);
	}
	
	/* 
	 * 
	 * 2）在函数的参数上配置@ModelAttribute
	 */
	//测试函数
	@ApiOperation(value = "testWithModelParam", notes = "testWithModelParam")
	@GetMapping("/testWithModelParam")
	@ResponseBody
	public ResultEntity testWithModelParam(
			@ModelAttribute("user_name") String name,
			Model model){
		System.out.println(name);
		System.out.println(model);
		return ResultEntity.success(name);
//		return ResultEntity.success(model); //返回model会报错
	}
}
