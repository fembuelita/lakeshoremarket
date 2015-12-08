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
	
	
	public XMLGregorianCalendar getDatePurchased() {
		return datePurchased;
	}
	public void setDatePurchased(XMLGregorianCalendar datePurchased) {
		this.datePurchased = datePurchased;
	}
	public XMLGregorianCalendar getDateRefunded() {
		return dateRefunded;
	}
	public void setDateRefunded(XMLGregorianCalendar dateRefunded) {
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
	public String getTrackingNumber() {
		return trackingNumber;
	}
	public void setTrackingNumber(String trackingNumber) {
		this.trackingNumber = trackingNumber;
	}
	
}
