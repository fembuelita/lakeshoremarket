package com.online.lakeshoremarket.service;

import com.online.lakeshoremarket.domain.ProductDomain;
import com.online.lakeshoremarket.model.product.Product;

public class TestSearchProduct {

	public static void main(String[] args) {

		Product prod = null;
		String prodName = "Oliver Twist";
		ProductDomain prodDomain = new ProductDomain();
		prod = prodDomain.searchProductByName(prodName);
		if(0 == prod.getProductID()){
			System.out.println("Product not found");
		}else{
			prod.displayProductDetails();
		}
	}

}
