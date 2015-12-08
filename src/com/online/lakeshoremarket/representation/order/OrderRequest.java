package com.online.lakeshoremarket.representation.order;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

@XmlRootElement(name = "Order")
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "")

/**
 * Client request for order representation.
 *
 */

public class OrderRequest {

	private int productID;
	private int quantity;
	private int customerID;
	
	/**
	 * gets the product ID
	 * @return the product ID
	 */
	
	public int getProductID() {
		return productID;
	}
	
	/**
	 * sets this product ID number
	 * @param the product ID number
	 */
	
	public void setProductID(int productID) {
		this.productID = productID;
	}
	
	/**
	 * gets the quantity
	 * @return the quantity
	 */
	
	public int getQuantity() {
		return quantity;
	}
	
	/**
	 * sets the quantity
	 * @param quantity
	 */
	
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	
	/**
	 * gets a customer ID for this order
	 * @return the customer ID
	 */
	
	public int getCustomerID() {
		return customerID;
	}
	
	/**
	 * sets the customer ID for this order
	 * @param customerID the customer id
	 */
	
	public void setCustomerID(int customerID) {
		this.customerID = customerID;
	}
	
	
}
