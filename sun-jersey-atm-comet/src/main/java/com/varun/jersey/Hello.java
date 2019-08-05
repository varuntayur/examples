package com.varun.jersey;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("hello")
public class Hello {

	@GET
	@Path("{name}")
	@Produces(MediaType.TEXT_PLAIN)
	public String getMsg(@PathParam("name") String msg) {

		String output = "Jersey says : " + msg;

		return output;

	}

}