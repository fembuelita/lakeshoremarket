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
import com.online.lakeshoremarket.model.partnerReport.PartnerReport;
import com.online.lakeshoremarket.model.product.ProdImpl;
import com.online.lakeshoremarket.model.product.Product;
import com.online.lakeshoremarket.model.review.Review;
import com.online.lakeshoremarket.model.review.ReviewImpl;
import com.online.lakeshoremarket.representation.customer.CustomerRepresentation;
import com.online.lakeshoremarket.representation.customer.CustomerRequest;
import com.online.lakeshoremarket.representation.order.OrderRepresentation;
import com.online.lakeshoremarket.representation.order.OrderRequest;
import com.online.lakeshoremarket.representation.partner.PartnerRepresentation;
import com.online.lakeshoremarket.representation.partner.PartnerRequest;
import com.online.lakeshoremarket.representation.partnerReport.PartnerReportRepresentation;
import com.online.lakeshoremarket.representation.product.ProductRepresentation;
import com.online.lakeshoremarket.representation.product.ProductRequest;
import com.online.lakeshoremarket.representation.review.PartnerReviewRequest;
import com.online.lakeshoremarket.representation.review.ReviewRepresentation;
import com.online.lakeshoremarket.representation.review.ProductReviewRequest;

public class LakeshoreMarketActivity {

	//Not required anymore
	/*public ArrayList<ProductRepresentation> getProducts(String prodName){
		
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
	}*/
	
	//Not required anymore
	/*public boolean createProduct(ProductRequest prodRequest){
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
	}*/
	
	//Not required anymore
	/*public boolean cancelOrder(String orderIDString) {
		boolean isOrderRefunded = false;
		OrderDomain orderDomain = new OrderDomain();
		isOrderRefunded = orderDomain.cancelAndRefundOrder(Integer.parseInt(orderIDString));
		return isOrderRefunded;
	}*/
	
	//Not required anymore
	/*public OrderRepresentation getOrderDetails(String orderIDString) {
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
	}*/
	
	/*public boolean shipOrder(String orderIDString, String trackingNumb) {
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
	}*/
	
	/*public boolean createCustomer(CustomerRequest custRequest) {
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
	}*/
	
	/*public boolean createPartner(PartnerRequest partnerRequest) {
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
	}*/
	
	/*public boolean createPartnerReview(PartnerReviewRequest partnerReviewRequest) {
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
	}*/
	
	/*public int buyProduct(OrderRequest orderRequest) {
		PaymentDomain paymentDomain = new PaymentDomain();
		int orderID = 0;
		orderID = paymentDomain.buyProduct(orderRequest.getProductID(), orderRequest.getQuantity(), orderRequest.getCustomerID());
		
		return orderID;
	}*/
	
	
	
	
	
	/*Start Maggie Activity
	 * 
	 * 
	 * */
	
	//----GET PRODUCT----
	//public ProductRepresentation getProduct(String ProductIDString){
	/*public ProductRepresentation getProduct(String prodName){
		ProductDomain prodDomain = new ProductDomain();
		Product product = new ProdImpl();
		//product = prodDomain.getProductByID(Integer.parseInt(ProductIDString));
		product = prodDomain.searchProductByName(prodName);
		ProductRepresentation productRepresentation = new ProductRepresentation();
		productRepresentation.setProductName(product.getProductName());
		productRepresentation.setDescription(product.getDescription());
		productRepresentation.setActive(product.isActive()); //is this correct?
		productRepresentation.setPartnerID(product.getPartnerID());
		productRepresentation.setPrice(product.getPrice());
		productRepresentation.setProductID(product.getProductID());
		productRepresentation.setTaxonomyID(product.getTaxonomyID());
		
		return productRepresentation;
	}*/
	
	
	//----CHECK PRODUCT AVAILABILITY----
	/*public boolean checkProductAvailability(String productIDString) { 
		boolean IsProductAvailable = false;
		ProductDomain prodDomain = new ProductDomain();
		IsProductAvailable = prodDomain.checkProductAvailabilityByID(Integer.parseInt(productIDString));
		
		return IsProductAvailable;
	}*/
	
	//----DELETE CUSTOMER----
	/*public boolean deleteCustomer(String customerIDString) {
		boolean isCustomerDeleted = false;
		CustomerDomain custDomain = new CustomerDomain();
		isCustomerDeleted = custDomain.deleteCustomer(Integer.parseInt(customerIDString));
		
		return isCustomerDeleted;
	}*/
	
