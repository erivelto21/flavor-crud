package br.com.flavorCRUD.bean;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import br.com.flavorCRUD.domain.Ingredient;
import br.com.flavorCRUD.service.IngredientService;
import br.com.flavorCRUD.util.FacesMessageUtil;

@Named
@ViewScoped
public class IngredientBean implements Serializable{

	private Ingredient ingredient = new Ingredient();
	
	private List<Ingredient> ingredients;
	
	@Inject
	private IngredientService service;

	@PostConstruct
	public void initialize() {
		this.ingredients = this.service.getAll();
	}
	
	public Ingredient getIngredient() {
		return ingredient;
	}

	public void setIngredient(Ingredient ingredient) {
		this.ingredient = ingredient;
	}

	public List<Ingredient> getIngredients() {
		return ingredients;
	}

	public void setIngredients(List<Ingredient> ingredients) {
		this.ingredients = ingredients;
	}

	public void delete(Ingredient ingredient) {
		this.service.delete(ingredient);
		this.reloadIngredientList();
	}
	
	public void save() {
		if(this.ingredient.getId() != 0) {
			this.update();
			new FacesMessageUtil().successMessage("Ingrediente atualizado com sucesso");
		}else {
			this.create();
			new FacesMessageUtil().successMessage("Ingrediente cadastrado com sucesso");
		}
		
		this.clear();
	}
	
	public void clear() {
		this.ingredient = new Ingredient();
	}
	
	private void create() {
		this.service.create(ingredient);
		this.reloadIngredientList();
	}
	
	private void update() {
		this.service.update(this.ingredient);
	}
	
	private void reloadIngredientList() {
		this.setIngredients(this.service.getAll());
	}
}
