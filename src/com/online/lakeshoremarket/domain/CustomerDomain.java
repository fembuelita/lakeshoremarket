package com.online.lakeshoremarket.domain;

import com.online.lakeshoremarket.dao.CustomerDAO;
import com.online.lakeshoremarket.model.customer.Address;
import com.online.lakeshoremarket.model.customer.Customer;

/**
 * Represents the customer domain business logic
 *
 */
public class CustomerDomain {

	CustomerDAO custDao = null;
	
	/**
	 * accepts a customer to be inserted into the database
	 * @uses customerDAO 		the DAO to pass the SQL request to
	 * @param cust				the customer to insert
	 * @param billingAddress	the address for the customer's billing
	 * @param shippingAddress 	the address for the customer's shipping
	 * @return					customer id of newly added customer
	 */
	public int addCustomer(Customer cust, Address billingAddress, Address shippingAddress) {
		int customerID = 0;
		int billingAddressID = addAddress(billingAddress);
		int shippingAddressID = addAddress(shippingAddress);
		if(0 != billingAddressID && 0 != shippingAddressID){
			cust.setBillingAddress(billingAddressID);
			cust.setShippingAddress(shippingAddressID);
			custDao = new CustomerDAO();
			customerID = custDao.addCustomer(cust);
			
		}
		return customerID;
	}
	
	/**
	 * adds an address to the database
	 * @param address 	the address to insert
	 * @return			address ID
	 */
	public int addAddress(Address address){
		int addressID = 0;
		custDao = new CustomerDAO();
		addressID = custDao.addAddress(address);
		return addressID;
	}

	/**
	 * deletes a customer
	 * marks the customer as inactive
	 * @param custID	the customer to delete
	 * @return 			boolean true if success, else false
	 */
	public boolean deleteCustomer(int custID) {
		boolean isCustomerDeleted = false ;
		custDao = new CustomerDAO();
		isCustomerDeleted = custDao.deleteCustomer(custID);
		
		return isCustomerDeleted;
	}
	
	/**
	 * gets the customer's billing address
	 * @param custID	the customer ID to lookup
	 * @return 			the address ID
	 */
	public int getCustomerBillingAddress(int custID){
		int billingAddressID = 0;
		custDao = new CustomerDAO();
		billingAddressID = custDao.getCustomerBillingAddress(custID);
		return billingAddressID;
	}
	
	/**
	 * gets a shipping address
	 * @param custID 	the customer ID to lookup
	 * @return 			the address ID
	 */
	public int getCustomerShippingAddress(int custID){
		int shippingAddressID = 0;
		custDao = new CustomerDAO();
		shippingAddressID = custDao.getCustomerShippingAddress(custID);
		return shippingAddressID;
	}

	/**
	 * gets status of a customer (active or not [deleted])
	 * @param custID	the customer to lookup
	 * @return			true if the customer is active, false else
	 */
	public boolean getStatus(int custID) {
		boolean isCustomerActive = false;
		custDao = new CustomerDAO();
		isCustomerActive = custDao.getStatus(custID);
		return isCustomerActive;
	}
	
	public Customer getCustomerByID(int custID){
		custDao = new CustomerDAO();
		return custDao.getCustomerByID(custID);
		
	}

}
