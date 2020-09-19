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

	public ClientRequest() {
		this.ip = PropertyReader.getIp();
		this.port = Integer.parseInt(PropertyReader.getPort());
		uri = "http://" + ip + ":" + port + "/server/webapi/resource/";
		System.out.println("stelnw req edw: " + uri);
	}

	public ClientRequest(String ip, int port) {
		this.ip = ip;
		this.port = port;
		uri = "http://" + ip + ":" + port + "/server/webapi/resource/";
		System.out.println("stelnw req edw: " + uri);
	}

	public void testRequest() {
		HttpAuthenticationFeature feature = HttpAuthenticationFeature.basicBuilder().credentials("lazaros", "sarafidis").build();
		System.out.println("piga mexri edw 1");
		
		
		final Client client = ClientBuilder.newClient();
		client.register(feature);
		System.out.println("piga mexri edw 2");
		
		
		WebTarget target = client.target(uri+"status");
		System.out.println("piga mexri edw 3");
		
		Invocation.Builder builder = target.request(MediaType.TEXT_PLAIN_TYPE);
		Response response = builder.get();
		//Response response = target.request().get();
		System.out.println("piga mexri edw 4");
		
		
		System.out.println(response.readEntity(String.class));
		System.out.println(response);

		/*
		 * Response response = target.request().get();
		 * 
		 * System.out.println(response.getStatus() + " status" );
		 * System.out.println(response.readEntity(String.class));
		 */
	}

	public static void main(String[] args) {
		ClientRequest cr = new ClientRequest();
		cr.testRequest();

	}

}
