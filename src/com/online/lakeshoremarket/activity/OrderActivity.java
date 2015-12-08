package com.online.lakeshoremarket.activity;

import com.online.lakeshoremarket.domain.OrderDomain;
import com.online.lakeshoremarket.model.order.OrderImpl;
import com.online.lakeshoremarket.representation.order.OrderRepresentation;

/**
 * Interacts with order model and domain business logic to create and modify order representations
 *
 */

public class OrderActivity {
	
	/**
	 * Cancels an order representation and triggers a refund
	 * @param orderIDString
	 * @return isOrderRefunded	true if cancelAndRefundOrder is successful
	 */
	
	public boolean cancelOrder(String orderIDString) {
		boolean isOrderRefunded = false;
		OrderDomain orderDomain = new OrderDomain();
		isOrderRefunded = orderDomain.cancelAndRefundOrder(Integer.parseInt(orderIDString));
		return isOrderRefunded;
	}
	
	/**
	 * Gets details of an order representation, including customer, product, payment, and status information
	 * @param orderIDString
	 * @return orderRepresentation
	 */
	
	public OrderRepresentation getOrderDetails(String orderIDString) {
		OrderRepresentation orderRepresentation = new OrderRepresentation();
		OrderDomain orderDomain = new OrderDomain();
		OrderImpl custOrder = new OrderImpl();
		custOrder = orderDomain.getOrderDetails(Integer.parseInt(orderIDString));
		orderRepresentation.setCustomerID(custOrder.getCustomerID());
		orderRepresentation.setOrderID(Integer.parseInt(orderIDString));
		orderRepresentation.setOrderStatusCode(custOrder.getOrderStatusCode());
		orderRepresentation.setPaymentID(custOrder.getPaymentID());
		orderRepresentation.setProductID(custOrder.getProductID());
		orderRepresentation.setQty(custOrder.getQty());
		orderRepresentation.setTrackingNumber(custOrder.getTrackingNumber());
		
		if(custOrder.getDatePurchased() > 0 ){
			orderRepresentation.setDatePurchased( custOrder.getDatePurchased() );
		}
		
		if( custOrder.getDateRefunded() > 0){
			orderRepresentation.setDateRefunded( custOrder.getDateRefunded() );
		}		
		
		
		return orderRepresentation;
	}
	
	/**
	 * Updates an order representation to reflect shipping status
	 * @param orderIDString
	 * @param trackingNumb
	 * @return isOrderStatusUpdated	true if order is shipped
	 */
	
	public boolean shipOrder(int orderID, String trackingNumb) {
		boolean isOrderStatusUpdated = false;
		OrderDomain orderDomain = new OrderDomain();
		isOrderStatusUpdated = orderDomain.shipOrder(orderID,trackingNumb);
		return isOrderStatusUpdated;
	}
	
	/**
	 * Updates an order representation to reflect fulfillment status
	 * @param orderIDString
	 * @return isOrderStatusUpdated	true if order is fulfilled
	 */
	
	public boolean fulfillOrder(String orderIDString) {
		boolean isOrderStatusUpdated = false;
		OrderDomain orderDomain = new OrderDomain();
		isOrderStatusUpdated = orderDomain.fulfillOrder(Integer.parseInt(orderIDString));
		return isOrderStatusUpdated;
	}
	
}
