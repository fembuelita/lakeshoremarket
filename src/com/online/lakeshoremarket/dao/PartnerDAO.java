package com.online.lakeshoremarket.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.ws.rs.core.Response;

import com.online.lakeshoremarket.exception.GenericLSMException;
import com.online.lakeshoremarket.model.customer.Address;
import com.online.lakeshoremarket.model.partner.Partner;
import com.online.lakeshoremarket.model.partner.PartnerImpl;
import com.online.lakeshoremarket.model.partnerReport.PartnerReport;
import com.online.lakeshoremarket.model.partnerReport.PartnerReportImpl;
import com.online.lakeshoremarket.util.DatabaseConnection;

/**
 * Represents the partner database access object
 * used to working with the database
 */
public class PartnerDAO {
	
	Connection conn = null;
	PreparedStatement pstmt = null;

	/**
	 * adds a partner to the database
	 * @param partner 		the partner object to add into the db
	 * @return 				partner id of newly added partner
	 */
	public int addPartner(Partner partner) {
		conn = DatabaseConnection.getSqlConnection();
		int partnerID = 0;
		int rowsUpdated = 0;
		try{
			String insertStmt = "INSERT INTO partner "
											+ "(address_id, name, contact_name, tel, email, password, active) "
								+ "VALUES "
											+ "(?,?,?,?,?,?,?)";
			pstmt = conn.prepareStatement(insertStmt);
			pstmt.setInt(1, partner.getAddressID());
			pstmt.setString(2, partner.getPartnerName());
			pstmt.setString(3, partner.getContactName());
			pstmt.setString(4, partner.getPhone());
			pstmt.setString(5, partner.getEmail());
			pstmt.setString(6, partner.getPassword());
			pstmt.setBoolean(7, partner.isActive());
			rowsUpdated = pstmt.executeUpdate();
			if(0 != rowsUpdated){
				String selectQuery = "SELECT MAX(partner_id) FROM partner";
				pstmt = conn.prepareStatement(selectQuery);
				ResultSet resultSet = pstmt.executeQuery();
				if(resultSet.next()){
					partnerID = resultSet.getInt(1);
				}
			}
		}catch(SQLException sqe){
			System.err.println("PartnerDAO.addPartner: Threw an SQLException inserting a new partner in table.");
  	      	System.err.println(sqe.getMessage());
  	      	throw new GenericLSMException("Threw an SQLException inserting a new partner in table.		" 
					+ sqe.getMessage() , Response.Status.INTERNAL_SERVER_ERROR );
		} finally {
			try {
				pstmt.close();
				conn.close();
			} catch (Exception e) {
				System.err.println("PartnerDAO.addPartner: Threw an Exception inserting a new partner in table.");
				throw new GenericLSMException("Threw an Exception inserting a new partner in table.		" 
						+ e.getMessage() , Response.Status.INTERNAL_SERVER_ERROR );
			}
		}
		return partnerID;
	}

	/**
	 * adds an address to the database for the partner
	 * @param address 		address to insert
	 * @return   			address ID of the new address
	 */
	public int addAddress(Address address) {
		conn = DatabaseConnection.getSqlConnection();
		int addressID = 0;
		int rowsUpdated = 0;
		try{
			String insertStmt = "INSERT INTO address "
											+ "(line1, line2, line3, city, state, country, postal_code) "
								+ "VALUES "
											+ "(?,?,?,?,?,?,?)";
			pstmt = conn.prepareStatement(insertStmt);
			pstmt.setString(1, address.getLine1());
			pstmt.setString(2, address.getLine2());
			pstmt.setString(3, address.getLine3());
			pstmt.setString(4, address.getCity());
			pstmt.setString(5, address.getState());
			pstmt.setString(6, address.getCountry());
			pstmt.setString(7, address.getZip());
			rowsUpdated = pstmt.executeUpdate();
			if(0 != rowsUpdated){
				String selectQuery = "SELECT MAX(address_id) FROM address";
				pstmt = conn.prepareStatement(selectQuery);
				ResultSet resultSet = pstmt.executeQuery();
				if(resultSet.next()){
					addressID = resultSet.getInt(1);
				}
			}
		}catch(SQLException sqe){
			System.err.println("PartnerDAO.addAddress: Threw an SQLException inserting a new address in table.");
  	      	System.err.println(sqe.getMessage());
  	      	throw new GenericLSMException("Threw an SQLException inserting a new address in table.		" 
					+ sqe.getMessage() , Response.Status.INTERNAL_SERVER_ERROR );
		} finally {
			try {
				pstmt.close();
				conn.close();
			} catch (Exception e) {
				System.err.println("PartnerDAO.addAddress: Threw an Exception inserting a new address in table.");
				throw new GenericLSMException("Threw an Exception inserting a new address in table.		" 
						+ e.getMessage() , Response.Status.INTERNAL_SERVER_ERROR );
			}
		}
		return addressID;
	}

