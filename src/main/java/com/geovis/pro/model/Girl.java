package com.geovis.pro.model;

import java.io.Serializable;

public class Girl implements Serializable{

	/**
	 * redis实体对象
	 */
	private static final long serialVersionUID = -3946734305303957850L;
	int id;
	String name;
	int age;
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public Girl(int id, String name, int age) {
		super();
		this.id = id;
		this.name = name;
		this.age = age;
	}

	public Girl() {
	}
	
	
}
