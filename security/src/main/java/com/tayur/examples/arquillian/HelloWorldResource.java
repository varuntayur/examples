package com.tayur.examples.arquillian;

import java.util.Arrays;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("api/world")
public class HelloWorldResource {

	@GET
	@Path("continents")
	public Response getContinents() {
		return Response
				.ok(Arrays.asList("Asia", "Europe", "North America", "South America"), MediaType.APPLICATION_JSON)
				.build();
	}

}
