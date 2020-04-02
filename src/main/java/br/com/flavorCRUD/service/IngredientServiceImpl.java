package br.com.flavorCRUD.service;

import java.io.Serializable;
import java.util.List;

import javax.inject.Inject;

import br.com.flavorCRUD.dao.IngredientDao;
import br.com.flavorCRUD.domain.Flavor;
import br.com.flavorCRUD.domain.Ingredient;
import br.com.flavorCRUD.util.FacesMessageUtil;

public class IngredientServiceImpl implements IngredientService, Serializable{

	@Inject
	private IngredientDao dao;

	@Inject
	private FlavorService service;
	
	public void create(Ingredient ingredient) {
		this.dao.create(ingredient);
	}

	public List<Ingredient> getAll() {
		return this.dao.getAll();
	}
	
	public List<Ingredient> pagination(int begin, int amount) {
		return dao.pagination(begin, amount);
	}

	public void delete(Ingredient ingredient) {
		if(this.ingredientIsInAFalvor(ingredient)) {
			new FacesMessageUtil().errorMessage("O ingrediente esta em uso em algum sabor");
		} else {
			this.dao.delete(ingredient);
			new FacesMessageUtil().successMessage("Ingrediente removido com sucesso");
		}
	}

	public void update(Ingredient ingredient) {
		this.dao.update(ingredient);
	}
	
	private boolean ingredientIsInAFalvor(Ingredient ingredient) {
		boolean aux = false;
		
		for(Flavor f: this.service.getAll()) {
			if(!aux)
				aux = f.getIngredients().contains(ingredient);
		}

		return aux;
	}
	
	public int getTotalAmount() {
		return (int) dao.count();
	}
}
