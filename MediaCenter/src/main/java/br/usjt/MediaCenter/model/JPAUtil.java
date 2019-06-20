package br.usjt.MediaCenter.model;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class JPAUtil {
	
	private static EntityManagerFactory factory;
	
	static {
		factory = Persistence.createEntityManagerFactory("media_center_hibernate");
	}
	
	public static EntityManager getEntityManager () {
		return factory.createEntityManager();
	}
	
	public static void close () {
		factory.close();
	}
}