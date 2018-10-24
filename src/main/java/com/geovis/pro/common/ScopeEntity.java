package com.geovis.pro.common;

import org.springframework.context.annotation.Scope;

@Scope
public class ScopeEntity {
	public int a;
	public int b;
	public int getA() {
		return a;
	}
	public void setA(int a) {
		this.a = a;
	}
	public int getB() {
		return b;
	}
	public void setB(int b) {
		this.b = b;
	}
	public ScopeEntity(int a, int b) {
		super();
		this.a = a;
		this.b = b;
	}
	public ScopeEntity() {
	}
}
