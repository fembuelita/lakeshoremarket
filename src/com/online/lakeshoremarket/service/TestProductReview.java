package com.online.lakeshoremarket.service;

import com.online.lakeshoremarket.domain.ReviewDomain;
import com.online.lakeshoremarket.model.review.Review;
import com.online.lakeshoremarket.model.review.ReviewImpl;

public class TestProductReview {

	public static void main(String[] args) {
		
		Review review = new ReviewImpl();
		review.setCustomerID(1);
		review.setRating(10);
		review.setProductID(1);
		review.setReview("This is the Best Book of my LIFE!! Seriously.. ");
		
		boolean isProductReviewAdded = false;
		ReviewDomain reviewDomain = new ReviewDomain();
		isProductReviewAdded = reviewDomain.addProductReview(review);
		if(isProductReviewAdded){
			System.out.println("Product Review is successfully added into the system.");
		}else{
			System.out.println("Product Review is NOT added into the system");
		}
	}

}
