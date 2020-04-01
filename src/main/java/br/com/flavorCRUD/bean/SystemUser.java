package br.com.flavorCRUD.bean;

import java.io.Serializable;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import br.com.flavorCRUD.domain.User;

@ManagedBean
@SessionScoped
public class SystemUser implements Serializable {

	private User user;

	public User getUser() {
		return user;
	}

	public void login(User user) {
		this.user = user;
	}
	
	public boolean isLogged() {
		return this.user != null;
	}
	
	public void logout() {
		this.user = null;
	}
}
