package com.online.lakeshoremarket.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;

import com.online.lakeshoremarket.model.review.Review;
import com.online.lakeshoremarket.model.review.ReviewImpl;
import com.online.lakeshoremarket.util.DatabaseConnection;

/**
 * Represents the review data access object
 * interacts with the database object
 */
public class ReviewDAO {

	Connection conn = null;
	PreparedStatement pstmt = null;
	
	/**
	 * adds a review of a partner by a customer
	 * @param review		the review to insert
	 * @return				true if inserted OK, false else
	 */
	public boolean addPartnerReview(Review review) {
		conn = DatabaseConnection.getSqlConnection();
		int rowsUpdated = 0;
		try{
			String insertStmt = "INSERT INTO partner_review "
											+ "(partner_id, customer_id, rating, review, review_date) "
								+ "VALUES "
											+ "(?,?,?,?,?)";
			pstmt = conn.prepareStatement(insertStmt);
			pstmt.setInt(1, review.getPartnerID());
			pstmt.setInt(2, review.getCustomerID());
			pstmt.setInt(3, review.getRating());
			pstmt.setString(4, review.getReview());
			pstmt.setTimestamp(5, review.getReviewDate());
			rowsUpdated = pstmt.executeUpdate();
		}catch(SQLException sqe){
			System.err.println("ReviewDAO.addPartnerReview: Threw a SQLException inserting a new partner review in table.");
  	      	System.err.println(sqe.getMessage());
		} finally {
			try {
				pstmt.close();
				conn.close();
			} catch (Exception e) {
				System.err.println("ReviewDAO.addPartnerReview: Threw an Exception inserting a new partner review in table.");
			}
		}
		return (rowsUpdated == 0) ? false : true ;
	}

	/**
	 * inserts a review of a product by a customer
	 * @param review 		the review to insert
	 * @return				true for inserted OK, false else
	 */
	public boolean addProductReview(Review review) {
		conn = DatabaseConnection.getSqlConnection();
		int rowsUpdated = 0;
		try{
			String insertStmt = "INSERT INTO product_review "
											+ "(product_id, customer_id, rating, review, review_date) "
								+ "VALUES "
											+ "(?,?,?,?,?)";
			pstmt = conn.prepareStatement(insertStmt);
			pstmt.setInt(1, review.getProductID());
			pstmt.setInt(2, review.getCustomerID());
			pstmt.setInt(3, review.getRating());
			pstmt.setString(4, review.getReview());
			pstmt.setTimestamp(5, review.getReviewDate());
			rowsUpdated = pstmt.executeUpdate();
		}catch(SQLException sqe){
			System.err.println("ReviewDAO.addProductReview: Threw a SQLException inserting a new product review in table.");
  	      	System.err.println(sqe.getMessage());
		} finally {
			try {
				pstmt.close();
				conn.close();
			} catch (Exception e) {
				System.err.println("ReviewDAO.addProductReview: Threw an Exception inserting a new product review in table.");
			}
		}
		return (rowsUpdated == 0) ? false : true ;
	}
	
	/**
	 * gets a partner review
	 * @param reviewID
	 * @return
	 */
	public Review getPartnerReviewByID( int reviewID ) {
		conn = DatabaseConnection.getSqlConnection();
		Review rev = new ReviewImpl();
		try{
			String insertStmt = "SELECT FROM partner_review WHERE `partner_review_id`=" + "(?) LIMIT 1";
			pstmt = conn.prepareStatement(insertStmt);
			pstmt.setInt( 1, reviewID );
			
			//iterate over the results
			ResultSet resultSet = pstmt.executeQuery();
			while(resultSet.next()){
				rev.setCustomerID( resultSet.getInt( "customer_id" ) );
				rev.setPartnerID( resultSet.getInt( "partner_id" ) );
				rev.setPartnerReviewID( resultSet.getInt( "partner_review_id" ) );
				rev.setRating( resultSet.getInt( "rating" ) );
				rev.setReview( resultSet.getString( "review" ) );
				rev.setReviewDate( resultSet.getTimestamp( "review_date" ) );
			}
			
		}catch(SQLException sqe){
			System.err.println("ReviewDAO.getPartnerReviewByID: Threw a SQLException getting partner review from table.");
  	      	System.err.println(sqe.getMessage());
		} finally {
			try {
				pstmt.close();
				conn.close();
			} catch (Exception e) {
				System.err.println("ReviewDAO.getPartnerReviewByID: Threw a SQLException getting partner review from table.");
			}
		}
		
		return rev;
	}

	
	/**
	 * gets a product review 
	 * @param reviewID
	 * @return
	 */
	public Review getProductReviewByID( int reviewID ) {
		conn = DatabaseConnection.getSqlConnection();
		Review rev = new ReviewImpl();
		try{
			String insertStmt = "SELECT FROM product_review WHERE `product_review_id`=" + "(?) LIMIT 1";
			pstmt = conn.prepareStatement(insertStmt);
			pstmt.setInt( 1, reviewID );
			
			//iterate over the results
			ResultSet resultSet = pstmt.executeQuery();
			while(resultSet.next()){
				rev.setCustomerID( resultSet.getInt( "customer_id" ) );
				rev.setProductID( resultSet.getInt( "product_id" ) );
				rev.setProductReviewID( resultSet.getInt( "product_review_id" ) );
				rev.setRating( resultSet.getInt( "rating" ) );
				rev.setReview( resultSet.getString( "review" ) );
				rev.setReviewDate( resultSet.getTimestamp( "review_date" ) );
			}
			
		}catch(SQLException sqe){
			System.err.println("ReviewDAO.getPartnerReviewByID: Threw a SQLException getting partner review from table.");
  	      	System.err.println(sqe.getMessage());
		} finally {
			try {
				pstmt.close();
				conn.close();
			} catch (Exception e) {
				System.err.println("ReviewDAO.getPartnerReviewByID: Threw a SQLException getting partner review from table.");
			}
		}
		
		return rev;
	}
}
