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

/**
 * @author benja
 * Classe DAO contenant toutes les méthodes utiles à la direction concernant la gestion des étudiants
 */
public class DirectionDao implements IDirectionDao {
		// ouverture unité de persistance
		EntityManagerFactory emf;
		// porter de requete
		EntityManager em;
		
	public List<Etudiant> listerEtudiants() {
		emf = Persistence.createEntityManagerFactory("gestion-etu");
		em = emf.createEntityManager();
		List<Etudiant> etu = new ArrayList();
		Query req = em.createQuery("select etu from Etudiant etu");
		etu = req.getResultList();
		return etu;
	}

	public int creerEtudiant(Etudiant etu) {
		emf = Persistence.createEntityManagerFactory("gestion-etu");
		em = emf.createEntityManager();
		EntityTransaction tx = em.getTransaction();
		try {
			// 1 débuter la transaction
			tx.begin();
			// 2 Effectuer l'opération
			em.persist(etu);
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

	public int modifierEtudiant(Etudiant etu) {
		emf = Persistence.createEntityManagerFactory("gestion-etu");
		em = emf.createEntityManager();
		EntityTransaction tx = em.getTransaction();
		try {
			// 1 débuter la transaction
			tx.begin();
			// 2 Effectuer l'opération
			em.merge(etu);
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

	public int supprimerEtudiant(int idEtudiant) {
		emf = Persistence.createEntityManagerFactory("gestion-etu");
		em = emf.createEntityManager();
		EntityTransaction tx = em.getTransaction();
		try {
			// 1 débuter la transaction
			tx.begin();
			// 2 Effectuer l'opération
			em.remove(em.getReference(Etudiant.class, idEtudiant));
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

	public Etudiant lireInfoEtudiant(int idEtudiant) {
		emf = Persistence.createEntityManagerFactory("gestion-etu");
		em = emf.createEntityManager();
		Etudiant etudiant = em.getReference(Etudiant.class, idEtudiant);
		return etudiant;
	}

	public int ajouterEtudiantCours(Etudiant etu, Cours c) {
		emf = Persistence.createEntityManagerFactory("gestion-etu");
		em = emf.createEntityManager();
		EntityTransaction tx = em.getTransaction();
		etu.getCours().add(c);
		try {
			// 1 débuter la transaction
			tx.begin();
			// 2 Effectuer l'opération
			em.merge(etu);
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

}
