package com.online.lakeshoremarket.representation.product;


import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

@XmlRootElement(name = "Product")
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "")

/**
 * Client request for customer representation.
 *
 */

public class ProductRequest{
	
	
	private boolean isActive;
	private float cost;
	private float price;
	private int partnerID;
	private int taxonomyID;
	private int qoh;
	private String productName;
	private String description;
	
	/**
	 * represents if this product is active or not
	 * @return true if active, false else
	 */
	
	public boolean isActive() {
		return isActive;
	}
	
	/** 
	 * sets a product active or not
	 * @param isActive true if active, false else
	 */
	
	public void setActive(boolean isActive) {
		this.isActive = isActive;
	}
	
	/**
	 * gets a product cost
	 * @return cost
	 */
	
	public float getCost() {
		return cost;
	}
	
	/**
	 * sets the product cost
	 * @param cost the cost
	 */
	
	public void setCost(float cost) {
		this.cost = cost;
	}
	
	/**
	 * gets a product price
	 * @return price
	 */
	
	public float getPrice() {
		return price;
	}
	
	/**
	 * sets the product price
	 * @param price the price
	 */
	
	public void setPrice(float price) {
		this.price = price;
	}
	
	/**
	 * gets the product partner ID
	 * @return the partner ID
	 */
	
	public int getPartnerID() {
		return partnerID;
	}
	
	/**
	 * sets the product partner ID
	 * @param partnerID the partner ID
	 */
	
	public void setPartnerID(int partnerID) {
		this.partnerID = partnerID;
	}
	
	/**
	 * gets a product taxonomy ID
	 * @return the taxonomy ID
	 */
	
	public int getTaxonomyID() {
		return taxonomyID;
	}
	
	/**
	 * sets the product taxonomy ID
	 * @param taxonomyID the taxonomy ID
	 */
	
	public void setTaxonomyID(int taxonomyID) {
		this.taxonomyID = taxonomyID;
	}
	
	/**
	 * gets the product quantity on hand
	 * @return qoh
	 */
	
	public int getQoh() {
		return qoh;
	}
	
	/**
	 * sets the product quantity on hand
	 * @param qoh
	 */
	
	public void setQoh(int qoh) {
		this.qoh = qoh;
	}
	
	/**
	 * gets the product name for this product
	 * @return the product name
	 */
	
	public String getProductName() {
		return productName;
	}
	
	/**
	 * sets the product name for this product
	 * @param productName the product name
	 */
	
	public void setProductName(String productName) {
		this.productName = productName;
	}
	
	/**
	 * gets a product description
	 * @return the description
	 */
	
	public String getDescription() {
		return description;
	}
	
	/**
	 * sets a product description
	 * @param description the description
	 */
	
	public void setDescription(String description) {
		this.description = description;
	}

	
}
