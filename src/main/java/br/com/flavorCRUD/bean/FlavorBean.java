package br.com.flavorCRUD.bean;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.context.FacesContext;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import org.primefaces.component.datatable.DataTable;

import br.com.flavorCRUD.domain.Flavor;
import br.com.flavorCRUD.domain.Ingredient;
import br.com.flavorCRUD.service.FlavorService;
import br.com.flavorCRUD.service.IngredientService;
import br.com.flavorCRUD.util.FacesMessageUtil;

@Named
@ViewScoped
public class FlavorBean implements Serializable {

	private Flavor flavor = new Flavor();
	
	@Inject
	private FlavorService flavorService;

	@Inject
	private IngredientService ingredientService;
	
	private List<Ingredient> ingredients;

	@PostConstruct
	public void initialize() {
		this.ingredients = this.ingredientService.getAll();
	}
	
	public Flavor getFlavor() {
		return flavor;
	}

	public void setFlavor(Flavor flavor) {
		this.flavor = flavor;
	}
	
	public List<Ingredient> getIngredients() {
		return ingredients;
	}

	public void setIngredients(List<Ingredient> ingredients) {
		this.ingredients = ingredients;
	}
	
	public void delete(Flavor flavor) {
		this.flavorService.delete(flavor);
		new FacesMessageUtil().successMessage("Sabor removido com sucesso");
		this.dataTableLazyReload();
	}
	
	public void save() {
		if(this.flavor.getId() != 0) {
			this.update();
			new FacesMessageUtil().successMessage("Sabor atualizado com sucesso");
		}else {
			this.create();
			new FacesMessageUtil().successMessage("Sabor cadastrado com sucesso");
		}
		
		this.clear();
		this.dataTableLazyReload();
	}
	
	public void clear() {
		this.flavor = new Flavor();
	}
	
	private void create() {
		this.flavorService.create(flavor);
	}
	
	private void update() {
		this.flavorService.update(this.flavor);
	}
	
	private void dataTableLazyReload() {
		DataTable dataTable = (DataTable)  FacesContext.getCurrentInstance().getViewRoot().findComponent("list");
		dataTable.loadLazyData();
	}
}
