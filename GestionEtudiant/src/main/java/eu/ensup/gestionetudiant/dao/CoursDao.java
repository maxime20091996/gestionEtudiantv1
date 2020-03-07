package eu.ensup.gestionetudiant.dao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

import eu.ensup.gestionetudiant.domaine.Cours;
import eu.ensup.gestionetudiant.domaine.Etudiant;

public class CoursDao implements ICoursDao {
	// ouverture unité de persistance
	EntityManagerFactory emf;
	// porter de requete
	EntityManager em;
	
	public List<Cours> listerCours() {
		emf = Persistence.createEntityManagerFactory("gestion-etu");
		em = emf.createEntityManager();
		List<Cours> cours = new ArrayList();
		Query req = em.createQuery("select cours from Cours cours");
		cours = req.getResultList();
		return cours;
	}

	public int creerCours(Cours cours) {
		emf = Persistence.createEntityManagerFactory("gestion-etu");
		em = emf.createEntityManager();
		EntityTransaction tx = em.getTransaction();
		try {
			// 1 débuter la transaction
			tx.begin();
			// 2 Effectuer l'opération
			em.persist(cours);
			// 3 valider la transaction
			tx.commit();
			// 4 fermet l'unité de persistence
			em.close();
			emf.close();
			return 1;
		} catch (Exception e) {
			System.err.println(e.getMessage());
			tx.rollback();
			return 0;
		}
	}
	
	public Cours lireInfoCours(int idCours) {
		emf = Persistence.createEntityManagerFactory("gestion-etu");
		em = emf.createEntityManager();
		Cours cours = em.getReference(Cours.class, idCours);
		return cours;
	}

}
