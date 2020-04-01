package br.com.flavorCRUD.service;

import br.com.flavorCRUD.domain.User;

public interface AuthenticateService {

	User authenticate(String email, String password);
}
