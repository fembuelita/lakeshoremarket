package com.online.lakeshoremarket.model.order;

/**
 * defines the structure for a order line
 * one order holds many order lines in the same way
 * there are many cart lines to an cart
 *
 */
public interface OrderLine {

	/**
	 * gets the order line ID
	 * @return the order line ID
	 */
	public int getOrderLineID();
	
	/**
	 * sets the order line id
	 * @param orderLineID the order line ID
	 */
	public void setOrderLineID(int orderLineID);
	
	/**
	 * gets the order ID
	 * @return the order ID
	 */
	public int getOrderID();
	
	/**
	 * sets the order ID
	 * @param orderID the order ID
	 */
	public void setOrderID(int orderID);
	
	/**
	 * gets the product ID
	 * @return the product ID
	 */
	public int getProductID();
	
	/**
	 * sets the product ID
	 * @param productID	the product ID
	 */
	public void setProductID(int productID);
	
	/**
	 * gets the quantity of product in this order line
	 * @return the quantity
	 */
	public int getQuantity();
	
	/**
	 * sets the quantity of product in this order line
	 * @param quantity the quantity
	 */
	public void setQuantity(int quantity);
	
	
}