	//----GET CUSTOMER DETAILS----	
	/*public CustomerRepresentation getCustomerDetails(String customerIDString){
		CustomerDomain custDomain = new CustomerDomain();
		Customer customer = new CustomerImpl();
		customer = custDomain.getCustomerByID(Integer.parseInt(customerIDString));
		CustomerRepresentation customerRepresentation = new CustomerRepresentation();
		customerRepresentation.setActive(customer.isActive()); //is this correct
		customerRepresentation.setBillingAddress(customer.getBillingAddress());
		customerRepresentation.setCustomerId(customer.getCustomerId());
		customerRepresentation.setEmail(customer.getEmail());
		customerRepresentation.setFirstName(customer.getFirstName());
		customerRepresentation.setLastName(customer.getLastName()); 
		customerRepresentation.setPhone(customer.getPhone());
		customerRepresentation.setShippingAddress(customer.getShippingAddress());
		customerRepresentation.setTitle(customer.getTitle());
		
		return customerRepresentation;
	}*/
	
	//----DELETE PARTNER----
	/*public boolean deletePartner(String partnerIDString) {
		boolean isPartnerDeleted = false;
		PartnerDomain partnerDomain = new PartnerDomain();
		isPartnerDeleted = partnerDomain.deletePartner(Integer.parseInt(partnerIDString));
		
		return isPartnerDeleted;
	}*/
	
	//----GET PARTNER DETAILS----	
	/*public PartnerRepresentation getPartnerDetails(String partnerIDString){
		PartnerDomain partnerDomain = new PartnerDomain();
		Partner partner = new PartnerImpl();
		partner = partnerDomain.getPartnerByID(Integer.parseInt(partnerIDString)); 
		PartnerRepresentation partnerRepresentation = new PartnerRepresentation();
		partnerRepresentation.setActive(partner.isActive()); //is this correct?
		partnerRepresentation.setPartnerName(partner.getPartnerName());
		partnerRepresentation.setContactName(partner.getContactName());
		partnerRepresentation.setAddressID(partner.getAddressID());
		partnerRepresentation.setPartnerID(partner.getPartnerID());
		partnerRepresentation.setEmail(partner.getEmail());
		partnerRepresentation.setPhone(partner.getPhone());
		
		return partnerRepresentation;
	}*/
	
	/*Start Elliott Activity
	 * 
	 * 
	 * */
	
	/**
	 * Builds a review representation
	 * @param type 		partner or product (lowercase)
	 * @param reviewID 	the partner ID or product ID, depending on type
	 * @return ReviewRepresentation
	 *//*
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
		if(null != review.getReviewDate()){
			GregorianCalendar gregCalReviewDate = new GregorianCalendar();
			long longReviewDate = review.getReviewDate().getTime();
			Date utilReviewDate = new Date(longReviewDate);
			gregCalReviewDate.setTime(utilReviewDate);
			XMLGregorianCalendar xmlReviewDate;
			try {
				xmlReviewDate = DatatypeFactory.newInstance().newXMLGregorianCalendar(gregCalReviewDate);
				revRep.setReviewDate(xmlReviewDate);
			} catch (DatatypeConfigurationException e) {
				e.printStackTrace();
			}
		}
		
		return revRep;
	}*/
	
	/**
	 * gets a report representation for a specific partner
	 * @param partnerID
	 * @return
	 *//*
	public ArrayList<PartnerReportRepresentation> getPartnerReport( int partnerID ) {
		PartnerDomain partnerDomain = new PartnerDomain();
		ArrayList<PartnerReport> report = partnerDomain.generatePartnerReport( partnerID );
		ArrayList<PartnerReportRepresentation> reports = new ArrayList<PartnerReportRepresentation>();
		
		int size = report.size();
		for(int i=0; i< size; i++){
			PartnerReportRepresentation partnerReport = new PartnerReportRepresentation();
			partnerReport.setProductId( report.get(i).getProductId() );
			partnerReport.setQuantity( report.get(i).getQuantity() );
			partnerReport.setCost( report.get(i).getCost() );
			partnerReport.setPrice( report.get(i).getPrice() );
			partnerReport.setTotalCost( report.get(i).getTotalCost() );
			partnerReport.setTotalPrice( report.get(i).getTotalPrice() );
			partnerReport.setTotalProfit( report.get(i).getTotalProfit() );
			
			reports.add(partnerReport);
		}		
		

		return reports;
	}*/
	
	
}
