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

/**
 * Root resource (exposed at "myresource" path)
 */
//@RolesAllowed("admin")
@Path("/resource")
public class MyResource {

	Logger logger = LogManager.getLogger(MyResource.class);
	List<Card> cards = new ArrayList<Card>();
	@QueryParam("query")
	private String queryParamExample;

	@GET
	@Path("/createCard")
	@Singleton
	public Response createCard(@QueryParam("client") int client) {
		System.out.println("Client "+ client);
		Card c = new Card(client);
		c.addProduct(65, "kokkino");
		cards.add(c);
		return Response.ok("Card created with ID: " + c.getOrderID() + "!").build();
	}
	
	@GET
	@Path("/getCard/{id}")
	@Produces(MediaType.APPLICATION_XML)
	public Card getit(@PathParam("id") int oID) {
		
		return cards.get(oID);
	}

	@GET
	@Path("/updateCard")
	public Response getDBStatus() throws Exception {

		MyRepo mr = new MyRepo();
		ArrayList<String> answer = mr.fetchData();
		for (String dd : answer) {
			System.out.println(dd);
		}
		return Response.ok(answer.get(0) + " +++ " + answer.get(1)).build();
	}
}
