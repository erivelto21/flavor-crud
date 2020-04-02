package br.com.flavorCRUD.bean;

import java.io.Serializable;

import javax.faces.context.FacesContext;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import org.primefaces.component.datatable.DataTable;

import br.com.flavorCRUD.domain.Ingredient;
import br.com.flavorCRUD.service.IngredientService;
import br.com.flavorCRUD.util.FacesMessageUtil;

@Named
@ViewScoped
public class IngredientBean implements Serializable{

	private Ingredient ingredient = new Ingredient();
	
	@Inject
	private IngredientService service;

	public Ingredient getIngredient() {
		return ingredient;
	}

	public void setIngredient(Ingredient ingredient) {
		this.ingredient = ingredient;
	}

	public void delete(Ingredient ingredient) {
		this.service.delete(ingredient);
		this.dataTableLazyReload();
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
		this.dataTableLazyReload();
	}
	
	public void clear() {
		this.ingredient = new Ingredient();
	}
	
	private void create() {
		this.service.create(ingredient);
	}
	
	private void update() {
		this.service.update(this.ingredient);
	}
	
	private void dataTableLazyReload() {
		DataTable dataTable = (DataTable)  FacesContext.getCurrentInstance().getViewRoot().findComponent("list");
		dataTable.loadLazyData();
	}
}
