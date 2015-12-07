package com.online.lakeshoremarket.activity;

import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.online.lakeshoremarket.domain.CustomerDomain;
import com.online.lakeshoremarket.model.customer.Address;
import com.online.lakeshoremarket.model.customer.AddressImpl;
import com.online.lakeshoremarket.model.customer.Customer;
import com.online.lakeshoremarket.model.customer.CustomerImpl;
import com.online.lakeshoremarket.representation.customer.CustomerRepresentation;
import com.online.lakeshoremarket.representation.customer.CustomerRequest;
import com.online.lakeshoremarket.representation.generic.GenericResponse;
import com.online.lakeshoremarket.representation.generic.Link;
import com.online.lakeshoremarket.util.Constant;

public class CustomerActivity {

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
