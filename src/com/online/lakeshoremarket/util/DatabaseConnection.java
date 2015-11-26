package com.online.lakeshoremarket.util;

//import java.net.URI;
//import java.net.URISyntaxException;
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
	public static Connection getLocalSqlConnection () {
		
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
	
	public static Connection getSqlConnection() {

		Connection conn = null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			conn = DriverManager.getConnection("jdbc:mysql://162.243.94.35:3306/" + Constant.REMOTE_DBNAME + "?" + "user="+Constant.REMOTE_USERNAME+"&password="+Constant.REMOTE_PASSWORD);
		} catch (SQLException e) {
			System.out.println("SQLException");
		} catch (ClassNotFoundException e) {
			System.out.println("SQLException" + e.getMessage() + "   " +  e.getLocalizedMessage());
			e.printStackTrace();
		}
		return conn;		
	}	
}