package eu.ensup.gestionetudiant.service;

import java.util.List;

import eu.ensup.gestionetudiant.dao.LoginDao;
import eu.ensup.gestionetudiant.domaine.Direction;

public class LoginService {

	/**
	 * Service de connection/ Authentification de l'utilisateur
	 * @param login
	 * @param password
	 * @return
	 */
	public List<Direction> connection(String login, String password) {
		LoginDao dao = new LoginDao();
		return dao.login(login, password);
	}
}
