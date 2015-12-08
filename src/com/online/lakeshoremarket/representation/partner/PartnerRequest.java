package com.online.lakeshoremarket.representation.partner;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;


@XmlRootElement(name = "Partner")
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "")

/**
 * Client request for partner representation.
 *
 */

public class PartnerRequest {
	
	private String line1;
	private String line2;
	private String line3;
	private String city;
	private String country;
	private String state;
	private String zip;
	
	private boolean isActive;
	private String contactName;
	private String email;
	private String partnerName;
	private String password;
	private String phone;
	
	/**
	 * gets an address line
	 * @return 	the first line of the address
	 */
	
	public String getLine1() {
		return line1;
	}
	
	/**
	 * sets the address line 1
	 * @param line1
	 */
	
	public void setLine1(String line1) {
		this.line1 = line1;
	}
	
	/**
	 * gets an address line
	 * @return 	the second line of the address
	 */
	
	public String getLine2() {
		return line2;
	}
	
	/**
	 * sets the address line 2
	 * @param line2
	 */
	
	public void setLine2(String line2) {
		this.line2 = line2;
	}
	
	/**
	 * gets an address line
	 * @return 	the third line of the address
	 */
	
	public String getLine3() {
		return line3;
	}
	
	/**
	 * sets the address line 3
	 * @param line3
	 */
	
	public void setLine3(String line3) {
		this.line3 = line3;
	}
	
	/**
	 * gets the city of the address
	 * @return 	the city of the address
	 */
	
	public String getCity() {
		return city;
	}
	
	/**
	 * sets the city of the address
	 * @param city
	 */
	
	public void setCity(String city) {
		this.city = city;
	}
	
	/**
	 * gets the country of the address
	 * @return 	the country of the address
	 */
	
	public String getCountry() {
		return country;
	}
	
	/**
	 * sets the country of the address
	 * @param country
	 */
	
	public void setCountry(String country) {
		this.country = country;
	}
	
	/**
	 * gets the state of the address
	 * @return 	the state of the address
	 */
	
	public String getState() {
		return state;
	}
	
	/**
	 * sets the state of the address
	 * @param state
	 */
	
	public void setState(String state) {
		this.state = state;
	}
	
	/**
	 * gets the zipcode of the address
	 * @return 	the zipcode of the address
	 */
	
	public String getZip() {
		return zip;
	}
	
	/**
	 * sets the zipcode of the address
	 * @param zip
	 */
	
	public void setZip(String zip) {
		this.zip = zip;
	}
	
	/**
	 * determines if a customer is active or not
	 * @return true if active, false else
	 */
	
	public boolean isActive() {
		return isActive;
	}
	
	/**
	 * sets a customer active status
	 * @param isActive true or false
	 */
	
	public void setActive(boolean isActive) {
		this.isActive = isActive;
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
