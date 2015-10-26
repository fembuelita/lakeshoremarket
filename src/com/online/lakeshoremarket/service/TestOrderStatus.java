package com.online.lakeshoremarket.service;

import com.online.lakeshoremarket.domain.OrderDomain;
import com.online.lakeshoremarket.util.Constant;

public class TestOrderStatus {

	public static void main(String[] args) {

		OrderDomain orderDomain = new OrderDomain();
		int orderStatus = -1;
		int orderID = 1;
		orderStatus = orderDomain.getOrderStatus(orderID);

		if(orderStatus == Constant.CANCELLED){
			System.out.println("Order is cancelled");
		}else if (orderStatus == Constant.INPROGRESS) {
			System.out.println("Order is in progress ");
		}else if (orderStatus == Constant.SHIPPED) {
			System.out.println("Order is shipped");
		}else if (orderStatus == Constant.DELIVERED) {
			System.out.println("Order is delivered");
		}else if (orderStatus == -1) {
			System.out.println("Order not found in the system");
		}
	}

}
