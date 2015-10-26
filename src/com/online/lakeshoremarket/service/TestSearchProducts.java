package com.online.lakeshoremarket.service;

import java.util.ArrayList;
import java.util.Iterator;

import com.online.lakeshoremarket.domain.ProductDomain;
import com.online.lakeshoremarket.model.product.Product;

public class TestSearchProducts {

	public static void main(String[] args) {

		ArrayList<Product> prodList = new ArrayList<Product>();
		String prodName = "works";
		ProductDomain prodDomain = new ProductDomain();
		prodList = prodDomain.searchProductByLikeName(prodName);
		Iterator<Product> prodListIterator = prodList.iterator();
		while (prodListIterator.hasNext()) {
			prodListIterator.next().displayProductDetails();
			System.out.println("**************************************************");
		}
	}

}
