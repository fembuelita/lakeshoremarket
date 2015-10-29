package com.online.lakeshoremarket.representation.product;


public class ProductRequest {
	
	
	private boolean isActive;
	private float cost;
	private float price;
	private int partnerID;
	private int taxonomyID;
	private int qoh;
	private String productName;
	private String description;
	
	public boolean isActive() {
		return isActive;
	}
	public void setActive(boolean isActive) {
		this.isActive = isActive;
	}
	public float getCost() {
		return cost;
	}
	public void setCost(float cost) {
		this.cost = cost;
	}
	public float getPrice() {
		return price;
	}
	public void setPrice(float price) {
		this.price = price;
	}
	public int getPartnerID() {
		return partnerID;
	}
	public void setPartnerID(int partnerID) {
		this.partnerID = partnerID;
	}
	public int getTaxonomyID() {
		return taxonomyID;
	}
	public void setTaxonomyID(int taxonomyID) {
		this.taxonomyID = taxonomyID;
	}
	public int getQoh() {
		return qoh;
	}
	public void setQoh(int qoh) {
		this.qoh = qoh;
	}
	public String getProductName() {
		return productName;
	}
	public void setProductName(String productName) {
		this.productName = productName;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}

	
}
