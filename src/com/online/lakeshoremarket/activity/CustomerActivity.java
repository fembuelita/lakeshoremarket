package com.online.lakeshoremarket.activity;


import java.util.ArrayList;

import com.online.lakeshoremarket.domain.CustomerDomain;
import com.online.lakeshoremarket.model.customer.Address;
import com.online.lakeshoremarket.model.customer.AddressImpl;
import com.online.lakeshoremarket.model.customer.Customer;
import com.online.lakeshoremarket.model.customer.CustomerImpl;
import com.online.lakeshoremarket.model.order.Order;
import com.online.lakeshoremarket.representation.customer.CustomerRepresentation;
import com.online.lakeshoremarket.representation.customer.CustomerRequest;
import com.online.lakeshoremarket.representation.generic.GenericResponse;
import com.online.lakeshoremarket.representation.generic.Link;
import com.online.lakeshoremarket.representation.order.OrderRepresentation;
import com.online.lakeshoremarket.util.Constant;

/**
 * Interacts with customer model and domain business logic to create and modify customer representations
 *
 */

public class CustomerActivity {

	/**
	 * Creates a customer representation for a specific customer, including details like address, name, email, etc. 
	 * @param custRequest 	imported from the CustomerRepresentation class
	 * @return genericResponse 	success or failure message
	 */
	
	public GenericResponse createCustomer(CustomerRequest custRequest) {
		int customerID = 0;
		GenericResponse genericResponse = new GenericResponse();
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
		customerID = custDomain.addCustomer(cust, billingAddress, shippingAddress);
		if(0 != customerID){
			genericResponse.setMessage("Customer is created");
			genericResponse.setSuccess(true);
			genericResponse.setGenericReturnValue( Integer.toString( customerID ) );
			Link get = new Link("Get Customer Details", Constant.LSM_COMMON_URL + "/customer/" + customerID, "application/xml");
			genericResponse.setLinks(get);
		}else{
			genericResponse.setMessage("Customer is not created");
			genericResponse.setSuccess(false);
		}
		
		return genericResponse;
	}
	
	/**
	 * Deletes a customer representation for a specific customer
	 * @param customerIDString
	 * @return isCustomerDeleted 	bool that is true if deleteCustomer is successful
	 */
	
	public boolean deleteCustomer(String customerIDString) {
		boolean isCustomerDeleted = false;
		CustomerDomain custDomain = new CustomerDomain();
		isCustomerDeleted = custDomain.deleteCustomer(Integer.parseInt(customerIDString));
		
		return isCustomerDeleted;
	}
	
	/**
	 * Gets details of a customer representation for a specific customer (e.g., name, address, email, etc.)
	 * @param customerIDString
	 * @return customerRepresentation
	 */
	
	public CustomerRepresentation getCustomerDetails(String customerIDString){
		CustomerDomain custDomain = new CustomerDomain();
		Customer customer = new CustomerImpl();
		customer = custDomain.getCustomerByID(Integer.parseInt(customerIDString));
		CustomerRepresentation customerRepresentation = new CustomerRepresentation();
		customerRepresentation.setActive(customer.isActive()); //is this correct
		customerRepresentation.setBillingAddress(customer.getBillingAddress());
		customerRepresentation.setCustomerID(customer.getCustomerID());
		customerRepresentation.setEmail(customer.getEmail());
		customerRepresentation.setFirstName(customer.getFirstName());
		customerRepresentation.setLastName(customer.getLastName()); 
		customerRepresentation.setPhone(customer.getPhone());
		customerRepresentation.setShippingAddress(customer.getShippingAddress());
		customerRepresentation.setTitle(customer.getTitle());
		customerRepresentation.setCustomerID(customer.getCustomerID());
		
		return customerRepresentation;
	}

	/**
	 * gets the order history
	 * @param customerID
	 * @return the order history
	 */
	public ArrayList<OrderRepresentation> getOrderHistory(int customerID) {
		CustomerDomain custDomain = new CustomerDomain();


		ArrayList<Order> orderList = new ArrayList<Order>();
		ArrayList<OrderRepresentation> orderRepresentationList = new ArrayList<OrderRepresentation>();
		orderList = custDomain.getOrderHistory( customerID );
		
		for(int i=0; i< orderList.size() ; i++){
			OrderRepresentation orderRepresentation = new OrderRepresentation();
			orderRepresentation.setDatePurchased(orderList.get(i).getDatePurchased());
			orderRepresentation.setDateRefunded(orderList.get(i).getDateRefunded());
			orderRepresentation.setCustomerID(orderList.get(i).getCustomerID());
			orderRepresentation.setOrderID(orderList.get(i).getOrderID());
			orderRepresentation.setOrderStatusCode(orderList.get(i).getOrderStatusCode());
			orderRepresentation.setPaymentID(orderList.get(i).getPaymentID());
			orderRepresentation.setProductID(orderList.get(i).getProductID());
			orderRepresentation.setQty(orderList.get(i).getQty());
			orderRepresentation.setTrackingNumber(orderList.get(i).getTrackingNumber());
			
			Link get = new Link("Get Order Details", Constant.LSM_COMMON_URL + "/order/" + orderList.get(i).getOrderID(), "application/xml");
			orderRepresentation.setLinks(get);
			orderRepresentationList.add(orderRepresentation);
		}
		if(orderRepresentationList != null && orderRepresentationList.size() != 0){
			return orderRepresentationList;
		}else{
			return null;
		}		
	}
}
