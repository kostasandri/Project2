package com.ergasia.rest.client;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Invocation;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.glassfish.jersey.client.authentication.HttpAuthenticationFeature;

import com.ergasia.rest.config.PropertyReader;

public class ClientRequest {

	private String ip;
	private int port;
	private String uri;
	private final Client client;
	// private HttpAuthenticationFeature feature;

	public ClientRequest() {
		this.ip = PropertyReader.getIp();
		this.port = Integer.parseInt(PropertyReader.getPort());
		uri = "http://" + ip + ":" + port + "/service/webapi/resource/";
		client = ClientBuilder.newClient();
		// feature = HttpAuthenticationFeature.basicBuilder().credentials("lazaros",
		// "sarafidis").build();
	}

	public ClientRequest(String ip, int port) {
		this.ip = ip;
		this.port = port;
		uri = "http://" + ip + ":" + port + "/service/webapi/resource/";
		client = ClientBuilder.newClient();
		HttpAuthenticationFeature.basicBuilder().credentials("lazaros", "sarafidis").build();
	}

	public void createCard(int cID) {

		// client.register(feature); // assigns credentials to client

		WebTarget target = client.target(uri + "client/" + cID + "/createCard");

		Invocation.Builder builder = target.request(MediaType.TEXT_PLAIN_TYPE);
		Response response = builder.get();
		// Response response = target.request().get();

		System.out.println(response.readEntity(String.class));
		System.out.println(response);

		/*
		 * Response response = target.request().get();
		 * 
		 * System.out.println(response.getStatus() + " status" );
		 * System.out.println(response.readEntity(String.class));
		 */
	}

	private void updateCard(int oID, int iID, String colour, int quantity) {			// orderID, itemID
		// client.register(feature); // assigns credentials to client

		WebTarget target = client.target(uri + "updateCard/{oID}/item/{iID}?colour={colour}&quantity={quantity}");

		Invocation.Builder builder = target.request(MediaType.TEXT_PLAIN_TYPE);
		Response response = builder.get();

		System.out.println(response.readEntity(String.class));
		System.out.println(response);

	}


	private void readCard(int oID) {
		WebTarget target = client.target(uri + "getCard/{oID}");

		Invocation.Builder builder = target.request(MediaType.TEXT_PLAIN_TYPE);
		Response response = builder.get();

		System.out.println(response.readEntity(String.class));
		System.out.println(response);

	}
	
	private void resetCard(int oID) {
		WebTarget target = client.target(uri + "resetCard/" + oID);

		Invocation.Builder builder = target.request(MediaType.TEXT_PLAIN_TYPE);
		Response response = builder.get();

		System.out.println(response.readEntity(String.class));
		System.out.println(response);
		
	}
	
	private void history() {
		WebTarget target = client.target(uri + "history");

		Invocation.Builder builder = target.request(MediaType.TEXT_PLAIN_TYPE);
		Response response = builder.get();

		System.out.println(response.readEntity(String.class));
		System.out.println(response);
		
	}

	public static void main(String[] args) {
		ClientRequest cr = new ClientRequest();
		for (int i = 0; i < 10; i++) {
			cr.createCard(i + 5); // iparxoun idi 5 pelates sti vasi
		}
		cr.readCard(8);
		cr.updateCard(8,2,"mauro", 3);
		cr.updateCard(8,2,"aspro", 2);
		cr.readCard(8);
		
		cr.readCard(9);
		cr.updateCard(9,1,"prasino",4);
		cr.readCard(9);
		cr.updateCard(9,1,"prasino",3);
		cr.readCard(9);
		cr.updateCard(9,1,"prasino",0);
		cr.readCard(9);
		
		cr.readCard(10);
		cr.updateCard(10,1,"prasino",1);
		cr.updateCard(10,1,"kokkino",1);
		cr.readCard(9);
		cr.resetCard(9);
		cr.readCard(9);
		
		cr.history();
		
	}
}
