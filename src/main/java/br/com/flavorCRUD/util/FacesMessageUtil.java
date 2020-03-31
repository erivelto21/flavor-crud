package br.com.flavorCRUD.util;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;

public class FacesMessageUtil {

	private FacesContext facesContext;
	
	public FacesMessageUtil() {
		this.facesContext = FacesContext.getCurrentInstance();
	}
	
	public void successMessage(String message) {
		FacesMessage facesMessage = new FacesMessage(FacesMessage.SEVERITY_INFO, message, message);
		facesContext.addMessage(null, facesMessage);
	}
	
	public void errorMessage(String message) {
		FacesMessage facesMessage = new FacesMessage(FacesMessage.SEVERITY_ERROR, message, null);
		facesContext.addMessage(null, facesMessage);
	}
}
