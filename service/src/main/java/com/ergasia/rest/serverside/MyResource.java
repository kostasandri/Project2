package com.ergasia.rest.serverside;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Singleton;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.ergasia.rest.data.Card;
import com.ergasia.rest.data.TempStore;

/**
 * Root resource (exposed at "myresource" path)
 */
//@RolesAllowed("admin")
@Path("/resource")
public class MyResource {

	Logger logger = LogManager.getLogger(MyResource.class);

	@GET
	@Path("client/{cid}/createCard")
	public Response createCard(@PathParam("cID") int cID) {
		int totalCardsInDB = MyRepo.getOrdersTotalRows() + 1;
		Card.setTotalCards(totalCardsInDB++);
		Card c = new Card(cID, totalCardsInDB);
		TempStore.addCard(c);
		return Response.ok("Card created with ID: " + c.getOrderID() + "!").build();
	}
	
	@GET
	@Path("/getCard/{id}")
	@Produces(MediaType.APPLICATION_XML)
	public Card getit(@PathParam("id") int oID) {
		System.out.println("Order ID is "+ oID);
		return TempStore.getCard(oID);
	}

	@GET
	@Path("/updateCard/{oID}/item/{iID}")
	public Response updateCard(@PathParam("iID") int iID, @PathParam("oID") int oID, @QueryParam("colour") String colour, @QueryParam("quantity") int quantity) throws Exception {

		Card c = TempStore.getCard(oID);
		c.addProduct(iID, colour, quantity);

		return Response.ok("Product with item ID " + iID + " added.").build();
	}
}
