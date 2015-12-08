package com.online.lakeshoremarket.resource;


import javax.ws.rs.GET;
import javax.ws.rs.HeaderParam;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;

import com.online.lakeshoremarket.exception.GenericLSMException;
import com.online.lakeshoremarket.representation.generic.GenericResponse;
import com.online.lakeshoremarket.util.LSMAuthenticator;

@Path("/")
public class UtilResource {

	/**
	 * Authenticates a user
	 * @param email 	the user email
	 * @param password 	the user password hash
	 * @return 	generic response value
	 */
	@GET
	@Produces({"application/xml" , "application/json"})
	@Path("/authenticate")
	public GenericResponse authenticate( @HeaderParam("email") String email, @HeaderParam("password") String password){
		System.out.println("AUTHENTICATE METHOD Request for user .............");
		boolean isUserAuthentic = false;
		isUserAuthentic = LSMAuthenticator.authenticateUser(email, password);
		if(isUserAuthentic){
			GenericResponse genericResponse = new GenericResponse();
			genericResponse.setMessage("User is authenticated");
			genericResponse.setSuccess(true);
			return genericResponse;
		}
		
		throw new GenericLSMException("User is not authenticated", Response.Status.UNAUTHORIZED);
	}
	
	
	/**
	 * Authenticates a customer and returns the customer ID as part of the detail
	 * @param email 	the user email
	 * @param password	the user password
	 * @return generic response value
	 */
	@GET
	@Produces({"application/xml" , "application/json"})
	@Path("/authenticate/customer")
	public GenericResponse authenticateCustomer( @HeaderParam("email") String email, @HeaderParam("password") String password){
		System.out.println("AUTHENTICATE METHOD Request for customer .............");
		int customerID = LSMAuthenticator.authenticateCustomer(email, password);
		if(customerID < 1)
			throw new GenericLSMException("User is not authenticated", Response.Status.UNAUTHORIZED);
	
		GenericResponse genericResponse = new GenericResponse();
		genericResponse.setMessage("User is authenticated");
		genericResponse.setSuccess(true);
		genericResponse.setGenericReturnValue( Integer.toString( customerID ) );
		return genericResponse;
	}	
}
