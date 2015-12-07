package com.online.lakeshoremarket.resource;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.HeaderParam;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.online.lakeshoremarket.activity.CustomerActivity;
import com.online.lakeshoremarket.exception.GenericLSMException;
import com.online.lakeshoremarket.representation.customer.CustomerRepresentation;
import com.online.lakeshoremarket.representation.customer.CustomerRequest;
import com.online.lakeshoremarket.representation.generic.GenericResponse;
import com.online.lakeshoremarket.util.LSMAuthenticator;

@Path("/")
public class CustomerResource {

	@PUT
	@Consumes({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
	@Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
	@Path("/customer")
	public GenericResponse createCustomer(CustomerRequest custRequest, @HeaderParam("email") String email, @HeaderParam("password") String password) {
		System.out.println("PUT METHOD Request for Creating a new customer .............");
		// If requiring authorization to create a user, uncomment the following lines
		boolean isUserAuthentic = true;
//		boolean isUserAuthentic = false;
//		isUserAuthentic = LSMAuthenticator.authenticateUser(email, password);
		if(isUserAuthentic){
			GenericResponse genericResponse = new GenericResponse();
			CustomerActivity customerActivity = new CustomerActivity();
			genericResponse = customerActivity.createCustomer(custRequest);
			return genericResponse;
		}else{
			throw new GenericLSMException("User is not authorized", Response.Status.UNAUTHORIZED);
		}
	}
	
	@GET
	@Produces({"application/xml", "application/json"})
	@Path("/customer/{customerID}")
	public CustomerRepresentation getCustomerDetails(@PathParam("customerID") String customerIDString, @HeaderParam("email") String email, @HeaderParam("password") String password){
		System.out.println("GET METHOD Request for Customer details............." + customerIDString);
		boolean isUserAuthentic = false;
		isUserAuthentic = LSMAuthenticator.authenticateUser(email, password);
		if(isUserAuthentic){
			CustomerActivity customerActivity = new CustomerActivity();
			CustomerRepresentation customerRepresentation = new CustomerRepresentation();
			customerRepresentation = customerActivity.getCustomerDetails(customerIDString);
			if(customerRepresentation.getCustomerId() == 0){
				throw new GenericLSMException("Customer is not found", Response.Status.NOT_FOUND);
			}else{
				return customerRepresentation;
			}
		}else{
			throw new GenericLSMException("User is not authorized", Response.Status.UNAUTHORIZED);
		}
	}
	
	@DELETE
	@Produces({"application/xml" , "application/json"})
	@Path("/customer/{customerID}")
	public GenericResponse deleteCustomer(@PathParam("customerID") String customerIDString, @HeaderParam("email") String email, @HeaderParam("password") String password){
		System.out.println("DELETE METHOD Request for Deleting a Customer ............." + customerIDString);
		boolean isUserAuthentic = false;
		isUserAuthentic = LSMAuthenticator.authenticateUser(email, password);
		if(isUserAuthentic){
			boolean isCustomerDeleted = false;
			CustomerActivity customerActivity = new CustomerActivity();
			isCustomerDeleted = customerActivity.deleteCustomer(customerIDString);
			GenericResponse genericResponse = new GenericResponse();
			if(isCustomerDeleted){
				genericResponse.setMessage("Customer has been deleted");
				genericResponse.setSuccess(true);
			}else{
				genericResponse.setMessage("Customer was not deleted");
				genericResponse.setSuccess(false);
			}		
			return genericResponse;
		}else{
			throw new GenericLSMException("User is not authorized", Response.Status.UNAUTHORIZED);
		}
	}
}
