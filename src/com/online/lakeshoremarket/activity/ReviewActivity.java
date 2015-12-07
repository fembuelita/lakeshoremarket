package com.online.lakeshoremarket.activity;

import java.util.Date;
import java.util.GregorianCalendar;

import javax.xml.datatype.DatatypeConfigurationException;
import javax.xml.datatype.DatatypeFactory;
import javax.xml.datatype.XMLGregorianCalendar;

import com.online.lakeshoremarket.domain.ReviewDomain;
import com.online.lakeshoremarket.model.review.Review;
import com.online.lakeshoremarket.model.review.ReviewImpl;
import com.online.lakeshoremarket.representation.generic.GenericResponse;
import com.online.lakeshoremarket.representation.generic.Link;
import com.online.lakeshoremarket.representation.review.PartnerReviewRequest;
import com.online.lakeshoremarket.representation.review.ProductReviewRequest;
import com.online.lakeshoremarket.representation.review.ReviewRepresentation;
import com.online.lakeshoremarket.util.Constant;

/**
 * Interacts with review model and domain business logic to create and modify review representations
 *
 */

public class ReviewActivity {

	/**
	 * Creates partner review representation
	 * @param partnerReviewRequest
	 * @return genericResponse	success or failure message
	 */
	
	public GenericResponse createPartnerReview(PartnerReviewRequest partnerReviewRequest) {
		int partnerReviewID = 0;
		GenericResponse genericResponse = new GenericResponse();
		ReviewDomain reviewDomain = new ReviewDomain();
		Review review = new ReviewImpl();
		
		review.setCustomerID(partnerReviewRequest.getCustomerID());
		review.setPartnerID(partnerReviewRequest.getPartnerID());
		review.setRating(partnerReviewRequest.getRating());
		review.setReview(partnerReviewRequest.getReview());
		
		partnerReviewID = reviewDomain.addPartnerReview(review);
		if(0 != partnerReviewID){
			genericResponse.setMessage("Partner review is created");
			genericResponse.setSuccess(true);
			Link get = new Link("Get Partner Review Details", Constant.LSM_COMMON_URL + "/review/partner/" + partnerReviewID, "application/xml");
			genericResponse.setLinks(get);
		}else{
			genericResponse.setMessage("Partner review is not created");
			genericResponse.setSuccess(false);
		}
		
		return genericResponse;
	}
	
	/**
	 * Creates product review representation
	 * @param productReviewRequest
	 * @return genericResponse	success or failure message
	 */
	
	public GenericResponse createProductReview(ProductReviewRequest productReviewRequest) {
		int productReviewID = 0;
		GenericResponse genericResponse = new GenericResponse();
		ReviewDomain reviewDomain = new ReviewDomain();
		Review review = new ReviewImpl();
		
		review.setCustomerID(productReviewRequest.getCustomerID());
		review.setProductID(productReviewRequest.getProductID());
		review.setRating(productReviewRequest.getRating());
		review.setReview(productReviewRequest.getReview());
		
		productReviewID = reviewDomain.addProductReview(review);
		if(0 != productReviewID){
			genericResponse.setMessage("Product review is created");
			genericResponse.setSuccess(true);
			Link get = new Link("Get Product Review Details", Constant.LSM_COMMON_URL + "/review/product/" + productReviewID, "application/xml");
			genericResponse.setLinks(get);
		}else{
			genericResponse.setMessage("Product review is not created");
			genericResponse.setSuccess(false);
		}
		
		return genericResponse;
	}
	
	/**
	 * Builds a review representation
	 * @param type 		partner or product (lowercase)
	 * @param reviewID 	the partner ID or product ID, depending on type
	 * @return ReviewRepresentation
	 */
	public ReviewRepresentation getReview( String type, int reviewID ) {
		ReviewDomain revDomain = new ReviewDomain();
		Review review;
		ReviewRepresentation revRep = new ReviewRepresentation();
		
		if( type == "partner" ) {
			review = revDomain.getPartnerReviewByID( reviewID );
			revRep.setPartnerReviewID( reviewID );
			revRep.setPartnerID( review.getPartnerID() );
			Link get = new Link("Get Partner Details", Constant.LSM_COMMON_URL + "/partner/" + review.getPartnerID(), "application/xml");
			revRep.setLinks(get);
			
		} else if( type == "product" ) {
			review = revDomain.getProductReviewByID( reviewID );
			revRep.setProductReviewID( reviewID );
			revRep.setProductID( review.getProductID() );
			Link get = new Link("Get Product Details", Constant.LSM_COMMON_URL + "/product/" + review.getProductID(), "application/xml");
			Link buy = new Link("Buy Product", Constant.LSM_COMMON_URL + "/order", "application/xml");
			revRep.setLinks(get,buy);
		} else {
			throw new IllegalArgumentException( "Invalid review type (supplied " + type + ")" );
		}
		
		revRep.setCustomerID( review.getCustomerID() );
		revRep.setRating( review.getRating() );
		revRep.setReview( review.getReview() );
		if(null != review.getReviewDate()){
			GregorianCalendar gregCalReviewDate = new GregorianCalendar();
			long longReviewDate = review.getReviewDate().getTime();
			Date utilReviewDate = new Date(longReviewDate);
			gregCalReviewDate.setTime(utilReviewDate);
			XMLGregorianCalendar xmlReviewDate;
			try {
				xmlReviewDate = DatatypeFactory.newInstance().newXMLGregorianCalendar(gregCalReviewDate);
				revRep.setReviewDate(xmlReviewDate);
			} catch (DatatypeConfigurationException e) {
				e.printStackTrace();
			}
		}
		
		return revRep;
	}
}
