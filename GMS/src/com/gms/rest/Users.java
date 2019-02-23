package com.gms.rest;

import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("/users")
public class Users {
	
	static <T> Response getOkResponse(T obj) {
		return Response.ok().entity(obj).build();
	}
	
	@GET
	@Produces(MediaType.TEXT_PLAIN)
	public Response getAllUsers(){
		List<String> listName = new ArrayList<String>();
		listName.add("Salman");
		listName.add("Aliyan");
		listName.add("Nouman");
		listName.add("Imran");
		
		
		return getOkResponse(listName);
	}

}
