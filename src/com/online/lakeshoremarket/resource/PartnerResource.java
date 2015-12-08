package com.online.lakeshoremarket.resource;

import java.util.ArrayList;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.HeaderParam;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.online.lakeshoremarket.activity.PartnerActivity;
import com.online.lakeshoremarket.exception.GenericLSMException;
import com.online.lakeshoremarket.representation.generic.GenericResponse;
import com.online.lakeshoremarket.representation.generic.Link;
import com.online.lakeshoremarket.representation.partner.PartnerRepresentation;
import com.online.lakeshoremarket.representation.partner.PartnerRequest;
import com.online.lakeshoremarket.representation.partnerReport.PartnerReportRepresentation;
import com.online.lakeshoremarket.util.Constant;
import com.online.lakeshoremarket.util.LSMAuthenticator;

@Path("/")

/**
 * Provides a medium for communications between view and controller/model
 */

public class PartnerResource {

	/**
	 * PUT method request for creating a new partner
	 * @param partnerRequest
	 * @param email
	 * @param password
	 * @return genericReponse (if successful); else, exception message
	 */
	
	@PUT
	@Consumes({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
	@Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
	@Path("/partner")
	public GenericResponse createPartner(PartnerRequest partnerRequest, @HeaderParam("email") String email, @HeaderParam("password") String password) {
		System.out.println("PUT METHOD Request for Creating a new partner .............");
		// If requiring authorization to create a user, uncomment the following lines
		boolean isUserAuthentic = true;
//		boolean isUserAuthentic = false;
//		isUserAuthentic = LSMAuthenticator.authenticateUser(email, password);
		if(isUserAuthentic){
			GenericResponse genericResponse = new GenericResponse();
			PartnerActivity partnerActivity = new PartnerActivity();
			genericResponse = partnerActivity.createPartner(partnerRequest);
			return genericResponse;
		}else{
			throw new GenericLSMException("User is not authorized", Response.Status.UNAUTHORIZED);
		}
	}
	
	/**
	 * GET method request for partner details
	 * @param partnerIDString
	 * @param email
	 * @param password
	 * @return partnerRepresentation (if successful); else, exception message
	 */
	
	@GET
	@Produces({"application/xml", "application/json"})
	@Path("/partner/{partnerID}")
	public PartnerRepresentation getPartnerDetails(@PathParam("partnerID") String partnerIDString, @HeaderParam("email") String email, @HeaderParam("password") String password){
		System.out.println("GET METHOD Request for Partner details............." + partnerIDString);
		boolean isUserAuthentic = false;
		isUserAuthentic = LSMAuthenticator.authenticateUser(email, password);
		if(isUserAuthentic){
			PartnerActivity partnerActivity = new PartnerActivity();
			PartnerRepresentation partnerRepresentation = new PartnerRepresentation();
			partnerRepresentation = partnerActivity.getPartnerDetails(partnerIDString);
			
			Link deletePartner = new Link("Delete Partner", Constant.LSM_COMMON_URL + "/partner/" + partnerIDString, "application/xml");
			Link generateReport = new Link("Generate Report", Constant.LSM_COMMON_URL + "/report/" + partnerIDString, "application/xml");
			partnerRepresentation.setLinks(deletePartner, generateReport);
			
			return partnerRepresentation;
		}else{
			throw new GenericLSMException("User is not authorized", Response.Status.UNAUTHORIZED);
		}
	}
	
	/**
	 * DELETE method request for deleting a partner
	 * @param partnerIDString
	 * @param email
	 * @param password
	 * @return genericResponse (if successful); else, exception message
	 */
	
	@DELETE
	@Produces({"application/xml" , "application/json"})
	@Path("/partner/{partnerIDString}")
	public GenericResponse deletePartner(@PathParam("partnerIDString") String partnerIDString, @HeaderParam("email") String email, @HeaderParam("password") String password){
		System.out.println("DELETE METHOD Request for Deleting a Partner ............." + partnerIDString);
		boolean isUserAuthentic = false;
		isUserAuthentic = LSMAuthenticator.authenticateUser(email, password);
		if(isUserAuthentic){
			boolean isPartnerDeleted = false;
			PartnerActivity partnerActivity = new PartnerActivity();
			isPartnerDeleted = partnerActivity.deletePartner(partnerIDString);
			GenericResponse genericResponse = new GenericResponse();
			if(isPartnerDeleted){
				genericResponse.setMessage("Partner has been deleted");
				genericResponse.setSuccess(true);
			}else{
				genericResponse.setMessage("Partner was not deleted");
				genericResponse.setSuccess(false);
			}		
			return genericResponse;
		}else{
			throw new GenericLSMException("User is not authorized", Response.Status.UNAUTHORIZED);
		}
		
	}
	
	/**
	 * GET method request for partner report
	 * @param partnerID
	 * @param email
	 * @param password
	 * @return partner report (if successful); else, return exception message
	 */
	
	@GET
	@Produces({"application/xml", "application/json"})
	@Path("/report/{partnerID}")
	public ArrayList<PartnerReportRepresentation> getPartnerReport(@PathParam("partnerID") int partnerID, @HeaderParam("email") String email, @HeaderParam("password") String password) {
		System.out.println("GET METHOD Request for partner report............" + partnerID);
		boolean isUserAuthentic = false;
		isUserAuthentic = LSMAuthenticator.authenticateUser(email, password);
		if(isUserAuthentic){
			PartnerActivity partnerActivity = new PartnerActivity();
			return partnerActivity.getPartnerReport( partnerID );
		}else{
			throw new GenericLSMException("User is not authorized", Response.Status.UNAUTHORIZED);
		}
	}
}
