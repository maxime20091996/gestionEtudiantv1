package eu.ensup.gestionetudiant.presentation;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import eu.ensup.gestionetudiant.domaine.Etudiant;
import eu.ensup.gestionetudiant.service.DirectionService;

/**
 * Servlet implementation class ModifierEtudiantServlet
 */
@WebServlet("/recherche-modifier-etudiant")
public class RechercheModifierEtudiantServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RechercheModifierEtudiantServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		RequestDispatcher rs = request.getRequestDispatcher("rechercheModificationEtudiant.jsp");
		rs.forward(request, response);		
		}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		int idEtudiant = Integer.parseInt(request.getParameter("idEtudiant")); 

//		String nom = request.getParameter("nom");
//		String prenom = request.getParameter("prenom");
//		String mail = request.getParameter("mail");
//		String adresse = request.getParameter("adresse");
//		int telephone = Integer.parseInt(request.getParameter("telephone")); 
//		String dateNaissance = request.getParameter("dateNaissance");
//		
		DirectionService service = new DirectionService();
		Etudiant etudiantRecherche = new Etudiant();
		etudiantRecherche = service.lireInfoEtudiant(idEtudiant);
		
//		Etudiant etudiantModifie = new Etudiant(nom, prenom, mail, adresse, telephone, dateNaissance);
//		int etu = service.modifierEtudiant(etudiantModifie);

		
		if (etudiantRecherche != null) {
			System.out.println(etudiantRecherche);
			RequestDispatcher rs = request.getRequestDispatcher("modificationEtudiant.jsp");
			HttpSession maSession = request.getSession();
			maSession.setAttribute("etudiant", etudiantRecherche);
//			getServletContext().setAttribute("idEtudiant", idEtudiant);
			rs.forward(request, response);
		} else {
			
			RequestDispatcher rs = request.getRequestDispatcher("rechercheModificationEtudiant.jsp");
			rs.include(request, response);
		}
	}

}
