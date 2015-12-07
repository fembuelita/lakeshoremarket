package com.online.lakeshoremarket.domain;

import java.util.ArrayList;

import com.online.lakeshoremarket.dao.PartnerDAO;
import com.online.lakeshoremarket.model.customer.Address;
import com.online.lakeshoremarket.model.partner.Partner;
import com.online.lakeshoremarket.model.partnerReport.PartnerReport;

/**
 * Represents the partner domain business logic
 *
 */
public class PartnerDomain {

	PartnerDAO partnerDao = null;
	
	/**
	 * adds a partner to the db
	 * @param partner 	the partner to add
	 * @param address	the address to set for the partner
	 * @return			partner id of newly added partner
	 */
	public int addPartner(Partner partner, Address address) {
		int partnerID = 0;
		int addressID = addAddress(address);
		if(0 != addressID){
			partner.setAddressID(addressID);
			partnerDao = new PartnerDAO();
			partnerID = partnerDao.addPartner(partner);
			
		}
		return partnerID;
	}
	
	/**
	 * adds an address to the database
	 * @param address	the address to insert
	 * @return			address ID or 0 on failure
	 */
	public int addAddress(Address address){
		int addressID = 0;
		partnerDao = new PartnerDAO();
		addressID = partnerDao.addAddress(address);
		return addressID;
	}

	/**
	 * marks a partner as inactive
	 * @param partnerID 	the partner ID to update
	 * @return				true on success, else false
	 */
	public boolean deletePartner(int partnerID) {
		boolean isPartnerDeleted = false ;
		partnerDao = new PartnerDAO();
		isPartnerDeleted = partnerDao.deletePartner(partnerID);
		return isPartnerDeleted;
	}

	/**
	 * determines if a partner is active or not
	 * @param partnerID 	the partner to look up
	 * @return				true if active, else false
	 */
	public boolean getStatus(int partnerID) {
		boolean isPartnerActive = false;
		partnerDao = new PartnerDAO();
		isPartnerActive = partnerDao.getStatus(partnerID);
		return isPartnerActive;
	}

	public boolean notifySales(int partnerID) {
		//This method is left unimplemented intentionally. It will accommodate notification to the partner through an email
		return true;
	}

	/**
	 * builds a partner report
	 * @param partnerID 	the partner to look up
	 * @return				a report with partner information
	 */
	
	public ArrayList<PartnerReport> generatePartnerReport(int partnerID) {
		ArrayList<PartnerReport> partnerReport = new ArrayList<PartnerReport>();
		partnerDao = new PartnerDAO();
		partnerReport = partnerDao.generatePartnerReport(partnerID);
		/*System.out.println("product_id		qty		cost		price		total_cost		total_price		total_profit		Grand Total");
		
		
		
		for (PartnerReport temp : partnerReport) {
			System.out.println(temp.getProductId()+"			"
					+temp.getQuantity()+"		"
					+temp.getCost()+"		"
					+temp.getPrice()+"		"
					+temp.getTotalCost()+"			"
					+temp.getTotalPrice()+"			"
					+temp.getTotalProfit()+"		");
		}*/
		
		return partnerReport;
		
	}
	
	/**
	 * Gets partner by ID
	 * @param partnerID 	the partner to look up
	 * @return				the partner representation from the db
	 */
	
	public Partner getPartnerByID(int partnerID){
		partnerDao = new PartnerDAO();
		return partnerDao.getPartnerByID(partnerID);
		
	}
}
