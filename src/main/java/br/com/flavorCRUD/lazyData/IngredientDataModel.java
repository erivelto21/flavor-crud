package br.com.flavorCRUD.lazyData;

import java.util.List;
import java.util.Map;

import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import org.primefaces.model.LazyDataModel;
import org.primefaces.model.SortOrder;

import br.com.flavorCRUD.domain.Ingredient;
import br.com.flavorCRUD.service.IngredientService;

@Named
@ViewScoped
public class IngredientDataModel extends LazyDataModel<Ingredient>{
	
	@Inject
	private IngredientService service;

	@Override
	public List<Ingredient> load(int first, int pageSize, String sortField, SortOrder sortOrder,
			Map<String, Object> filters) {
		this.setRowCount(service.getTotalAmount());
		return service.pagination(first, pageSize);
	}
}
