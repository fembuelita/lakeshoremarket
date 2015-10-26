package com.online.lakeshoremarket.activity;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

import com.online.lakeshoremarket.domain.ProductDomain;
import com.online.lakeshoremarket.model.product.Product;
import com.online.lakeshoremarket.representation.product.ProductRepresentation;

public class LakeshoreMarketActivity {

	
	public Set<ProductRepresentation> getProducts(String prodName){
		Set<ProductRepresentation> prodRepresentationList = new HashSet<ProductRepresentation>();
		
		ArrayList<Product> prodList = new ArrayList<Product>();
		ProductDomain prodDomain = new ProductDomain();
		prodList = prodDomain.searchProductByLikeName(prodName);
		Iterator<Product> prodListIterator = prodList.iterator();
		while (prodListIterator.hasNext()) {
			ProductRepresentation productRepresentation = new ProductRepresentation();
			productRepresentation.setProductName(prodListIterator.next().getProductName());
			
		}
		
		return prodRepresentationList;
	}
	
	
	
	/**
	 * Start Maggie Activity
	 */
	
	
	
	
	
	
	
	/**
	 * Start Elliott Activity
	 */
	 
}
