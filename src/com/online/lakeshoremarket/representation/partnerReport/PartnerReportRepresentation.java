package com.online.lakeshoremarket.representation.partnerReport;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

@XmlRootElement(name = "ProductSold")
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "")

/**
 * This class builds the representation of partner reports that interact with and are manipulated by the user in the service layer.
 *
 */

public class PartnerReportRepresentation {

	private int productId;
	private int quantity;
	private int cost;
	private int price;
	private int totalCost;
	private int totalPrice;
	private int totalProfit;
	
	/**
	 * gets a product ID
	 * @return 	the product ID
	 */
	
	public int getProductId() {
		return productId;
	}
	
	/**
	 * sets a product ID
	 * @param 	the product ID
	 */
	
	public void setProductId(int productId) {
		this.productId = productId;
	}
	
	/**
	 * gets a product quantity
	 * @return 	the product quantity
	 */
	
	public int getQuantity() {
		return quantity;
	}
	
	/**
	 * sets the quantity of the product
	 * @param 	the product quantity
	 */
	
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	
	/**
	 * gets a product cost
	 * @return 	the product cost
	 */
	
	public int getCost() {
		return cost;
	}
	
	/**
	 * sets the cost of the product
	 * @param 	the product cost
	 */
	
	public void setCost(int cost) {
		this.cost = cost;
	}
	
	/**
	 * gets a product price
	 * @return 	the product price
	 */
	
	public int getPrice() {
		return price;
	}
	
	/**
	 * sets the price of the product
	 * @param 	the product price
	 */
	
	public void setPrice(int price) {
		this.price = price;
	}
	
	/**
	 * gets the total cost for the report
	 * @return 	the total cost
	 */
	
	public int getTotalCost() {
		return totalCost;
	}
	
	/**
	 * sets the total cost for the report
	 * @param 	the total cost
	 */
	
	public void setTotalCost(int totalCost) {
		this.totalCost = totalCost;
	}
	
	/**
	 * sets the total price for the report
	 * @return 	the total price
	 */
	
	public int getTotalPrice() {
		return totalPrice;
	}
	
	/**
	 * sets the total price for the report
	 * @param 	the total price
	 */
	
	public void setTotalPrice(int totalPrice) {
		this.totalPrice = totalPrice;
	}
	
	/**
	 * gets the total profit for the report
	 * @return 	the total profit
	 */
	
	public int getTotalProfit() {
		return totalProfit;
	}
	
	/**
	 * sets the total profit for the report
	 * @param 	the total profit
	 */
	
	public void setTotalProfit(int totalProfit) {
		this.totalProfit = totalProfit;
	}
	
}
