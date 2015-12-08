package com.online.lakeshoremarket.util;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.ws.rs.core.Response;

import com.online.lakeshoremarket.exception.GenericLSMException;

/**
 * Checks users and partner database tables for matching credentials (does not authorize)
 * @param 	customer/partner email
 * @param	customer/partner password
 * @return	bool (affirmative if the user is authentic)
 *
 */

public class LSMAuthenticator {

	public static boolean authenticateUser(String email, String password) {
		boolean isUserAuthentic = false;
		Connection conn = DatabaseConnection.getSqlConnection();
		PreparedStatement pstmt = null;
		
		if(conn != null){
			try{
				String searchQuery = "SELECT * FROM `customer` WHERE email = ? AND password = ? AND active = 1 LIMIT 1";
				pstmt = conn.prepareStatement(searchQuery);
				pstmt.setString(1, email);
				pstmt.setString(2, password);
				ResultSet resultSet = pstmt.executeQuery();
				while(resultSet.next()){
					int custId = resultSet.getInt("customer_id");
					if(custId >= 0){
						isUserAuthentic = true;
					}
				}
				if(!isUserAuthentic){
					searchQuery = "SELECT * FROM `partner` WHERE email = ? AND password = ? AND active = 1 LIMIT 1";
					pstmt.close();
					pstmt = conn.prepareStatement(searchQuery);
					pstmt.setString(1, email);
					pstmt.setString(2, password);
					resultSet = pstmt.executeQuery();
					while(resultSet.next()){
						int partnerID = resultSet.getInt("partner_id");
						if(partnerID >= 0){
							isUserAuthentic = true;
						}
					}
				}
				
			}catch(SQLException sqe){
				System.err.println("Threw an SQLException while authenticating user.");
	  	      	System.err.println(sqe.getMessage());
			} finally {
				try {
					pstmt.close();
					conn.close();
				} catch (Exception e) {
					System.err.println("Threw an SQLException while authenticating user.");
					System.err.println(e.getMessage());
				}
			}
		}else{
			throw new GenericLSMException("Failed to establish connection with the DB", Response.Status.INTERNAL_SERVER_ERROR);
		}
		
		return isUserAuthentic;
	}
}
