package com.online.lakeshoremarket.model.order;

/**
 * represents an order in the database
 *
 */
public interface Order {

	/**
	 * gets the date and time an item was purchased
	 * @return the timestamp
	 */
	public long getDatePurchased();
	
	/**
	 * sets the date and time an item was purchased
	 * @param datePurchased the timestamp
	 */
	public void setDatePurchased(long datePurchased);
	
	/**
	 * gets the date an item was refunded
	 * @return the timestamp
	 */
	public long getDateRefunded();
	/**
	 * sets the date an item was refunded
	 * @param dateRefunded the refund date
	 */
	public void setDateRefunded(long dateRefunded);
	/**
	 * gets a customer ID for this order
	 * @return the customer ID
	 */
	public int getCustomerID();
	/**
	 * sets the customer ID for this order
	 * @param customerID the customer id
	 */
	public void setCustomerID(int customerID);
	/**
	 * gets this order ID number
	 * @return the order ID
	 */
	public int getOrderID();
	/**
	 * sets this order ID number
	 * @param orderID the order ID number
	 */
	public void setOrderID(int orderID);
	/**
	 * gets the status code to be used with constants file
	 * @return the status code
	 */
	public int getOrderStatusCode();
	/**
	 * sets the status code
	 * @param orderStatusCode the status code
	 */
	public void setOrderStatusCode(int orderStatusCode);
	
	/**
	 * gets the payment ID
	 * @return the payment ID
	 */
	public int getPaymentID();
	
	/**
	 * sets the payment ID
	 * @param paymentID 	the payment ID
	 */
	public void setPaymentID(int paymentID);
	
	/**
	 * gest the tracking number
	 * @return the tracking number
	 */
	public String getTrackingNumber();
	
	/**
	 * sets the tracking number
	 * @param trackingNumber the tracking number
	 */
	public void setTrackingNumber(String trackingNumber);
	
	
	
	//We might remove these two methods later on
	public int getProductID();
	public void setProductID(int productID);
	public int getQty();
	public void setQty(int qty);
	//We might remove the above two methods later on
	
	
}
