package com.online.lakeshoremarket.activity;

import java.util.ArrayList;
import java.util.Date;
import java.util.GregorianCalendar;

import javax.xml.datatype.DatatypeConfigurationException;
import javax.xml.datatype.DatatypeFactory;
import javax.xml.datatype.XMLGregorianCalendar;

import com.online.lakeshoremarket.domain.OrderDomain;
import com.online.lakeshoremarket.domain.ProductDomain;
import com.online.lakeshoremarket.model.order.OrderImpl;
import com.online.lakeshoremarket.model.product.ProdImpl;
import com.online.lakeshoremarket.model.product.Product;
import com.online.lakeshoremarket.representation.order.OrderRepresentation;
import com.online.lakeshoremarket.representation.product.ProductRepresentation;
import com.online.lakeshoremarket.representation.product.ProductRequest;

public class LakeshoreMarketActivity {

	
	public ArrayList<ProductRepresentation> getProducts(String prodName){
		
		ArrayList<Product> prodList = new ArrayList<Product>();
		ArrayList<ProductRepresentation> prodRepresentationList = new ArrayList<ProductRepresentation>();
		ProductDomain prodDomain = new ProductDomain();
		prodList = prodDomain.searchProductByLikeName(prodName);
		for(int i=0; i< prodList.size() ; i++){
			ProductRepresentation productRepresentation = new ProductRepresentation();
			productRepresentation.setActive(prodList.get(i).isActive());
			productRepresentation.setDescription(prodList.get(i).getDescription());
			productRepresentation.setPartnerID(prodList.get(i).getPartnerID());
			productRepresentation.setPrice(prodList.get(i).getPrice());
			productRepresentation.setProductID(prodList.get(i).getProductID());
			productRepresentation.setProductName(prodList.get(i).getProductName());
			productRepresentation.setTaxonomyID(prodList.get(i).getTaxonomyID());
			
			prodRepresentationList.add(productRepresentation);
		}
		
		return prodRepresentationList;
	}
	
	public boolean createProduct(ProductRequest prodRequest){
		boolean isProductCreated = false;
		
		Product prodNew  = new ProdImpl();
		prodNew.setPartnerID(prodRequest.getPartnerID());
		prodNew.setTaxonomyID(prodRequest.getTaxonomyID());
		prodNew.setCost(prodRequest.getCost());
		prodNew.setPrice(prodRequest.getPrice());
		prodNew.setProductName(prodRequest.getProductName());
		prodNew.setDescription(prodRequest.getDescription());
		prodNew.setQoh(prodRequest.getQoh());
		prodNew.setActive(true);
		
		ProductDomain prodDomain = new ProductDomain();
		
		int rowsUpdated = prodDomain.addProduct(prodNew);
		
		if(0 == rowsUpdated){
			isProductCreated = false;
		}else{
			isProductCreated = true;
		}
		
		return isProductCreated;
	}
	
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
	
	
	
	
	
	/*Start Maggie Activity
	 * 
	 * 
	 * */
	
	public ProductRepresentation getProduct(int productID){
		ProductDomain prodDomain = new ProductDomain();
		Product product = new ProdImpl();
		//TODO implement this method
//		product = prodDomain.getProductByID(productID);
		
		ProductRepresentation productRepresentation = new ProductRepresentation();
		productRepresentation.setProductName(product.getProductName());
		
		
		
		
		
		return productRepresentation;
	}
	
	
	
	
	
	/*Start Elliott Activity
	 * 
	 * 
	 * */
	 
}
