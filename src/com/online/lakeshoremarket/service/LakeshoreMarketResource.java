package com.online.lakeshoremarket.service;

import java.util.ArrayList;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.online.lakeshoremarket.activity.LakeshoreMarketActivity;
import com.online.lakeshoremarket.representation.customer.CustomerRepresentation;
import com.online.lakeshoremarket.representation.customer.CustomerRequest;
import com.online.lakeshoremarket.representation.generic.GenericResponse;
import com.online.lakeshoremarket.representation.order.OrderRepresentation;
import com.online.lakeshoremarket.representation.order.OrderRequest;
import com.online.lakeshoremarket.representation.partner.PartnerRepresentation;
import com.online.lakeshoremarket.representation.partner.PartnerRequest;
import com.online.lakeshoremarket.representation.partnerReport.PartnerReportRepresentation;
import com.online.lakeshoremarket.representation.product.ProductRepresentation;
import com.online.lakeshoremarket.representation.product.ProductRequest;
import com.online.lakeshoremarket.representation.review.PartnerReviewRequest;
import com.online.lakeshoremarket.representation.review.ReviewRepresentation;
import com.online.lakeshoremarket.representation.review.ProductReviewRequest;


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
	@Consumes({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
	@Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
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
	
	@PUT
	@Consumes({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
	@Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
	@Path("/customer")
	public GenericResponse createCustomer(CustomerRequest custRequest) {
		System.out.println("PUT METHOD Request for Creating a new customer .............");
		GenericResponse genericResponse = new GenericResponse();
		boolean isCustomerCreated = false;
		LakeshoreMarketActivity marketActivity = new LakeshoreMarketActivity();
		isCustomerCreated = marketActivity.createCustomer(custRequest);
		if(isCustomerCreated){
			genericResponse.setMessage("Customer is created");
			genericResponse.setSuccess(true);
		}else{
			genericResponse.setMessage("Customer is not created");
			genericResponse.setSuccess(false);
		}
		
		return genericResponse;	
	}
	
	@PUT
	@Consumes({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
	@Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
	@Path("/partner")
	public GenericResponse createPartner(PartnerRequest partnerRequest) {
		System.out.println("PUT METHOD Request for Creating a new partner .............");
		GenericResponse genericResponse = new GenericResponse();
		boolean isPartnerCreated = false;
		LakeshoreMarketActivity marketActivity = new LakeshoreMarketActivity();
		isPartnerCreated = marketActivity.createPartner(partnerRequest);
		if(isPartnerCreated){
			genericResponse.setMessage("Partner is created");
			genericResponse.setSuccess(true);
		}else{
			genericResponse.setMessage("Partner is not created");
			genericResponse.setSuccess(false);
		}
		
		return genericResponse;	
	}
	
	@PUT
	@Consumes({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
	@Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
	@Path("/review/partner")
	public GenericResponse createPartnerReview(PartnerReviewRequest partnerReviewRequest) {
		System.out.println("PUT METHOD Request for Creating a new partner review.............");
		GenericResponse genericResponse = new GenericResponse();
		boolean isPartnerReviewCreated = false;
		LakeshoreMarketActivity marketActivity = new LakeshoreMarketActivity();
		isPartnerReviewCreated = marketActivity.createPartnerReview(partnerReviewRequest);
		if(isPartnerReviewCreated){
			genericResponse.setMessage("Partner review is created");
			genericResponse.setSuccess(true);
		}else{
			genericResponse.setMessage("Partner review is not created");
			genericResponse.setSuccess(false);
		}
		
		return genericResponse;	
	}
	
	@PUT
	@Consumes({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
	@Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
	@Path("/review/product")
	public GenericResponse createProductReview(ProductReviewRequest productReviewRequest) {
		System.out.println("PUT METHOD Request for Creating a new product review.............");
		GenericResponse genericResponse = new GenericResponse();
		boolean isProductReviewCreated = false;
		LakeshoreMarketActivity marketActivity = new LakeshoreMarketActivity();
		isProductReviewCreated = marketActivity.createProductReview(productReviewRequest);
		if(isProductReviewCreated){
			genericResponse.setMessage("Product review is created");
			genericResponse.setSuccess(true);
		}else{
			genericResponse.setMessage("Product review is not created");
			genericResponse.setSuccess(false);
		}
		
		return genericResponse;	
	}
	
	@PUT
	@Consumes({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
	@Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
	@Path("/order")
	public GenericResponse buyProduct(OrderRequest orderRequest) {
		System.out.println("PUT METHOD Request for placing an order.............");
		GenericResponse genericResponse = new GenericResponse();
		int orderID = 0;
		LakeshoreMarketActivity marketActivity = new LakeshoreMarketActivity();
		orderID = marketActivity.buyProduct(orderRequest);
		if(0 != orderID){
			genericResponse.setMessage("Order is created");
			genericResponse.setSuccess(true);
			genericResponse.setGenericReturnValue(orderID+"");
		}else{
			genericResponse.setMessage("Order is not created");
			genericResponse.setSuccess(false);
		}
		
		return genericResponse;	
	}
	
	
	
	/*Start Maggie Resource
	 * 
	 * 
	 * */
	
	
	
	
	
	//----GET PRODUCT----
	@GET
	@Produces({"application/xml", "application/json"})
	@Path("/product/{productName}")
	public ProductRepresentation getProduct(@PathParam("productName") String prodName) {
		System.out.println("GET METHOD Request for individual product ............" + prodName);
		LakeshoreMarketActivity marketActivity = new LakeshoreMarketActivity();
		return marketActivity.getProduct(prodName); 
	}
	
	//----CHECK PRODUCT AVAILABILITY----
	@GET
	@Produces({"application/xml", "application/json"})
	@Path("/available/{productID}")
	public Response checkProductAvailability(@PathParam("productID") String prodName){ //should the path param always be ID? //is this okay? (not Product ID because there is no ID search)
			System.out.println("GET METHOD Request for Availability of Product ............" + prodName);
			boolean isProductAvailable = false;
			LakeshoreMarketActivity marketActivity = new LakeshoreMarketActivity();
			isProductAvailable = marketActivity.checkProductAvailability(prodName);
			if(isProductAvailable){
				return Response.status(Response.Status.OK).build();
			}else{
				return Response.status(Response.Status.SERVICE_UNAVAILABLE).build();
			}
			
		
	}
	
	//----GET CUSTOMER DETAILS----
	@GET
	@Produces({"application/xml", "application/json"})
	@Path("/customer/{customerID}")
	public CustomerRepresentation getCustomerDetails(@PathParam("customerID") String customerIDString){ 
		System.out.println("GET METHOD Request for Customer details............." + customerIDString);
		LakeshoreMarketActivity marketActivity = new LakeshoreMarketActivity();
		CustomerRepresentation customerRepresentation = new CustomerRepresentation();
		customerRepresentation = marketActivity.getCustomerDetails(customerIDString);
		return customerRepresentation;
	}
	
	//----DELETE CUSTOMER----
	
	@DELETE
	@Produces({"application/xml" , "application/json"})
	@Path("/customer/{customerID}")
	public Response deleteCustomer(@PathParam("customerID") String customerIDString){
		System.out.println("DELETE METHOD Request for Deleting a Customer ............." + customerIDString);
		boolean isCustomerDeleted = false;
		LakeshoreMarketActivity marketActivity = new LakeshoreMarketActivity();
		isCustomerDeleted = marketActivity.deleteCustomer(customerIDString);
		if(isCustomerDeleted){
			return Response.status(Response.Status.OK).build();
		}else{
			return Response.status(Response.Status.SERVICE_UNAVAILABLE).build();
		}
		
	}
	
	//----GET PARTNER DETAILS----
	@GET
	@Produces({"application/xml", "application/json"})
	@Path("/partner/{partnerID}")
	public PartnerRepresentation getPartnerDetails(@PathParam("partnerID") String partnerIDString){
		System.out.println("GET METHOD Request for Partner details............." + partnerIDString);
		LakeshoreMarketActivity marketActivity = new LakeshoreMarketActivity();
		PartnerRepresentation partnerRepresentation = new PartnerRepresentation();
		partnerRepresentation = marketActivity.getPartnerDetails(partnerIDString);
		return partnerRepresentation;
	}
	
	//----DELETE PARTNER----
	
	@DELETE
	@Produces({"application/xml" , "application/json"})
	@Path("/partner/{partnerIDString}")
	public Response deletePartner(@PathParam("partnerIDString") String partnerIDString){
		System.out.println("DELETE METHOD Request for Deleting a Partner ............." + partnerIDString);
		boolean isPartnerDeleted = false;
		LakeshoreMarketActivity marketActivity = new LakeshoreMarketActivity();
		isPartnerDeleted = marketActivity.deletePartner(partnerIDString);
		if(isPartnerDeleted){
			return Response.status(Response.Status.OK).build();
		}else{
			return Response.status(Response.Status.SERVICE_UNAVAILABLE).build();
		}
		
	}
	
	
	
	
	/*Start Elliott Resource
	 * 
	 * 
	 * */
	
	@GET
	@Produces({"application/xml", "application/json"})
	@Path("/review/partner/{partnerID}")
	public ReviewRepresentation getPartnerReview(@PathParam("partnerID") int partnerID) {
		System.out.println("GET METHOD Request for partner review............" + partnerID);
		LakeshoreMarketActivity marketActivity = new LakeshoreMarketActivity();
		return marketActivity.getReview( "partner", partnerID );
	}
	
	@GET
	@Produces({"application/xml", "application/json"})
	@Path("/review/product/{productID}")
	public ReviewRepresentation getProductReview(@PathParam("productID") int productID) {
		System.out.println("GET METHOD Request for product review............" + productID);
		LakeshoreMarketActivity marketActivity = new LakeshoreMarketActivity();
		return marketActivity.getReview( "product", productID );
	}
	
	@GET
	@Produces({"application/xml", "application/json"})
	@Path("/report/{partnerID}")
	public ArrayList<PartnerReportRepresentation> getPartnerReport(@PathParam("partnerID") int partnerID) {
		System.out.println("GET METHOD Request for partner report............" + partnerID);
		LakeshoreMarketActivity marketActivity = new LakeshoreMarketActivity();
		return marketActivity.getPartnerReport( partnerID );
	}
	
}
