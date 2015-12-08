package com.online.lakeshoremarket.resource;

import javax.ws.rs.Consumes;
import javax.ws.rs.HeaderParam;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.online.lakeshoremarket.activity.PaymentActivity;
import com.online.lakeshoremarket.exception.GenericLSMException;
import com.online.lakeshoremarket.representation.generic.GenericResponse;
import com.online.lakeshoremarket.representation.generic.Link;
import com.online.lakeshoremarket.representation.order.OrderRequest;
import com.online.lakeshoremarket.util.Constant;
import com.online.lakeshoremarket.util.LSMAuthenticator;

@Path("/")

/**
 * Provides a medium for communications between view and controller/model
 */

public class PaymentResource {

	@PUT
	@Consumes({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
	@Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
	@Path("/order")
	public GenericResponse buyProduct(OrderRequest orderRequest, @HeaderParam("email") String email, @HeaderParam("password") String password) {
		System.out.println("PUT METHOD Request for placing an order.............");
		boolean isUserAuthentic = false;
		isUserAuthentic = LSMAuthenticator.authenticateUser(email, password);
		if(isUserAuthentic){
			GenericResponse genericResponse = new GenericResponse();
			int orderID = 0;
			PaymentActivity paymentActivity = new PaymentActivity();
			orderID = paymentActivity.buyProduct(orderRequest);
			if(0 != orderID){
				genericResponse.setMessage("Order is created");
				genericResponse.setSuccess(true);
				genericResponse.setGenericReturnValue(orderID+"");
				Link get = new Link("Get Order Detail", Constant.LSM_COMMON_URL + "/order/" + orderID, "application/xml");
				Link cancel = new Link("Cancel Order", Constant.LSM_COMMON_URL + "/order/" + orderID, "application/xml");
				Link ship = new Link("Ship order", Constant.LSM_COMMON_URL + "/order/ship", "application/xml");
				genericResponse.setLinks(get,cancel,ship);
				
			}else{
				genericResponse.setMessage("Order is not created");
				genericResponse.setSuccess(false);
			}
			
			return genericResponse;
		}else{
			throw new GenericLSMException("User is not authorized", Response.Status.UNAUTHORIZED);
		}
	}
}