	/**
	 * SOFT delete a partner from the database (mark the partner inactive)
	 * @param partnerID 		the partner to update
	 * @return					number of rows affected
	 */
	public boolean deletePartner(int partnerID) {
		int rowsUpdated = 0;
		boolean isPartnerDeleted = false;
		conn = DatabaseConnection.getSqlConnection();
		try{
			String updateStmt = "UPDATE partner SET active = 0 WHERE partner_id = ?";
			pstmt = conn.prepareStatement(updateStmt);
			pstmt.setInt(1, partnerID);
			rowsUpdated = pstmt.executeUpdate();
			if(rowsUpdated == 1){
				isPartnerDeleted = true;
			}
		}catch(SQLException sqe){
			System.err.println("PartnerDAO.deletePartner: Threw an SQLException deleting partner from the table.");
  	      	System.err.println(sqe.getMessage());
  	      	throw new GenericLSMException("Threw an SQLException deleting partner from the table.		" 
					+ sqe.getMessage() , Response.Status.INTERNAL_SERVER_ERROR );
		} finally {
			try {
				pstmt.close();
				conn.close();
			} catch (Exception e) {
				System.err.println("PartnerDAO.deletePartner: Threw an Exception deleting partner from the table.");
				throw new GenericLSMException("Threw an Exception deleting partner from the table.		" 
						+ e.getMessage() , Response.Status.INTERNAL_SERVER_ERROR );
			}
		}
		return isPartnerDeleted;
	}

	/**
	 * Determines if a partner is active or not (deleted)
	 * @param partnerID 		the partner ID to look up
	 * @return 					true for active, else false
	 */
	public boolean getStatus(int partnerID) {
		conn = DatabaseConnection.getSqlConnection();
		boolean isPartnerActive = false;
		try{
			String getQuery = "SELECT active FROM partner WHERE partner_id = ? ";
			pstmt = conn.prepareStatement(getQuery);
			pstmt.setInt(1, partnerID);
			ResultSet resultSet = pstmt.executeQuery();
			while(resultSet.next()){
				isPartnerActive = resultSet.getBoolean("active");
			}
		}catch(SQLException sqe){
			System.err.println("PartnerDAO.getStatus: Threw an SQLException while getting partner active status.");
  	      	System.err.println(sqe.getMessage());
  	      	throw new GenericLSMException("Threw an SQLException while getting partner active status.		" 
					+ sqe.getMessage() , Response.Status.INTERNAL_SERVER_ERROR );
		} finally {
			try {
				pstmt.close();
				conn.close();
			} catch (Exception e) {
				System.err.println("PartnerDAO.getStatus: Threw an Exception while getting partner active status.");
				throw new GenericLSMException("Threw an Exception while getting partner active status.		" 
						+ e.getMessage() , Response.Status.INTERNAL_SERVER_ERROR );
			}
		}
		return isPartnerActive;
	}

	/**
	 * Builds a partner report
	 * @param partnerID 		the partner ID to look up
	 * @return 					a report with partner data
	 */
	
