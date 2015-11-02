package com.online.lakeshoremarket.service;

import java.util.ArrayList;

import javax.ws.rs.DELETE;
import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.ResponseBuilder;

import com.online.lakeshoremarket.activity.LakeshoreMarketActivity;
import com.online.lakeshoremarket.representation.order.OrderRepresentation;
import com.online.lakeshoremarket.representation.product.ProductRepresentation;
import com.online.lakeshoremarket.representation.product.ProductRequest;


@Path("/")
public class LakeshoreMarketResource {

	
	@GET
	@Produces({"application/xml" , "application/json"})
	@Path("/products/{searchString}")
	public ArrayList<ProductRepresentation> getProducts(@PathParam("searchString") String prodName) {
		System.out.println("GET METHOD Request for all products.............");
		LakeshoreMarketActivity marketActivity = new LakeshoreMarketActivity();
		ArrayList<ProductRepresentation> prodRepresentationSet = marketActivity.getProducts(prodName); 
		return prodRepresentationSet;
	}
	
	@PUT
	@Produces({"application/xml" , "application/json"})
	@Path("/product")
	public Response createProduct(ProductRequest prodRequest) {
		System.out.println("PUT METHOD Request for Creating a new product .............");
		boolean isProductCreated = false;
		LakeshoreMarketActivity marketActivity = new LakeshoreMarketActivity();
		isProductCreated = marketActivity.createProduct(prodRequest);
		if(isProductCreated){
			return Response.status(Response.Status.CREATED).build();
		}
		
		return Response.status(Response.Status.SERVICE_UNAVAILABLE).build();	
	}
	
	@DELETE
	@Produces({"application/xml" , "application/json"})
	@Path("/order/{orderIDString}")
	public Response cancelOrder(@PathParam("orderIDString") String orderIDString){
		System.out.println("DELETE METHOD Request for Canceling an order .............");
		boolean isOrderRefunded = false;
		LakeshoreMarketActivity marketActivity = new LakeshoreMarketActivity();
		isOrderRefunded = marketActivity.cancelOrder(orderIDString);
		if(isOrderRefunded){
			return Response.status(Response.Status.OK).build();
		}else{
			return Response.status(Response.Status.SERVICE_UNAVAILABLE).build();
		}
		
	}
	
	@GET
	@Produces({"application/xml" , "application/json"})
	@Path("/order/{orderIDString}")
	public OrderRepresentation getOrderDetails(@PathParam("orderIDString") String orderIDString){
		System.out.println("GET METHOD Request for Order details.............");
		LakeshoreMarketActivity marketActivity = new LakeshoreMarketActivity();
		OrderRepresentation orderRepresentation = new OrderRepresentation();
		orderRepresentation = marketActivity.getOrderDetails(orderIDString);
		return orderRepresentation;
	}
	
	@POST
	@Produces({"application/xml" , "application/json"})
	@Path("/order/ship")
	public Response shipOrder(@FormParam("orderIDString") String orderIDString, @FormParam("trackingNumb") String trackingNumb){
		System.out.println("POST METHOD to ship order.............");
		boolean isOrderShipped = false;
		LakeshoreMarketActivity marketActivity = new LakeshoreMarketActivity();
		isOrderShipped = marketActivity.shipOrder(orderIDString,trackingNumb);
		if(isOrderShipped){
			return Response.status(Response.Status.OK).build();
		}else{
			return Response.status(Response.Status.SERVICE_UNAVAILABLE).build();
		}
	}
	
	@POST
	@Produces({"application/xml" , "application/json"})
	@Path("/order/fulfill")
	public Response fulfillOrder(@FormParam("orderIDString") String orderIDString){
		System.out.println("POST METHOD to ship order.............");
		boolean isOrderFulfilled = false;
		LakeshoreMarketActivity marketActivity = new LakeshoreMarketActivity();
		isOrderFulfilled = marketActivity.fulfillOrder(orderIDString);
		if(isOrderFulfilled){
			return Response.status(Response.Status.OK).build();
		}else{
			return Response.status(Response.Status.SERVICE_UNAVAILABLE).build();
		}
	}
	
	
	
	/*Start Maggie Resource
	 * 
	 * 
	 * */
	
	
	
	@GET
	@Produces({"application/xml", "application/json"})
	@Path("/product/{productID}")
	public ProductRepresentation getProduct(@PathParam("productID") int productID) {
		System.out.println("GET METHOD Request for individual product ............" + productID);
		LakeshoreMarketActivity marketActivity = new LakeshoreMarketActivity();
		return marketActivity.getProduct(productID);
	}
	
	
	
	/*Start Elliott Resource
	 * 
	 * 
	 * */
	 
	
	
}
