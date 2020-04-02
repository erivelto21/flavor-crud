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
	
	public List<Flavor> pagination(int begin, int amount) {
		return this.entityManager
				.createQuery("SELECT f FROM Flavor f ORDER BY ID", Flavor.class)
				.setFirstResult(begin)
				.setMaxResults(amount)
				.getResultList();
	}

	@Transacional
	public void delete(Flavor flavor) {
		this.entityManager.remove(this.entityManager.contains(flavor) ? flavor : this.entityManager.merge(flavor));
	}

	@Transacional
	public void update(Flavor flavor) {
		this.entityManager.merge(flavor);
	}
	
	public long count() {
		return (Long) this.entityManager.createQuery("select count(distinct f.id) from Flavor f").getSingleResult();
	}
}
