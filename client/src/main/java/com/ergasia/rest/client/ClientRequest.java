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
	private HttpAuthenticationFeature feature; 

	public ClientRequest() {
		this.ip = PropertyReader.getIp();
		this.port = Integer.parseInt(PropertyReader.getPort());
		uri = "http://" + ip + ":" + port + "/server/webapi/resource/";
		client = ClientBuilder.newClient();
		 feature = HttpAuthenticationFeature.basicBuilder().credentials("lazaros", "sarafidis").build();
	}

	public ClientRequest(String ip, int port) {
		this.ip = ip;
		this.port = port;
		uri = "http://" + ip + ":" + port + "/server/webapi/resource/";
		client = ClientBuilder.newClient();
		HttpAuthenticationFeature.basicBuilder().credentials("lazaros", "sarafidis").build();
	}

	public void createCard() {
		
		client.register(feature); // assigns credentials to client
		
		WebTarget target = client.target(uri+"status");
		
		Invocation.Builder builder = target.request(MediaType.TEXT_PLAIN_TYPE);
		Response response = builder.get();
		//Response response = target.request().get();		
		
		System.out.println(response.readEntity(String.class));
		System.out.println(response);

		/*
		 * Response response = target.request().get();
		 * 
		 * System.out.println(response.getStatus() + " status" );
		 * System.out.println(response.readEntity(String.class));
		 */
	}
	
	private void updateCard() {
		client.register(feature); // assigns credentials to client
		
		WebTarget target = client.target(uri+"getResp");
		
		Invocation.Builder builder = target.request(MediaType.TEXT_PLAIN_TYPE);
		Response response = builder.get();	
		
		System.out.println(response.readEntity(String.class));
		System.out.println(response);
		
	}

	private void deleteCard() {
		// TODO Auto-generated method stub
		
	}

	private void readCard() {
		// TODO Auto-generated method stub
		
	}

	public static void main(String[] args) {
		ClientRequest cr = new ClientRequest();
		cr.createCard();
		cr.readCard();
		//cr.deleteCard();
		//cr.updateCard();

	}
}
