package eu.ensup.gestionetudiant.dao;

import java.util.List;

import eu.ensup.gestionetudiant.domaine.Cours;
import eu.ensup.gestionetudiant.domaine.Etudiant;

/**
 * @author benja
 * Interface du DAO de l'entité Cours
 *
 */
public interface ICoursDao {

	/**
	 * @return une liste des cours
	 */
	public List<Cours> listerCours();
	
	/**
	 * Création d'un cours
	 * @param cours
	 * @return un cours
	 */
	public int creerCours(Cours cours);
	
	/**
	 * Lit le détail des informations d'un cours
	 * @param idCours
	 * @return Cours
	 */
	public Cours lireInfoCours(int idCours);
}
