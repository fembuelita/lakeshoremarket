package com.online.lakeshoremarket.resource;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.online.lakeshoremarket.activity.CustomerActivity;
import com.online.lakeshoremarket.representation.customer.CustomerRepresentation;
import com.online.lakeshoremarket.representation.customer.CustomerRequest;
import com.online.lakeshoremarket.representation.generic.GenericResponse;

@Path("/")
public class CustomerResource {

	@PUT
	@Consumes({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
	@Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
	@Path("/customer")
	public GenericResponse createCustomer(CustomerRequest custRequest) {
		System.out.println("PUT METHOD Request for Creating a new customer .............");
		GenericResponse genericResponse = new GenericResponse();
		boolean isCustomerCreated = false;
		CustomerActivity customerActivity = new CustomerActivity();
		isCustomerCreated = customerActivity.createCustomer(custRequest);
		if(isCustomerCreated){
			genericResponse.setMessage("Customer is created");
			genericResponse.setSuccess(true);
		}else{
			genericResponse.setMessage("Customer is not created");
			genericResponse.setSuccess(false);
		}
		
		return genericResponse;	
	}
	
	@GET
	@Produces({"application/xml", "application/json"})
	@Path("/customer/{customerID}")
	public CustomerRepresentation getCustomerDetails(@PathParam("customerID") String customerIDString){ 
		System.out.println("GET METHOD Request for Customer details............." + customerIDString);
		CustomerActivity customerActivity = new CustomerActivity();
		CustomerRepresentation customerRepresentation = new CustomerRepresentation();
		customerRepresentation = customerActivity.getCustomerDetails(customerIDString);
		return customerRepresentation;
	}
	
	@DELETE
	@Produces({"application/xml" , "application/json"})
	@Path("/customer/{customerID}")
	public GenericResponse deleteCustomer(@PathParam("customerID") String customerIDString){
		System.out.println("DELETE METHOD Request for Deleting a Customer ............." + customerIDString);
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
		
	}
}
