package com.online.lakeshoremarket.model.cart;

/**
 * instantiates the cart line interface
 *
 */
public class CartLineImpl implements CartLine {

	private int cartLineID;
	private int customerID;
	private int productID;
	private int quantity;
	
	
	public int getCartLineID() {
		return cartLineID;
	}
	public void setCartLineID(int cartLineID) {
		this.cartLineID = cartLineID;
	}
	public int getCustomerID() {
		return customerID;
	}
	public void setCustomerID(int customerID) {
		this.customerID = customerID;
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
