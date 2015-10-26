package com.online.lakeshoremarket.service;

import com.online.lakeshoremarket.domain.PartnerDomain;

public class TestNotifySales {

	public static void main(String[] args) {

		PartnerDomain partnerDomain = new PartnerDomain();
		boolean isPartnerNorified = false ;
		int partnerID = 1;
		isPartnerNorified = partnerDomain.notifySales(partnerID);
		if(isPartnerNorified){
			System.out.println("Partner is notified");
		}else{
			System.out.println("Partner is NOT notified");
		}
	}

}
