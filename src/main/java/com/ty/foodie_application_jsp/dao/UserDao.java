package com.ty.foodie_application_jsp.dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

import com.ty.foodie_application_jsp.dto.User;



public class UserDao {

	public EntityManager getEntityManager() {
		EntityManagerFactory entityManagerFactory=Persistence.createEntityManagerFactory("vinod");
		EntityManager entityManager=entityManagerFactory.createEntityManager();
		return entityManager;
		
	}
	
	public User saveUser(User user) {
		EntityManager entityManager = getEntityManager();
		EntityTransaction entityTransaction = entityManager.getTransaction();

		entityTransaction.begin();

		entityManager.persist(user);
		entityTransaction.commit();
		return user;
	}
	

	public User loginUserByEmail(String email) {
		EntityManager entityManager = getEntityManager();
		Query query = entityManager.createQuery("select u from User u where u.email=?1");
		query.setParameter(1, email);
		User user = (User) query.getSingleResult();
		return user;

	}

}
