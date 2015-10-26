package com.online.lakeshoremarket.model.partner;

/**
 * represents a partner in the database
 *
 */
public interface Partner {


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
	public int getAddressID();

	/**
	 * sets a address ID
	 * @param addressID	the address ID
	 */
	public void setAddressID(int billingAddress);
	
	/**
	 * gets this partner id
	 * @return 	the partner ID
	 */
	public int getPartnerID();
	
	/**
	 * sets this partner ID
	 * @param partnerID 	the partner ID
	 */
	public void setPartnerID(int partnerID);
	
	/**
	 * gets the partner's contact name
	 * @return the contact name
	 */
	public String getContactName();
	
	/**
	 * sets the partner's contact name
	 * @param contactName 	the contact name
	 */
	public void setContactName(String contactName);
	
	/**
	 * gets the partner's email address
	 * @return 	the email
	 */
	public String getEmail();
	
	/**
	 * sets the partner's email
	 * @param email the email
	 */
	public void setEmail(String email);
	
	/**
	 * gets the partner's name
	 * @return the name
	 */
	public String getPartnerName();
	
	/**
	 * sets the partner name
	 * @param partnerName 	the name
	 */
	public void setPartnerName(String partnerName);
	
	/**
	 * gets the password
	 * @return the password
	 */
	public String getPassword();
	
	/**
	 * sets the password
	 * @param password the password
	 */
	public void setPassword(String password);
	
	/**
	 * gets the partner's phone
	 * @return the phone
	 */
	public String getPhone();
	
	/**
	 * sets the partner's phone
	 * @param phone the phone
	 */
	public void setPhone(String phone);
	
}
