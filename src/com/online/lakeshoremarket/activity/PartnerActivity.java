package com.online.lakeshoremarket.activity;

import java.util.ArrayList;

import com.online.lakeshoremarket.domain.PartnerDomain;
import com.online.lakeshoremarket.model.customer.Address;
import com.online.lakeshoremarket.model.customer.AddressImpl;
import com.online.lakeshoremarket.model.partner.Partner;
import com.online.lakeshoremarket.model.partner.PartnerImpl;
import com.online.lakeshoremarket.model.partnerReport.PartnerReport;
import com.online.lakeshoremarket.representation.partner.PartnerRepresentation;
import com.online.lakeshoremarket.representation.partner.PartnerRequest;
import com.online.lakeshoremarket.representation.partnerReport.PartnerReportRepresentation;

public class PartnerActivity {

	public boolean createPartner(PartnerRequest partnerRequest) {
		boolean isPartnerCreated = false;
		int rowsUpdated = 0;
		PartnerDomain partnerDomain = new PartnerDomain();
		Partner partner = new PartnerImpl();
		Address partnerAddress = new AddressImpl();
		
		partnerAddress.setLine1(partnerRequest.getLine1());
		partnerAddress.setLine2(partnerRequest.getLine2());
		partnerAddress.setLine3(partnerRequest.getLine3());
		partnerAddress.setCity(partnerRequest.getCity());
		partnerAddress.setState(partnerRequest.getState());
		partnerAddress.setCountry(partnerRequest.getCountry());
		partnerAddress.setZip(partnerRequest.getZip());
		
		partner.setActive(partnerRequest.isActive());
		partner.setContactName(partnerRequest.getContactName());
		partner.setEmail(partnerRequest.getEmail());
		partner.setPartnerName(partnerRequest.getPartnerName());
		partner.setPassword(partnerRequest.getPassword());
		partner.setPhone(partnerRequest.getPhone());
		
		rowsUpdated = partnerDomain.addPartner(partner, partnerAddress);
		
		if(rowsUpdated != 0){
			isPartnerCreated = true;
		}
		
		return isPartnerCreated;
	}
	
	public boolean deletePartner(String partnerIDString) {
		boolean isPartnerDeleted = false;
		PartnerDomain partnerDomain = new PartnerDomain();
		isPartnerDeleted = partnerDomain.deletePartner(Integer.parseInt(partnerIDString));
		
		return isPartnerDeleted;
	}
	
	public PartnerRepresentation getPartnerDetails(String partnerIDString){
		PartnerDomain partnerDomain = new PartnerDomain();
		Partner partner = new PartnerImpl();
		partner = partnerDomain.getPartnerByID(Integer.parseInt(partnerIDString)); 
		PartnerRepresentation partnerRepresentation = new PartnerRepresentation();
		partnerRepresentation.setActive(partner.isActive()); //is this correct?
		partnerRepresentation.setPartnerName(partner.getPartnerName());
		partnerRepresentation.setContactName(partner.getContactName());
		partnerRepresentation.setAddressID(partner.getAddressID());
		partnerRepresentation.setPartnerID(partner.getPartnerID());
		partnerRepresentation.setEmail(partner.getEmail());
		partnerRepresentation.setPhone(partner.getPhone());
		
		return partnerRepresentation;
	}
	
	/**
	 * gets a report representation for a specific partner
	 * @param partnerID
	 * @return
	 */
	public ArrayList<PartnerReportRepresentation> getPartnerReport( int partnerID ) {
		PartnerDomain partnerDomain = new PartnerDomain();
		ArrayList<PartnerReport> report = partnerDomain.generatePartnerReport( partnerID );
		ArrayList<PartnerReportRepresentation> reports = new ArrayList<PartnerReportRepresentation>();
		
		int size = report.size();
		for(int i=0; i< size; i++){
			PartnerReportRepresentation partnerReport = new PartnerReportRepresentation();
			partnerReport.setProductId( report.get(i).getProductId() );
			partnerReport.setQuantity( report.get(i).getQuantity() );
			partnerReport.setCost( report.get(i).getCost() );
			partnerReport.setPrice( report.get(i).getPrice() );
			partnerReport.setTotalCost( report.get(i).getTotalCost() );
			partnerReport.setTotalPrice( report.get(i).getTotalPrice() );
			partnerReport.setTotalProfit( report.get(i).getTotalProfit() );
			
			reports.add(partnerReport);
		}		
		

		return reports;
	}
}
