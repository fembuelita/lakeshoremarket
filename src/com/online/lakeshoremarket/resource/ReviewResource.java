package com.online.lakeshoremarket.resource;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.online.lakeshoremarket.activity.ReviewActivity;
import com.online.lakeshoremarket.representation.generic.GenericResponse;
import com.online.lakeshoremarket.representation.review.PartnerReviewRequest;
import com.online.lakeshoremarket.representation.review.ProductReviewRequest;
import com.online.lakeshoremarket.representation.review.ReviewRepresentation;

@Path("/")
public class ReviewResource {

	@PUT
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
	}
	
	@GET
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
	}
}
