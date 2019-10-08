package com.roytuts.jpa.crud;

import java.util.List;

import javax.persistence.EntityManager;

import com.roytuts.jpa.crud.entity.UserDetails;
import com.roytuts.jpa.crud.exception.JpaException;

public class UserDeatilsCrud {

	private EntityManager em;

	public UserDeatilsCrud(EntityManager em) {
		this.em = em;
	}

	public UserDetails getUserDetails(int id) {
		try {
			UserDetails userDetails = em.find(UserDetails.class, id);
			return userDetails;
		} catch (JpaException ex) {
			throw new JpaException(ex.getMessage(), ex);
		}
	}

	public List<UserDetails> getUsersDetails() {
		try {
			String sql = "select u from UserDetails u";
			List<UserDetails> userDetails = em.createQuery(sql, UserDetails.class).getResultList();
			return userDetails;
		} catch (JpaException ex) {
			throw new JpaException(ex.getMessage(), ex);
		}
	}

	public void addUserDetails(UserDetails userDetails) {
		try {
			if (!em.getTransaction().isActive()) {
				em.getTransaction().begin();
			}
			em.persist(userDetails);
			em.getTransaction().commit();
		} catch (JpaException e) {
			em.getTransaction().rollback();
			throw new JpaException(e.getMessage(), e);
		}
	}

	public void updateUserDetails(UserDetails userDetails) {
		try {
			if (!em.getTransaction().isActive()) {
				em.getTransaction().begin();
			}
			UserDetails details = getUserDetails(userDetails.getId());
			details.setFirstName(userDetails.getFirstName());
			details.setLastName(userDetails.getLastName());
			details.setEmail(userDetails.getEmail());
			details.setDob(userDetails.getDob());
			em.getTransaction().commit();
		} catch (JpaException e) {
			em.getTransaction().rollback();
			throw new JpaException(e.getMessage(), e);
		}
	}

	public void deleteUserDetails(int id) {
		try {
			if (!em.getTransaction().isActive()) {
				em.getTransaction().begin();
			}
			UserDetails details = getUserDetails(id);
			em.remove(details);
			em.getTransaction().commit();
		} catch (JpaException e) {
			em.getTransaction().rollback();
			throw new JpaException(e.getMessage(), e);
		}
	}

}
