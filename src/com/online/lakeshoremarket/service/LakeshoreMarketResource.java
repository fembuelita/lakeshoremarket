package com.online.lakeshoremarket.service;

import java.util.Set;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;

import com.online.lakeshoremarket.activity.LakeshoreMarketActivity;
import com.online.lakeshoremarket.representation.product.ProductRepresentation;


@Path("/lakeshoreMarketservice/")
public class LakeshoreMarketResource {

	
	@GET
	@Produces({"application/xml" , "application/json"})
	@Path("/products/{searchString}")
	public Set<ProductRepresentation> getProducts(@PathParam("searchString") String prodName) {
		System.out.println("GET METHOD Request for all products .............");
		LakeshoreMarketActivity marketActivity = new LakeshoreMarketActivity();
		return marketActivity.getProducts(prodName);	
	}
	
	//TESTING PUSH through eclipse
	
	
	
	
	
	
	
	/**
	 * Start Maggie Activity
	 */
	
	
	
	
	
	
	
	/**
	 * Start Elliott Activity
	 */
	 
	
	
}
