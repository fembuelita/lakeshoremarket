package com.online.lakeshoremarket.service;

import com.online.lakeshoremarket.domain.PartnerDomain;

public class TestDeletePartner {

	public static void main(String[] args) {

		int partnerID = 2;
		boolean isPartnerDeleted = false;
		PartnerDomain partnerDomain = new PartnerDomain();
		isPartnerDeleted = partnerDomain.deletePartner(partnerID);
		if(isPartnerDeleted){
			System.out.println("Partner is successfully deleted from the system");
		}else{
			System.out.println("Partner is NOT deleted from the system");
		}
	}

}
