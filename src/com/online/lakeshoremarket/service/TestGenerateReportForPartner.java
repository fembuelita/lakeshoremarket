package com.online.lakeshoremarket.service;

import com.online.lakeshoremarket.domain.PartnerDomain;

public class TestGenerateReportForPartner {

	public static void main(String[] args) {

		PartnerDomain partnerDomain = new PartnerDomain();
		int partnerID = 1;
		partnerDomain.generatePartnerReport(partnerID);
	}

}
