package com.online.lakeshoremarket.domain;

import java.time.Instant;

import com.online.lakeshoremarket.dao.PaymentDAO;
import com.online.lakeshoremarket.model.order.Order;
import com.online.lakeshoremarket.model.order.OrderImpl;
import com.online.lakeshoremarket.model.payment.Payment;
import com.online.lakeshoremarket.model.payment.PaymentImpl;
import com.online.lakeshoremarket.util.Constant;

/**
 * Represents the payment domain business logic
 *
 */

public class PaymentDomain {

	PaymentDAO pDao = null;
	
	/**
	 * if product is available, creates order and payment for the product
	 * @param prodID			the product being purchased
	 * @param quantity			the amount of product being purchased
	 * @param custID			the customer purchasing the product
	 * @return					The order ID number
	 */
	
	
	public int buyProduct(int prodID, int quantity, int custID) {
		boolean isProductAvailable = false;
		ProductDomain prodDomain = new ProductDomain();
		int methodTransactionID = 0;
		int orderID = 0;
		int price = 0;
		int paymentID = 0;
		isProductAvailable = prodDomain.checkProductAvailabilityByID(prodID);
		if(isProductAvailable){
			pDao = new PaymentDAO();
			price = prodDomain.getProductPrice(prodID);
			Payment custPayment = new PaymentImpl();
			methodTransactionID = acceptPayment(custPayment);		// This is PAYPAL method
			custPayment.setMethodTransactionID(methodTransactionID);
			custPayment.setMethodOfPayment(Constant.PAYPAL);
			custPayment.setPaymentStatusCode(Constant.PAID);
			custPayment.setDatePaid(Instant.now().getEpochSecond());
			custPayment.setTotalPaid(price * quantity);
			paymentID = pDao.createPayment(custPayment);
			prodDomain.decreaseQoh(prodID, quantity);
			OrderDomain orderDomain = new OrderDomain();
			Order custOrder = new OrderImpl();
			custOrder.setDatePurchased(Instant.now().getEpochSecond());
			custOrder.setOrderStatusCode(Constant.INPROGRESS);
			custOrder.setPaymentID(paymentID);
			custOrder.setTrackingNumber("Dummy Tracking Number");
			custOrder.setCustomerID(custID);
			custOrder.setProductID(prodID);
			custOrder.setQty(quantity);
			orderID = orderDomain.createOrder(custOrder);
			
			
		}
		return orderID;
	}
	
	public int acceptPayment(Payment custPayment){
		int methodTransactionID = 0;
		//This method is left unimplemented intentionally. It will accommodate the payment acceptance for PAYPAL
		//It will return the Method Transaction ID
		return methodTransactionID;
	}

	public void refundCustomerMoney(int paymentID) {
		/*This method is implemented partially. This method will fetch payment details and then 
		return money through the PAYPAL. Finally it will update the payment status*/
		updatePaymentStatus(paymentID);
	}

	/**
	 * updates payment status if a purchase is being refunded
	 * @param paymentID			
	 */
	
	private void updatePaymentStatus(int paymentID) {
		pDao = new PaymentDAO();
		pDao.updatePaymentStatusForRefund(paymentID,Instant.now().getEpochSecond());
	}

	
}
