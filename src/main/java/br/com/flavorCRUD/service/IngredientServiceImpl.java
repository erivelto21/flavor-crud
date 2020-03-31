package br.com.flavorCRUD.service;

import java.io.Serializable;
import java.util.List;

import javax.inject.Inject;

import br.com.flavorCRUD.dao.IngredientDao;
import br.com.flavorCRUD.domain.Ingredient;

public class IngredientServiceImpl implements IngredientService, Serializable{

	@Inject
	private IngredientDao dao;

	public void create(Ingredient ingredient) {
		this.dao.create(ingredient);
	}

	public List<Ingredient> getAll() {
		return this.dao.getAll();
	}

	public void delete(Ingredient ingredient) {
		this.dao.delete(ingredient);
	}

	public void update(Ingredient ingredient) {
		this.dao.update(ingredient);
	}
}
