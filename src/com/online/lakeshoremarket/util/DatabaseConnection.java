package com.online.lakeshoremarket.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * manages the db connection
 *
 */
public class DatabaseConnection {

	/**
	 * gets a connection
	 * @return returns the connection status.
	 */
	public static Connection getSqlConnection () {
		Connection conn = null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/lakeshore_market?" + "user="+Constant.USERNAME+"&password="+Constant.PASSWORD);
		} catch (SQLException e) {
			System.out.println("SQLException");
		} catch (ClassNotFoundException e) {
			System.out.println("SQLException" + e.getMessage() + "   " +  e.getLocalizedMessage());
			e.printStackTrace();
		}
		return conn;
	}
}
