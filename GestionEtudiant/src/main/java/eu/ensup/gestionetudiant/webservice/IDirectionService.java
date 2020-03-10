package eu.ensup.gestionetudiant.webservice;
import java.util.List;
import javax.jws.WebService;
import eu.ensup.gestionetudiant.domaine.Cours;
import eu.ensup.gestionetudiant.domaine.Etudiant;
/**
 * @author benja Interface du service de la gestion des étudiants Elle comprends
 *         toutes les méthodes obligatoire du service
 */
@WebService
public interface IDirectionService {
	/**
	 * Ajoute un étudiaant à un cours
	 *
	 * @param etu
	 * @param c
	 * @return int
	 */
	public int ajouterEtudiantCours(Etudiant etu, Cours c);
	/**
	 * Création d'un étudiant
	 *
	 * @param etu
	 * @return un étudiant
	 */
	public int creerEtudiant(Etudiant etu);
	/**
	 * Lit le détail des informations d'un étudiant
	 *
	 * @param idEtudiant
	 * @return Etudiant
	 */
	public Etudiant lireInfoEtudiant(int idEtudiant);
	/**
	 * @return une liste d'étudiant
	 */
	public List<Etudiant> listerEtudiants();
	/**
	 * Modifier un étudiant
	 *
	 * @param etu
	 * @return int
	 */
	public int modifierEtudiant(Etudiant etu);
	/**
	 * Supprime un étudiant
	 *
	 * @param idEtudiant
	 * @return int
	 */
	public int supprimerEtudiant(int idEtudiant);
}