package com.online.lakeshoremarket.model.customer;

/**
 * represents the an address in the database
 *
 */
public interface Address {

	/**
	 * gets the address ID
	 * @return	the address id
	 */
	public int getAddressID();
	
	/**
	 * sets the address ID
	 * @param addressID 	the address ID
	 */
	public void setAddressID(int addressID);
	
	/**
	 * gets line 1 of the address
	 * @return	line 1
	 */
	public String getLine1();
	
	/**
	 * sets line 1 of the address
	 * @param line1 line 1
	 */
	public void setLine1(String line1);
	
	/**
	 * gets line2 of the address
	 * @return	line 2
	 */
	public String getLine2();
	
	/**
	 * sets line 2 of the address
	 * @param line2 line 2
	 */
	public void setLine2(String line2);
	
	/**
	 * gets line 3 of the address
	 * @return line3
	 */
	public String getLine3();
	
	/**
	 * sets line 3 of the address
	 * @param line3 line3
	 */
	public void setLine3(String line3);
	
	/**
	 * gets the city 
	 * @return city
	 */
	public String getCity();
	
	/**
	 * sets the city
	 * @param city city
	 */
	public void setCity(String city);
	
	/**
	 * gets the country
	 * @return country
	 */
	public String getCountry();
	
	/**
	 * sets the country
	 * @param country country
	 */
	public void setCountry(String country);
	
	/**
	 * gets the state
	 * @return the state
	 */
	public String getState();
	
	/**
	 * sets the state
	 * @param state	the state
	 */
	public void setState(String state);
	
	/**
	 * gets the zip
	 * @return the zip
	 */
	public String getZip();
	
	/**
	 * sets the zip
	 * @param zip	the zip
	 */
	public void setZip(String zip);
	
	
}
