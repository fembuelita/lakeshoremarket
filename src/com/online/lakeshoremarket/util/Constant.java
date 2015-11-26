package com.online.lakeshoremarket.util;

/**
 * represents constants used throughout the different objects and methods in this project
 *
 */
public final class Constant {

	//For Payment Method
	/**
	 * This is for Payment Method and its char value is C
	 */
	public static char CREDITCARD = 'C';
	/**
	 * This is for Payment Method and its char value is D
	 */
	public static char DEBITCARD = 'D';
	/**
	 * This is for Payment Method and its char value is P
	 */
	public static char PAYPAL = 'P';
	
	//For Payment status
	/**
	 * This is for Payment Status and its int value is 0
	 */
	public static int UNPAID = 0;
	/**
	 * This is for Payment Status and its int value is 1
	 */
	public static int PAID = 1;
	/**
	 * This is for Payment Status and its int value is 2
	 */
	public static int RETURNED = 2;
	
	//For Order status
	/**
	 * This is for Order Status and its int value is 0
	 */
	public static int CANCELLED = 0;
	/**
	 * This is for Order Status and its int value is 1
	 */
	public static int INPROGRESS = 1;
	/**
	 * This is for Order Status and its int value is 2
	 */
	public static int SHIPPED = 2;
	/**
	 * This is for Order Status and its int value is 3
	 */
	public static int DELIVERED = 3;
	/**
	 * This is the username for the database connection.
	 */
	public static String USERNAME = "root";
	/**
	 * This is the password for the database connection.
	 */
	public static String PASSWORD = "tiger";
	
	/**
	 * This is the database name for the database connection.
	 */
	public static String REMOTE_DBNAME = "lakeshore_market";	//actually should be comp433, oops
	/**
	 * This is the username for the database connection.
	 */
	public static String REMOTE_USERNAME = "lsm";
	/**
	 * This is the password for the database connection.
	 */
	public static String REMOTE_PASSWORD = "tiger";
	
	
	
}
