package com.roytuts.jpa.criteria.api.app;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import com.roytuts.jpa.criteria.api.entity.User;
import com.roytuts.jpa.criteria.api.persistence.manager.PersistenceManager;

public class JpaCriteriaApp {

	public static void main(String[] args) {

		EntityManager em = PersistenceManager._INSTANCE.getEntityManager();

		// create user for id 35
		try {
			em.getTransaction().begin();

			User u = new User();
			u.setName("Liton");
			u.setEmail("liton.sarkar@email.com");
			u.setPhone("1407874760");
			u.setAddress("Mars");

			em.persist(u);

			em.getTransaction().commit();

			System.out.println("User " + u + " successfully saved");
		} catch (Exception e) {
			em.getTransaction().rollback();
			e.printStackTrace();
		}

		CriteriaBuilder criteriaBuilder = em.getCriteriaBuilder();
		CriteriaQuery<Object> criteriaQuery = criteriaBuilder.createQuery();
		Root<User> from = criteriaQuery.from(User.class);

		// select all records
		System.out.println("Select all records");
		System.out.println("------------------");
		System.out.println();

		CriteriaQuery<Object> select = criteriaQuery.select(from);
		TypedQuery<Object> typedQuery = em.createQuery(select);
		List<Object> resultlist = typedQuery.getResultList();

		for (Object o : resultlist) {
			User u = (User) o;
			System.out.println(u);
		}

		// Ordering the records
		System.out.println();
		System.out.println("Select all records in ascending order");
		System.out.println("-------------------------------------");
		System.out.println();

		CriteriaQuery<Object> select1 = criteriaQuery.select(from);
		select1.orderBy(criteriaBuilder.asc(from.get("name")));

		TypedQuery<Object> typedQuery1 = em.createQuery(select);
		List<Object> resultlist1 = typedQuery1.getResultList();

		for (Object o : resultlist1) {
			User u = (User) o;
			System.out.println(u);
		}

		// update user for id 35
		try {
			User user = em.find(User.class, 35);
			user.setName("Liton Sarkar");
			user.setEmail("liton.sarkar@email.com");
			user.setPhone("140787476990");
			user.setAddress("Earth");

			em.persist(user);

			em.getTransaction().commit();

			System.out.println("User " + user + " successfully updated");
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			em.close();
			PersistenceManager._INSTANCE.close();
		}

	}

}
