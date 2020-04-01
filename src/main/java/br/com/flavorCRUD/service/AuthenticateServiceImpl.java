package br.com.flavorCRUD.service;

import java.util.List;

import br.com.flavorCRUD.dao.UserDao;
import br.com.flavorCRUD.dao.UserDaoImpl;
import br.com.flavorCRUD.domain.User;

public class AuthenticateServiceImpl implements AuthenticateService{

	private UserDao dao; 
	
	public AuthenticateServiceImpl() {
		this.dao = new UserDaoImpl();
	}
	
	public User authenticate(String email, String password) {
		List<User> list = dao.getSystemUser(email, password);

		if(list.size() > 0)
			return list.get(0);
		
		return null;
	}
}
