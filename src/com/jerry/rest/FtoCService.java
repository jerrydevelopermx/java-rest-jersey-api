package com.jerry.rest;


import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;
import org.json.JSONException;
import org.json.JSONObject;

import com.jerry.entity.User;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import com.jerry.util.*;
 
@Path("/ftocservice")
public class FtoCService {
	public PersistenceService persistence;
	
	public FtoCService() {
		persistence = new PersistenceService();
	}
 
	@GET
	@Produces("application/json")
	public Response convertFtoC() throws JSONException {
 
		JSONObject jsonObject = new JSONObject();
		Double fahrenheit = 98.24;
		Double celsius;
		celsius = (fahrenheit - 32) * 5 / 9;
		jsonObject.put("F Value", fahrenheit);
		jsonObject.put("C Value", celsius);
 
		//EntityManagerFactory factory = Persistence.createEntityManagerFactory("JAXApiTestPersistence2");
		//EntityManager entityManager = factory.createEntityManager();
		
		//entityManager.getTransaction().begin();
		 
		//TypedQuery<User> e = entityManager.createQuery("Select u from User u", User.class);
		List <User> users = persistence.getAllUsers();
		//Query nativeQuery = entityManager.createNativeQuery("SELECT * FROM user", User.class);
		//List users = nativeQuery.getResultList();
	   // return ;
		return Response.ok(users).build();
		//String result = "Is opened connection :: "+ factory.createEntityManager().isOpen();// "@Produces(\"application/json\") Output: \n\nF to C Converter Output: \n\n" + jsonObject;
		//return Response.status(200).entity(result).build();
	}
 
	@Path("{f}")
	@GET
	@Produces("application/json")
	public Response convertFtoCfromInput(@PathParam("f") float f) throws JSONException {
 
		JSONObject jsonObject = new JSONObject();
		float celsius;
		celsius = (f - 32) * 5 / 9;
		jsonObject.put("F Value", f);
		jsonObject.put("C Value", celsius);
 
		String result = "@Produces(\"application/json\") Output: \n\nF to C Converter Output: \n\n" + jsonObject;
		return Response.status(200).entity(result).build();
	}
}
