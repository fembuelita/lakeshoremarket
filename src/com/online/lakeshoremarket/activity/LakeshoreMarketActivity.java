package com.online.lakeshoremarket.activity;

import java.util.ArrayList;
import java.util.Date;
import java.util.GregorianCalendar;

import javax.xml.datatype.DatatypeConfigurationException;
import javax.xml.datatype.DatatypeFactory;
import javax.xml.datatype.XMLGregorianCalendar;

import com.online.lakeshoremarket.domain.CustomerDomain;
import com.online.lakeshoremarket.domain.OrderDomain;
import com.online.lakeshoremarket.domain.PartnerDomain;
import com.online.lakeshoremarket.domain.PaymentDomain;
import com.online.lakeshoremarket.domain.ProductDomain;
import com.online.lakeshoremarket.domain.ReviewDomain;
import com.online.lakeshoremarket.model.customer.Address;
import com.online.lakeshoremarket.model.customer.AddressImpl;
import com.online.lakeshoremarket.model.customer.Customer;
import com.online.lakeshoremarket.model.customer.CustomerImpl;
import com.online.lakeshoremarket.model.order.OrderImpl;
import com.online.lakeshoremarket.model.partner.Partner;
import com.online.lakeshoremarket.model.partner.PartnerImpl;
import com.online.lakeshoremarket.model.product.ProdImpl;
import com.online.lakeshoremarket.model.product.Product;
import com.online.lakeshoremarket.model.review.Review;
import com.online.lakeshoremarket.model.review.ReviewImpl;
import com.online.lakeshoremarket.representation.customer.CustomerRequest;
import com.online.lakeshoremarket.representation.order.OrderRepresentation;
import com.online.lakeshoremarket.representation.order.OrderRequest;
import com.online.lakeshoremarket.representation.partner.PartnerRequest;
import com.online.lakeshoremarket.representation.product.ProductRepresentation;
import com.online.lakeshoremarket.representation.product.ProductRequest;
import com.online.lakeshoremarket.representation.review.PartnerReviewRequest;
import com.online.lakeshoremarket.representation.review.ReviewRepresentation;
import com.online.lakeshoremarket.representation.review.ProductReviewRequest;

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
	
	public boolean fulfillOrder(String orderIDString) {
		boolean isOrderStatusUpdated = false;
		OrderDomain orderDomain = new OrderDomain();
		isOrderStatusUpdated = orderDomain.fulfillOrder(Integer.parseInt(orderIDString));
		return isOrderStatusUpdated;
	}
	
	public boolean createCustomer(CustomerRequest custRequest) {
		boolean isCustomerCreated = false;
		int numbOfRowsUpdated = 0;
		
		Address billingAddress = new AddressImpl();
		Address shippingAddress = new AddressImpl();
		Customer cust = new CustomerImpl();
		
		billingAddress.setLine1(custRequest.getBillingAddressLine1());
		billingAddress.setLine2(custRequest.getBillingAddressLine2());
		billingAddress.setLine3(custRequest.getBillingAddressLine3());
		billingAddress.setCity(custRequest.getBillingAddressCity());
		billingAddress.setState(custRequest.getBillingAddressState());
		billingAddress.setCountry(custRequest.getBillingAddressCountry());
		billingAddress.setZip(custRequest.getBillingAddressZip());
		
		shippingAddress.setLine1(custRequest.getShippingAddressLine1());
		shippingAddress.setLine2(custRequest.getShippingAddressLine2());
		shippingAddress.setLine3(custRequest.getShippingAddressLine3());
		shippingAddress.setCity(custRequest.getShippingAddressCity());
		shippingAddress.setState(custRequest.getShippingAddressState());
		shippingAddress.setCountry(custRequest.getShippingAddressCountry());
		shippingAddress.setZip(custRequest.getShippingAddressZip());
		
		cust.setPhone(custRequest.getPhone());
		cust.setEmail(custRequest.getEmail());
		cust.setFirstName(custRequest.getFirstName());
		cust.setLastName(custRequest.getLastName());
		cust.setTitle(custRequest.getTitle());
		cust.setPassword(custRequest.getPassword());
		cust.setPaypalCustID(custRequest.getPaypalCustID());
		
		
		CustomerDomain custDomain = new CustomerDomain();
		numbOfRowsUpdated = custDomain.addCustomer(cust, billingAddress, shippingAddress);
		
		if(1 == numbOfRowsUpdated){
			isCustomerCreated = true;
		}
		return isCustomerCreated;
	}
	
	public boolean createPartner(PartnerRequest partnerRequest) {
		boolean isPartnerCreated = false;
		int rowsUpdated = 0;
		PartnerDomain partnerDomain = new PartnerDomain();
		Partner partner = new PartnerImpl();
		Address partnerAddress = new AddressImpl();
		
		partnerAddress.setLine1(partnerRequest.getLine1());
		partnerAddress.setLine2(partnerRequest.getLine2());
		partnerAddress.setLine3(partnerRequest.getLine3());
		partnerAddress.setCity(partnerRequest.getCity());
		partnerAddress.setState(partnerRequest.getState());
		partnerAddress.setCountry(partnerRequest.getCountry());
		partnerAddress.setZip(partnerRequest.getZip());
		
		partner.setActive(partnerRequest.isActive());
		partner.setContactName(partnerRequest.getContactName());
		partner.setEmail(partnerRequest.getEmail());
		partner.setPartnerName(partnerRequest.getPartnerName());
		partner.setPassword(partnerRequest.getPassword());
		partner.setPhone(partnerRequest.getPhone());
		
		rowsUpdated = partnerDomain.addPartner(partner, partnerAddress);
		
		if(rowsUpdated != 0){
			isPartnerCreated = true;
		}
		
		return isPartnerCreated;
	}
	
	public boolean createPartnerReview(PartnerReviewRequest partnerReviewRequest) {
		boolean isPartnerReviewCreated = false;
		ReviewDomain reviewDomain = new ReviewDomain();
		Review review = new ReviewImpl();
		
		review.setCustomerID(partnerReviewRequest.getCustomerID());
		review.setPartnerID(partnerReviewRequest.getPartnerID());
		review.setRating(partnerReviewRequest.getRating());
		review.setReview(partnerReviewRequest.getReview());
		
		isPartnerReviewCreated = reviewDomain.addPartnerReview(review);
		
		return isPartnerReviewCreated;
	}
	
	public boolean createProductReview(ProductReviewRequest productReviewRequest) {
		boolean isProductReviewCreated = false;
		ReviewDomain reviewDomain = new ReviewDomain();
		Review review = new ReviewImpl();
		
		review.setCustomerID(productReviewRequest.getCustomerID());
		review.setProductID(productReviewRequest.getProductID());
		review.setRating(productReviewRequest.getRating());
		review.setReview(productReviewRequest.getReview());
		
		isProductReviewCreated = reviewDomain.addProductReview(review);
		
		return isProductReviewCreated;
	}
	
	public int buyProduct(OrderRequest orderRequest) {
		PaymentDomain paymentDomain = new PaymentDomain();
		int orderID = 0;
		orderID = paymentDomain.buyProduct(orderRequest.getProductID(), orderRequest.getQuantity(), orderRequest.getCustomerID());
		
		return orderID;
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
	
	/**
	 * Builds a review representation
	 * @param type 		partner or product (lowercase)
	 * @param reviewID 	the partner ID or product ID, depending on type
	 * @return ReviewRepresentation
	 */
	public ReviewRepresentation getReview( String type, int reviewID ) {
		ReviewDomain revDomain = new ReviewDomain();
		Review review;
		ReviewRepresentation revRep = new ReviewRepresentation();
		
		if( type == "partner" ) {
			review = revDomain.getPartnerReviewByID( reviewID );
			revRep.setPartnerReviewID( reviewID );
			revRep.setPartnerID( review.getPartnerID() );
			
		} else if( type == "product" ) {
			review = revDomain.getProductReviewByID( reviewID );
			revRep.setProductReviewID( reviewID );
			revRep.setProductID( review.getProductID() );
		} else {
			throw new IllegalArgumentException( "Invalid review type (supplied " + type + ")" );
		}
		
		revRep.setCustomerID( review.getCustomerID() );
		revRep.setRating( review.getRating() );
		revRep.setReview( review.getReview() );
		revRep.setReviewDate( review.getReviewDate().getTime() );
		
		return revRep;
	}
	
	
}
