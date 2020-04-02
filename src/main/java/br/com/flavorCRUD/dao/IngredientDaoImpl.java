package br.com.flavorCRUD.dao;

import java.util.List;

import javax.inject.Inject;
import javax.persistence.EntityManager;

import br.com.flavorCRUD.domain.Ingredient;
import br.com.flavorCRUD.interceptor.Transacional;

public class IngredientDaoImpl implements IngredientDao {

	@Inject
	private EntityManager entityManager;

	@Transacional
	public void create(Ingredient ingredient) {
		this.entityManager.persist(ingredient);
	}

	public List<Ingredient> getAll() {
		return this.entityManager.createQuery("select i from Ingredient i ORDER BY ID", Ingredient.class).getResultList();
	}
	
	public List<Ingredient> pagination(int begin, int amount) {
		return this.entityManager
				.createQuery("SELECT i FROM Ingredient i ORDER BY ID", Ingredient.class)
				.setFirstResult(begin)
				.setMaxResults(amount)
				.getResultList();
	}

	@Transacional
	public void delete(Ingredient ingredient) {
 		this.entityManager.remove(this.entityManager.contains(ingredient) ? ingredient : this.entityManager.merge(ingredient));
	}

	@Transacional
	public void update(Ingredient ingredient) {
		this.entityManager.merge(ingredient);
	}
	
	public long count() {
		return (Long) this.entityManager.createQuery("select count(distinct i.id) from Ingredient i").getSingleResult();
	}
}
