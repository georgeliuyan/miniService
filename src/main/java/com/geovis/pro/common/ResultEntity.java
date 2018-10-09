package com.geovis.pro.common;

public class ResultEntity {
	int code;
	String msg;
	Object body;
	
	public int getCode() {
		return code;
	}
	public void setCode(int code) {
		this.code = code;
	}
	public String getMsg() {
		return msg;
	}
	public void setMsg(String msg) {
		this.msg = msg;
	}
	public Object getBody() {
		return body;
	}
	public void setBody(Object body) {
		this.body = body;
	}
	
	public ResultEntity(int code, String msg, Object body) {
		super();
		this.code = code;
		this.msg = msg;
		this.body = body;
	}
	
	public ResultEntity() {
	}
	
	public static ResultEntity success(Object body){
		ResultEntity entity = new ResultEntity();
		entity.setBody(body);
		entity.setCode(ResultCode.SUCCESS);
		entity.setMsg("success");
		return entity;
	}
	
	public static ResultEntity fail(Object body){
		ResultEntity entity = new ResultEntity();
		entity.setBody(body);
		entity.setCode(ResultCode.FAIL);
		entity.setMsg("fail");
		return entity;
	}

}
