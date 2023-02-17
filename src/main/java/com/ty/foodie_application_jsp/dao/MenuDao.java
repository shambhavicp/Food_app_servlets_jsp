package com.ty.foodie_application_jsp.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

import com.ty.foodie_application_jsp.dto.Menu;

public class MenuDao {

	public EntityManager getEntityManager() {
		EntityManagerFactory entityManagerFactory=Persistence.createEntityManagerFactory("vinod");
		EntityManager entityManager=entityManagerFactory.createEntityManager();
		return entityManager;
		
	}
	
	public Menu saveMenu(Menu menu) {
		EntityManager entityManager = getEntityManager();
		EntityTransaction entityTransaction = entityManager.getTransaction();

		entityTransaction.begin();

		entityManager.persist(menu);
		entityTransaction.commit();
		return menu;
	}
	
	public List<Menu> getAllMenu(){
		EntityManager entityManager = getEntityManager();
		Query query=entityManager.createQuery("select m from Menu m");
		List<Menu> menu=query.getResultList();
		return menu;
	}
	
	public boolean deleteMenu(int id) {
		EntityManager entityManager = getEntityManager();
		EntityTransaction entityTransaction = entityManager.getTransaction();

		Menu menu = entityManager.find(Menu.class, id);
		if (menu != null) {

			entityTransaction.begin();
			entityManager.remove(menu);
			entityTransaction.commit();
			return true;
		} else {
			return false;
		}
	}

	public Menu getMenuById(int id) {
		return getEntityManager().find(Menu.class, id);
	}

	public Menu updateMenu(Menu menu) {

		EntityManager entityManager = getEntityManager();
		EntityTransaction entityTransaction = entityManager.getTransaction();

		entityTransaction.begin();
		entityManager.merge(menu);
		entityTransaction.commit();
		return menu;
	}

	
	
	
}
