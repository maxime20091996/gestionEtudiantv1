package eu.ensup.gestionetudiant.domaine;

import javax.persistence.Entity;

/**
 * @author benja
 * Classe Enseignant héritant de la classe Personne
 */
@Entity
public class Enseignant extends Personne {

	private String matiere;

	public String getMatiere() {
		return matiere;
	}

	public void setMatiere(String matiere) {
		this.matiere = matiere;
	}

	public Enseignant(String nom, String prenom, String mail, String adresse, int telephone, String matiere) {
		super(nom, prenom, mail, adresse, telephone);
		this.matiere = matiere;
	}

	public Enseignant(String nom, String prenom, String mail, String adresse, int telephone) {
		super(nom, prenom, mail, adresse, telephone);
	}

	public Enseignant() {
		super();
	}
}
