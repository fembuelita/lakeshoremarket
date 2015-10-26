package com.online.lakeshoremarket.model.product;

/**
 * represents a product in the database
 *
 */
public interface Product {

	/**
	 * represents if this product is active or not
	 * @return true if active, false else
	 */
	public boolean isActive();
	
	/** 
	 * sets a product active or not
	 * @param isActive true if active, false else
	 */
	public void setActive(boolean isActive);
	
	/**
	 * gets a product cost
	 * @return cost
	 */
	public float getCost();
	
	/**
	 * sets a product cost
	 * @param cost the cost
	 */
	public void setCost(float cost);
	
	/**
	 * gets the product price
	 * @return price
	 */
	public float getPrice();
	
	/**
	 * sets the product price
	 * @param price the price
	 */
	public void setPrice(float price);
	
	/**
	 * gets the product partner ID
	 * @return the partner ID
	 */
	public int getPartnerID();
	
	/**
	 * sets the product partner ID
	 * @param partnerID the partner ID
	 */
	public void setPartnerID(int partnerID);
	
	/**
	 * gets the product ID
	 * @return the ID
	 */
	public int getProductID();
	
	/**
	 * sets the product ID
	 * @param productID the ID
	 */
	public void setProductID(int productID);
	
	/**
	 * gets a product taxonomy ID
	 * @return the taxonomy ID
	 */
	public int getTaxonomyID();
	
	/**
	 * sets the product taxonomy ID
	 * @param taxonomyID the taxonomy ID
	 */
	public void setTaxonomyID(int taxonomyID);
	
	/**
	 * gets the QOH for this product
	 * @return the QOH
	 */
	public int getQoh();
	
	/**
	 * sets the QOH for this product
	 * @param qoh the qoh
	 */
	public void setQoh(int qoh);
	
	/**
	 * gets the product name for this product
	 * @return the product name
	 */
	public String getProductName();
	
	/**
	 * sets the product name for this product
	 * @param productName the product name
	 */
	public void setProductName(String productName);
	
	/**
	 * gets a product description
	 * @return the description
	 */
	public String getDescription();
	
	/**
	 * sets a product description
	 * @param description the description
	 */
	public void setDescription(String description);
	
	/**
	 * prints the product details
	 */
	public void displayProductDetails();
	
	
}
