package com.online.lakeshoremarket.representation.customer;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

@XmlRootElement(name = "Customer")
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "")

/**
 * This class builds a request for fields related to the customer representation.
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
	
	
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getPaypalCustID() {
		return paypalCustID;
	}
	public void setPaypalCustID(String paypalCustID) {
		this.paypalCustID = paypalCustID;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getBillingAddressLine1() {
		return billingAddressLine1;
	}
	public void setBillingAddressLine1(String billingAddressLine1) {
		this.billingAddressLine1 = billingAddressLine1;
	}
	public String getBillingAddressLine2() {
		return billingAddressLine2;
	}
	public void setBillingAddressLine2(String billingAddressLine2) {
		this.billingAddressLine2 = billingAddressLine2;
	}
	public String getBillingAddressLine3() {
		return billingAddressLine3;
	}
	public void setBillingAddressLine3(String billingAddressLine3) {
		this.billingAddressLine3 = billingAddressLine3;
	}
	public String getBillingAddressCity() {
		return billingAddressCity;
	}
	public void setBillingAddressCity(String billingAddressCity) {
		this.billingAddressCity = billingAddressCity;
	}
	public String getBillingAddressCountry() {
		return billingAddressCountry;
	}
	public void setBillingAddressCountry(String billingAddressCountry) {
		this.billingAddressCountry = billingAddressCountry;
	}
	public String getBillingAddressState() {
		return billingAddressState;
	}
	public void setBillingAddressState(String billingAddressState) {
		this.billingAddressState = billingAddressState;
	}
	public String getBillingAddressZip() {
		return billingAddressZip;
	}
	public void setBillingAddressZip(String billingAddressZip) {
		this.billingAddressZip = billingAddressZip;
	}
	public String getShippingAddressLine1() {
		return shippingAddressLine1;
	}
	public void setShippingAddressLine1(String shippingAddressLine1) {
		this.shippingAddressLine1 = shippingAddressLine1;
	}
	public String getShippingAddressLine2() {
		return shippingAddressLine2;
	}
	public void setShippingAddressLine2(String shippingAddressLine2) {
		this.shippingAddressLine2 = shippingAddressLine2;
	}
	public String getShippingAddressLine3() {
		return shippingAddressLine3;
	}
	public void setShippingAddressLine3(String shippingAddressLine3) {
		this.shippingAddressLine3 = shippingAddressLine3;
	}
	public String getShippingAddressCity() {
		return shippingAddressCity;
	}
	public void setShippingAddressCity(String shippingAddressCity) {
		this.shippingAddressCity = shippingAddressCity;
	}
	public String getShippingAddressCountry() {
		return shippingAddressCountry;
	}
	public void setShippingAddressCountry(String shippingAddressCountry) {
		this.shippingAddressCountry = shippingAddressCountry;
	}
	public String getShippingAddressState() {
		return shippingAddressState;
	}
	public void setShippingAddressState(String shippingAddressState) {
		this.shippingAddressState = shippingAddressState;
	}
	public String getShippingAddressZip() {
		return shippingAddressZip;
	}
	public void setShippingAddressZip(String shippingAddressZip) {
		this.shippingAddressZip = shippingAddressZip;
	}
	
	
}
