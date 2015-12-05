package com.online.lakeshoremarket.domain;

import java.util.ArrayList;

import com.online.lakeshoremarket.dao.ProductDAO;
import com.online.lakeshoremarket.model.product.Product;

/**
 * Represents the customer domain business logic
 *
 */
public class ProductDomain {

	ProductDAO pDao = null;
	
	/**
	 * searches for a product by name
	 * @param prodName		the product to search for
	 * @return				product or null if no result
	 */
	public Product searchProductByName(String prodName){
		pDao = new ProductDAO();
		Product prod = null;
		prod = pDao.getProductByName(prodName);
		return prod;
	}
	
	/**
	 * searches for products by name with wildcards on either end
	 * @param prodName	the name of the product to search for
	 * @return 			an array of products that match criteria
	 */
	public ArrayList<Product> searchProductByLikeName(String prodName){
		ArrayList<Product> prodList = new ArrayList<Product>();
		pDao = new ProductDAO();
		prodList = pDao.getProductByLikeName(prodName);
		return prodList;
	}
	
	/**
	 * adds a new product
	 * @param prod 	the product to add
	 * @return		productID
	 */
	public int addProduct(Product prod){
		int productID = 0;
		pDao = new ProductDAO();
		productID = pDao.createProduct(prod);
		return productID;
	}

	/**
	 * checks if a product is available
	 * @param prodName		the name of the product
	 * @return				true if available, else false
	 */
	public boolean checkProductAvailability(String prodName) {
		boolean isProductAvailable = false;
		pDao = new ProductDAO();
		isProductAvailable = pDao.getProductAvailability(prodName);
		return isProductAvailable;
	}
	
	/**
	 * checks if a product is available
	 * @param prodID 		the id of the product
	 * @return				true if available, else false
	 */
	public boolean checkProductAvailabilityByID(int prodID) {
		boolean isProductAvailable = false;
		pDao = new ProductDAO();
		isProductAvailable = pDao.getProductAvailabilityByID(prodID);
		return isProductAvailable;
	}

	/**
	 * gets the price of a product
	 * @param prodID 	the product ID to query
	 * @return			the price as an integer
	 */
	public int getProductPrice(int prodID) {
		int price = 0;
		pDao = new ProductDAO();
		price = pDao.getProductPrice(prodID);
		return price;
	}

	/**
	 * decreases quantity on hand by a specified amount
	 * @param prodID		the product id to decrement
	 * @param quantity 		the quantity to decrement by
	 */
	public void decreaseQoh(int prodID, int quantity) {
		pDao = new ProductDAO();
		pDao.decreaseQoh(prodID, quantity);
	}

	/**
	 * increases quantity on hand by a specified amount
	 * @param prodID		the product id to increase
	 * @param quantity 		the quantity to increase by
	 */
	public boolean increaseQoh(int prodID,int quantity) {
		boolean isQuantityIncreased = false;
		pDao = new ProductDAO();
		isQuantityIncreased = pDao.increaseQoh(prodID, quantity);
		return isQuantityIncreased;
	}
	
	/**
	 * returns a product using product ID
	 * @param prodID		the product ID of the product to search for
	 * @return				product or null if no result
	 */
	public Product getProductByID(int prodID){
		pDao = new ProductDAO();
		Product prod = null;
		prod = pDao.getProductByID(prodID);
		if(prod.getProductID() == 0){
			return null;
		}else{
			return prod;
		}
	}

	
}
