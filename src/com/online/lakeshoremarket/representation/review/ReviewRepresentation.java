package com.online.lakeshoremarket.representation.review;


import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import javax.xml.datatype.XMLGregorianCalendar;

/**
 * represents a review
 *
 */
@XmlRootElement(name = "Review")
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "")
public class ReviewRepresentation {


	private int customerID;
	private int partnerID;
	private int partnerReviewID;
	private int productID;
	private int productReviewID;
	private int rating;
	private String review;
	private XMLGregorianCalendar reviewDate;
	

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
	public XMLGregorianCalendar getReviewDate() {
		return reviewDate;
	}
	public void setReviewDate(XMLGregorianCalendar reviewDate) {
		this.reviewDate = reviewDate;
	}
	
}
