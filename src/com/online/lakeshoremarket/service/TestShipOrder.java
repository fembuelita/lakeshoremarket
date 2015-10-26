package com.online.lakeshoremarket.service;

import com.online.lakeshoremarket.domain.OrderDomain;

public class TestShipOrder {

	public static void main(String[] args) {
		
		boolean isOrderStatusUpdated = false;
		String trackingNumber = "FedEx tracking Number 123456";
		int orderID = 1;
		OrderDomain orderDomain = new OrderDomain();
		isOrderStatusUpdated = orderDomain.shipOrder(orderID,trackingNumber);
		if(isOrderStatusUpdated){
			System.out.println("Order in shipping");
		}
	}

}
