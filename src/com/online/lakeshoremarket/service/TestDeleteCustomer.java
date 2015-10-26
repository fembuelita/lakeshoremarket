package com.online.lakeshoremarket.service;

import com.online.lakeshoremarket.domain.CustomerDomain;

public class TestDeleteCustomer {

	public static void main(String[] args) {

		boolean isCustomerDeleted = false;
		CustomerDomain custDomain = new CustomerDomain();
		int custID = 1;
		isCustomerDeleted = custDomain.deleteCustomer(custID);
		if(isCustomerDeleted){
			System.out.println("Customer is deleted from the system");
		}else {
			System.out.println("Customer is not deleted from the system");
		}
		
	}

}
