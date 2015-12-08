package com.online.lakeshoremarket.representation.review;


import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import javax.xml.datatype.XMLGregorianCalendar;

import com.online.lakeshoremarket.representation.generic.AbstractRepresentation;

/**
 * represents a review
 *
 */
@XmlRootElement(name = "Review")
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "")
public class ReviewRepresentation extends AbstractRepresentation{


	private int customerID;
	private int partnerID;
	private int partnerReviewID;
	private int productID;
	private int productReviewID;
	private int rating;
	private String review;
	private XMLGregorianCalendar reviewDate;
	
	/**
	 * gets the customer ID of the reviewer
	 * @return the id
	 */
	
	public int getCustomerID() {
		return customerID;
	}
	
	/**
	 * sets the reviewer customer ID
	 * @param customerID the id
	 */
	
	public void setCustomerID(int customerID) {
		this.customerID = customerID;
	}
	
	/**
	 * gets the ID of the partner this review is for, null if for product
	 * @return the id or null
	 */
	
	public int getPartnerID() {
		return partnerID;
	}
	
	/**
	 * sets the ID of the partner this review is for
	 * @param partnerID the id 
	 */
	
	public void setPartnerID(int partnerID) {
		this.partnerID = partnerID;
	}
	
	/**
	 * gets the review ID 
	 * @return the id
	 */
	
	public int getPartnerReviewID() {
		return partnerReviewID;
	}
	
	/**
	 * sets the review ID	
	 * @param partnerReviewID	the id
	 */
	
	public void setPartnerReviewID(int partnerReviewID) {
		this.partnerReviewID = partnerReviewID;
	}
	
	/**
	 * gets the product ID that is being reviewed, or null if its a partner
	 * @return the id
	 */
	
	public int getProductID() {
		return productID;
	}
	
	/**
	 * sets the product id that is being reviewed, do not use if for partner
	 * @param productID the id
	 */
	
	public void setProductID(int productID) {
		this.productID = productID;
	}
	
	/**
	 * gets the product review id
	 * @return the id
	 */
	
	public int getProductReviewID() {
		return productReviewID;
	}
	
	/**
	 * sets the product review id
	 * @param productReviewID the id
	 */
	
	public void setProductReviewID(int productReviewID) {
		this.productReviewID = productReviewID;
	}
	
	/**
	 * gets the review rating (eg: 1-5)
	 * @return the rating
	 */
	
	public int getRating() {
		return rating;
	}
	
	/**
	 * sets the review rating
	 * @param rating the rating
	 */
	
	public void setRating(int rating) {
		this.rating = rating;
	}
	
	/**
	 * gets the review text
	 * @return the review text
	 */
	
	public String getReview() {
		return review;
	}
	
	/**
	 * sets the review text
	 * @param review the text
	 */
	
	public void setReview(String review) {
		this.review = review;
	}
	/**
	 * gets the date the review was created
	 * @return the timestamp
	 */
	
	public XMLGregorianCalendar getReviewDate() {
		return reviewDate;
	}
	
	/**
	 * sets the creation date of the review
	 * @param reviewDate the timestamp
	 */
	
	public void setReviewDate(XMLGregorianCalendar reviewDate) {
		this.reviewDate = reviewDate;
	}
	
}
