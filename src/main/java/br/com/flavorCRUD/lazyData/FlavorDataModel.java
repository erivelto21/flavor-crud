package br.com.flavorCRUD.lazyData;

import java.util.List;
import java.util.Map;

import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import org.primefaces.model.LazyDataModel;
import org.primefaces.model.SortOrder;

import br.com.flavorCRUD.domain.Flavor;
import br.com.flavorCRUD.service.FlavorService;

@Named
@ViewScoped
public class FlavorDataModel extends LazyDataModel<Flavor>{
	
	@Inject
	private FlavorService service;
	
	@Override
	public List<Flavor> load(int first, int pageSize, String sortField, SortOrder sortOrder,
			Map<String, Object> filters) {
		this.setRowCount(service.getTotalAmount());
		return service.pagination(first, pageSize);
	}
}
