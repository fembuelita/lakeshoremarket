package com.online.lakeshoremarket.representation.review;


import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

@XmlRootElement(name = "PartnerReview")
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "")

/**
 * Client request for partner review representation.
 *
 */

public class PartnerReviewRequest {
	
	private int customerID;
	private int partnerID;
	private int rating;
	private String review;
	
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
	

}
