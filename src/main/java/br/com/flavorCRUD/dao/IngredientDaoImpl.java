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

	@Transacional
	public void delete(Ingredient ingredient) {
 		this.entityManager.remove(this.entityManager.contains(ingredient) ? ingredient : this.entityManager.merge(ingredient));
	}

	@Transacional
	public void update(Ingredient ingredient) {
		this.entityManager.merge(ingredient);
	}
}
