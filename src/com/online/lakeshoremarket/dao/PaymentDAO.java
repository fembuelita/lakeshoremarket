package com.online.lakeshoremarket.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;

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
											+ "(?,?,?,?,?,?)";
			pstmt = conn.prepareStatement(insertStmt);
			pstmt.setInt(1, custPayment.getPaymentStatusCode());
			pstmt.setString(2, String.valueOf(custPayment.getMethodOfPayment()));
			pstmt.setInt(3, custPayment.getMethodTransactionID());
			pstmt.setTimestamp(4, custPayment.getDatePaid());
			pstmt.setTimestamp(5, custPayment.getDateReturned());
			pstmt.setFloat(6, custPayment.getTotalPaid());
			pstmt.executeUpdate();
			
			
			String getQuery = "SELECT MAX(payment_id) FROM payment ";
			pstmt = conn.prepareStatement(getQuery);
			ResultSet resultSet = pstmt.executeQuery();
			if(resultSet.next()){
				paymentID = resultSet.getInt(1);
			}
		}catch(SQLException sqe){
			System.err.println("PaymentDAO.createPayment: Threw a SQLException inserting a new payment in table.");
  	      	System.err.println(sqe.getMessage());
		} finally {
			try {
				pstmt.close();
				conn.close();
			} catch (Exception e) {
				System.err.println("PaymentDAO.createPayment: Threw an Exception inserting a new payment in table.");
			}
		}
		return paymentID;
	}

	/**
	 * marks a payment status as refunded
	 * @param paymentStatusID		the payment ID to update
	 * @param date 					the date/time the update occurred
	 */
	public void updatePaymentStatusForRefund(int paymentStatusID, Timestamp date) {
		conn = DatabaseConnection.getSqlConnection();
		try{
			String updateStmt = "UPDATE payment SET status_id = ?, date_refunded = ? WHERE payment_id = ?";
			pstmt = conn.prepareStatement(updateStmt);
			pstmt.setInt(1, Constant.RETURNED);
			pstmt.setTimestamp(2, date);
			pstmt.setInt(3, paymentStatusID);
			pstmt.executeUpdate();
		}catch(SQLException sqe){
			System.err.println("PaymentDAO.updatePaymentStatusForRefund: Threw a SQLException updating payment status and date refunded in the payment table.");
  	      	System.err.println(sqe.getMessage());
		} finally {
			try {
				pstmt.close();
				conn.close();
			} catch (Exception e) {
				System.err.println("PaymentDAO.updatePaymentStatusForRefund: Threw an Exception updating payment status and date refunded in the payment table.");
			}
		}
	}

}
