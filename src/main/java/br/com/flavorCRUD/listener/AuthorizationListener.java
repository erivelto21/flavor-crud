package br.com.flavorCRUD.listener;

import javax.faces.application.NavigationHandler;
import javax.faces.context.FacesContext;
import javax.faces.event.PhaseEvent;
import javax.faces.event.PhaseId;
import javax.faces.event.PhaseListener;

import br.com.flavorCRUD.bean.SystemUser;

public class AuthorizationListener implements PhaseListener{
	
	@Override
	public void afterPhase(PhaseEvent event) {
		FacesContext facesContext = event.getFacesContext();
		
		String urlPage = facesContext.getViewRoot().getViewId();

		if("/login.xhtml".equals(urlPage)) {
			return;
		}

		SystemUser user = (SystemUser) facesContext.getExternalContext().getSessionMap().get("systemUser");

		if(user == null) {
			this.redirectToLogin(facesContext);
			return;
		}

		if(!user.isLogged()) {
			this.redirectToLogin(facesContext);
		}
	}

	@Override
	public void beforePhase(PhaseEvent event) {}

	@Override
	public PhaseId getPhaseId() {
		return PhaseId.RESTORE_VIEW;
	}
	
	private void redirectToLogin(FacesContext facesContext) {
		NavigationHandler navigationHandler = facesContext.getApplication().getNavigationHandler();
		navigationHandler.handleNavigation(facesContext, null, "/login?faces-redirect=true");
		
		facesContext.renderResponse();
	}
}
