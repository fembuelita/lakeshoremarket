package com.online.lakeshoremarket.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.online.lakeshoremarket.model.customer.Address;
import com.online.lakeshoremarket.model.customer.Customer;
import com.online.lakeshoremarket.util.DatabaseConnection;

/**
 * Represents the data access object for the customer
 * used for interacting with the database 
 */
public class CustomerDAO {

	Connection conn = null;
	PreparedStatement pstmt = null;
	
	/**
	 * @param cust 	the customer object to add
	 * @return 		number of rows updated
	 */
	public int addCustomer(Customer cust){
		conn = DatabaseConnection.getSqlConnection();
		int rowsUpdated = 0;
		try{
			String insertStmt = "INSERT INTO customer "
											+ "(ship_address_id, bill_address_id, tel, email, first_name, last_name, title, password, paypal_cust_id) "
								+ "VALUES "
											+ "(?,?,?,?,?,?,?,?,?)";
			pstmt = conn.prepareStatement(insertStmt);
			pstmt.setInt(1, cust.getShippingAddress());
			pstmt.setInt(2, cust.getBillingAddress());
			pstmt.setString(3, cust.getPhone());
			pstmt.setString(4, cust.getEmail());
			pstmt.setString(5, cust.getFirstName());
			pstmt.setString(6, cust.getLastName());
			pstmt.setString(7, cust.getTitle());
			pstmt.setString(8, cust.getPassword());
			pstmt.setString(9, cust.getPaypalCustID());
			rowsUpdated = pstmt.executeUpdate();
		}catch(SQLException sqe){
			System.err.println("CustomerDAO.addCustomer: Threw a SQLException inserting a new customer in table.");
  	      	System.err.println(sqe.getMessage());
		} finally {
			try {
				pstmt.close();
				conn.close();
			} catch (Exception e) {
				System.err.println("CustomerDAO.addCustomer: Threw an Exception inserting a new customer in table.");
			}
		}
		return rowsUpdated;
	}

	/**
	 * @param address 	the customer address object to insert
	 * @return 			address ID
	 */
	public int addAddress(Address address) {
		conn = DatabaseConnection.getSqlConnection();
		int addressID = 0;
		int rowsUpdated = 0;
		try{
			String insertStmt = "INSERT INTO address "
											+ "(line1, line2, line3, city, state, country, postal_code) "
								+ "VALUES "
											+ "(?,?,?,?,?,?,?)";
			pstmt = conn.prepareStatement(insertStmt);
			pstmt.setString(1, address.getLine1());
			pstmt.setString(2, address.getLine2());
			pstmt.setString(3, address.getLine3());
			pstmt.setString(4, address.getCity());
			pstmt.setString(5, address.getState());
			pstmt.setString(6, address.getCountry());
			pstmt.setString(7, address.getZip());
			rowsUpdated = pstmt.executeUpdate();
			if(0 != rowsUpdated){
				String selectQuery = "SELECT MAX(address_id) FROM address";
				pstmt = conn.prepareStatement(selectQuery);
				ResultSet resultSet = pstmt.executeQuery();
				if(resultSet.next()){
					addressID = resultSet.getInt(1);
				}
			}
		}catch(SQLException sqe){
			System.err.println("CustomerDAO.addAddress: Threw a SQLException inserting a new address in table.");
  	      	System.err.println(sqe.getMessage());
		} finally {
			try {
				pstmt.close();
				conn.close();
			} catch (Exception e) {
				System.err.println("CustomerDAO.addAddress: Threw an Exception inserting a new address in table.");
			}
		}
		return addressID;
	}

	/**
	 * attempts a SOFT delete of a customer from the database (by marking it as inactive)
	 * @param custID 	the customer ID
	 * @return 			1 for success, 0 on failure or no rows affected
	 */
	public boolean deleteCustomer(int custID) {
		conn = DatabaseConnection.getSqlConnection();
		int rowsUpdated = 0;
		try{
			String updateStmt = "UPDATE customer SET active = 0 WHERE customer_id = ? ";
			pstmt = conn.prepareStatement(updateStmt);
			pstmt.setInt(1, custID);
			rowsUpdated = pstmt.executeUpdate();
			//This code section is commented because we don't actually have to delete the customer instead make the customer inactive
			/*String deleteStmt = "DELETE FROM customer WHERE customer_id = ? ";
			pstmt = conn.prepareStatement(deleteStmt);
			pstmt.setInt(1, custID);
			rowsUpdated = pstmt.executeUpdate();*/
		}catch(SQLException sqe){
			System.err.println("CustomerDAO.deleteCustomer: Threw a SQLException while deleteing the customer with customerID = " + custID);
  	      	System.err.println(sqe.getMessage());
		} finally {
			try {
				pstmt.close();
				conn.close();
			} catch (Exception e) {
				System.err.println("CustomerDAO.deleteCustomer: Threw an Exception while deleteing the customer with customerID = " + custID);
			}
		}
		return (rowsUpdated == 1) ? true : false;
	}

