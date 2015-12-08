package com.online.lakeshoremarket.representation.product;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

import com.online.lakeshoremarket.representation.generic.AbstractRepresentation;

@XmlRootElement(name = "Product")
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "")

/**
 * This class builds the representation of products that interact with and are manipulated by the user in the service layer.
 *
 */

public class ProductRepresentation extends AbstractRepresentation{
	
	private boolean isActive;
	private float price;
	private int partnerID;
	private int productID;
	private int taxonomyID;
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
	 * gets the product ID
	 * @return the ID
	 */
	
	public int getProductID() {
		return productID;
	}
	
	/**
	 * sets the product ID
	 * @param productID the ID
	 */
	
	public void setProductID(int productID) {
		this.productID = productID;
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
