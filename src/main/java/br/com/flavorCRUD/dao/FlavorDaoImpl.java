package br.com.flavorCRUD.dao;

import java.util.List;

import javax.inject.Inject;
import javax.persistence.EntityManager;

import br.com.flavorCRUD.domain.Flavor;
import br.com.flavorCRUD.interceptor.Transacional;

public class FlavorDaoImpl implements FlavorDao {

	@Inject
	private EntityManager entityManager;

	@Transacional
	public void create(Flavor flavor) {
		this.entityManager.persist(flavor);
	}
	
	public List<Flavor> getAll() {
		return this.entityManager.createQuery("select f from Flavor f ORDER BY ID", Flavor.class).getResultList();
	}

	@Transacional
	public void delete(Flavor flavor) {
		this.entityManager.remove(this.entityManager.contains(flavor) ? flavor : this.entityManager.merge(flavor));
	}

	@Transacional
	public void update(Flavor flavor) {
		this.entityManager.merge(flavor);
	}
}
