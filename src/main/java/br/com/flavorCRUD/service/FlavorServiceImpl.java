package br.com.flavorCRUD.service;

import java.io.Serializable;
import java.util.List;

import javax.inject.Inject;

import br.com.flavorCRUD.dao.FlavorDao;
import br.com.flavorCRUD.domain.Flavor;

public class FlavorServiceImpl implements FlavorService, Serializable{

	@Inject
	private FlavorDao dao;
	
	public void create(Flavor flavor) {
		dao.create(flavor);
	}
	
	public List<Flavor> getAll() {
		return dao.getAll();
	}
	
	public List<Flavor> pagination(int begin, int amount) {
		return dao.pagination(begin, amount);
	}

	public void delete(Flavor flavor) {
		dao.delete(flavor);
	}

	public void update(Flavor flavor) {
		dao.update(flavor);
	}

	public int getTotalAmount() {
		return (int) dao.count();
	}
}
