package com.ty.foodie_application_jsp.dao;


import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

import com.ty.foodie_application_jsp.dto.Items;


public class ItemsDao {
	
	
		public EntityManager getEntityManager() {
			EntityManagerFactory entityManagerFactory=Persistence.createEntityManagerFactory("vinod");
			EntityManager entityManager=entityManagerFactory.createEntityManager();
			return entityManager;
			
		}
		
		public Items saveItems(Items items) {
			EntityManager entityManager = getEntityManager();
			EntityTransaction entityTransaction = entityManager.getTransaction();
			
			entityTransaction.begin();
			
			entityManager.persist(items);
			entityTransaction.commit();
			return items;
		}
		

		public boolean deleteItems(int id) {
			EntityManager entityManager = getEntityManager();
			EntityTransaction entityTransaction = entityManager.getTransaction();

			Items items = entityManager.find(Items.class, id);
			if (items != null) {

				entityTransaction.begin();
				entityManager.remove(items);
				entityTransaction.commit();
				return true;
			} else {
				return false;
			}
		}
		

		public Items getItemsById(int id) {
			return getEntityManager().find(Items.class, id);
		}
		

		public List<Items> getAllItems(){
			EntityManager entityManager = getEntityManager();
			Query query=entityManager.createQuery("select i from Items i");
			List<Items> items=query.getResultList();
			return items;
		}
		

		
		public Items updateItem(Items items) {

			EntityManager entityManager = getEntityManager();
			EntityTransaction entityTransaction = entityManager.getTransaction();

			entityTransaction.begin();
			entityManager.merge(items);
			entityTransaction.commit();
			return items;
		}


}
