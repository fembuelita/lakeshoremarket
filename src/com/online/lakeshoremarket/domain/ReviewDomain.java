package com.online.lakeshoremarket.domain;

import java.time.Instant;

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
	 * @return			partner review id of newly added review
	 */
	public int addPartnerReview(Review review) {
		int partnerReviewID = 0;
		reviewDAO = new ReviewDAO();
		review.setReviewDate(Instant.now().getEpochSecond());
		partnerReviewID = reviewDAO.addPartnerReview(review);
		return partnerReviewID;
	}

	/**
	 * adds a review by a customer of a product
	 * @param review	the review to add
	 * @return			product review id of newly added review
	 */
	public int addProductReview(Review review) {
		int productReviewID = 0;
		reviewDAO = new ReviewDAO();
		review.setReviewDate(Instant.now().getEpochSecond());
		productReviewID = reviewDAO.addProductReview(review);
		return productReviewID;
	}
	
	/**
	 * Gets a partner review by the review ID
	 * @param partnerReviewID
	 * @return Review
	 */
	public Review getPartnerReviewByID( int partnerReviewID ) {
		reviewDAO = new ReviewDAO();
		return reviewDAO.getPartnerReviewByID( partnerReviewID );
	}
	
	/**
	 * Gets a product review by the review ID
	 * @param productReviewID
	 * @return Review
	 */
	public Review getProductReviewByID( int productReviewID ) {
		reviewDAO = new ReviewDAO();
		return reviewDAO.getProductReviewByID( productReviewID );
	}

}
