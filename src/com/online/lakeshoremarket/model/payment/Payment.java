package com.online.lakeshoremarket.model.payment;


/**
 * represents a payment in the database
 *
 */
public interface Payment {

	/**
	 * gets the date and time this payment was marked as paid
	 * @return long
	 */
	public long getDatePaid();
	
	/**
	 * sets the date and time this payment was paid
	 * @param datePaid the timestamp
	 */
	public void setDatePaid(long datePaid);
	
	/**
	 * gets the date and time this order was returned
	 * @return the timestamp
	 */
	public long getDateReturned();
	
	/**
	 * sets the date and time this order was returned
	 * @param dateReturned the timestamp
	 */
	public void setDateReturned(long dateReturned);
	
	/**
	 * gets the total amount this order was paid for
	 * @return the order total
	 */
	public float getTotalPaid();
	
	/**
	 * sets the total amount paid
	 * @param totalPaid amount paid
	 */
	public void setTotalPaid(float totalPaid);
	
	/**
	 * gets the payment ID
	 * @return the ID
	 */
	public int getPaymentID();
	
	/**
	 * sets this payment ID
	 * @param paymentID the ID
	 */
	public void setPaymentID(int paymentID);
	
	/**
	 * gets this payment status code
	 * @return the status code
 	 */
	public int getPaymentStatusCode();
	
	/**
	 * sets this payment status code
	 * @param paymentStatusCode the code
	 */
	public void setPaymentStatusCode(int paymentStatusCode);
	
	/**
	 * gets the method of payment (always paypal for this system)
	 * @return payment status
	 */
	public char getMethodOfPayment();
	
	/**
	 * sets the method of payment 
	 * @param methodOfPayment the method
	 */
	public void setMethodOfPayment(char methodOfPayment);
	
	/**
	 * gets the method transaction ID from payment processor
	 * @return the ID
	 */
	public int getMethodTransactionID();
	
	/**
	 * sets the method transaction ID from payment processor
	 * @param methodTransactionID the ID
	 */
	public void setMethodTransactionID(int methodTransactionID);
	
	
}
