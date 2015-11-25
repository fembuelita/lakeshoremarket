package com.online.lakeshoremarket.activity;

import java.util.ArrayList;

import com.online.lakeshoremarket.domain.ProductDomain;
import com.online.lakeshoremarket.model.product.ProdImpl;
import com.online.lakeshoremarket.model.product.Product;
import com.online.lakeshoremarket.representation.product.ProductRepresentation;
import com.online.lakeshoremarket.representation.product.ProductRequest;

public class ProductActivity {

	public ArrayList<ProductRepresentation> getProducts(String prodName){
		
		ArrayList<Product> prodList = new ArrayList<Product>();
		ArrayList<ProductRepresentation> prodRepresentationList = new ArrayList<ProductRepresentation>();
		ProductDomain prodDomain = new ProductDomain();
		prodList = prodDomain.searchProductByLikeName(prodName);
		for(int i=0; i< prodList.size() ; i++){
			ProductRepresentation productRepresentation = new ProductRepresentation();
			productRepresentation.setActive(prodList.get(i).isActive());
			productRepresentation.setDescription(prodList.get(i).getDescription());
			productRepresentation.setPartnerID(prodList.get(i).getPartnerID());
			productRepresentation.setPrice(prodList.get(i).getPrice());
			productRepresentation.setProductID(prodList.get(i).getProductID());
			productRepresentation.setProductName(prodList.get(i).getProductName());
			productRepresentation.setTaxonomyID(prodList.get(i).getTaxonomyID());
			
			prodRepresentationList.add(productRepresentation);
		}
		
		return prodRepresentationList;
	}
	
	public boolean createProduct(ProductRequest prodRequest){
		boolean isProductCreated = false;
		
		Product prodNew  = new ProdImpl();
		prodNew.setPartnerID(prodRequest.getPartnerID());
		prodNew.setTaxonomyID(prodRequest.getTaxonomyID());
		prodNew.setCost(prodRequest.getCost());
		prodNew.setPrice(prodRequest.getPrice());
		prodNew.setProductName(prodRequest.getProductName());
		prodNew.setDescription(prodRequest.getDescription());
		prodNew.setQoh(prodRequest.getQoh());
		prodNew.setActive(true);
		
		ProductDomain prodDomain = new ProductDomain();
		
		int rowsUpdated = prodDomain.addProduct(prodNew);
		
		if(0 == rowsUpdated){
			isProductCreated = false;
		}else{
			isProductCreated = true;
		}
		
		return isProductCreated;
	}
	
	public ProductRepresentation getProduct(String prodName){
		ProductDomain prodDomain = new ProductDomain();
		Product product = new ProdImpl();
		//product = prodDomain.getProductByID(Integer.parseInt(ProductIDString));
		product = prodDomain.searchProductByName(prodName);
		ProductRepresentation productRepresentation = new ProductRepresentation();
		productRepresentation.setProductName(product.getProductName());
		productRepresentation.setDescription(product.getDescription());
		productRepresentation.setActive(product.isActive()); //is this correct?
		productRepresentation.setPartnerID(product.getPartnerID());
		productRepresentation.setPrice(product.getPrice());
		productRepresentation.setProductID(product.getProductID());
		productRepresentation.setTaxonomyID(product.getTaxonomyID());
		
		return productRepresentation;
	}
	
	public boolean checkProductAvailability(String productIDString) { 
		boolean IsProductAvailable = false;
		ProductDomain prodDomain = new ProductDomain();
		IsProductAvailable = prodDomain.checkProductAvailabilityByID(Integer.parseInt(productIDString));
		
		return IsProductAvailable;
	}
}
