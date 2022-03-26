package net.codejava.ws;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("src")
public class HelloResource {
	
	@Path("/hi")
	@GET
	public String Hello() {
		return "Hello Son";
	}
	
	@Path("/json")
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public String sayJsonHello() {
	    return "{\"name\":\"greeting\", \"message\":\"Bonjour tout le monde!\"}";
	}
}
