package com.rjgc.cjh.domain;

import java.sql.Date;

public class CartInfo {
	private String goodsname;
	private int orderID;
	private int pieces;
	private int CustomerID;
	private int goodsID;
	
	
	public int getGoodsID() {
		return goodsID;
	}
	public void setGoodsID(int goodsID) {
		this.goodsID = goodsID;
	}

	
	public void setOrderID(int orderID) {
		this.orderID = orderID;
	}
	public String getGoodsname() {
		return goodsname;
	}
	public void setGoodsname(String goodsname) {
		this.goodsname = goodsname;
	}
	public int getOrderID() {
		return orderID;
	}
	public int getPieces() {
		return pieces;
	}
	public void setPieces(int pieces) {
		this.pieces = pieces;
	}
	public int getCustomerID() {
		return CustomerID;
	}
	public void setCustomerID(int customerID) {
		CustomerID = customerID;
	}
	
	
}
