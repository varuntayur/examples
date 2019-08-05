package com.tayur.examples.arquillian;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.Arrays;

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
