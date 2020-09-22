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
import com.ergasia.rest.data.Product;
import com.ergasia.rest.data.TempStore;

/**
 * Root resource (exposed at "myresource" path)
 */
//@RolesAllowed("admin")
@Path("/resource")
public class MyResource {

	Logger logger = LogManager.getLogger(MyResource.class);

	@GET
	@Path("client/{cID}/createCard")
	public Response createCard(@PathParam("cID") int cID) {
		Card c = new Card(cID);
		TempStore.addCard(c);
		return Response.ok("Card created with ID: " + c.getOrderID() + "!").build();
	}

	@GET
	@Path("/getCard/{id}")
	@Produces(MediaType.APPLICATION_XML)
	public Card getit(@PathParam("id") int oID) {
		System.out.println("Order ID is " + oID);
		return TempStore.getCard(oID);
	}

	@GET
	@Path("/updateCard/{oID}/item/{iID}")
	public Response updateCard(@PathParam("iID") int iID, @PathParam("oID") int oID,
			@QueryParam("colour") String colour, @QueryParam("quantity") int quantity) throws Exception {

		if(logger.isDebugEnabled()) {
			logger.debug("Order id " +oID+ ", itemID "+ iID+ ", colour " +colour+ ", quantity " + quantity);
		}
		
		int flag = 0; // flag gia to ean iparxei i oxi to proion

		Card c = TempStore.getCard(oID);
		for (Product p : c.getProducts()) {
			if (p.getItemID() == iID && p.getColour().equals(colour)) { // ean to proion iparxei idi stin karta.
																		// iparxei simainei na einai idios kwdikos kai
																		// idio xrwma
				if (quantity == 0) {
					c.removeProduct(iID,colour);
					flag = 1;
					break;
				} else {
					p.setQuantity(quantity);
					MyRepo.updateItemQuantity(quantity, iID, colour);
					flag = 1;
					break;
				}				
			}
		}

		if (flag == 0) {
			c.addProduct(iID, colour, quantity);
		}

		return Response.ok("Product with item ID " + iID + " updated.").build();
	}
}
