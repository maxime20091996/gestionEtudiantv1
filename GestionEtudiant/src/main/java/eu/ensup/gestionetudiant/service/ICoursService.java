package eu.ensup.gestionetudiant.service;

import java.util.List;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;
import eu.ensup.gestionetudiant.domaine.Cours;

@WebService
@SOAPBinding(style = SOAPBinding.Style.DOCUMENT)
public interface ICoursService {

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

