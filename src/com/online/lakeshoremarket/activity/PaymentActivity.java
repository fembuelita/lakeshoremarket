package com.online.lakeshoremarket.activity;

import com.online.lakeshoremarket.domain.PaymentDomain;
import com.online.lakeshoremarket.representation.order.OrderRequest;


public class PaymentActivity {

	/**
	 * creates a new payment domain for an order representation
	 * @param orderRequest
	 * @return orderID
	 */
	
	public int buyProduct(OrderRequest orderRequest) {
		PaymentDomain paymentDomain = new PaymentDomain();
		int orderID = 0;
		orderID = paymentDomain.buyProduct(orderRequest.getProductID(), orderRequest.getQuantity(), orderRequest.getCustomerID());
		
		return orderID;
	}
}
