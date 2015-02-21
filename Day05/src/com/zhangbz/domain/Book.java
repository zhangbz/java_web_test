package com.zhangbz.domain;

import java.io.Serializable;

public class Book implements Serializable{
	private String id;
	private String name;
	private String price;
	private String auth;
	private String publish;
	private String description;
	
	public Book() {
	}
	
	public Book(String id, String name, String price, String auth,
			String publish, String description) {
		super();
		this.id = id;
		this.name = name;
		this.price = price;
		this.auth = auth;
		this.publish = publish;
		this.description = description;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPrice() {
		return price;
	}
	public void setPrice(String price) {
		this.price = price;
	}
	public String getAuth() {
		return auth;
	}
	public void setAuth(String auth) {
		this.auth = auth;
	}
	public String getPublish() {
		return publish;
	}
	public void setPublish(String publish) {
		this.publish = publish;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	
	
}
