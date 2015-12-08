package com.online.lakeshoremarket.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.ws.rs.core.Response;

import com.online.lakeshoremarket.exception.GenericLSMException;
import com.online.lakeshoremarket.model.order.Order;
import com.online.lakeshoremarket.model.order.OrderImpl;
import com.online.lakeshoremarket.util.Constant;
import com.online.lakeshoremarket.util.DatabaseConnection;

/**
 * Represents the order database access object
 * used for interacting with the database
 *
 */
public class OrderDAO {

	
	Connection conn = null;
	PreparedStatement pstmt = null;
	
	/**
	 * creates an order in the database
	 * @param custOrder 	the order to create
	 * @return int	orderID
	 */
	public int createOrder(Order custOrder) {
		int rowsUpdated = 0;
		int orderID = 0;
		conn = DatabaseConnection.getSqlConnection();
		try{
			String insertStmt = "INSERT INTO `order` "
											+ "(customer_id, payment_id, status_id, date_purchased, date_refunded, tracking_number, product_id, qty ) "
								+ "VALUES "
											+ "(?,?,?,FROM_UNIXTIME(?),FROM_UNIXTIME(?),?,?,?)";
			pstmt = conn.prepareStatement(insertStmt);
			pstmt.setInt(1, custOrder.getCustomerID());
			pstmt.setInt(2, custOrder.getPaymentID());
			pstmt.setInt(3, custOrder.getOrderStatusCode());
			pstmt.setLong(4, custOrder.getDatePurchased());
			pstmt.setLong(5, custOrder.getDateRefunded());
			pstmt.setString(6, custOrder.getTrackingNumber());
			pstmt.setInt(7, custOrder.getProductID());
			pstmt.setInt(8, custOrder.getQty());
			rowsUpdated = pstmt.executeUpdate();
			if(0 != rowsUpdated){
				String selectQuery = "SELECT MAX(order_id) FROM `order`";
				pstmt = conn.prepareStatement(selectQuery);
				ResultSet resultSet = pstmt.executeQuery();
				if(resultSet.next()){
					orderID = resultSet.getInt(1);
				}
			}
		}catch(SQLException sqe){
			System.err.println("OrderDAO.createOrder: Threw a SQLException inserting a new order in table.");
  	      	System.err.println(sqe.getMessage());
  	      	throw new GenericLSMException("Threw a SQLException inserting a new order in table.		" 
					+ sqe.getMessage() , Response.Status.INTERNAL_SERVER_ERROR );
		} finally {
			try {
				pstmt.close();
				conn.close();
			} catch (Exception e) {
				System.err.println("OrderDAO.createOrder: Threw an Exception inserting a new order in table.");
				throw new GenericLSMException("Threw an Exception inserting a new order in table.		" 
						+ e.getMessage() , Response.Status.INTERNAL_SERVER_ERROR );
			}
		}
		return orderID;
	}

	/**
	 * Marks an order as shipped and updates the order with the tracking number
	 * @param orderID 			the order ID to update
	 * @param trackingNumber  	the tracking number to save to order
	 * @return  				true on saved changes false otherwise
	 */
	public boolean shipOrder(int orderID, String trackingNumber) {
		int rowsUpdated = 0;
		conn = DatabaseConnection.getSqlConnection();
		try{
			String updateStmt = "UPDATE `order` SET tracking_number = ?, status_id = ? WHERE order_id = ?";
			pstmt = conn.prepareStatement(updateStmt);
			pstmt.setString(1, trackingNumber);
			pstmt.setInt(2, Constant.SHIPPED);
			pstmt.setInt(3, orderID);
			rowsUpdated = pstmt.executeUpdate();
		}catch(SQLException sqe){
			System.err.println("OrderDAO.shipOrder: Threw a SQLException updating tracking number and status in the order table.");
  	      	System.err.println(sqe.getMessage());
  	      	throw new GenericLSMException("Threw a SQLException updating tracking number and status in the order table.		" 
					+ sqe.getMessage() , Response.Status.INTERNAL_SERVER_ERROR );
		} finally {
			try {
				pstmt.close();
				conn.close();
			} catch (Exception e) {
				System.err.println("OrderDAO.shipOrder: Threw an Exception updating tracking number and status in the order table.");
				throw new GenericLSMException("Threw an Exception updating tracking number and status in the order table.		" 
						+ e.getMessage() , Response.Status.INTERNAL_SERVER_ERROR );
			}
		}
		return (rowsUpdated == 0)? false : true;
	}

	/**
	 * updates an order to mark as delivered
	 * @param orderID 		the ID of the order to mark as delivered
	 * @return 				true on changes saved else false
	 */
	public boolean fulfillOrder(int orderID) {
		int rowsUpdated = 0;
		conn = DatabaseConnection.getSqlConnection();
		try{
			String updateStmt = "UPDATE `order` SET status_id = ? WHERE order_id = ?";
			pstmt = conn.prepareStatement(updateStmt);
			pstmt.setInt(1, Constant.DELIVERED);
			pstmt.setInt(2, orderID);
			rowsUpdated = pstmt.executeUpdate();
		}catch(SQLException sqe){
			System.err.println("OrderDAO.fulfillOrder: Threw a SQLException updating status to 'DELIVERED' in the order table.");
  	      	System.err.println(sqe.getMessage());
  	      	throw new GenericLSMException("Threw a SQLException updating status to 'DELIVERED' in the order table.		" 
					+ sqe.getMessage() , Response.Status.INTERNAL_SERVER_ERROR );
		} finally {
			try {
				pstmt.close();
				conn.close();
			} catch (Exception e) {
				System.err.println("OrderDAO.fulfillOrder: Threw an Exception updating status to 'DELIVERED' in the order table.");
				throw new GenericLSMException("Threw an Exception updating status to 'DELIVERED' in the order table.		" 
						+ e.getMessage() , Response.Status.INTERNAL_SERVER_ERROR );
			}
		}
		return (rowsUpdated == 0)? false : true;
	}

