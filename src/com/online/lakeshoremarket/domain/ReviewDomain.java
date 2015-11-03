package com.online.lakeshoremarket.domain;

import java.sql.Timestamp;
import java.util.Date;

import com.online.lakeshoremarket.dao.ReviewDAO;
import com.online.lakeshoremarket.model.review.Review;

/**
 * Represents the review domain business logic
 *
 */
public class ReviewDomain {
	
	ReviewDAO reviewDAO = null;

	/**
	 * Adds a review by a customer of a partner
	 * @param review 	the review to add
	 * @return			true if success, false else
	 */
	public boolean addPartnerReview(Review review) {
		boolean isPartnerReviewAdded = false;
		reviewDAO = new ReviewDAO();
		Date systemDate = new Date();
		Timestamp date = new Timestamp(systemDate.getTime());
		review.setReviewDate(date);
		isPartnerReviewAdded = reviewDAO.addPartnerReview(review);
		return isPartnerReviewAdded;
	}

	/**
	 * adds a review by a customer of a product
	 * @param review	the review to add
	 * @return			true if success, false else
	 */
	public boolean addProductReview(Review review) {
		boolean isProductReviewAdded = false;
		reviewDAO = new ReviewDAO();
		Date systemDate = new Date();
		Timestamp date = new Timestamp(systemDate.getTime());
		review.setReviewDate(date);
		isProductReviewAdded = reviewDAO.addProductReview(review);
		return isProductReviewAdded;
	}
	
	/**
	 * Gets a partner review by the review ID
	 * @param partnerReviewID
	 * @return Review
	 */
	public Review getPartnerReviewByID( int partnerReviewID ) {
		ReviewDAO reviewDao = new ReviewDAO();
		return reviewDAO.getPartnerReviewByID( partnerReviewID );
	}
	
	/**
	 * Gets a product review by the review ID
	 * @param productReviewID
	 * @return Review
	 */
	public Review getProductReviewByID( int productReviewID ) {
		ReviewDAO reviewDao = new ReviewDAO();
		return reviewDAO.getProductReviewByID( productReviewID );
	}

}
