package br.com.flavorCRUD.service;

import java.util.List;

import br.com.flavorCRUD.domain.Ingredient;

public interface IngredientService {

	void create(Ingredient ingredient);
	
	List<Ingredient> getAll();
	
	List<Ingredient> pagination(int begin, int amount);
	
	void delete(Ingredient ingredient);
	
	void update(Ingredient ingredient);
	
	int getTotalAmount();
}
