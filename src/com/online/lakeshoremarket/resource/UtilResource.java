package com.online.lakeshoremarket.resource;

import javax.ws.rs.DELETE;
import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.HeaderParam;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;

import com.online.lakeshoremarket.activity.OrderActivity;
import com.online.lakeshoremarket.exception.GenericLSMException;
import com.online.lakeshoremarket.representation.generic.GenericResponse;
import com.online.lakeshoremarket.representation.generic.Link;
import com.online.lakeshoremarket.representation.order.OrderRepresentation;
import com.online.lakeshoremarket.util.Constant;
import com.online.lakeshoremarket.util.LSMAuthenticator;

@Path("/")
public class UtilResource {

	/**
	 * Authenticates a user
	 */
	@GET
	@Produces({"application/xml" , "application/json"})
	@Path("/authenticate")
	public GenericResponse authenticate( @HeaderParam("email") String email, @HeaderParam("password") String password){
		System.out.println("AUTHENTICATE METHOD Request for customer .............");
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
}
