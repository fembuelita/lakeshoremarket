package com.online.lakeshoremarket.representation.customer;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

@XmlRootElement(name = "Customer")
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "")

/**
 * This class builds the representation of customers that interact with and are manipulated by the user in the service layer.
 *
 */


public class CustomerRepresentation {
		
	private boolean isActive;
	private int billingAddress;
	private int shippingAddress;
	private int customerId;
	private String email;
	private String firstName;
	private String lastName;
	private String password;
	private String paypalCustID;
	private String phone;
	private String title;
	
	/**
	 * determines if a customer representation is active or not
	 * @return true if active, false else
	 */
	
	public boolean isActive() {
		return isActive;
	}
	
	/**
	 * sets a customer representation's active status
	 * @param isActive true or false
	 */
	
	public void setActive(boolean isActive) {
		this.isActive = isActive;
	}
	
	/**
	 * gets an address ID for the customer representation
	 * @return 	the address ID
	 */
	
	public int getBillingAddress() {
		return billingAddress;
	}
	
	/**
	 * sets an address ID for the customer representation
	 * @param billingAddress	the address ID
	 */
	
	public void setBillingAddress(int billingAddress) {
		this.billingAddress = billingAddress;
	}
	
	/**
	 * gets an address ID for the customer representation
	 * @return 	the address ID
	 */
	
	public int getShippingAddress() {
		return shippingAddress;
	}
	
	/**
	 * sets a address ID for the customer representation
	 * @param shippingAddress the address ID
	 */
	
	public void setShippingAddress(int shippingAddress) {
		this.shippingAddress = shippingAddress;
	}
	
	/**
	 * gets a customer ID for the customer representation
	 * @return 	the ID
	 */
	
	public int getCustomerId() {
		return customerId;
	}
	
	/**
	 * sets a customer ID for the customer representation
	 * @param customerId	the ID
	 */
	
	public void setCustomerId(int customerId) {
		this.customerId = customerId;
	}
	
	/**
	 * gets a customer email for the customer representation
	 * @return 	the email
	 */
	
	public String getEmail() {
		return email;
	}
	
	/**
	 * sets a customer email
	 * @param email 	the email
	 */
	
	public void setEmail(String email) {
		this.email = email;
	}
	
	/**
	 * gets a customer first name for the customer representation
	 * @return 	the name
	 */
	
	public String getFirstName() {
		return firstName;
	}
	
	/**
	 * sets a customer first name for the customer representation
	 * @param firstName	the name
	 */
	
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	
	/**
	 * gets a customer last name for the customer representation
	 * @return 	the name
	 */
	
	public String getLastName() {
		return lastName;
	}
	
	/**
	 * sets a customer last name for the customer representation
	 * @param lastName the name
	 */
	
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	
	/**
	 * gets a hashed customer password for the customer representation
	 * @return 	the password
	 */
	
	public String getPassword() {
		return password;
	}
	
	/**
	 * sets a customer password
	 * @param password	the password
	 */
	
	public void setPassword(String password) {
		this.password = password;
	}
	
	/**
	 * gets the paypal customer ID if known (for the customer representation)
	 * @return the ID
	 */
	
	public String getPaypalCustID() {
		return paypalCustID;
	}
	
	/**
	 * sets the paypal customer ID
	 * @param paypalCustID	the ID
	 */
	
	public void setPaypalCustID(String paypalCustID) {
		this.paypalCustID = paypalCustID;
	}
	
	/**
	 * gets a phone number for the customer representation
	 * @return phone number
	 */
	
	public String getPhone() {
		return phone;
	}
	
	/**
	 * sets a phone number
	 * @param phone the phone number
	 */
	
	public void setPhone(String phone) {
		this.phone = phone;
	}
	
	/**
	 * gets a title for the customer representation
	 * @return the title
	 */
	
	public String getTitle() {
		return title;
	}
	
	/**
	 * sets a title
	 * @param title the title
	 */
	
	public void setTitle(String title) {
		this.title = title;
	}
	
	
}