	/**
	 * returns the status of an order 
	 * @param orderID		the order ID to look up
	 * @return				-1 on error, 0+ for success (see constants class to match)
	 */
	public int getOrderStatus(int orderID) {
		int orderStatus = -1;
		conn = DatabaseConnection.getSqlConnection();
		try{
			String getQuery = "SELECT status_id FROM `order` WHERE order_id = ?";
			pstmt = conn.prepareStatement(getQuery);
			pstmt.setInt(1, orderID);
			ResultSet resultSet = pstmt.executeQuery();
			while(resultSet.next()){
				orderStatus = resultSet.getInt("status_id");
			}
		}catch(SQLException sqe){
			System.err.println("OrderDAO.getOrderStatus: Threw a SQLException while getting order status ID for the orderID = "+orderID);
  	      	System.err.println(sqe.getMessage());
  	      	throw new GenericLSMException("Threw a SQLException while getting order status ID		" 
					+ sqe.getMessage() , Response.Status.INTERNAL_SERVER_ERROR );
		} finally {
			try {
				pstmt.close();
				conn.close();
			} catch (Exception e) {
				System.err.println("OrderDAO.getOrderStatus: Threw an Exception while getting order status ID for the orderID = "+orderID);
				throw new GenericLSMException("Threw an Exception while getting order status ID		" 
						+ e.getMessage() , Response.Status.INTERNAL_SERVER_ERROR );
			}
		}
		return orderStatus;
	}

	/**
	 * builds an order object by looking up the details in the database
	 * @param orderID 		the order ID to lookup
	 * @return				the order object
	 */
	public Order getOrderDetails(int orderID) {
		Order custOrder = null;
		conn = DatabaseConnection.getSqlConnection();
		try{
			custOrder = new OrderImpl();
			String getQuery = "SELECT *, UNIX_TIMESTAMP(date_purchased) AS `purchase_date`, UNIX_TIMESTAMP(date_refunded) as `refund_date` FROM `order` WHERE order_id = ?";
			pstmt = conn.prepareStatement(getQuery);
			pstmt.setInt(1, orderID);
			ResultSet resultSet = pstmt.executeQuery();
			while(resultSet.next()){
				custOrder.setCustomerID(resultSet.getInt("customer_id"));
				custOrder.setPaymentID(resultSet.getInt("payment_id"));
				custOrder.setOrderStatusCode(resultSet.getInt("status_id"));
				custOrder.setDatePurchased(resultSet.getLong("purchase_date"));
				custOrder.setDateRefunded(resultSet.getLong("refund_date"));
				custOrder.setTrackingNumber(resultSet.getString("tracking_number"));
				custOrder.setProductID(resultSet.getInt("product_id"));
				custOrder.setQty(resultSet.getInt("qty"));
			}
		}catch(SQLException sqe){
			System.err.println("OrderDAO.getOrderDetails: Threw a SQLException while getting order details for the orderID = "+orderID);
  	      	System.err.println(sqe.getMessage());
  	      	throw new GenericLSMException("Threw a SQLException while getting order details		" 
					+ sqe.getMessage() , Response.Status.INTERNAL_SERVER_ERROR );
		} finally {
			try {
				pstmt.close();
				conn.close();
			} catch (Exception e) {
				System.err.println("OrderDAO.getOrderDetails: Threw an Exception while getting order details for the orderID = "+orderID);
				throw new GenericLSMException("Threw an Exception while getting order details		" 
						+ e.getMessage() , Response.Status.INTERNAL_SERVER_ERROR );
			}
		}
		return custOrder;
	}

	/**
	 * sets the order status to refunded 
	 * @param orderID 		the order ID to update
	 * @param unixtimestamp the date/time the change occurred
	 * @return void 
	 */
	public void updateOrderStatusForRefund(int orderID, long unixtimestamp) {
		conn = DatabaseConnection.getSqlConnection();
		try{
			String updateStmt = "UPDATE `order` SET status_id = ?, date_refunded = FROM_UNIXTIME(?) WHERE order_id = ?";
			pstmt = conn.prepareStatement(updateStmt);
			pstmt.setInt(1, Constant.CANCELLED);
			pstmt.setLong(2, unixtimestamp);
			pstmt.setInt(3, orderID);
			pstmt.executeUpdate();
		}catch(SQLException sqe){
			System.err.println("OrderDAO.updateOrderStatusForRefund: Threw a SQLException updating order status and date refunded in the order table.");
  	      	System.err.println(sqe.getMessage());
  	      	throw new GenericLSMException("Threw a SQLException updating order status and date refunded in the order table.		" 
					+ sqe.getMessage() , Response.Status.INTERNAL_SERVER_ERROR );
		} finally {
			try {
				pstmt.close();
				conn.close();
			} catch (Exception e) {
				System.err.println("OrderDAO.updateOrderStatusForRefund: Threw an Exception updating order status and date refunded in the order table.");
				throw new GenericLSMException("Threw an Exception updating order status and date refunded in the order table.		" 
						+ e.getMessage() , Response.Status.INTERNAL_SERVER_ERROR );
			}
		}
	}

}
