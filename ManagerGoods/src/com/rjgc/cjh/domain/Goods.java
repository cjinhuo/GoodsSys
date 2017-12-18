package com.rjgc.cjh.domain;

import java.util.Date;


public class Goods {
	
	public static String Loginer = null;
	public static int flag = 0;
	private int id;
	private int stock;
	private String name;
	private String type;
	private String EXP;
	private String manufacturer;
	private String supplier;
	private Date PD;
	private String managername;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getStock() {
		return stock;
	}
	public void setStock(int stock) {
		this.stock = stock;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public void setManagername(String managername) {
		this.managername = managername;
	}
	public String getManagername() {
		return managername;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getEXP() {
		return EXP;
	}
	public void setEXP(String eXP) {
		EXP = eXP;
	}
	public String getManufacturer() {
		return manufacturer;
	}
	public void setManufacturer(String manufacturer) {
		this.manufacturer = manufacturer;
	}
	public String getSupplier() {
		return supplier;
	}
	public void setSupplier(String supplier) {
		this.supplier = supplier;
	}
	public Date getPD() {
		return PD;
	}
	public void setPD(Date pD) {
		PD = pD;
	}

}
