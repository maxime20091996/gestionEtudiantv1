package eu.ensup.gestionetudiant.webservice;
import java.util.List;
import javax.jws.WebService;
import eu.ensup.gestionetudiant.dao.DirectionDao;
import eu.ensup.gestionetudiant.dao.IDirectionDao;
import eu.ensup.gestionetudiant.domaine.Cours;
import eu.ensup.gestionetudiant.domaine.Etudiant;
@WebService(endpointInterface = "eu.ensup.gestionetudiant.webservice.IDirectionService")
public class DirectionService implements IDirectionService {
	IDirectionDao dao = new DirectionDao();
	public int ajouterEtudiantCours(Etudiant etu, Cours c) {
		// TODO Auto-generated method stub
		return dao.ajouterEtudiantCours(etu, c);
	}
	public int creerEtudiant(Etudiant etu) {
		// TODO Auto-generated method stub
		return dao.creerEtudiant(etu);
	}
	public Etudiant lireInfoEtudiant(int idEtudiant) {
		// TODO Auto-generated method stub
		return dao.lireInfoEtudiant(idEtudiant);
	}
	public List<Etudiant> listerEtudiants() {
		// TODO Auto-generated method stub
		return dao.listerEtudiants();
	}
	public int modifierEtudiant(Etudiant etu) {
		// TODO Auto-generated method stub
		return dao.modifierEtudiant(etu);
	}
	public int supprimerEtudiant(int idEtudiant) {
		// TODO Auto-generated method stub
		return dao.supprimerEtudiant(idEtudiant);
	}
}