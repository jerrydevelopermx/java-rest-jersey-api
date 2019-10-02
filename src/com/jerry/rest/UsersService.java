package com.jerry.rest;

import java.net.URISyntaxException;
import java.util.List;

import javax.ejb.EJB;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriBuilder;
import javax.ws.rs.core.UriInfo;

import org.json.JSONException;

import com.jerry.entity.User;
import com.jerry.util.PersistenceService;

@Path("/users")
public class UsersService {
	
	@EJB
	public PersistenceService persistence;

	@GET
	@Produces("application/json")
	public Response getUsers() throws JSONException {
		List <User> users = persistence.getAllUsers();
		return Response.ok(users).build();
	}
	
	@Path("{id}")
	@GET
	@Produces("application/json")
	public Response getUser(@PathParam("id") int id) throws JSONException {
		User user = persistence.getUserById(id);
		return Response.ok(user).build();
	}
	
	@Path("{id}")
	@PUT
	@Consumes(MediaType.APPLICATION_JSON)
	public Response updateUser(User user, @PathParam("id") int id) {
		user.setUserId(id);
		persistence.updateUser(user);
		return Response.ok(user).build();
	}
	
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	public Response addUser(User user, @Context UriInfo uriInfo) throws URISyntaxException {		
		persistence.addUser(user);
		UriBuilder builder = uriInfo.getAbsolutePathBuilder();
		builder.path(String.valueOf(user.getUserId()));
		return Response.created(builder.build()).build();
	}
	
	@DELETE
	@Path("{id}")
	public Response deleteUser(@PathParam("id") int id) {
		int userId = persistence.deleteUser(id);		
		return Response.ok(userId).build();
	}
}
