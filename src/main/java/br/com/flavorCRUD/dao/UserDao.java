package br.com.flavorCRUD.dao;

import java.util.List;

import br.com.flavorCRUD.domain.User;

public interface UserDao {

	List<User> getSystemUser(String email, String password);
}
