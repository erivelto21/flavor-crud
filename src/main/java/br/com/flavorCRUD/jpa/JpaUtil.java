package br.com.flavorCRUD.jpa;

import javax.enterprise.context.RequestScoped;
import javax.enterprise.inject.Disposes;
import javax.enterprise.inject.Produces;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class JpaUtil {

	private static EntityManagerFactory emf;
	
	@Produces
	@RequestScoped
	public static EntityManager getEntityManager() {
		if(emf == null)
			emf = Persistence.createEntityManagerFactory("pizzaria");
		
		return emf.createEntityManager();
	}
	
	public void close(@Disposes EntityManager entityManager) {
		entityManager.close();
	}
}