	/**
	 * deletes a customer address from the database
	 * @param addressID 	the address record ID to delete
	 * @return 				number of rows affected
	 */
	public int deleteCustomerAddress(int addressID) {
		int rowsUpdated = 0;
		conn = DatabaseConnection.getSqlConnection();
		try{
			String deleteStmt = "DELETE FROM address WHERE address_id = ? " ;
			pstmt = conn.prepareStatement(deleteStmt);
			pstmt.setInt(1, addressID);
			rowsUpdated = pstmt.executeUpdate();
		}catch(SQLException sqe){
			System.err.println("CustomerDAO.deleteCustomerAddress: Threw a SQLException while deleting customer address where addressID = "+addressID);
  	      	System.err.println(sqe.getMessage());
		} finally {
			try {
				pstmt.close();
				conn.close();
			} catch (Exception e) {
				System.err.println("CustomerDAO.deleteCustomerAddress: Threw an Exception while deleting customer address where addressID = "+addressID);
			}
		}
		return rowsUpdated;
	}

	/**
	 * returns an address ID for the customer specified
	 * @param custID 		the customer ID to lookup billing address
	 * @return				billing address ID
	 */
	public int getCustomerBillingAddress(int custID) {
		int billingAddressID = 0;
		conn = DatabaseConnection.getSqlConnection();
		try{
			String getQuery = "SELECT bill_address_id FROM customer WHERE customer_id = ? ";
			pstmt = conn.prepareStatement(getQuery);
			pstmt.setInt(1, custID);
			ResultSet resultSet = pstmt.executeQuery();
			while(resultSet.next()){
				billingAddressID = resultSet.getInt("bill_address_id");
			}
		}catch(SQLException sqe){
			System.err.println("CustomerDAO.getCustomerBillingAddress: Threw a SQLException while getting customer billing address.");
  	      	System.err.println(sqe.getMessage());
		} finally {
			try {
				pstmt.close();
				conn.close();
			} catch (Exception e) {
				System.err.println("CustomerDAO.getCustomerBillingAddress: Threw a Exception while getting customer billing address.");
			}
		}
		return billingAddressID;
	}

	/**
	 * Looks up a customer's shipping address ID
	 * @param custID	the customer ID to look up the address for
	 * @return 			the customer's shipping address ID
	 */
	public int getCustomerShippingAddress(int custID) {
		int shippingAddressID = 0;
		conn = DatabaseConnection.getSqlConnection();
		try{
			String getQuery = "SELECT ship_address_id FROM customer WHERE customer_id = ? ";
			pstmt = conn.prepareStatement(getQuery);
			pstmt.setInt(1, custID);
			ResultSet resultSet = pstmt.executeQuery();
			while(resultSet.next()){
				shippingAddressID = resultSet.getInt("ship_address_id");
			}
		}catch(SQLException sqe){
			System.err.println("CustomerDAO.getCustomerShippingAddress: Threw a SQLException while getting customer shipping address.");
  	      	System.err.println(sqe.getMessage());
		} finally {
			try {
				pstmt.close();
				conn.close();
			} catch (Exception e) {
				System.err.println("CustomerDAO.getCustomerShippingAddress: Threw a Exception while getting customer shipping address.");
			}
		}
		return shippingAddressID;
	}

	/**
	 * determines if a customer is active or not (deleted or not)
	 * @param custID 	the customer ID to lookup
	 * @return			true for active, false for deleted/inactive	
	 */
	public boolean getStatus(int custID) {
		conn = DatabaseConnection.getSqlConnection();
		boolean isCustomerActive = false;
		try{
			String getQuery = "SELECT active FROM customer WHERE customer_id = ? ";
			pstmt = conn.prepareStatement(getQuery);
			pstmt.setInt(1, custID);
			ResultSet resultSet = pstmt.executeQuery();
			while(resultSet.next()){
				isCustomerActive = resultSet.getBoolean("active");
			}
		}catch(SQLException sqe){
			System.err.println("CustomerDAO.getStatus: Threw a SQLException while getting customer active status.");
  	      	System.err.println(sqe.getMessage());
		} finally {
			try {
				pstmt.close();
				conn.close();
			} catch (Exception e) {
				System.err.println("CustomerDAO.getStatus: Threw a Exception while getting customer active status.");
			}
		}
		return isCustomerActive;
	}
}