package com.online.lakeshoremarket.resource;

import javax.ws.rs.Consumes;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.online.lakeshoremarket.activity.PaymentActivity;
import com.online.lakeshoremarket.representation.generic.GenericResponse;
import com.online.lakeshoremarket.representation.order.OrderRequest;

@Path("/")
public class PaymentResource {

	@PUT
	@Consumes({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
	@Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
	@Path("/order")
	public GenericResponse buyProduct(OrderRequest orderRequest) {
		System.out.println("PUT METHOD Request for placing an order.............");
		GenericResponse genericResponse = new GenericResponse();
		int orderID = 0;
		PaymentActivity paymentActivity = new PaymentActivity();
		orderID = paymentActivity.buyProduct(orderRequest);
		if(0 != orderID){
			genericResponse.setMessage("Order is created");
			genericResponse.setSuccess(true);
			genericResponse.setGenericReturnValue(orderID+"");
		}else{
			genericResponse.setMessage("Order is not created");
			genericResponse.setSuccess(false);
		}
		
		return genericResponse;	
	}
}
