package com.online.lakeshoremarket.representation.customer;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

@XmlRootElement(name = "Customer")
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "")

/**
 * Client request for customer representation.
 *
 */

public class CustomerRequest {

	//For customer details
	private String email;
	private String firstName;
	private String lastName;
	private String password;
	private String paypalCustID;
	private String phone;
	private String title;
	
	
	//For billing address
	private String billingAddressLine1;
	private String billingAddressLine2;
	private String billingAddressLine3;
	private String billingAddressCity;
	private String billingAddressCountry;
	private String billingAddressState;
	private String billingAddressZip;
	
	
	//For shipping address
	private String shippingAddressLine1;
	private String shippingAddressLine2;
	private String shippingAddressLine3;
	private String shippingAddressCity;
	private String shippingAddressCountry;
	private String shippingAddressState;
	private String shippingAddressZip;
	
	/**
	 * gets a customer email 
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
	 * gets a customer first name
	 * @return 	the name
	 */
	
	public String getFirstName() {
		return firstName;
	}
	
	/**
	 * sets a customer first name 
	 * @param firstName	the name
	 */
	
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	
	/**
	 * gets a customer last name 
	 * @return 	the name
	 */
	
	public String getLastName() {
		return lastName;
	}
	
	/**
	 * sets a customer last name 
	 * @param lastName the name
	 */
	
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	
	/**
	 * gets a hashed customer password
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
	
	/**
	 * gets address line 1
	 * @return 	the first line of the address
	 */
	
	public String getBillingAddressLine1() {
		return billingAddressLine1;
	}
	
	/**
	 * sets the first line of the address
	 * @param 	the first line of the address
	 */
	
	public void setBillingAddressLine1(String billingAddressLine1) {
		this.billingAddressLine1 = billingAddressLine1;
	}
	
	/**
	 * gets address line 2
	 * @return 	the second line of the address
	 */
	
	public String getBillingAddressLine2() {
		return billingAddressLine2;
	}
	
	/**
	 * sets the second line of the address
	 * @param 	the second line of the address
	 */
	
	public void setBillingAddressLine2(String billingAddressLine2) {
		this.billingAddressLine2 = billingAddressLine2;
	}
	
	/**
	 * gets address line 3
	 * @return 	the third line of the address
	 */
	
	public String getBillingAddressLine3() {
		return billingAddressLine3;
	}
	
	/**
	 * sets the third line of the address
	 * @param 	the third line of the address
	 */
	
	public void setBillingAddressLine3(String billingAddressLine3) {
		this.billingAddressLine3 = billingAddressLine3;
	}
	
	/**
	 * gets the city of the address
	 * @return 	city
	 */
	
	public String getBillingAddressCity() {
		return billingAddressCity;
	}
	
	/**
	 * sets the city of the address
	 * @return 	city
	 */
	
	public void setBillingAddressCity(String billingAddressCity) {
		this.billingAddressCity = billingAddressCity;
	}
	
	/**
	 * gets the country of the address
	 * @return 	county
	 */
	
	public String getBillingAddressCountry() {
		return billingAddressCountry;
	}
	
	/**
	 * sets the country of the address
	 * @return 	country
	 */
	
	public void setBillingAddressCountry(String billingAddressCountry) {
		this.billingAddressCountry = billingAddressCountry;
	}
	
	/**
	 * gets the state of the address
	 * @return 	state
	 */
	
	public String getBillingAddressState() {
		return billingAddressState;
	}
	
	/**
	 * sets the state of the address
	 * @return 	state
	 */
	
	public void setBillingAddressState(String billingAddressState) {
		this.billingAddressState = billingAddressState;
	}
	
	/**
	 * gets the zipcode of the address
	 * @return 	zipcode
	 */
	
	public String getBillingAddressZip() {
		return billingAddressZip;
	}
	
	/**
	 * sets the zipcode of the address
	 * @return 	zipcode
	 */
	
	public void setBillingAddressZip(String billingAddressZip) {
		this.billingAddressZip = billingAddressZip;
	}
	
	/**
	 * gets address line 1
	 * @return 	the first line of the address
	 */
	
	public String getShippingAddressLine1() {
		return shippingAddressLine1;
	}
	
	/**
	 * sets the first line of the address
	 * @param 	the first line of the address
	 */
	
	public void setShippingAddressLine1(String shippingAddressLine1) {
		this.shippingAddressLine1 = shippingAddressLine1;
	}
	
	/**
	 * gets address line 2
	 * @return 	the second line of the address
	 */
	
	public String getShippingAddressLine2() {
		return shippingAddressLine2;
	}
	
	/**
	 * sets the second line of the address
	 * @param 	the second line of the address
	 */
	
	public void setShippingAddressLine2(String shippingAddressLine2) {
		this.shippingAddressLine2 = shippingAddressLine2;
	}
	
	/**
	 * gets address line 3
	 * @return 	the third line of the address
	 */
	
	public String getShippingAddressLine3() {
		return shippingAddressLine3;
	}
	
	/**
	 * sets the third line of the address
	 * @param 	the third line of the address
	 */
	
	public void setShippingAddressLine3(String shippingAddressLine3) {
		this.shippingAddressLine3 = shippingAddressLine3;
	}
	
	/**
	 * gets the city of the address
	 * @return 	city
	 */
	
	public String getShippingAddressCity() {
		return shippingAddressCity;
	}
	
	/**
	 * sets the city of the address
	 * @return 	city
	 */
	
	public void setShippingAddressCity(String shippingAddressCity) {
		this.shippingAddressCity = shippingAddressCity;
	}
	
	/**
	 * gets the country of the address
	 * @return 	country
	 */
	
	public String getShippingAddressCountry() {
		return shippingAddressCountry;
	}
	
	/**
	 * sets the country of the address
	 * @return 	country
	 */
	
	public void setShippingAddressCountry(String shippingAddressCountry) {
		this.shippingAddressCountry = shippingAddressCountry;
	}
	
	/**
	 * gets the state of the address
	 * @return 	state
	 */
	
	public String getShippingAddressState() {
		return shippingAddressState;
	}
	
	/**
	 * sets the state of the address
	 * @return 	state
	 */
	
	public void setShippingAddressState(String shippingAddressState) {
		this.shippingAddressState = shippingAddressState;
	}
	
	/**
	 * gets the zipcode of the address
	 * @return 	zipcode
	 */
	
	public String getShippingAddressZip() {
		return shippingAddressZip;
	}
	
	/**
	 * sets the zipcode of the address
	 * @return 	zipcode
	 */
	
	public void setShippingAddressZip(String shippingAddressZip) {
		this.shippingAddressZip = shippingAddressZip;
	}
	
	
}
