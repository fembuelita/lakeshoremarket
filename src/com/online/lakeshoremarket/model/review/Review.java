package com.online.lakeshoremarket.model.review;

/**
 * represents a review in the database
 *
 */
public interface Review {

	/**
	 * gets the customer ID of the reviewer
	 * @return the id
	 */
	public int getCustomerID();
	
	/**
	 * sets the reviewer customer ID
	 * @param customerID the id
	 */
	public void setCustomerID(int customerID);
	
	/**
	 * gets the ID of the partner this review is for, null if for product
	 * @return the id or null
	 */
	public int getPartnerID();
	
	/**
	 * sets the ID of the partner this review is for, do not use if for product
	 * @param partnerID the id 
	 */
	public void setPartnerID(int partnerID);
	
	/**
	 * gets the review ID 
	 * @return the id
	 */
	public int getPartnerReviewID();
	
	/**
	 * sets the review ID	
	 * @param partnerReviewID	the id
	 */
	public void setPartnerReviewID(int partnerReviewID);
	
	/**
	 * gets the product ID that is being reviewed, or null if its a partner
	 * @return the id
	 */
	public int getProductID();
	
	/**
	 * sets the product id that is being reviewed, do not use if for partner
	 * @param productID the id
	 */
	public void setProductID(int productID);
	
	/**
	 * gets the product review id
	 * @return the id
	 */
	public int getProductReviewID();
	
	/**
	 * sets the product review id
	 * @param productReviewID the id
	 */
	public void setProductReviewID(int productReviewID);
	
	/**
	 * gets the review rating (eg: 1-5)
	 * @return the rating
	 */
	public int getRating();
	
	/**
	 * sets the review rating
	 * @param rating the rating
	 */
	public void setRating(int rating);
	
	/**
	 * gets the review text
	 * @return the review text
	 */
	public String getReview();
	
	/**
	 * sets the review text
	 * @param review the text
	 */
	public void setReview(String review);
	
	/**
	 * gets the date the review was created
	 * @return the timestamp
	 */
	public long getReviewDate();
	
	/**
	 * sets the creation date of the review
	 * @param reviewDate the timestamp
	 */
	public void setReviewDate(long reviewDate);
	
	
}
