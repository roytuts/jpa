package com.roytuts.jpa.crud.manager;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public enum PersistenceManager {

	_INSTANCE;

	private EntityManagerFactory emf;

	private PersistenceManager() {
		emf = Persistence.createEntityManagerFactory("userPersistanceUnit");
	}

	public EntityManager getEntityManager() {
		return emf.createEntityManager();
	}

	public void close() {
		emf.close();
	}

}
