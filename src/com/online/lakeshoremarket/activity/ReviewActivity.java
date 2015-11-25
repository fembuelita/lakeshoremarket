package com.online.lakeshoremarket.activity;

import java.util.Date;
import java.util.GregorianCalendar;

import javax.xml.datatype.DatatypeConfigurationException;
import javax.xml.datatype.DatatypeFactory;
import javax.xml.datatype.XMLGregorianCalendar;

import com.online.lakeshoremarket.domain.ReviewDomain;
import com.online.lakeshoremarket.model.review.Review;
import com.online.lakeshoremarket.model.review.ReviewImpl;
import com.online.lakeshoremarket.representation.review.PartnerReviewRequest;
import com.online.lakeshoremarket.representation.review.ProductReviewRequest;
import com.online.lakeshoremarket.representation.review.ReviewRepresentation;

public class ReviewActivity {

	public boolean createPartnerReview(PartnerReviewRequest partnerReviewRequest) {
		boolean isPartnerReviewCreated = false;
		ReviewDomain reviewDomain = new ReviewDomain();
		Review review = new ReviewImpl();
		
		review.setCustomerID(partnerReviewRequest.getCustomerID());
		review.setPartnerID(partnerReviewRequest.getPartnerID());
		review.setRating(partnerReviewRequest.getRating());
		review.setReview(partnerReviewRequest.getReview());
		
		isPartnerReviewCreated = reviewDomain.addPartnerReview(review);
		
		return isPartnerReviewCreated;
	}
	
	public boolean createProductReview(ProductReviewRequest productReviewRequest) {
		boolean isProductReviewCreated = false;
		ReviewDomain reviewDomain = new ReviewDomain();
		Review review = new ReviewImpl();
		
		review.setCustomerID(productReviewRequest.getCustomerID());
		review.setProductID(productReviewRequest.getProductID());
		review.setRating(productReviewRequest.getRating());
		review.setReview(productReviewRequest.getReview());
		
		isProductReviewCreated = reviewDomain.addProductReview(review);
		
		return isProductReviewCreated;
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
			
		} else if( type == "product" ) {
			review = revDomain.getProductReviewByID( reviewID );
			revRep.setProductReviewID( reviewID );
			revRep.setProductID( review.getProductID() );
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
