package com.geovis.pro.rest;

import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.geovis.pro.resultEntity.ResultEntity;
import com.geovis.pro.service.JpegService;
@Controller
@RequestMapping("/rest")
public class JpegRest {
	@Autowired
	private JpegService jpegService;
	
	@RequestMapping("/getJpegByPath")
	@ResponseBody
    public ResultEntity getTestById(@RequestBody HashMap<String,String> params){
		String path = params.get("path");
		ResultEntity t = jpegService.loadJpegImage(path);
		return t;
    }
	
	@GetMapping("/getJpegByPath2")
	@ResponseBody
    public String getTestById(){
		return "getJpegByPath2";
    }

}
