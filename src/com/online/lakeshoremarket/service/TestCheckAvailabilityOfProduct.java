package com.online.lakeshoremarket.service;

import com.online.lakeshoremarket.domain.ProductDomain;

public class TestCheckAvailabilityOfProduct {

	public static void main(String[] args) {

		boolean isProductAvailable = false;
		int prodID = 1;
		ProductDomain prodDomain = new ProductDomain();
		isProductAvailable = prodDomain.checkProductAvailabilityByID(prodID);
		System.out.println(isProductAvailable ? "Product is available" : "Product is unavailable");
	}

}