	public ArrayList<PartnerReport> generatePartnerReport(int partnerID) {
		conn = DatabaseConnection.getSqlConnection();
		ArrayList<PartnerReport> paReports = null;
		try{
			PartnerReport partnerReport = null;
			paReports = new ArrayList<PartnerReport>();
			String getQuery = 		"SELECT"
										+ " `order`.product_id, "
										+ " `order`.qty, product.cost, "
										+ " product.price, "
										+ " ( product.cost * `order`.qty ) AS `total_cost` , "
										+ " ( product.price * `order`.qty ) AS `total_price` , "
										+ " (( product.price * `order`.qty ) - ( product.cost * `order`.qty )) AS `total_profit` "
									+ "	FROM `order` "
									+ "	INNER JOIN product "
									+ "	ON `order`.product_id=product.product_id  AND product.partner_id = ? "
									+ "	WHERE status_id NOT IN(0) ";
			pstmt = conn.prepareStatement(getQuery);
			pstmt.setInt(1, partnerID);
			ResultSet resultSet = pstmt.executeQuery();
			while(resultSet.next()){
				partnerReport = new PartnerReportImpl();
				partnerReport.setProductId(resultSet.getInt("product_id"));
				partnerReport.setQuantity(resultSet.getInt("qty"));
				partnerReport.setCost(resultSet.getInt("cost"));
				partnerReport.setPrice(resultSet.getInt("price"));
				partnerReport.setTotalCost(resultSet.getInt("total_cost"));
				partnerReport.setTotalPrice(resultSet.getInt("total_price"));
				partnerReport.setTotalProfit(resultSet.getInt("total_profit"));
				
				paReports.add(partnerReport);
			}
		}catch(SQLException sqe){
			System.err.println("PartnerDAO.generatePartnerReport: Threw an SQLException while generating partner sales report.");
  	      	System.err.println(sqe.getMessage());
  	      	throw new GenericLSMException("Threw an SQLException while generating partner sales report.		" 
					+ sqe.getMessage() , Response.Status.INTERNAL_SERVER_ERROR );
		} finally {
			try {
				pstmt.close();
				conn.close();
			} catch (Exception e) {
				System.err.println("PartnerDAO.generatePartnerReport: Threw an Exception while generating partner sales report.");
				throw new GenericLSMException("Threw an Exception while generating partner sales report.		" 
						+ e.getMessage() , Response.Status.INTERNAL_SERVER_ERROR );
			}
		}
		return paReports;
	}
	
	/**
	 * Finds a partner by ID
	 * @param partnerID 		the partner ID to look up
	 * @return 					a representation of the partner
	 */
	
	public Partner getPartnerByID(int partnerID){
		Partner partner = null;
		conn = DatabaseConnection.getSqlConnection();
		try{
			partner = new PartnerImpl();
			String searchQuery = "SELECT * FROM `partner` WHERE partner_id = ?";
			pstmt = conn.prepareStatement(searchQuery);
			pstmt.setInt(1, partnerID);
			ResultSet resultSet = pstmt.executeQuery();
			while(resultSet.next()){
				partner.setPartnerName(resultSet.getString("name"));
				partner.setContactName(resultSet.getString("contact_name"));
				partner.setActive(resultSet.getByte("active") == 1 ? true : false);
				partner.setAddressID(resultSet.getInt("address_id"));
				partner.setEmail(resultSet.getString("email"));
				partner.setPhone(resultSet.getString("tel"));
				partner.setPartnerID(resultSet.getInt("partnerID"));
			}
		}catch(SQLException sqe){
			System.err.println("PartnerDAO.getPartnerByID: Threw an SQLException while getting Partner information.");
  	      	System.err.println(sqe.getMessage());
  	      	throw new GenericLSMException("Threw an SQLException while getting Partner information.		" 
					+ sqe.getMessage() , Response.Status.INTERNAL_SERVER_ERROR );
		} finally {
			try {
				pstmt.close();
				conn.close();
			} catch (Exception e) {
				System.err.println("PartnerDAO.getPartnerByID: Threw an Exception while getting Partner information.");
				System.err.println(e.getMessage());
				throw new GenericLSMException("Threw an Exception while getting Partner information.		" 
						+ e.getMessage() , Response.Status.INTERNAL_SERVER_ERROR );
			}
		}
		
		return partner;
	}

}
