package com.online.lakeshoremarket.exception;

import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

public class GenericLSMException extends WebApplicationException{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public GenericLSMException(String message){
		super(Response.status(Response.Status.BAD_REQUEST).entity(message).type(MediaType.TEXT_PLAIN).build());
	}
	public GenericLSMException(String message, Response.Status respStatus){
		super(Response.status(respStatus).entity(message).type(MediaType.TEXT_PLAIN).build());
	}
}
