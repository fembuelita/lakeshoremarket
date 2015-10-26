package com.online.lakeshoremarket.model.cart;

/**
 * defines the structure for a cart line
 * one cart holds many cart lines in the same way
 * there are many order lines to an order
 *
 */
public interface CartLine {

	/**
	 * get the cart line ID
	 * @return the cart line ID
	 */
	public int getCartLineID();
	/**
	 * sets the cart line id
	 * @param cartLineID the cart line id
	 */
	public void setCartLineID(int cartLineID);
	/**
	 * gets the customer ID for the cart line
	 * @return the customer id
	 */
	public int getCustomerID();
	/**
	 * sets the customer ID for the cart line
	 * @param customerID 	the customer ID
	 */
	public void setCustomerID(int customerID);
	/**
	 * gets the product ID this line represents
	 * @return product id 	the product ID
	 */
	public int getProductID();
	/**
	 * sets the product ID this line represents
	 * @param productID 	the product ID
	 */
	public void setProductID(int productID);
	/**
	 * gets the quantity of product this line represents
	 * @return	the quantity
	 */
	public int getQuantity();
	/**
	 * sets the quantity of product this line represents
	 * @param quantity the quantity
	 */
	public void setQuantity(int quantity);
	
	
}
