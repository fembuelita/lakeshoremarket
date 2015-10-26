package com.online.lakeshoremarket.model.order;

/**
 * instantiates the order line interface to represent the order model
 *
 */
public class OrderLineImpl {

	private int orderLineID;
	private int orderID;
	private int productID;
	private int quantity;
	
	
	public int getOrderLineID() {
		return orderLineID;
	}
	public void setOrderLineID(int orderLineID) {
		this.orderLineID = orderLineID;
	}
	public int getOrderID() {
		return orderID;
	}
	public void setOrderID(int orderID) {
		this.orderID = orderID;
	}
	public int getProductID() {
		return productID;
	}
	public void setProductID(int productID) {
		this.productID = productID;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	
	
}
