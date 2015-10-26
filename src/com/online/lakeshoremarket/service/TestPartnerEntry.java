package com.online.lakeshoremarket.service;

import com.online.lakeshoremarket.domain.PartnerDomain;
import com.online.lakeshoremarket.model.customer.Address;
import com.online.lakeshoremarket.model.customer.AddressImpl;
import com.online.lakeshoremarket.model.partner.Partner;
import com.online.lakeshoremarket.model.partner.PartnerImpl;

public class TestPartnerEntry {

	public static void main(String[] args) {

		PartnerDomain partnerDomain = new PartnerDomain();
		
		Address partnerAddress = new AddressImpl();
		partnerAddress.setLine1("7784");
		partnerAddress.setLine2("W Arthur Ave");
		partnerAddress.setLine3("Apt 1");
		partnerAddress.setCity("Chicago");
		partnerAddress.setState("Illinois");
		partnerAddress.setCountry("USA");
		partnerAddress.setZip("60645");
		
		Partner partner = new PartnerImpl();
		partner.setActive(true);
		partner.setContactName("The Boss");
		partner.setEmail("boss_awesome@ymail.com");
		partner.setPartnerName("The Best Seller");
		partner.setPassword("obviousPassword1234");
		partner.setPhone("9119119110");
		
		int rowsUpdated = 0;

		rowsUpdated = partnerDomain.addPartner(partner, partnerAddress);
		
		if(rowsUpdated != 0){
			System.out.println("Partner added in the system");
		}else{
			System.out.println("Partner NOT added in the system");
		}
		
	}

}
