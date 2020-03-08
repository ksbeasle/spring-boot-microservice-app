package com.icart.DealsMS.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Table(name="deals")
@Entity
public class DealsEntity {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="DEAL_ID")
	private int dealId;
	
	@Column(name="PRODUCT_ID")
	private int productId;
	
	@Column(name="DEAL_DISCOUNT")
	private int dealDiscount;
	
	@Column(name="SELLER_EMAIL_ID")
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
