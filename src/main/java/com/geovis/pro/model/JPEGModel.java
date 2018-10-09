package com.geovis.pro.model;

public class JPEGModel {
	String jpegName;
	byte[] jpegByte;
	
	
	public String getJpegName() {
		return jpegName;
	}


	public void setJpegName(String jpegName) {
		this.jpegName = jpegName;
	}


	public byte[] getJpegByte() {
		return jpegByte;
	}


	public void setJpegByte(byte[] jpegByte) {
		this.jpegByte = jpegByte;
	}


	
	public JPEGModel(String jpegName, byte[] jpegByte) {
		super();
		this.jpegName = jpegName;
		this.jpegByte = jpegByte;
	}


	public JPEGModel() {
		// TODO Auto-generated constructor stub
	}
}
