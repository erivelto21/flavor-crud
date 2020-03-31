package br.com.flavorCRUD.service;

import java.util.List;

import br.com.flavorCRUD.domain.Flavor;

public interface FlavorService {

	void create(Flavor flavor);
	
	List<Flavor> getAll();
	
	void delete(Flavor flavor);
	
	void update(Flavor flavor);
}
