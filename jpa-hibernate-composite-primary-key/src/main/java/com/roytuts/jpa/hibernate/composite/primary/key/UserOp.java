package com.roytuts.jpa.hibernate.composite.primary.key;

import java.util.List;

import javax.persistence.EntityManager;

public class UserOp {

	private EntityManager em;

	public UserOp(EntityManager em) {
		this.em = em;
	}

	public UserEntity getUser(UserPKey compositePKey) {
		UserEntity user = em.find(UserEntity.class, compositePKey);
		return user;
	}

	public List<UserEntity> getUsers() {
		String sql = "select u from UserEntity u";
		List<UserEntity> users = em.createQuery(sql, UserEntity.class).getResultList();
		return users;
	}

	public void addUser(UserEntity user) {
		if (!em.getTransaction().isActive()) {
			em.getTransaction().begin();
		}

		em.persist(user);
		em.getTransaction().commit();
	}

	public void updateUser(UserEntity user) {
		if (!em.getTransaction().isActive()) {
			em.getTransaction().begin();
		}

		em.persist(user);
		em.getTransaction().commit();
	}

	public void deleteUser(UserPKey userPKey) {
		if (!em.getTransaction().isActive()) {
			em.getTransaction().begin();
		}

		UserEntity ue = new UserEntity();
		//ue.setUserPKey(userPKey);
		
		ue.setFirstName(userPKey.getFirstName());
		ue.setLastName(userPKey.getLastName());
		
		em.remove(em.contains(ue) ? ue : em.merge(ue));
		em.getTransaction().commit();
	}

}
