package com.online.lakeshoremarket.util;

import java.net.URI;
import java.net.URISyntaxException;
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
		try {
		    URI jdbUri = new URI(System.getenv("JAWSDB_URL"));
	
		    String username = jdbUri.getUserInfo().split(":")[0];
		    String password = jdbUri.getUserInfo().split(":")[1];
		    String port = String.valueOf(jdbUri.getPort());
		    String jdbUrl = "jdbc:mysql://" + jdbUri.getHost() + ":" + port + jdbUri.getPath();
	
		    return DriverManager.getConnection(jdbUrl, username, password);
		} catch( URISyntaxException e ) {
			System.err.println( "Failed to connect to SQL remotely" + e.getMessage() );
			e.printStackTrace();
		} catch( SQLException e ) {
			System.err.println( "SQL Exception: " + e.getMessage() );
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			System.out.println("SQLException" + e.getMessage() + "   " +  e.getLocalizedMessage());
			e.printStackTrace();
		}
		
		return null;
	}	
}
