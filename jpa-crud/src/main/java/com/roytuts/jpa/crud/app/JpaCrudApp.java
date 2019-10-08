package com.roytuts.jpa.crud.app;

import java.util.List;

import javax.persistence.EntityManager;

import com.roytuts.jpa.crud.UserDeatilsCrud;
import com.roytuts.jpa.crud.entity.UserDetails;
import com.roytuts.jpa.crud.manager.PersistenceManager;

public class JpaCrudApp {

	public static void main(String[] args) {
		EntityManager em = PersistenceManager._INSTANCE.getEntityManager();

		UserDeatilsCrud userDeatilsCrud = new UserDeatilsCrud(em);

		// user details for user id 7
		try {
			UserDetails userDetails = userDeatilsCrud.getUserDetails(7);
			System.out.println(userDetails);
		} catch (Exception e) {
			e.printStackTrace();
		}

		// get all user details
		try {
			List<UserDetails> detailsList = userDeatilsCrud.getUsersDetails();
			for (UserDetails details : detailsList) {
				System.out.println(details);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		// add new user
		try {
			UserDetails user = new UserDetails();
			user.setFirstName("Liton");
			user.setLastName("Sarkar");
			user.setEmail("liton.sarkar@email.com");
			user.setDob("20-07-1990");
			userDeatilsCrud.addUserDetails(user);
		} catch (Exception e) {
			e.printStackTrace();
		}

		// get all users after addition
		try {
			List<UserDetails> detailsList = userDeatilsCrud.getUsersDetails();
			for (UserDetails details : detailsList) {
				System.out.println(details);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		// update user for id 10
		try {
			UserDetails user = new UserDetails();
			user.setId(10);
			user.setFirstName("Liton");
			user.setLastName("Sarkar");
			user.setEmail("liton.sarkar@email.com");
			user.setDob("14-07-1990");
			userDeatilsCrud.updateUserDetails(user);
		} catch (Exception e) {
			e.printStackTrace();
		}

		// get all users after update
		try {
			List<UserDetails> detailsList = userDeatilsCrud.getUsersDetails();
			for (UserDetails details : detailsList) {
				System.out.println(details);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		// delete user for id 9
		try {
			userDeatilsCrud.deleteUserDetails(9);
		} catch (Exception e) {
			e.printStackTrace();
		}

		// get all users after deletion
		try {
			List<UserDetails> detailsList = userDeatilsCrud.getUsersDetails();
			for (UserDetails details : detailsList) {
				System.out.println(details);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		// close EntityManager
		em.close();

		// close EntityManagerFactory
		PersistenceManager._INSTANCE.close();
	}

}
