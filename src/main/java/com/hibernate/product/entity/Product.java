package com.hibernate.product.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Product {
	
	@Id
	private int productId;
	
	@Column
	private String productName;
	
	@Column
	private double productPrice;
	
	@Column
	private String productMgf;
	
	@Column
	private String productCategory;
	
	
	public Product() {
		
	}

	public Product(int productId, String productName, double procuctPrice, String prodcutMgf, String prodcutCategory) {
		super();
		this.productId = productId;
		this.productName = productName;
		this.productPrice = procuctPrice;
		this.productMgf = prodcutMgf;
		this.productCategory = prodcutCategory;
	}


	public int getProductId() {
		return productId;
	}


	public void setProductId(int productId) {
		this.productId = productId;
	}


	public String getProductName() {
		return productName;
	}


	public void setProductName(String productName) {
		this.productName = productName;
	}


	public double getProcuctPrice() {
		return productPrice;
	}


	public void setProcuctPrice(double procuctPrice) {
		this.productPrice = procuctPrice;
	}


	public String getProdcutMgf() {
		return productMgf;
	}


	public void setProdcutMgf(String prodcutMgf) {
		this.productMgf = prodcutMgf;
	}


	public String getProdcutCategory() {
		return productCategory;
	}


	public void setProductCategory(String productCategory) {
		this.productCategory = productCategory;
	}


	@Override
	public String toString() {
		return "Product [productId=" + productId + ", productName=" + productName + ", procuctPrice=" + productPrice
				+ ", prodcutMgf=" + productMgf + ", productCategory=" + productCategory + "]";
	}
	
	

}
