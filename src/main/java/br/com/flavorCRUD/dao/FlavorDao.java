package br.com.flavorCRUD.dao;

import java.util.List;

import br.com.flavorCRUD.domain.Flavor;

public interface FlavorDao {

	void create(Flavor flavor);
	
	List<Flavor> getAll();
	
	void delete(Flavor flavor);
	
	void update(Flavor flavor);
}
