package com.online.lakeshoremarket.service;


import javax.ws.rs.Path;


@Path("/")
public class LakeshoreMarketResource {

	
	/*@GET
	@Produces({"application/xml" , "application/json"})
	@Path("/products/{searchString}")
	public ArrayList<ProductRepresentation> getProducts(@PathParam("searchString") String prodName) {
		System.out.println("GET METHOD Request for all products.............");
		ProductActivity productActivity = new ProductActivity();
		ArrayList<ProductRepresentation> prodRepresentationSet = productActivity.getProducts(prodName);
		return prodRepresentationSet;
	}*/
	
	/*@PUT
	@Consumes({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
	@Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
	@Path("/product")
	public GenericResponse createProduct(ProductRequest prodRequest) {
		System.out.println("PUT METHOD Request for Creating a new product .............");
		GenericResponse genericResponse = new GenericResponse();
		boolean isProductCreated = false;
		ProductActivity productActivity = new ProductActivity();
		isProductCreated = productActivity.createProduct(prodRequest);
		if(isProductCreated){
			genericResponse.setMessage("Product is created");
			genericResponse.setSuccess(true);
		}else{
			genericResponse.setMessage("Product is not created");
			genericResponse.setSuccess(false);
		}
		
		return genericResponse;	
	}*/
	
	/*@DELETE
	@Produces({"application/xml" , "application/json"})
	@Path("/order/{orderIDString}")
	public GenericResponse cancelOrder(@PathParam("orderIDString") String orderIDString){
		System.out.println("DELETE METHOD Request for Canceling an order .............");
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
		
	}*/
	
	/*@GET
	@Produces({"application/xml" , "application/json"})
	@Path("/order/{orderIDString}")
	public OrderRepresentation getOrderDetails(@PathParam("orderIDString") String orderIDString){
		System.out.println("GET METHOD Request for Order details.............");
		OrderActivity orderActivity = new OrderActivity();
		OrderRepresentation orderRepresentation = new OrderRepresentation();
		orderRepresentation = orderActivity.getOrderDetails(orderIDString);
		return orderRepresentation;
	}
	
	@POST
	@Produces({"application/xml" , "application/json"})
	@Path("/order/ship")
	public GenericResponse shipOrder(@FormParam("orderIDString") String orderIDString, @FormParam("trackingNumb") String trackingNumb){
		System.out.println("POST METHOD to ship order.............");
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
	}
	
	@POST
	@Produces({"application/xml" , "application/json"})
	@Path("/order/fulfill")
	public GenericResponse fulfillOrder(@FormParam("orderIDString") String orderIDString){
		System.out.println("POST METHOD to ship order.............");
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
	}*/
	
	/*@PUT
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
	}*/
	
	/*@PUT
	@Consumes({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
	@Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
	@Path("/partner")
	public GenericResponse createPartner(PartnerRequest partnerRequest) {
		System.out.println("PUT METHOD Request for Creating a new partner .............");
		GenericResponse genericResponse = new GenericResponse();
		boolean isPartnerCreated = false;
		PartnerActivity partnerActivity = new PartnerActivity();
		isPartnerCreated = partnerActivity.createPartner(partnerRequest);
		if(isPartnerCreated){
			genericResponse.setMessage("Partner is created");
			genericResponse.setSuccess(true);
		}else{
			genericResponse.setMessage("Partner is not created");
			genericResponse.setSuccess(false);
		}
		
		return genericResponse;	
	}*/
	
	/*@PUT
	@Consumes({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
	@Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
	@Path("/review/partner")
	public GenericResponse createPartnerReview(PartnerReviewRequest partnerReviewRequest) {
		System.out.println("PUT METHOD Request for Creating a new partner review.............");
		GenericResponse genericResponse = new GenericResponse();
		boolean isPartnerReviewCreated = false;
		ReviewActivity reviewActivity = new ReviewActivity();
		isPartnerReviewCreated = reviewActivity.createPartnerReview(partnerReviewRequest);
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
		ReviewActivity reviewActivity = new ReviewActivity();
		isProductReviewCreated = reviewActivity.createProductReview(productReviewRequest);
		if(isProductReviewCreated){
			genericResponse.setMessage("Product review is created");
			genericResponse.setSuccess(true);
		}else{
			genericResponse.setMessage("Product review is not created");
			genericResponse.setSuccess(false);
		}
		
		return genericResponse;	
	}*/
	
	/*@PUT
	@Consumes({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
	@Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
	@Path("/order")
	public GenericResponse buyProduct(OrderRequest orderRequest) {
		System.out.println("PUT METHOD Request for placing an order.............");
		GenericResponse genericResponse = new GenericResponse();
		int orderID = 0;
		PaymentActivity paymentActivity = new PaymentActivity();
		orderID = paymentActivity.buyProduct(orderRequest);
		if(0 != orderID){
			genericResponse.setMessage("Order is created");
			genericResponse.setSuccess(true);
			genericResponse.setGenericReturnValue(orderID+"");
		}else{
			genericResponse.setMessage("Order is not created");
			genericResponse.setSuccess(false);
		}
		
		return genericResponse;	
	}*/
	
	
	
