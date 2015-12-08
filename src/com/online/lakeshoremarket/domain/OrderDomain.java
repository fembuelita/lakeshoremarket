package com.online.lakeshoremarket.domain;

import java.time.Instant;

import com.online.lakeshoremarket.dao.OrderDAO;
import com.online.lakeshoremarket.model.order.Order;
import com.online.lakeshoremarket.model.order.OrderImpl;
import com.online.lakeshoremarket.util.Constant;

/**
 * Represents the order domain business logic
 *
 */
public class OrderDomain {

	OrderDAO orderDao = null;
	
	/**
	 * creates an order
	 * @param custOrder		the order object to create
	 */
	public int createOrder(Order custOrder) {
		int orderID = 0;
		orderDao = new OrderDAO();
		orderID = orderDao.createOrder(custOrder);
		return orderID;
	}
	
	/**
	 * marks an order as shipped
	 * @param orderID			the order ID to update
	 * @param trackingNumber	the shipping number to update with
	 * @return					true if success, false if no changes made
	 */
	public boolean shipOrder(int orderID, String trackingNumber) {
		boolean isOrderStatusUpdated = false;
		orderDao = new OrderDAO();
		isOrderStatusUpdated = orderDao.shipOrder(orderID, trackingNumber);
		return isOrderStatusUpdated;
	}
	
	/**
	 * marks an order as delivered
	 * @param orderID 		the order ID to update
	 * @return				true if changed, false else
	 */
	public boolean fulfillOrder(int orderID) {
		boolean isOrderFulfilled = false;
		orderDao = new OrderDAO();
		isOrderFulfilled = orderDao.fulfillOrder(orderID);
		return isOrderFulfilled;
	}
	
	/**
	 * gets an order status to be compared with the constants file
	 * @param orderID 		the order ID to lookup
	 * @return				-1 on failure, else order status constant
	 */
	public int getOrderStatus(int orderID) {
		int orderStatus = -1;
		orderDao = new OrderDAO();
		orderStatus = orderDao.getOrderStatus(orderID);
		return orderStatus;
	}
	
	/**
	 * cancels and refunds an order
	 * @param orderID 		the order ID to cancel and refund
	 * @return				true on success, false else
	 */
	public boolean cancelAndRefundOrder(int orderID) {
		boolean isOrderRefunded = false;
		orderDao = new OrderDAO();
		Order custOrder = new OrderImpl();
		custOrder = orderDao.getOrderDetails(orderID);
		if(Constant.SHIPPED == custOrder.getOrderStatusCode()){
			notifyShipmentPartnerForRefund(custOrder);
		}
		PaymentDomain paymentDomain = new PaymentDomain();
		paymentDomain.refundCustomerMoney(custOrder.getPaymentID());
		updateOrderStatusForRefund(orderID);
		ProductDomain productDomain = new ProductDomain();
		/*//TODO get quantity and prodID from the order
		int quantity = 2;
		int prodID = 12;*/
		boolean isQuantityIncreased = false;
		isQuantityIncreased = productDomain.increaseQoh(custOrder.getProductID(), custOrder.getQty());
		if(isQuantityIncreased){
			isOrderRefunded = isQuantityIncreased;
		}
		return isOrderRefunded;
	}
	
	/**
	 * updates a status as refunded
	 * @param orderID 		the order ID to update
	 */
	private void updateOrderStatusForRefund(int orderID) {
		orderDao = new OrderDAO();
		orderDao.updateOrderStatusForRefund(orderID, Instant.now().getEpochSecond() );
	}
	
	/**
	 * notifies a partner whose product was sold that the order was refunded
	 * @param custOrder 		the order in question
	 */
	public void notifyShipmentPartnerForRefund(Order custOrder) {
		/*This method is being left unimplemented on purpose as we do not 
		have any means to communicate with the Shipment Delivery Partner. But this
		method would notify the Shipment Delivery Partner of cancellation of the order
		and refund of the products that are in due for shipment*/
	}
	
	/**
	 * gets all order details
	 * @param orderID 		the order ID to lookup
	 * @return				null on failure, else order details
	 */
	public OrderImpl getOrderDetails(int orderID) {
		OrderImpl custOrder = null;
		orderDao = new OrderDAO();
		custOrder = (OrderImpl) orderDao.getOrderDetails(orderID);
		return custOrder;
	}

}
