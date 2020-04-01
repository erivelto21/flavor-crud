package br.com.flavorCRUD.dao;

import java.util.List;

import javax.persistence.EntityManager;

import br.com.flavorCRUD.domain.User;
import br.com.flavorCRUD.jpa.JpaUtil;

public class UserDaoImpl implements UserDao{

	private EntityManager entityManager;
	
	public UserDaoImpl() {
		this.entityManager = JpaUtil.getEntityManager();
	}

	public List<User> getSystemUser(String email, String password) {
		return this.entityManager
				.createQuery("select u from User u where u.email = :email and u.password = :password",
						User.class)
				.setParameter("email", email).setParameter("password", password).getResultList();
	}
}
