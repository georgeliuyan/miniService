package com.geovis.pro.service.impl;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.springframework.stereotype.Service;

import com.geovis.pro.model.JPEGModel;
import com.geovis.pro.resultEntity.ResultEntity;
import com.geovis.pro.service.JpegService;

@Service
public class JpegServiceImpl implements JpegService {

	@Override
	public ResultEntity loadJpegImage(String path) {
		HashMap<String, Object> resourse = new HashMap<String, Object>();
		
		List<JPEGModel> list = new ArrayList<JPEGModel>();
		
		File file = new File(path);
		File[] files = file.listFiles();
		if (files == null) {
			return new ResultEntity();
		}
		
		for (File f : files) {
			if (f.isFile() && f.getName().toLowerCase().contains(".jpeg")) {
				JPEGModel jpeg = new JPEGModel();
				byte[] data = readImage(f.getAbsoluteFile());
				jpeg.setJpegName(f.getName());
				jpeg.setJpegByte(data);
				list.add(jpeg);
			} else if (f.isDirectory()) {
				continue;
			}
		}
		resourse.put("jpegNum", list.size());
		resourse.put("jpegData", list);
		return ResultEntity.success(resourse);
	}
	
	private byte[] readImage(File file){
	    byte[] data=null;
	    FileInputStream fin=null;
	    ByteArrayOutputStream bout=null;
	    try{
	        fin=new FileInputStream(file);
	        bout=new ByteArrayOutputStream((int)file.length());
	        byte[] buffer=new byte[1024];
	        int len=-1;
	        while((len=fin.read(buffer))!=-1){
	            bout.write(buffer,0,len);
	        }
	        data=bout.toByteArray();
	        fin.close();
	        bout.close();
	    }catch(Exception e){
	        e.printStackTrace();
	    }
	    return data;
	}
}
