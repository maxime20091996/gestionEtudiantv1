package eu.ensup.gestionetudiant.dao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import eu.ensup.gestionetudiant.domaine.Direction;

/**
 * @author benja
 * Classe DAO génrant la connection de la direction 
 */
public class LoginDao {
	// ouverture unité de persistance
	EntityManagerFactory emf;
	// porter de requete
	EntityManager em;

	/**
	* @param mail
	* @param nom
	* @return
	*/
	public List<Direction> login(String login,String password){
	
		List<Direction> listeDirection = new ArrayList<Direction>();
		emf = Persistence.createEntityManagerFactory("gestion-etu");
		em = emf.createEntityManager();
		
		Query req = em
				.createQuery("select d from Direction d where login ='"+login+"' and password ='"+password+"'");
		System.out.println(req);
		
		listeDirection = req.getResultList();
		
		System.out.println(listeDirection);
		return listeDirection;
		
	}
}
