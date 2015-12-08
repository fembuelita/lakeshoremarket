package com.online.lakeshoremarket.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.ws.rs.core.Response;

import com.online.lakeshoremarket.exception.GenericLSMException;
import com.online.lakeshoremarket.model.payment.Payment;
import com.online.lakeshoremarket.util.Constant;
import com.online.lakeshoremarket.util.DatabaseConnection;

/**
 * represents the payment database access object
 * interacts with the database
 *
 */
public class PaymentDAO {
	
	Connection conn = null;
	PreparedStatement pstmt = null;

	/**
	 * creates a payment in the database
	 * @param custPayment 		the payment object to create
	 * @return					payment ID
	 */
	public int createPayment(Payment custPayment) {
		int paymentID = 0;
		conn = DatabaseConnection.getSqlConnection();
		try{
			String insertStmt = "INSERT INTO payment "
											+ "(status_id, method, method_transaction_id, date_paid, date_refunded, total_paid ) "
								+ "VALUES "
											+ "(?,?,?,FROM_UNIXTIME(?),FROM_UNIXTIME(?),?)";
			pstmt = conn.prepareStatement(insertStmt);
			pstmt.setInt(1, custPayment.getPaymentStatusCode());
			pstmt.setString(2, String.valueOf(custPayment.getMethodOfPayment()));
			pstmt.setInt(3, custPayment.getMethodTransactionID());
			pstmt.setLong(4, custPayment.getDatePaid());
			pstmt.setLong(5, custPayment.getDateReturned());
			pstmt.setFloat(6, custPayment.getTotalPaid());
			pstmt.executeUpdate();
			
			
			String getQuery = "SELECT MAX(payment_id) FROM payment ";
			pstmt = conn.prepareStatement(getQuery);
			ResultSet resultSet = pstmt.executeQuery();
			if(resultSet.next()){
				paymentID = resultSet.getInt(1);
			}
		}catch(SQLException sqe){
			System.err.println("PaymentDAO.createPayment: Threw an SQLException inserting a new payment in table.");
  	      	System.err.println(sqe.getMessage());
  	      	throw new GenericLSMException("Threw an SQLException inserting a new payment in table.		" 
					+ sqe.getMessage() , Response.Status.INTERNAL_SERVER_ERROR );
		} finally {
			try {
				pstmt.close();
				conn.close();
			} catch (Exception e) {
				System.err.println("PaymentDAO.createPayment: Threw an Exception inserting a new payment in table.");
				throw new GenericLSMException("Threw an Exception inserting a new payment in table.		" 
						+ e.getMessage() , Response.Status.INTERNAL_SERVER_ERROR );
			}
		}
		return paymentID;
	}

	/**
	 * marks a payment status as refunded
	 * @param paymentStatusID		the payment ID to update
	 * @param refund 				the Unix time stamp the update occurred
	 */
	public void updatePaymentStatusForRefund(int paymentStatusID, long refund) {
		conn = DatabaseConnection.getSqlConnection();
		try{
			String updateStmt = "UPDATE payment SET status_id = ?, date_refunded = FROM_UNIXTIME(?) WHERE payment_id = ?";
			pstmt = conn.prepareStatement(updateStmt);
			pstmt.setInt(1, Constant.RETURNED);
			pstmt.setLong(2, refund);
			pstmt.setInt(3, paymentStatusID);
			pstmt.executeUpdate();
		}catch(SQLException sqe){
			System.err.println("PaymentDAO.updatePaymentStatusForRefund: Threw an SQLException updating payment status and date refunded in the payment table.");
  	      	System.err.println(sqe.getMessage());
  	      	throw new GenericLSMException("Threw an SQLException updating payment status and date refunded in the payment table.		" 
					+ sqe.getMessage() , Response.Status.INTERNAL_SERVER_ERROR );
		} finally {
			try {
				pstmt.close();
				conn.close();
			} catch (Exception e) {
				System.err.println("PaymentDAO.updatePaymentStatusForRefund: Threw an Exception updating payment status and date refunded in the payment table.");
				throw new GenericLSMException("Threw an Exception updating payment status and date refunded in the payment table.		" 
						+ e.getMessage() , Response.Status.INTERNAL_SERVER_ERROR );
			}
		}
	}

}
