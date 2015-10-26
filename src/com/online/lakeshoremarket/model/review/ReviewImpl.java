package com.online.lakeshoremarket.model.review;

import java.sql.Timestamp;

/**
 * instantiates the review interface to represent the review model
 *
 */
public class ReviewImpl implements Review{

	private int customerID;
	private int partnerID;
	private int partnerReviewID;
	private int productID;
	private int productReviewID;
	private int rating;
	private String review;
	private Timestamp reviewDate;
	
	
	
	// Constructors might not be needed at all
	/**
	* <h1>Constructor for Partner Review</h1>
	* This Constructor is used for creating an object of PARTNER REVIEW
	* <p>
	* <b>Note:</b> PARTNER REVIEW
	*
	*@param customerID
	*			type int
	*@param partnerID
	*			type int
	*@param partnerReviewID
	*			type int
	*@param rating
	*			type int
	*@param review
	*			type String
	*@param reviewDate
	*			type Timestamp
	* @author  Rayyan Mohammed Jaweed
	* @version 1.0
	* @since   09-27-2015
	*//*
	public ReviewImpl(int customerID, int partnerID, int partnerReviewID, int rating, String review,Timestamp reviewDate) {
		super();
		this.customerID = customerID;
		this.partnerID = partnerID;
		this.partnerReviewID = partnerReviewID;
		this.rating = rating;
		this.review = review;
		this.reviewDate = reviewDate;
	}
	
	// Constructors might not be needed at all
	/**
	* <h1>Constructor for Product Review</h1>
	* This Constructor is used for creating an object of PRODUCT REVIEW
	* <p>
	* <b>Note:</b> PRODUCT REVIEW
	*
	*@param customerID
	*			type int
	*@param rating
	*			type int
	*@param review
	*			type String
	*@param reviewDate
	*			type Timestamp
	*@param productID
	*			type int
	*@param productReviewID
	*			type int
	* @author  Rayyan Mohammed Jaweed
	* @version 1.0
	* @since   09-27-2015
	*//*
	public ReviewImpl(int customerID, int rating, String review,Timestamp reviewDate, int productID, int productReviewID) {
		super();
		this.customerID = customerID;
		this.productID = productID;
		this.productReviewID = productReviewID;
		this.rating = rating;
		this.review = review;
		this.reviewDate = reviewDate;
	}*/

	public int getCustomerID() {
		return customerID;
	}
	public void setCustomerID(int customerID) {
		this.customerID = customerID;
	}
	public int getPartnerID() {
		return partnerID;
	}
	public void setPartnerID(int partnerID) {
		this.partnerID = partnerID;
	}
	public int getPartnerReviewID() {
		return partnerReviewID;
	}
	public void setPartnerReviewID(int partnerReviewID) {
		this.partnerReviewID = partnerReviewID;
	}
	public int getProductID() {
		return productID;
	}
	public void setProductID(int productID) {
		this.productID = productID;
	}
	public int getProductReviewID() {
		return productReviewID;
	}
	public void setProductReviewID(int productReviewID) {
		this.productReviewID = productReviewID;
	}
	public int getRating() {
		return rating;
	}
	public void setRating(int rating) {
		this.rating = rating;
	}
	public String getReview() {
		return review;
	}
	public void setReview(String review) {
		this.review = review;
	}
	public Timestamp getReviewDate() {
		return reviewDate;
	}
	public void setReviewDate(Timestamp reviewDate) {
		this.reviewDate = reviewDate;
	}
	
	
}
