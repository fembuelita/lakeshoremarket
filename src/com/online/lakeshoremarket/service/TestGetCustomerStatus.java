package com.online.lakeshoremarket.service;

import com.online.lakeshoremarket.domain.CustomerDomain;

public class TestGetCustomerStatus {

	public static void main(String[] args) {

		CustomerDomain cDomain = new CustomerDomain();
		int custID = 1;
		boolean isCustomerActive = false;
		isCustomerActive = cDomain.getStatus(custID);
		if(isCustomerActive){
			System.out.println("Customer is active");
		}else{
			System.out.println("Customer is NOT active");
		}
	}

}
