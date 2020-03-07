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
@WebServlet("/modifier-etudiant")
public class ModifierEtudiantServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ModifierEtudiantServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		int id = Integer.parseInt(request.getParameter("idEtudiant"));
		String nom = request.getParameter("nom");
		String prenom = request.getParameter("prenom");
		String mail = request.getParameter("mail");
		String adresse = request.getParameter("adresse");
		int telephone = Integer.parseInt(request.getParameter("telephone")); 
		String dateNaissance = request.getParameter("dateNaissance");
				
		DirectionService service = new DirectionService();
		
		Etudiant etudiantModifie = new Etudiant(id, nom, prenom, mail, adresse, telephone, dateNaissance);
		int etu = service.modifierEtudiant(etudiantModifie);
		
		if (etu < 0) {
			System.out.println(etu);
			RequestDispatcher rs = request.getRequestDispatcher("accueil.jsp");
			
			rs.forward(request, response);
		} else {
			
			RequestDispatcher rs = request.getRequestDispatcher("rechercheModificationEtudiant.jsp");
			rs.include(request, response);
		}
	}

}
