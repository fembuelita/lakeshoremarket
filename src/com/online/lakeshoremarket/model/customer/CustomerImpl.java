package com.online.lakeshoremarket.model.customer;

/**
 * instantiates the customer interface to represent the customer model
 *
 */
public class CustomerImpl implements Customer{

	private boolean isActive;
	private int billingAddress;
	private int shippingAddress;
	private int customerID;
	private String email;
	private String firstName;
	private String lastName;
	private String password;
	private String paypalCustID;
	private String phone;
	private String title;
	
	
	public boolean isActive() {
		return isActive;
	}
	public void setActive(boolean isActive) {
		this.isActive = isActive;
	}
	public int getBillingAddress() {
		return billingAddress;
	}
	public void setBillingAddress(int billingAddress) {
		this.billingAddress = billingAddress;
	}
	public int getShippingAddress() {
		return shippingAddress;
	}
	public void setShippingAddress(int shippingAddress) {
		this.shippingAddress = shippingAddress;
	}

	public int getCustomerID() {
		return customerID;
	}
	public void setCustomerID(int customerID) {
		this.customerID = customerID;
	}
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
	
	
}
