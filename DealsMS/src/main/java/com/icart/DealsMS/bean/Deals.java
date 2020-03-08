package com.icart.DealsMS.bean;


public class Deals {

	private int dealId;
	private int productId;
	private int dealDiscount;
	private String sellerEmailId;
	
	
	public int getDealId() {
		return dealId;
	}
	public void setDealId(int dealId) {
		this.dealId = dealId;
	}
	public int getProductId() {
		return productId;
	}
	public void setProductId(int productId) {
		this.productId = productId;
	}
	public int getDealDiscount() {
		return dealDiscount;
	}
	public void setDealDiscount(int dealDiscount) {
		this.dealDiscount = dealDiscount;
	}
	public String getSellerEmailId() {
		return sellerEmailId;
	}
	public void setSellerEmailId(String sellerEmailId) {
		this.sellerEmailId = sellerEmailId;
	}
}
