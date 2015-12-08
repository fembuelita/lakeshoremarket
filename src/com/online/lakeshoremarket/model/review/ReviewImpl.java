package com.online.lakeshoremarket.model.review;


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
	private long reviewDate;
	

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
	public long getReviewDate() {
		return reviewDate;
	}
	public void setReviewDate(long reviewDate) {
		this.reviewDate = reviewDate;
	}
	
	
}
