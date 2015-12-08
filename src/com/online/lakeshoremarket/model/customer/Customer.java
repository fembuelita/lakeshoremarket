package com.online.lakeshoremarket.model.customer;

/**
 * represents a customer in the database
 *
 */
public interface Customer {
	
	/**
	 * determines if a customer is active or not
	 * @return true if active, false else
	 */
	public boolean isActive();
	
	/**
	 * sets a customer active status
	 * @param isActive true or false
	 */
	public void setActive(boolean isActive);
	
	/**
	 * gets a address ID
	 * @return 	the address ID
	 */
	public int getBillingAddress();

	/**
	 * sets a address ID
	 * @param billingAddress	the address ID
	 */
	public void setBillingAddress(int billingAddress);
	
	/**
	 * gets a address ID
	 * @return 	the address ID
	 */
	public int getShippingAddress();

	/**
	 * sets a address ID
	 * @param shippingAddress the address ID
	 */
	public void setShippingAddress(int shippingAddress);
	
	/**
	 * gets a customer ID
	 * @return 	the ID
	 */
	public int getCustomerId();
	/**
	 * sets a customer ID
	 * @param customerId	the ID
	 */
	public void setCustomerId(int customerId);
	
	/**
	 * gets a customer email
	 * @return 	the email
	 */
	public String getEmail();
	
	/**
	 * sets a customer email
	 * @param email 	the email
	 */
	public void setEmail(String email);
	
	/**
	 * gets a customer name
	 * @return 	the name
	 */
	public String getFirstName();
	
	/**
	 * sets a customer name
	 * @param firstName	the name
	 */
	public void setFirstName(String firstName);
	
	/**
	 * gets a customer name
	 * @return 	the name
	 */
	public String getLastName();
	
	/**
	 * sets a customer name
	 * @param lastName the name
	 */
	public void setLastName(String lastName);
	
	/**
	 * gets a hashed customer password
	 * @return 	the password
	 */
	
	public String getPassword();

	/**
	 * sets a customer password
	 * @param password	the password
	 */
	public void setPassword(String password);
	
	/**
	 * gets the paypal customer ID if known
	 * @return the ID
	 */
	public String getPaypalCustID();
	
	/**
	 * sets the paypal customer ID
	 * @param paypalCustID	the ID
	 */
	public void setPaypalCustID(String paypalCustID);
	
	/**
	 * gets a phone number
	 * @return phone number
	 */
	public String getPhone();
	
	/**
	 * sets a phone number
	 * @param phone the phone number
	 */
	public void setPhone(String phone);
	
	/**
	 * gets a title
	 * @return the title
	 */
	public String getTitle();
	
	/**
	 * sets a title
	 * @param title the title
	 */
	public void setTitle(String title);
	
}
