package com.online.lakeshoremarket.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.online.lakeshoremarket.model.product.ProdImpl;
import com.online.lakeshoremarket.model.product.Product;
import com.online.lakeshoremarket.util.DatabaseConnection;

/**
 * represents the product database access object
 * used to interact with the database
 */
public class ProductDAO {

	Connection conn = null;
	PreparedStatement pstmt = null;
	
	/**
	 * Gets a product by name
	 * @param prodName 		the product name
	 * @return 				the product object or null if not found
	 */
	public Product getProductByName(String prodName){
		Product prod = null;
		conn = DatabaseConnection.getSqlConnection();
		try{
			String searchQuery = "SELECT * FROM product WHERE name = ? AND active = 1 ";
			pstmt = conn.prepareStatement(searchQuery);
			pstmt.setString(1, prodName);
			ResultSet resultSet = pstmt.executeQuery();
			prod = new ProdImpl();
			while(resultSet.next()){
				prod.setProductID(resultSet.getInt("product_id"));
				prod.setPartnerID(resultSet.getInt("partner_id"));
				prod.setTaxonomyID(resultSet.getInt("taxonomy_id"));
				prod.setCost(resultSet.getFloat("cost"));
				prod.setPrice(resultSet.getFloat("price"));
				prod.setProductName(resultSet.getString("name"));
				prod.setDescription(resultSet.getString("description"));
				prod.setQoh(resultSet.getInt("qoh"));
				prod.setActive(resultSet.getByte("active") == 1 ? true : false);
			}
		}catch(SQLException sqe){
			System.err.println("ProductDAO.getProductByName: Threw a SQLException while searching for a product in table.");
  	      	System.err.println(sqe.getMessage());
		} finally {
			try {
				pstmt.close();
				conn.close();
			} catch (Exception e) {
				System.err.println("ProductDAO.getProductByName: Threw an Exception while searching for a product in table.");
			}
		}
		return prod;
	}
	
	/**
	 * searches for a product by a similar name
	 * @param prodName 		the name of the product to search for
	 * @return				an array of products or null if nothing found 
	 */
	public ArrayList<Product> getProductByLikeName(String prodName){
		Product prod = null;
		ArrayList<Product> prodList = new ArrayList<Product>();
		conn = DatabaseConnection.getSqlConnection();
		try{
			String searchQuery = "SELECT * FROM product WHERE name LIKE ? AND active = 1 ";
			pstmt = conn.prepareStatement(searchQuery);
			pstmt.setString(1, "%"+prodName+"%");
			ResultSet resultSet = pstmt.executeQuery();
			while(resultSet.next()){
				prod = new ProdImpl();
				prod.setProductID(resultSet.getInt("product_id"));
				prod.setPartnerID(resultSet.getInt("partner_id"));
				prod.setTaxonomyID(resultSet.getInt("taxonomy_id"));
				prod.setCost(resultSet.getFloat("cost"));
				prod.setPrice(resultSet.getFloat("price"));
				prod.setProductName(resultSet.getString("name"));
				prod.setDescription(resultSet.getString("description"));
				prod.setQoh(resultSet.getInt("qoh"));
				prod.setActive(resultSet.getByte("active") == 1 ? true : false);
				prodList.add(prod);
			}
		}catch(SQLException sqe){
			System.err.println("ProductDAO.getProductByLikeName: Threw a SQLException while searching for a product in table.");
  	      	System.err.println(sqe.getMessage());
		} finally {
			try {
				pstmt.close();
				conn.close();
			} catch (Exception e) {
				System.err.println("ProductDAO.getProductByLikeName: Threw an Exception while searching for a product in table.");
			}
		}
		return prodList;
	}
	
	/**
	 * Creates a product
	 * @param prod 		the product object to create in the DB
	 * @return			number of rows updated
	 */
	public int createProduct(Product prod){
		conn = DatabaseConnection.getSqlConnection();
		int rowsUpdated = 0;
		try{
			String insertStmt = "INSERT INTO product "
											+ "(partner_id,taxonomy_id,cost,price,name,description,qoh,active) "
								+ "VALUES "
											+ "(?,?,?,?,?,?,?,?)";
			pstmt = conn.prepareStatement(insertStmt);
			pstmt.setInt(1, prod.getPartnerID());
			pstmt.setInt(2, prod.getTaxonomyID());
			pstmt.setFloat(3, prod.getCost());
			pstmt.setFloat(4, prod.getPrice());
			pstmt.setString(5, prod.getProductName());
			pstmt.setString(6, prod.getDescription());
			pstmt.setInt(7, prod.getQoh());
			pstmt.setBoolean(8, prod.isActive());
			rowsUpdated = pstmt.executeUpdate();
		}catch(SQLException sqe){
			System.err.println("ProductDAO.createProduct: Threw a SQLException inserting a new product in table.");
  	      	System.err.println(sqe.getMessage());
		} finally {
			try {
				pstmt.close();
				conn.close();
			} catch (Exception e) {
				System.err.println("ProductDAO.createProduct: Threw an Exception inserting a new product in table.");
			}
		}
		
		return rowsUpdated;
	}

