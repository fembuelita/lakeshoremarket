package com.online.lakeshoremarket.activity;

import com.online.lakeshoremarket.domain.CustomerDomain;
import com.online.lakeshoremarket.model.customer.Address;
import com.online.lakeshoremarket.model.customer.AddressImpl;
import com.online.lakeshoremarket.model.customer.Customer;
import com.online.lakeshoremarket.model.customer.CustomerImpl;
import com.online.lakeshoremarket.representation.customer.CustomerRepresentation;
import com.online.lakeshoremarket.representation.customer.CustomerRequest;

public class CustomerActivity {

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
	
	public boolean deleteCustomer(String customerIDString) {
		boolean isCustomerDeleted = false;
		CustomerDomain custDomain = new CustomerDomain();
		isCustomerDeleted = custDomain.deleteCustomer(Integer.parseInt(customerIDString));
		
		return isCustomerDeleted;
	}
	
	public CustomerRepresentation getCustomerDetails(String customerIDString){
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
		customerRepresentation.setCustomerId(customer.getCustomerId());
		
		return customerRepresentation;
	}
}
