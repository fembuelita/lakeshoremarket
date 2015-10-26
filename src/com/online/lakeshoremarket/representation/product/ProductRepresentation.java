package com.online.lakeshoremarket.representation.product;

public class ProductRepresentation {
	
	private boolean isActive;
	private float price;
	private int partnerID;
	private int productID;
	private int taxonomyID;
	private String productName;
	private String description;
	
	public boolean isActive() {
		return isActive;
	}
	public void setActive(boolean isActive) {
		this.isActive = isActive;
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
	public int getProductID() {
		return productID;
	}
	public void setProductID(int productID) {
		this.productID = productID;
	}
	public int getTaxonomyID() {
		return taxonomyID;
	}
	public void setTaxonomyID(int taxonomyID) {
		this.taxonomyID = taxonomyID;
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
