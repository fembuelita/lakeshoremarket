package com.online.lakeshoremarket.service;

import com.online.lakeshoremarket.domain.ReviewDomain;
import com.online.lakeshoremarket.model.review.Review;
import com.online.lakeshoremarket.model.review.ReviewImpl;

public class TestPartnerReview {

	public static void main(String[] args) {

		Review review = new ReviewImpl();
		review.setCustomerID(1);
		review.setPartnerID(2);
		review.setRating(10);
		review.setReview("Amazing seller. Delivery was on time and the product was genuine. Bought other products from this seller"
				+ " and I must say all of them are upto the highest standards. The best part is that no other seller can beat their "
				+ " discounted pricing. AWESOME!!!!!!!");
		
		boolean isPartnerReviewAdded = false;
		ReviewDomain reviewDomain = new ReviewDomain();
		isPartnerReviewAdded = reviewDomain.addPartnerReview(review);
		if(isPartnerReviewAdded){
			System.out.println("Partner Review is successfully added into the system.");
		}else{
			System.out.println("Partner Review is NOT added into the system");
		}
	}

}
