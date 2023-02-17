package com.ty.foodie_application_jsp.dao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

import com.ty.foodie_application_jsp.dto.FoodOrder;
import com.ty.foodie_application_jsp.dto.Items;
import com.ty.foodie_application_jsp.dto.Menu;


public class FoodOrderDao {
	

	public EntityManager getEntityManager() {
		EntityManagerFactory entityManagerFactory=Persistence.createEntityManagerFactory("vinod");
		EntityManager entityManager=entityManagerFactory.createEntityManager();
		return entityManager;
		
	}
	
	public FoodOrder saveFoodOrder(FoodOrder foodOrder) {
		EntityManager entityManager = getEntityManager();
		EntityTransaction entityTransaction = entityManager.getTransaction();

		entityTransaction.begin();
		List<Items> list=new ArrayList<Items>();
		for(Items items:list) {
			entityManager.persist(items);
		}
		entityManager.persist(foodOrder);
		entityTransaction.commit();
		return foodOrder;
	}
	
	public List<FoodOrder> getAllFoodOrder(){
		EntityManager entityManager = getEntityManager();
		Query query=entityManager.createQuery("select f from FoodOrder f");
		List<FoodOrder> foodOrder=query.getResultList();
		return foodOrder;
	}
	

	public FoodOrder getFoodOrderByEmail(String email) {
		
		EntityManager entityManager = getEntityManager();
		Query query=entityManager.createQuery("select f from FoodOrder f where f.email=?1");
		query.setParameter(1, email);
		FoodOrder foodOrder=(FoodOrder)query.getSingleResult();
		return foodOrder;
		
	}
	
	
	public FoodOrder getFoodOrderById(int id) {
		
		EntityManager entityManager = getEntityManager();
		Query query=entityManager.createQuery("select f from FoodOrder f where f.id=?1");
		query.setParameter(1, id);
		FoodOrder foodOrder=(FoodOrder)query.getSingleResult();
		return foodOrder;
		
	}
	
	
	
	public FoodOrder updateFoodOrder(FoodOrder foodOrder) {

		EntityManager entityManager = getEntityManager();
		EntityTransaction entityTransaction = entityManager.getTransaction();

		entityTransaction.begin();
		entityManager.merge(foodOrder);
		entityTransaction.commit();
		return foodOrder;
	}


}
