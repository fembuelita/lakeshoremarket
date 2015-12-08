package com.online.lakeshoremarket.util;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


import com.online.lakeshoremarket.model.customer.Customer;
import com.online.lakeshoremarket.model.customer.CustomerImpl;

public class TestDatabaseConnection {

	public static void main(String[] args) {
		int custID = 1;
		Customer cust = null;
		PreparedStatement pstmt;
		Connection conn = DatabaseConnection.getSqlConnection();
		if(conn != null){
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
				System.out.println("SQLException   = " + sqe.getMessage());
			} finally {
				try {
					conn.close();
				} catch (Exception e) {
					System.out.println("Exception  =" +e.getMessage());
				}
			}
		}else{
			System.out.println("No connection");
		}
		
		
		System.out.println("Cutomer Name = " + cust.getFirstName());
	}

}
