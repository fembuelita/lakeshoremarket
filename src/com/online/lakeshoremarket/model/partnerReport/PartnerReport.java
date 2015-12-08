package com.online.lakeshoremarket.model.partnerReport;

/**
 * represents a partner report in the database
 *
 */

public interface PartnerReport {

	/**
	 * gets a product ID
	 * @return 	the product ID
	 */
	
	public int getProductId();
	
	/**
	 * sets a product ID
	 * @param 	the product ID
	 */
	
	public void setProductId(int productId);
	
	/**
	 * gets a product quantity
	 * @return 	the product quantity
	 */
	
	public int getQuantity();
	
	/**
	 * sets the quantity of the product
	 * @param 	the product quantity
	 */
	
	public void setQuantity(int quantity);
	
	/**
	 * gets a product cost
	 * @return 	the product cost
	 */
	
	public int getCost();
	
	/**
	 * sets the cost of the product
	 * @param 	the product cost
	 */
	
	public void setCost(int cost);
	
	/**
	 * gets a product price
	 * @return 	the product price
	 */
	
	public int getPrice();
	
	/**
	 * sets the price of the product
	 * @param 	the product price
	 */
	
	public void setPrice(int price);
	
	/**
	 * gets the total cost for the report
	 * @return 	the total cost
	 */
	
	public int getTotalCost();
	
	/**
	 * sets the total cost for the report
	 * @param 	the total cost
	 */
	
	public void setTotalCost(int totalCost);
	
	/**
	 * gets the total price for the report
	 * @return 	the total price
	 */
	
	public int getTotalPrice();
	
	/**
	 * sets the total price for the report
	 * @param 	the total price
	 */
	
	public void setTotalPrice(int totalPrice);
	
	/**
	 * gets the total profit for the report
	 * @return 	the total profit
	 */
	
	public int getTotalProfit();
	
	/**
	 * sets the total profit for the report
	 * @param 	the total profit
	 */
	
	public void setTotalProfit(int totalProfit);
	
	
}
