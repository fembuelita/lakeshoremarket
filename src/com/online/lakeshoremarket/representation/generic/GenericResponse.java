package com.online.lakeshoremarket.representation.generic;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

@XmlRootElement(name = "GenericResponse")
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "")

/**
 * This class establishes the representations of generic responses used throughout the application (service layer)
 *
 */

public class GenericResponse extends AbstractRepresentation{
	
	private boolean isSuccess;
	private String message;
	private String genericReturnValue;
	
	/**
	 * Establishes success
	 * @return 	affirmative bool if true
	 */
	
	public boolean isSuccess() {
		return isSuccess;
	}
	
	/**
	 * Sets the success message
	 * @param	boolean (successful or not)
	 */
	
	public void setSuccess(boolean isSuccess) {
		this.isSuccess = isSuccess;
	}
	
	/**
	 * Gets message
	 * @return 	message in the form of a string
	 */
	
	public String getMessage() {
		return message;
	}
	
	/**
	 * Sets the message
	 * @param	the message in the form of a string
	 */
	
	public void setMessage(String message) {
		this.message = message;
	}
	
	/**
	 * Gets a return value
	 * @return 	return value in the form of a string
	 */
	
	public String getGenericReturnValue() {
		return genericReturnValue;
	}
	
	/**
	 * Sets the generic value
	 * @param	the generic value in the form of a string
	 */
	
	public void setGenericReturnValue(String genericReturnValue) {
		this.genericReturnValue = genericReturnValue;
	}
	

}
