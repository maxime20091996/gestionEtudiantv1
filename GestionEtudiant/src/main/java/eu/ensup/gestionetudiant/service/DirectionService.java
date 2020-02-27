package eu.ensup.gestionetudiant.service;

import java.util.List;

import eu.ensup.gestionetudiant.dao.DirectionDao;
import eu.ensup.gestionetudiant.dao.IDirectionDao;
import eu.ensup.gestionetudiant.domaine.Cours;
import eu.ensup.gestionetudiant.domaine.Etudiant;

public class DirectionService implements IDirectionService {
	
	IDirectionDao dao = new DirectionDao();
	
	public List<Etudiant> listerEtudiants() {
		// TODO Auto-generated method stub
		return dao.listerEtudiants();
	}

	public int creerEtudiant(Etudiant etu) {
		// TODO Auto-generated method stub
		return dao.creerEtudiant(etu);
	}

	public int modifierEtudiant(Etudiant etu) {
		// TODO Auto-generated method stub
		return dao.modifierEtudiant(etu);
	}

	public int supprimerEtudiant(int idEtudiant) {
		// TODO Auto-generated method stub
		return dao.supprimerEtudiant(idEtudiant);
	}

	public Etudiant lireInfoEtudiant(int idEtudiant) {
		// TODO Auto-generated method stub
		return dao.lireInfoEtudiant(idEtudiant);
	}

	public int ajouterEtudiantCours(Etudiant etu, Cours c) {
		// TODO Auto-generated method stub
		return dao.ajouterEtudiantCours(etu, c);
	}

}
