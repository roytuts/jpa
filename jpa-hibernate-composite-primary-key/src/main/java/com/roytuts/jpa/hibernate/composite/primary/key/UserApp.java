package com.roytuts.jpa.hibernate.composite.primary.key;

import java.util.List;

import javax.persistence.EntityManager;

public class UserApp {

	public static void main(String[] args) {
		EntityManager em = PersistenceManager._INSTANCE.getEntityManager();

		UserOp userOp = new UserOp(em);

		// retrieve for first and last name
		UserEntity userByPKey = userOp
					.getUser(new UserPKey("Soumitra", "Roy"));
			System.out.println("By first and last name: " + userByPKey);

		// retrieve all
			List<UserEntity> detailsList = userOp.getUsers();

			detailsList.stream().forEach(d -> System.out.println(d));

		// add
			UserEntity addUser = new UserEntity();
			
			//UserPKey userPKey=new UserPKey("Liton", "Sarkar");
			UserPKey userPKey=new UserPKey("First", "Last");
			
			//addUser.setUserPKey(userPKey);
			
			//addUser.setFirstName("Liton");
			//addUser.setLastName("Sarkar");

			//userOp.addUser(addUser);

		// get all after addition
			detailsList = userOp.getUsers();

			detailsList.stream().forEach(d -> System.out.println(d));

		// update
			UserEntity updateUser = new UserEntity();
			updateUser.setId(2);
		
			 userPKey=new UserPKey("Liton", "Sarkr");
			
			//updateUser.setUserPKey(userPKey);
			
			//updateUser.setFirstName("Liton");
			//updateUser.setLastName("Sarkr");

			//userOp.updateUser(updateUser);

		// get all after update
			detailsList = userOp.getUsers();

			detailsList.stream().forEach(d -> System.out.println(d));

		// delete user
			//userOp.deleteUser(new UserPKey("Liton", "Sarkr"));
			userOp.deleteUser(new UserPKey("First", "Last"));

		// get all after deletion
			detailsList = userOp.getUsers();

			detailsList.stream().forEach(d -> System.out.println(d));

		// close EntityManager
		em.close();

		// close EntityManagerFactory
		PersistenceManager._INSTANCE.close();
	}

}
