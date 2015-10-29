package com.online.lakeshoremarket.model.product;

/**
 * instantiates the product interface to represent the product model
 *
 */
public class ProdImpl implements Product {
	
	private boolean isActive;
	private float cost;
	private float price;
	private int partnerID;
	private int productID;
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
	public void displayProductDetails(){
		System.out.println("Product id  = " + productID);
		System.out.println("Partner id = " + partnerID);
		System.out.println("Taxonomy id = " + taxonomyID);
		System.out.println("Cost = " + cost);
		System.out.println("Price = " + price);
		System.out.println("Product Name = " + productName);
		System.out.println("Description = " + description);
		System.out.println("Quantity on hand = " + qoh);
		System.out.println("Product status = " + (isActive ? "Active" : "Inactive"));
	}
}


