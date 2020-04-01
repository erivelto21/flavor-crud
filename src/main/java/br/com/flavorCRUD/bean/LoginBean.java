package br.com.flavorCRUD.bean;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;

import br.com.flavorCRUD.domain.User;
import br.com.flavorCRUD.service.AuthenticateService;
import br.com.flavorCRUD.service.AuthenticateServiceImpl;
import br.com.flavorCRUD.util.FacesMessageUtil;

@ManagedBean
@RequestScoped
public class LoginBean {

	private String email;
	
	private String password;

	@ManagedProperty("#{systemUser}")
	private SystemUser systemUser;
	
	private AuthenticateService service;

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public SystemUser getSystemUser() {
		return systemUser;
	}

	public void setSystemUser(SystemUser systemUser) {
		this.systemUser = systemUser;
	}

	public String login() {
		this.service = new AuthenticateServiceImpl();
		
		User user = this.service.authenticate(this.getEmail(), this.getPassword());
		
		boolean userIsValid = this.userIsValid(user);
		
		if(userIsValid) {
			this.systemUser.login(user);
			
			return "/private/flavor?faces-redirect=true";
		}
		
		new FacesMessageUtil().errorMessage("Dados Inválidos");
		
		return null;
	}
	
	public String logout() {
		this.systemUser.logout();
		
		return "/login?faces-redirect=true";
	}
	
	public void clear() {
		this.email = "";
		this.password = "";
	}
	
	private boolean userIsValid(User user) {
		if(user != null) {
			if(user.getRole().getId() == 1) {
				return true;
			} else {
				return false;
			}
		}
		
		return false;
	}
}
