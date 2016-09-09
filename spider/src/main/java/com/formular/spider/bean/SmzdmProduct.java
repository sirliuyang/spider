package com.formular.spider.bean;

public class SmzdmProduct extends Product{

	public SmzdmProduct(){}
	
	public SmzdmProduct(String name, String price){
		this.name = name;
		this.price = price;
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
}