	/**
	 * Determines if a product is available or not
	 * @param prodName			the product name	
	 * @return					true if available, else false
	 */
	public boolean getProductAvailability(String prodName) {
		boolean isProductAvailable = false;
		conn = DatabaseConnection.getSqlConnection();
		int qoh = 0;
		try{
			String searchQuery = "SELECT qoh FROM product WHERE name = ? AND active = 1; ";
			pstmt = conn.prepareStatement(searchQuery);
			pstmt.setString(1, prodName);
			ResultSet resultSet = pstmt.executeQuery();
			while(resultSet.next()){
				qoh = resultSet.getInt("qoh");
			}
			isProductAvailable = (qoh > 0 ) ?  true : false ;
		}catch(SQLException sqe){
			System.err.println("ProductDAO.getProductAvailability: Threw a SQLException while checking product availability.");
  	      	System.err.println(sqe.getMessage());
		} finally {
			try {
				pstmt.close();
				conn.close();
			} catch (Exception e) {
				System.err.println("ProductDAO.getProductAvailability: Threw an Exception while checking product availability.");
			}
		}
		return isProductAvailable;
	}

	/**
	 * gets a product availability by product ID
	 * @param prodID 		the product ID to inquire on
	 * @return 				true if available, else false
	 */
	public boolean getProductAvailabilityByID(int prodID) {
		boolean isProductAvailable = false;
		conn = DatabaseConnection.getSqlConnection();
		int qoh = 0;
		try{
			String searchQuery = "SELECT qoh FROM product WHERE product_id = ? AND active = 1; ";
			pstmt = conn.prepareStatement(searchQuery);
			pstmt.setInt(1, prodID);
			ResultSet resultSet = pstmt.executeQuery();
			while(resultSet.next()){
				qoh = resultSet.getInt("qoh");
			}
			isProductAvailable = (qoh >= 0 ) ?  true : false ;
		}catch(SQLException sqe){
			System.err.println("ProductDAO.getProductAvailabilityByID: Threw a SQLException while checking product availability.");
  	      	System.err.println(sqe.getMessage());
		} finally {
			try {
				pstmt.close();
				conn.close();
			} catch (Exception e) {
				System.err.println("ProductDAO.getProductAvailabilityByID: Threw an Exception while checking product availability.");
				System.err.println(e.getMessage());
			}
		}
		return isProductAvailable;
	}

	/**
	 * gets the product price 
	 * @param prodID 		the product id to inquire
	 * @return 				the price of the product
	 */
	public int getProductPrice(int prodID) {
		int price = 0;
		conn = DatabaseConnection.getSqlConnection();
		try{
			String getQuery = "SELECT price FROM product WHERE product_id = ? ";
			pstmt = conn.prepareStatement(getQuery);
			pstmt.setInt(1, prodID);
			ResultSet resultSet = pstmt.executeQuery();
			while(resultSet.next()){
				price = resultSet.getInt("price");
			}
		}catch(SQLException sqe){
			System.err.println("ProductDAO.getProductPrice: Threw a SQLException while getting product price.");
  	      	System.err.println(sqe.getMessage());
		} finally {
			try {
				pstmt.close();
				conn.close();
			} catch (Exception e) {
				System.err.println("ProductDAO.getProductPrice: Threw an Exception while getting product price.");
			}
		}
		return price;
	}

	/**
	 * decreases Quantity on hand (qoh) by a certain value
	 * @param prodID		the product ID to decrement
	 * @param quantity		the quantity to decrement by
	 */
	public void decreaseQoh(int prodID, int quantity) {
		conn = DatabaseConnection.getSqlConnection();
		try{
			String updateQuery = "UPDATE product SET qoh = qoh - ?  WHERE product_id = ?";
			pstmt = conn.prepareStatement(updateQuery);
			pstmt.setInt(1, quantity);
			pstmt.setInt(2, prodID);
			pstmt.executeUpdate();
		}catch(SQLException sqe){
			System.err.println("ProductDAO.decreaseQoh: Threw a SQLException while decreasing product quantity on hand.");
  	      	System.err.println(sqe.getMessage());
		} finally {
			try {
				pstmt.close();
				conn.close();
			} catch (Exception e) {
				System.err.println("ProductDAO.decreaseQoh: Threw an Exception while decreasing product quantity on hand.");
			}
		}
	}

	/**
	 * increases QOH by a certain value
	 * @param prodID 		the product ID to increment
	 * @param quantity		the amount to increment by
	 * @return				true for success, false else
	 */
	public boolean increaseQoh(int prodID, int quantity) {
		int rowsUpdated = 0;
		conn = DatabaseConnection.getSqlConnection();
		try{
			String updateQuery = "UPDATE product SET qoh = qoh + ?  WHERE product_id = ?";
			pstmt = conn.prepareStatement(updateQuery);
			pstmt.setInt(1, quantity);
			pstmt.setInt(2, prodID);
			rowsUpdated = pstmt.executeUpdate();
		}catch(SQLException sqe){
			System.err.println("ProductDAO.increaseQoh: Threw a SQLException while increasing product quantity on hand.");
  	      	System.err.println(sqe.getMessage());
		} finally {
			try {
				pstmt.close();
				conn.close();
			} catch (Exception e) {
				System.err.println("ProductDAO.increaseQoh: Threw an Exception while increasing product quantity on hand.");
			}
		}
		return (rowsUpdated == 1) ? true : false;
	}
}
