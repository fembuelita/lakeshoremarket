package com.online.lakeshoremarket.service;

import com.online.lakeshoremarket.domain.PaymentDomain;

public class TestBuyProduct {

	public static void main(String[] args) {

		PaymentDomain paymentDomain = new PaymentDomain();
		int prodID = 1;
		int quantity = 5;
		int custID = 2;
		
		
		int orderID = 0;
		orderID = paymentDomain.buyProduct(prodID, quantity, custID);
		
		
		if(0 != orderID){
			System.out.println("Congratulations your order has been placed");
		}
	}

}