	/*Start Maggie Resource
	 * 
	 * 
	 * */
	
	
	
	
	
	//----GET PRODUCT----
	/*@GET
	@Produces({"application/xml", "application/json"})
	@Path("/product/{productName}")
	public ProductRepresentation getProduct(@PathParam("productName") String prodName) {
		System.out.println("GET METHOD Request for individual product ............" + prodName);
		ProductActivity productActivity = new ProductActivity();
		return productActivity.getProduct(prodName); 
	}*/
	
	//----CHECK PRODUCT AVAILABILITY----
	/*@GET
	@Produces({"application/xml", "application/json"})
	@Path("/available/{productID}")
	public GenericResponse checkProductAvailability(@PathParam("productID") String prodName){ //should the path param always be ID? //is this okay? (not Product ID because there is no ID search)
		System.out.println("GET METHOD Request for Availability of Product ............" + prodName);
		boolean isProductAvailable = false;
		ProductActivity productActivity = new ProductActivity();
		isProductAvailable = productActivity.checkProductAvailability(prodName);
		GenericResponse genericResponse = new GenericResponse();
		if(isProductAvailable){
			genericResponse.setMessage("Product is available");
			genericResponse.setSuccess(true);
		}else{
			genericResponse.setMessage("Product is not available");
			genericResponse.setSuccess(false);
		}		
		return genericResponse;
	}*/
	
	//----GET CUSTOMER DETAILS----
	/*@GET
	@Produces({"application/xml", "application/json"})
	@Path("/customer/{customerID}")
	public CustomerRepresentation getCustomerDetails(@PathParam("customerID") String customerIDString){ 
		System.out.println("GET METHOD Request for Customer details............." + customerIDString);
		CustomerActivity customerActivity = new CustomerActivity();
		CustomerRepresentation customerRepresentation = new CustomerRepresentation();
		customerRepresentation = customerActivity.getCustomerDetails(customerIDString);
		return customerRepresentation;
	}*/
	
	//----DELETE CUSTOMER----
	
	/*@DELETE
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
		
	}*/
	
	//----GET PARTNER DETAILS----
	/*@GET
	@Produces({"application/xml", "application/json"})
	@Path("/partner/{partnerID}")
	public PartnerRepresentation getPartnerDetails(@PathParam("partnerID") String partnerIDString){
		System.out.println("GET METHOD Request for Partner details............." + partnerIDString);
		PartnerActivity partnerActivity = new PartnerActivity();
		PartnerRepresentation partnerRepresentation = new PartnerRepresentation();
		partnerRepresentation = partnerActivity.getPartnerDetails(partnerIDString);
		return partnerRepresentation;
	}
	
	//----DELETE PARTNER----
	
	@DELETE
	@Produces({"application/xml" , "application/json"})
	@Path("/partner/{partnerIDString}")
	public GenericResponse deletePartner(@PathParam("partnerIDString") String partnerIDString){
		System.out.println("DELETE METHOD Request for Deleting a Partner ............." + partnerIDString);
		boolean isPartnerDeleted = false;
		PartnerActivity partnerActivity = new PartnerActivity();
		isPartnerDeleted = partnerActivity.deletePartner(partnerIDString);
		GenericResponse genericResponse = new GenericResponse();
		if(isPartnerDeleted){
			genericResponse.setMessage("Partner has been deleted");
			genericResponse.setSuccess(true);
		}else{
			genericResponse.setMessage("Partner was not deleted");
			genericResponse.setSuccess(false);
		}		
		return genericResponse;
		
	}*/
	
	
	
	
	/*Start Elliott Resource
	 * 
	 * 
	 * */
	
	/*@GET
	@Produces({"application/xml", "application/json"})
	@Path("/review/partner/{partnerID}")
	public ReviewRepresentation getPartnerReview(@PathParam("partnerID") int partnerID) {
		System.out.println("GET METHOD Request for partner review............" + partnerID);
		ReviewActivity reviewActivity = new ReviewActivity();
		return reviewActivity.getReview( "partner", partnerID );
	}
	
	@GET
	@Produces({"application/xml", "application/json"})
	@Path("/review/product/{productID}")
	public ReviewRepresentation getProductReview(@PathParam("productID") int productID) {
		System.out.println("GET METHOD Request for product review............" + productID);
		ReviewActivity reviewActivity = new ReviewActivity();
		return reviewActivity.getReview( "product", productID );
	}*/
	
	/*@GET
	@Produces({"application/xml", "application/json"})
	@Path("/report/{partnerID}")
	public ArrayList<PartnerReportRepresentation> getPartnerReport(@PathParam("partnerID") int partnerID) {
		System.out.println("GET METHOD Request for partner report............" + partnerID);
		PartnerActivity partnerActivity = new PartnerActivity();
		return partnerActivity.getPartnerReport( partnerID );
	}*/
	
}
