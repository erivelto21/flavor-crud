package br.com.flavorCRUD.bean;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import br.com.flavorCRUD.domain.Flavor;
import br.com.flavorCRUD.domain.Ingredient;
import br.com.flavorCRUD.service.FlavorService;
import br.com.flavorCRUD.service.IngredientService;

@Named
@ViewScoped
public class FlavorBean implements Serializable {

	private Flavor flavor = new Flavor();

	private List<Flavor> flavors;
	
	@Inject
	private FlavorService flavorService;

	@Inject
	private IngredientService ingredientService;
	
	private List<Ingredient> ingredients;

	@PostConstruct
	public void initialize() {
		this.flavors = this.flavorService.getAll();
		this.ingredients = this.ingredientService.getAll();
	}
	
	public Flavor getFlavor() {
		return flavor;
	}

	public void setFlavor(Flavor flavor) {
		this.flavor = flavor;
	}

	public List<Flavor> getFlavors() {
		return flavors;
	}

	public void setFlavors(List<Flavor> flavors) {
		this.flavors = flavors;
	}
	
	public List<Ingredient> getIngredients() {
		return ingredients;
	}

	public void setIngredients(List<Ingredient> ingredients) {
		this.ingredients = ingredients;
	}
	
	public void delete(Flavor flavor) {
		this.flavorService.delete(flavor);
		this.reloadFlavorList();
	}
	
	public void save() {
		if(this.flavor.getId() != 0) {
			this.update();
		}else {
			this.create();
		}
		
		this.clear();
	}
	
	public void clear() {
		this.flavor = new Flavor();
	}
	
	private void create() {
		this.flavorService.create(flavor);
		this.reloadFlavorList();
	}
	
	private void update() {
		this.flavorService.update(this.flavor);
	}
	
	private void reloadFlavorList() {
		this.setFlavors(this.flavorService.getAll());
	}
}
