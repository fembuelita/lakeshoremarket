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
import com.online.lakeshoremarket.representation.order.OrderRepresentation;
import com.online.lakeshoremarket.util.LSMAuthenticator;

@Path("/")
public class OrderResource {

	@DELETE
	@Produces({"application/xml" , "application/json"})
	@Path("/order/{orderIDString}")
	public GenericResponse cancelOrder(@PathParam("orderIDString") String orderIDString, @HeaderParam("email") String email, @HeaderParam("password") String password){
		System.out.println("DELETE METHOD Request for Canceling an order .............");
		boolean isUserAuthentic = false;
		isUserAuthentic = LSMAuthenticator.authenticateUser(email, password);
		if(isUserAuthentic){
			GenericResponse genericResponse = new GenericResponse();
			boolean isOrderRefunded = false;
			OrderActivity orderActivity = new OrderActivity();
			isOrderRefunded = orderActivity.cancelOrder(orderIDString);
			if(isOrderRefunded){
				genericResponse.setMessage("Order is cancelled");
				genericResponse.setSuccess(true);
			}else{
				genericResponse.setMessage("Order is not cancelled");
				genericResponse.setSuccess(false);
			}
			return genericResponse;
		}else{
			throw new GenericLSMException("User is not authorized", Response.Status.UNAUTHORIZED);
		}
		
	}
	
	@GET
	@Produces({"application/xml" , "application/json"})
	@Path("/order/{orderIDString}")
	public OrderRepresentation getOrderDetails(@PathParam("orderIDString") String orderIDString, @HeaderParam("email") String email, @HeaderParam("password") String password){
		System.out.println("GET METHOD Request for Order details.............");
		boolean isUserAuthentic = false;
		isUserAuthentic = LSMAuthenticator.authenticateUser(email, password);
		if(isUserAuthentic){
			OrderActivity orderActivity = new OrderActivity();
			OrderRepresentation orderRepresentation = new OrderRepresentation();
			orderRepresentation = orderActivity.getOrderDetails(orderIDString);
			return orderRepresentation;
		}else{
			throw new GenericLSMException("User is not authorized", Response.Status.UNAUTHORIZED);
		}
	}
	
	@POST
	@Produces({"application/xml" , "application/json"})
	@Path("/order/ship")
	public GenericResponse shipOrder(@FormParam("orderIDString") String orderIDString, @FormParam("trackingNumb") String trackingNumb, @HeaderParam("email") String email, @HeaderParam("password") String password){
		System.out.println("POST METHOD to ship order.............");
		boolean isUserAuthentic = false;
		isUserAuthentic = LSMAuthenticator.authenticateUser(email, password);
		if(isUserAuthentic){
			GenericResponse genericResponse = new GenericResponse();
			boolean isOrderShipped = false;
			OrderActivity orderActivity = new OrderActivity();
			isOrderShipped = orderActivity.shipOrder(orderIDString,trackingNumb);
			if(isOrderShipped){
				genericResponse.setMessage("Order is shipped");
				genericResponse.setSuccess(true);
			}else{
				genericResponse.setMessage("Order is not shipped");
				genericResponse.setSuccess(false);
			}
			return genericResponse;
		}else{
			throw new GenericLSMException("User is not authorized", Response.Status.UNAUTHORIZED);
		}
	}
	
	@POST
	@Produces({"application/xml" , "application/json"})
	@Path("/order/fulfill")
	public GenericResponse fulfillOrder(@FormParam("orderIDString") String orderIDString, @HeaderParam("email") String email, @HeaderParam("password") String password){
		System.out.println("POST METHOD to ship order.............");
		boolean isUserAuthentic = false;
		isUserAuthentic = LSMAuthenticator.authenticateUser(email, password);
		if(isUserAuthentic){
			GenericResponse genericResponse = new GenericResponse();
			boolean isOrderFulfilled = false;
			OrderActivity orderActivity = new OrderActivity();
			isOrderFulfilled = orderActivity.fulfillOrder(orderIDString);
			if(isOrderFulfilled){
				genericResponse.setMessage("Order is fulfilled");
				genericResponse.setSuccess(true);
			}else{
				genericResponse.setMessage("Order is not fulfilled");
				genericResponse.setSuccess(false);
			}
			return genericResponse;
		}else{
			throw new GenericLSMException("User is not authorized", Response.Status.UNAUTHORIZED);
		}
	}
}
