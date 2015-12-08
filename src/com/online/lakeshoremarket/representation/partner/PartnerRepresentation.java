package com.online.lakeshoremarket.representation.partner;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

@XmlRootElement(name = "Partner")
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "")

/**
 * This class builds the representation of partners that interact with and are manipulated by the user in the service layer.
 *
 */

public class PartnerRepresentation {

	private boolean isActive;
	private int addressID;
	private int partnerID;
	private String contactName;
	private String email;
	private String partnerName;
	private String password;
	private String phone;
	
	/**
	 * determines if a partner representation is active or not
	 * @return true if active, false else
	 */
	
	public boolean isActive() {
		return isActive;
	}
	
	/**
	 * sets a partner representation's active status
	 * @param isActive true or false
	 */
	
	public void setActive(boolean isActive) {
		this.isActive = isActive;
	}
	
	/**
	 * gets an address ID for the partner representation
	 * @return 	the address ID
	 */
	
	public int getAddressID() {
		return addressID;
	}
	
	/**
	 * sets an address ID for the partner representation
	 * @param billingAddress	the address ID
	 */
	
	public void setAddressID(int addressID) {
		this.addressID = addressID;
	}
	
	/**
	 * gets a partner ID for the partner representation
	 * @return 	the partner ID
	 */
	
	public int getPartnerID() {
		return partnerID;
	}
	
	/**
	 * sets a partner ID for the partner representation
	 * @param 	the partner ID
	 */
	
	public void setPartnerID(int partnerID) {
		this.partnerID = partnerID;
	}
	
	/**
	 * gets the partner's contact name
	 * @return the contact name
	 */
	
	public String getContactName() {
		return contactName;
	}
	
	/**
	 * sets the partner's contact name
	 * @param contactName 	the contact name
	 */
	
	public void setContactName(String contactName) {
		this.contactName = contactName;
	}
	
	/**
	 * gets the partner's email address
	 * @return 	the email
	 */
	
	public String getEmail() {
		return email;
	}
	
	/**
	 * sets the partner's email
	 * @param email the email
	 */
	
	public void setEmail(String email) {
		this.email = email;
	}
	
	/**
	 * gets the partner's name
	 * @return the name
	 */
	
	public String getPartnerName() {
		return partnerName;
	}
	
	/**
	 * sets the partner name
	 * @param partnerName 	the name
	 */
	
	public void setPartnerName(String partnerName) {
		this.partnerName = partnerName;
	}
	
	/**
	 * gets the password (hashed)
	 * @return the password
	 */
	
	public String getPassword() {
		return password;
	}
	
	/**
	 * sets the password
	 * @param password the password
	 */
	
	public void setPassword(String password) {
		this.password = password;
	}
	
	/**
	 * gets the partner's phone
	 * @return the phone
	 */
	
	public String getPhone() {
		return phone;
	}
	
	/**
	 * sets the partner's phone
	 * @param phone the phone
	 */
	
	public void setPhone(String phone) {
		this.phone = phone;
	}
	
}
