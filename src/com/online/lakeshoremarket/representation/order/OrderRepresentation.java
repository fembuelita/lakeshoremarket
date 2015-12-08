package com.online.lakeshoremarket.representation.order;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import javax.xml.datatype.XMLGregorianCalendar;

import com.online.lakeshoremarket.representation.generic.AbstractRepresentation;

@XmlRootElement(name = "Order")
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "")

/**
 * This class builds the representation of orders that interact with and are manipulated by the user in the service layer.
 *
 */

public class OrderRepresentation extends AbstractRepresentation{

	private XMLGregorianCalendar datePurchased;
	private XMLGregorianCalendar dateRefunded;
	private int customerID;
	private int orderID;
	private int orderStatusCode;
	private int paymentID;
	private int productID;
	private int qty;
	private String trackingNumber;
	
	/**
	 * gets the date and time an item was purchased
	 * @return the timestamp
	 */
	
	public XMLGregorianCalendar getDatePurchased() {
		return datePurchased;
	}
	
	/**
	 * sets the date and time an item was purchased
	 * @param datePurchased the timestamp
	 */
	
	public void setDatePurchased(XMLGregorianCalendar datePurchased) {
		this.datePurchased = datePurchased;
	}
	
	/**
	 * gets the date an item was refunded
	 * @return the timestamp
	 */
	
	public XMLGregorianCalendar getDateRefunded() {
		return dateRefunded;
	}
	
	/**
	 * sets the date an item was refunded
	 * @param dateRefunded the refund date
	 */
	
	public void setDateRefunded(XMLGregorianCalendar dateRefunded) {
		this.dateRefunded = dateRefunded;
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
	
	/**
	 * gets this order ID number
	 * @return the order ID
	 */
	
	public int getOrderID() {
		return orderID;
	}
	
	/**
	 * sets this order ID number
	 * @param orderID the order ID number
	 */
	
	public void setOrderID(int orderID) {
		this.orderID = orderID;
	}
	
	/**
	 * gets the status code to be used with constants file
	 * @return the status code
	 */
	
	public int getOrderStatusCode() {
		return orderStatusCode;
	}
	
	/**
	 * sets this order status code
	 * @param orderStatusCode
	 */
	
	public void setOrderStatusCode(int orderStatusCode) {
		this.orderStatusCode = orderStatusCode;
	}
	
	/**
	 * gets the payment ID
	 * @return the payment ID
	 */
	
	public int getPaymentID() {
		return paymentID;
	}
	
	/**
	 * sets this order payment ID
	 * @param paymentID
	 */
	
	public void setPaymentID(int paymentID) {
		this.paymentID = paymentID;
	}
	
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
	
	public int getQty() {
		return qty;
	}
	
	/**
	 * sets the quantity
	 * @param quantity
	 */
	
	public void setQty(int qty) {
		this.qty = qty;
	}
	
	/**
	 * gets the tracking number
	 * @return the tracking number
	 */
	
	public String getTrackingNumber() {
		return trackingNumber;
	}
	
	/**
	 * sets the tracking number
	 * @param trackingNumber the tracking number
	 */
	
	public void setTrackingNumber(String trackingNumber) {
		this.trackingNumber = trackingNumber;
	}
	
}
