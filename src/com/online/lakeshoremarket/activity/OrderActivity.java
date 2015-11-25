package com.online.lakeshoremarket.activity;

import java.util.Date;
import java.util.GregorianCalendar;

import javax.xml.datatype.DatatypeConfigurationException;
import javax.xml.datatype.DatatypeFactory;
import javax.xml.datatype.XMLGregorianCalendar;

import com.online.lakeshoremarket.domain.OrderDomain;
import com.online.lakeshoremarket.model.order.OrderImpl;
import com.online.lakeshoremarket.representation.order.OrderRepresentation;

public class OrderActivity {

	public boolean cancelOrder(String orderIDString) {
		boolean isOrderRefunded = false;
		OrderDomain orderDomain = new OrderDomain();
		isOrderRefunded = orderDomain.cancelAndRefundOrder(Integer.parseInt(orderIDString));
		return isOrderRefunded;
	}
	
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
		
		if(null != custOrder.getDatePurchased()){
			GregorianCalendar gregCalDatePurchased = new GregorianCalendar();
			long longDatePurchased = custOrder.getDatePurchased().getTime();
			Date utilDatePurchased = new Date(longDatePurchased);
			gregCalDatePurchased.setTime(utilDatePurchased);
			XMLGregorianCalendar xmlDatePurchased;
			try {
				xmlDatePurchased = DatatypeFactory.newInstance().newXMLGregorianCalendar(gregCalDatePurchased);
				orderRepresentation.setDatePurchased((xmlDatePurchased));
			} catch (DatatypeConfigurationException e) {
				e.printStackTrace();
			}
		}
		
		if(null != custOrder.getDateRefunded()){
			GregorianCalendar gregCalDateRefunded = new GregorianCalendar();
			long longDateRefunded = custOrder.getDateRefunded().getTime();
			Date utilDateRefunded = new Date(longDateRefunded);
			gregCalDateRefunded.setTime(utilDateRefunded);
			XMLGregorianCalendar xmlDateRefunded;
			try {
				xmlDateRefunded = DatatypeFactory.newInstance().newXMLGregorianCalendar(gregCalDateRefunded);
				orderRepresentation.setDateRefunded(xmlDateRefunded);
			} catch (DatatypeConfigurationException e) {
				e.printStackTrace();
			}
			
		}
		
		return orderRepresentation;
	}
	
	public boolean shipOrder(String orderIDString, String trackingNumb) {
		boolean isOrderStatusUpdated = false;
		OrderDomain orderDomain = new OrderDomain();
		isOrderStatusUpdated = orderDomain.shipOrder(Integer.parseInt(orderIDString),trackingNumb);
		return isOrderStatusUpdated;
	}
	
	public boolean fulfillOrder(String orderIDString) {
		boolean isOrderStatusUpdated = false;
		OrderDomain orderDomain = new OrderDomain();
		isOrderStatusUpdated = orderDomain.fulfillOrder(Integer.parseInt(orderIDString));
		return isOrderStatusUpdated;
	}
	
}
