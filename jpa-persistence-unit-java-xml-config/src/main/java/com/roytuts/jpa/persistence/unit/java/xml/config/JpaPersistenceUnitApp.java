package com.roytuts.jpa.persistence.unit.java.xml.config;

import javax.persistence.EntityManager;

public class JpaPersistenceUnitApp {

	public static void main(String[] args) {
		EntityManager em = PersistenceUnitConfig.getEntityManager();

		System.out.println("em.isOpen(): " + em.isOpen());

		em.close();
	}

}
