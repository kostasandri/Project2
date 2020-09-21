package com.ergasia.rest.serverside;

import java.util.ArrayList;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 * Root resource (exposed at "myresource" path)
 */
//@RolesAllowed("admin")
@Path("/resource")
public class MyResource {

	Logger logger = LogManager.getLogger(MyResource.class);

	@QueryParam("query")
	private String queryParamExample;

	@GET
	@Path("/createCard")
	@Consumes(MediaType.TEXT_PLAIN)
	@Produces(MediaType.TEXT_PLAIN)
	public Response getit() {
		if(logger.isDebugEnabled()) {
			logger.debug("if debug");
		}
		logger.info("info");
		return Response.ok("got it").build();
	}

	@GET
	@Path("/updateCard")
	public Response getDBStatus() throws Exception {
		
		MyRepo mr = new MyRepo();
		ArrayList<String> answer = mr.fetchData();
		for (String dd : answer) {
			System.out.println(dd);
		}
		return Response.ok(answer.get(0) + " ++ " +answer.get(1)).build();
	}
}
