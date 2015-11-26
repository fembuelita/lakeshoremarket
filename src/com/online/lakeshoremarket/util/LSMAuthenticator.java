package com.online.lakeshoremarket.util;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


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
				System.out.println("test");
				while(resultSet.next()){
					int custId = resultSet.getInt("customer_id");
					System.out.println("cust id = " + custId);
					if(custId >= 0){
						isUserAuthentic = true;
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
		}
		
		return isUserAuthentic;
	}
}
