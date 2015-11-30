package com.online.lakeshoremarket.representation.generic;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

@XmlRootElement(name = "GenericResponse")
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "")
public class GenericResponse extends AbstractRepresentation{
	
	private boolean isSuccess;
	private String message;
	private String genericReturnValue;
	
	public boolean isSuccess() {
		return isSuccess;
	}
	public void setSuccess(boolean isSuccess) {
		this.isSuccess = isSuccess;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public String getGenericReturnValue() {
		return genericReturnValue;
	}
	public void setGenericReturnValue(String genericReturnValue) {
		this.genericReturnValue = genericReturnValue;
	}
	

}
