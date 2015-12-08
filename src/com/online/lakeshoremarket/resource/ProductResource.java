package com.online.lakeshoremarket.resource;

import java.util.ArrayList;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.HeaderParam;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.online.lakeshoremarket.activity.ProductActivity;
import com.online.lakeshoremarket.exception.GenericLSMException;
import com.online.lakeshoremarket.representation.generic.GenericResponse;
import com.online.lakeshoremarket.representation.product.ProductRepresentation;
import com.online.lakeshoremarket.representation.product.ProductRequest;
import com.online.lakeshoremarket.util.LSMAuthenticator;

@Path("/")

/**
 * Provides a medium for communications between view and controller/model
 */

public class ProductResource {

	@GET
	@Produces({"application/xml" , "application/json"})
	@Path("/products/{searchString}")
	public ArrayList<ProductRepresentation> getProducts(@PathParam("searchString") String prodName, @HeaderParam("email") String email, @HeaderParam("password") String password) {
		System.out.println("GET METHOD Request for all products (Search products).............");
		boolean isUserAuthentic = false;
		isUserAuthentic = LSMAuthenticator.authenticateUser(email, password);
		if(isUserAuthentic){
			ProductActivity productActivity = new ProductActivity();
			ArrayList<ProductRepresentation> prodRepresentationSet = productActivity.getProducts(prodName);
			if(prodRepresentationSet != null && prodRepresentationSet.size() != 0){
				return prodRepresentationSet;
			}else{
				throw new GenericLSMException("No products found by such a name", Response.Status.NOT_FOUND);
			}
			
		}else{
			throw new GenericLSMException("User is not authorized", Response.Status.UNAUTHORIZED);
		}
	}
	
	@PUT
	@Consumes({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
	@Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
	@Path("/product")
	public GenericResponse createProduct(ProductRequest prodRequest, @HeaderParam("email") String email, @HeaderParam("password") String password) {
		System.out.println("PUT METHOD Request for Creating a new product .............");
		boolean isUserAuthentic = false;
		isUserAuthentic = LSMAuthenticator.authenticateUser(email, password);
		if(isUserAuthentic){
			GenericResponse genericResponse = new GenericResponse();
			ProductActivity productActivity = new ProductActivity();
			genericResponse = productActivity.createProduct(prodRequest);
			
			return genericResponse;
		}else{
			throw new GenericLSMException("User is not authorized", Response.Status.UNAUTHORIZED);
		}
	}
	
	@GET
	@Produces({"application/xml", "application/json"})
	@Path("/product/{productName}")
	public ProductRepresentation getProduct(@PathParam("productName") String prodName, @HeaderParam("email") String email, @HeaderParam("password") String password) {
		System.out.println("GET METHOD Request for individual product ............" + prodName);
		boolean isUserAuthentic = false;
		isUserAuthentic = LSMAuthenticator.authenticateUser(email, password);
		if(isUserAuthentic){
			ProductActivity productActivity = new ProductActivity();
			ProductRepresentation productRepresentation = new ProductRepresentation();
			productRepresentation = productActivity.getProduct(prodName);
			if(productRepresentation != null && productRepresentation.getProductID() != 0){
				return productRepresentation;
			}else{
				throw new GenericLSMException("Product is not found", Response.Status.NOT_FOUND);
			}
			
		}else{
			throw new GenericLSMException("User is not authorized", Response.Status.UNAUTHORIZED);
		}
	}
	
	@GET
	@Produces({"application/xml", "application/json"})
	@Path("/available/{productID}")
	public GenericResponse checkProductAvailability(@PathParam("productID") String prodID, @HeaderParam("email") String email, @HeaderParam("password") String password){
		System.out.println("GET METHOD Request for Availability of Product ............" + prodID);
		boolean isUserAuthentic = false;
		isUserAuthentic = LSMAuthenticator.authenticateUser(email, password);
		if(isUserAuthentic){
			GenericResponse genericResponse = new GenericResponse();
			ProductActivity productActivity = new ProductActivity();
			genericResponse = productActivity.checkProductAvailability(prodID);
			
			return genericResponse;
		}else{
			throw new GenericLSMException("User is not authorized", Response.Status.UNAUTHORIZED);
		}
	}
	
	@GET
	@Produces({"application/xml", "application/json"})
	@Path("/product-by-id/{productID}")
	public ProductRepresentation getProductByID(@PathParam("productID") String ProductIDString, @HeaderParam("email") String email, @HeaderParam("password") String password) {
		System.out.println("GET METHOD Request for individual product using product id............");
		boolean isUserAuthentic = false;
		isUserAuthentic = LSMAuthenticator.authenticateUser(email, password);
		if(isUserAuthentic){
			ProductActivity productActivity = new ProductActivity();
			ProductRepresentation productRepresentation = new ProductRepresentation();
			productRepresentation =  productActivity.getProductByID(ProductIDString);
			if(productRepresentation == null){
				throw new GenericLSMException("Product is not found", Response.Status.NOT_FOUND);
			}else{
				return productRepresentation;
			}
		}else{
			throw new GenericLSMException("User is not authorized", Response.Status.UNAUTHORIZED);
		}
	}
}
