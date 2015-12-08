package com.online.lakeshoremarket.model.payment;

/**
 * instantiates the payment interface to represent the payment model
 *
 */
public class PaymentImpl implements Payment{

	private long datePaid;
	private long dateReturned;
	private float totalPaid;
	private int paymentID;
	private int paymentStatusCode;
	private char methodOfPayment;
	private int methodTransactionID;
	
	
	public long getDatePaid() {
		return datePaid;
	}
	public void setDatePaid(long datePaid) {
		this.datePaid = datePaid;
	}
	public long getDateReturned() {
		return dateReturned;
	}
	public void setDateReturned(long dateReturned) {
		this.dateReturned = dateReturned;
	}
	public float getTotalPaid() {
		return totalPaid;
	}
	public void setTotalPaid(float totalPaid) {
		this.totalPaid = totalPaid;
	}
	public int getPaymentID() {
		return paymentID;
	}
	public void setPaymentID(int paymentID) {
		this.paymentID = paymentID;
	}
	public int getPaymentStatusCode() {
		return paymentStatusCode;
	}
	public void setPaymentStatusCode(int paymentStatusCode) {
		this.paymentStatusCode = paymentStatusCode;
	}
	public char getMethodOfPayment() {
		return methodOfPayment;
	}
	public void setMethodOfPayment(char methodOfPayment) {
		this.methodOfPayment = methodOfPayment;
	}
	public int getMethodTransactionID() {
		return methodTransactionID;
	}
	public void setMethodTransactionID(int methodTransactionID) {
		this.methodTransactionID = methodTransactionID;
	}
	
	
}
