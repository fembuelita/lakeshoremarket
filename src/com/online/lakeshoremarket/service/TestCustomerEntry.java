package com.online.lakeshoremarket.service;

import com.online.lakeshoremarket.domain.CustomerDomain;
import com.online.lakeshoremarket.model.customer.Address;
import com.online.lakeshoremarket.model.customer.AddressImpl;
import com.online.lakeshoremarket.model.customer.Customer;
import com.online.lakeshoremarket.model.customer.CustomerImpl;

public class TestCustomerEntry {

	public static void main(String[] args) {

		Address billingAddress = new AddressImpl();
		Address shippingAddress = new AddressImpl();
		Customer cust = new CustomerImpl();
		
		billingAddress.setLine1("7784");
		billingAddress.setLine2("W Arthur Ave");
		billingAddress.setLine3("Apt 1");
		billingAddress.setCity("Chicago");
		billingAddress.setState("Illinois");
		billingAddress.setCountry("USA");
		billingAddress.setZip("60645");
		
		shippingAddress.setLine1("7784");
		shippingAddress.setLine2("W Arthur Ave");
		shippingAddress.setLine3("Apt 1");
		shippingAddress.setCity("Chicago");
		shippingAddress.setState("Illinois");
		shippingAddress.setCountry("USA");
		shippingAddress.setZip("60645");
		
		cust.setPhone("3129188888");
		cust.setEmail("rayyanjaweed@google.com");
		cust.setFirstName("John");
		cust.setLastName("Cena");
		cust.setTitle("Mr.");
		cust.setPassword("password12345");
		cust.setPaypalCustID("paypalID1234");
		
		CustomerDomain custDomain = new CustomerDomain();
		
		int rowsUpdated = custDomain.addCustomer(cust, billingAddress, shippingAddress);
		System.out.println("Rows Updated = "  + rowsUpdated);
	}

}
