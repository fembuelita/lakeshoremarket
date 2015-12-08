package com.online.lakeshoremarket.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.ws.rs.core.Response;

import com.online.lakeshoremarket.exception.GenericLSMException;
import com.online.lakeshoremarket.model.customer.Address;
import com.online.lakeshoremarket.model.customer.Customer;
import com.online.lakeshoremarket.model.customer.CustomerImpl;
import com.online.lakeshoremarket.model.order.Order;
import com.online.lakeshoremarket.model.order.OrderImpl;
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
	 * @return 		customer id of the newly added customer
	 */
	public int addCustomer(Customer cust){
		conn = DatabaseConnection.getSqlConnection();
		int customerID = 0;
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
			if(0 != rowsUpdated){
				String selectQuery = "SELECT MAX(customer_id) FROM customer";
				pstmt = conn.prepareStatement(selectQuery);
				ResultSet resultSet = pstmt.executeQuery();
				if(resultSet.next()){
					customerID = resultSet.getInt(1);
				}
			}
		}catch(SQLException sqe){
			System.err.println("CustomerDAO.addCustomer: Threw an SQLException inserting a new customer in table.");
  	      	System.err.println(sqe.getMessage());
  	      	throw new GenericLSMException("Threw an SQLException inserting a new customer in table.		" 
					+ sqe.getMessage() , Response.Status.INTERNAL_SERVER_ERROR );
		} finally {
			try {
				pstmt.close();
				conn.close();
			} catch (Exception e) {
				System.err.println("CustomerDAO.addCustomer: Threw an Exception inserting a new customer in table.");
				throw new GenericLSMException("Threw an Exception inserting a new customer in table.		" 
						+ e.getMessage() , Response.Status.INTERNAL_SERVER_ERROR );
			}
		}
		return customerID;
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
			System.err.println("CustomerDAO.addAddress: Threw an SQLException inserting a new address in table.");
  	      	System.err.println(sqe.getMessage());
  	      	throw new GenericLSMException("Threw a SQLException inserting a new address in table.		" 
					+ sqe.getMessage() , Response.Status.INTERNAL_SERVER_ERROR );
		} finally {
			try {
				pstmt.close();
				conn.close();
			} catch (Exception e) {
				System.err.println("CustomerDAO.addAddress: Threw an Exception inserting a new address in table.");
				throw new GenericLSMException("Threw an Exception inserting a new address in table.		" 
						+ e.getMessage() , Response.Status.INTERNAL_SERVER_ERROR );
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
			System.err.println("CustomerDAO.deleteCustomer: Threw an SQLException while deleting the customer with customerID = " + custID);
  	      	System.err.println(sqe.getMessage());
  	      	throw new GenericLSMException("Threw an SQLException while deleting the customer		" 
					+ sqe.getMessage() , Response.Status.INTERNAL_SERVER_ERROR );
		} finally {
			try {
				pstmt.close();
				conn.close();
			} catch (Exception e) {
				System.err.println("CustomerDAO.deleteCustomer: Threw an Exception while deleting the customer with customerID = " + custID);
				throw new GenericLSMException("Threw an Exception while deleting the customer		" 
						+ e.getMessage() , Response.Status.INTERNAL_SERVER_ERROR );
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
			System.err.println("CustomerDAO.deleteCustomerAddress: Threw an SQLException while deleting customer address where addressID = "+addressID);
  	      	System.err.println(sqe.getMessage());
  	      	throw new GenericLSMException("Threw an SQLException while deleting customer address		" 
					+ sqe.getMessage() , Response.Status.INTERNAL_SERVER_ERROR );
		} finally {
			try {
				pstmt.close();
				conn.close();
			} catch (Exception e) {
				System.err.println("CustomerDAO.deleteCustomerAddress: Threw an Exception while deleting customer address where addressID = "+addressID);
				throw new GenericLSMException("Threw an Exception while deleting customer address		" 
						+ e.getMessage() , Response.Status.INTERNAL_SERVER_ERROR );
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
			System.err.println("CustomerDAO.getCustomerBillingAddress: Threw an SQLException while getting customer billing address.");
  	      	System.err.println(sqe.getMessage());
  	      	throw new GenericLSMException("Threw an SQLException while getting customer billing address.		" 
					+ sqe.getMessage() , Response.Status.INTERNAL_SERVER_ERROR );
		} finally {
			try {
				pstmt.close();
				conn.close();
			} catch (Exception e) {
				System.err.println("CustomerDAO.getCustomerBillingAddress: Threw an Exception while getting customer billing address.");
				throw new GenericLSMException("Threw an Exception while getting customer billing address.		" 
						+ e.getMessage() , Response.Status.INTERNAL_SERVER_ERROR );
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
			System.err.println("CustomerDAO.getCustomerShippingAddress: Threw an SQLException while getting customer shipping address.");
  	      	System.err.println(sqe.getMessage());
  	      	throw new GenericLSMException("Threw an SQLException while getting customer shipping address.		" 
					+ sqe.getMessage() , Response.Status.INTERNAL_SERVER_ERROR );
		} finally {
			try {
				pstmt.close();
				conn.close();
			} catch (Exception e) {
				System.err.println("CustomerDAO.getCustomerShippingAddress: Threw an Exception while getting customer shipping address.");
				throw new GenericLSMException("Threw an Exception while getting customer shipping address.		" 
						+ e.getMessage() , Response.Status.INTERNAL_SERVER_ERROR );
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
			System.err.println("CustomerDAO.getStatus: Threw an SQLException while getting customer active status.");
  	      	System.err.println(sqe.getMessage());
  	      	throw new GenericLSMException("Threw an SQLException while getting customer active status.		" 
					+ sqe.getMessage() , Response.Status.INTERNAL_SERVER_ERROR );
		} finally {
			try {
				pstmt.close();
				conn.close();
			} catch (Exception e) {
				System.err.println("CustomerDAO.getStatus: Threw an Exception while getting customer active status.");
				throw new GenericLSMException("Threw an Exception while getting customer active status.		" 
						+ e.getMessage() , Response.Status.INTERNAL_SERVER_ERROR );
			}
		}
		return isCustomerActive;
	}
	
	/**
	 * searches for a customer given the customer ID
	 * @param custID 	the customer ID to lookup
	 * @return cust		a representation of the customer
	 */
	
	public Customer getCustomerByID(int custID){
		Customer cust = null;
		conn = DatabaseConnection.getSqlConnection();
		try{
			cust = new CustomerImpl();
			String searchQuery = "SELECT * FROM `customer` WHERE customer_id = ? LIMIT 1";
			pstmt = conn.prepareStatement(searchQuery);
			pstmt.setInt(1, custID);
			ResultSet resultSet = pstmt.executeQuery();
			while(resultSet.next()){
				cust.setTitle(resultSet.getString("title"));
				cust.setFirstName(resultSet.getString("first_name"));
				cust.setLastName(resultSet.getString("last_name"));
				cust.setActive(resultSet.getByte("active") == 1 ? true : false);
				cust.setBillingAddress(resultSet.getInt("bill_address_id"));
				cust.setShippingAddress(resultSet.getInt("ship_address_id"));
				cust.setEmail(resultSet.getString("email"));
				cust.setPhone(resultSet.getString("tel"));
				cust.setCustomerID(resultSet.getInt("customer_id"));
			}
			
		}catch(SQLException sqe){
			System.err.println("CustomerDAO.getCustomerByID: Threw an SQLException while getting Customer.");
  	      	System.err.println(sqe.getMessage());
  	      	throw new GenericLSMException("Threw an SQLException while getting Customer.		" 
					+ sqe.getMessage() , Response.Status.INTERNAL_SERVER_ERROR );
		} finally {
			try {
				pstmt.close();
				conn.close();
			} catch (Exception e) {
				System.err.println("CustomerDAO.getCustomerByID: Threw an Exception while getting Customer");
				System.err.println(e.getMessage());
				throw new GenericLSMException("Threw an Exception while getting Customer.		" 
						+ e.getMessage() , Response.Status.INTERNAL_SERVER_ERROR );
			}
		}
		
		return cust;
	}
	

	/**
	 * Queries the DB for orders placed by a  specific customer
	 * @param customerID
	 * @return order history
	 */
	public ArrayList<Order> getOrderHistory(int customerID) {
		Order custOrder = null;
		ArrayList<Order> orderList = new ArrayList<>();
		conn = DatabaseConnection.getSqlConnection();
		try{
			String getQuery = "SELECT *, UNIX_TIMESTAMP(date_purchased) AS `purchase_date`, UNIX_TIMESTAMP(date_refunded) as `refund_date` FROM `order` WHERE customer_id = ?";
			pstmt = conn.prepareStatement(getQuery);
			pstmt.setInt(1, customerID);
			ResultSet resultSet = pstmt.executeQuery();
			while(resultSet.next()){
				custOrder = new OrderImpl();
				custOrder.setCustomerID(resultSet.getInt("customer_id"));
				custOrder.setPaymentID(resultSet.getInt("payment_id"));
				custOrder.setOrderStatusCode(resultSet.getInt("status_id"));
				custOrder.setDatePurchased(resultSet.getLong("purchase_date"));
				custOrder.setDateRefunded(resultSet.getLong("refund_date"));
				custOrder.setTrackingNumber(resultSet.getString("tracking_number"));
				custOrder.setProductID(resultSet.getInt("product_id"));
				custOrder.setOrderID(resultSet.getInt("order_id"));
				custOrder.setQty(resultSet.getInt("qty"));
				orderList.add( custOrder );
			}			
		}catch(SQLException sqe){
			System.err.println("CustomerDAO.getOrderHistory: Threw an SQLException while searching for orders by customer ID.");
  	      	System.err.println(sqe.getMessage());
  	      	throw new GenericLSMException("Threw an SQLException while searching for orders in table.		" 
  	      									+ sqe.getMessage() , Response.Status.INTERNAL_SERVER_ERROR );
		} finally {
			try {
				pstmt.close();
				conn.close();
			} catch (Exception e) {
				System.err.println("CustomerDAO.getOrderHistory: Threw an SQLException while searching for orders by customer ID.");
	  	      	throw new GenericLSMException("Threw an SQLException while searching for orders in table.		" 
							+ e.getMessage() , Response.Status.INTERNAL_SERVER_ERROR );
			}
		}
		return orderList;
	}
}