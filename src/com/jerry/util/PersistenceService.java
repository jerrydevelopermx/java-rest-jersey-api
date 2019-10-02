package com.jerry.util;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateful;
import javax.ejb.Stateless;
//import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceContextType;
import javax.persistence.TypedQuery;

import com.jerry.entity.User;

@Stateless
public class PersistenceService {
	
	@PersistenceContext(unitName = "JAXApiTestPersistence2")
	EntityManager entityManager;
	
	
	public PersistenceService(){		
	}
	
	public List <User> getAllUsers() {
		TypedQuery<User> e = entityManager.createQuery("Select u from User u", User.class);
		List <User> users = e.getResultList();
		return users;
	}
	
	public User getUserById(int userId) {
		User user = entityManager.find(User.class, userId);
		return user;
	}
	
	public User updateUser(User user) {
		entityManager.merge(user); 
		return user;
	}
	
	public User addUser(User user) {
		entityManager.persist(user); 
		return user;
	}
	
	public int deleteUser(int id) {
		User user = entityManager.find(User.class, id);
		entityManager.remove(user);
		return user.getUserId();
	}
}
