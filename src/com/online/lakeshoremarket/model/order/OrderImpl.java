package com.online.lakeshoremarket.model.order;


/**
 * instantiates the order interface to represent the order model
 *
 */
public class OrderImpl implements Order{

	private long datePurchased;
	private long dateRefunded;
	private int customerID;
	private int orderID;
	private int orderStatusCode;
	private int paymentID;
	private String trackingNumber;
	
	//We might remove these two attributes later on
	private int productID;
	private int qty;
	public int getProductID() {
		return productID;
	}
	public void setProductID(int productID) {
		this.productID = productID;
	}
	public int getQty() {
		return qty;
	}
	public void setQty(int qty) {
		this.qty = qty;
	}
	//We might remove the above two attributes later on
	
	
	public long getDatePurchased() {
		return datePurchased;
	}
	public void setDatePurchased(long datePurchased) {
		this.datePurchased = datePurchased;
	}
	public long getDateRefunded() {
		return dateRefunded;
	}
	public void setDateRefunded(long dateRefunded) {
		this.dateRefunded = dateRefunded;
	}
	public int getCustomerID() {
		return customerID;
	}
	public void setCustomerID(int customerID) {
		this.customerID = customerID;
	}
	public int getOrderID() {
		return orderID;
	}
	public void setOrderID(int orderID) {
		this.orderID = orderID;
	}
	public int getOrderStatusCode() {
		return orderStatusCode;
	}
	public void setOrderStatusCode(int orderStatusCode) {
		this.orderStatusCode = orderStatusCode;
	}
	public int getPaymentID() {
		return paymentID;
	}
	public void setPaymentID(int paymentID) {
		this.paymentID = paymentID;
	}
	public String getTrackingNumber() {
		return trackingNumber;
	}
	public void setTrackingNumber(String trackingNumber) {
		this.trackingNumber = trackingNumber;
	}
	
	
}
