package eu.ensup.gestionetudiant.presentation;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import eu.ensup.gestionetudiant.domaine.Cours;
import eu.ensup.gestionetudiant.domaine.Etudiant;
import eu.ensup.gestionetudiant.service.CoursService;
import eu.ensup.gestionetudiant.service.DirectionService;

/**
 * Servlet implementation class AjouterEtudiantCoursServlet
 */
@WebServlet("/ajouter-etudiant-cours")
public class AjouterEtudiantCoursServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AjouterEtudiantCoursServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		Cours cours = new Cours();
		Etudiant etudiant = new Etudiant();
		
		DirectionService gestionService = new DirectionService();
		List<Etudiant> listeEtudiant = gestionService.listerEtudiants();
		
		CoursService coursService = new CoursService();
		List<Cours> listeCours = coursService.listerCours();
		
		HttpSession etudiantSession = request.getSession();
		etudiantSession.setAttribute("listeEtudiant", listeEtudiant);
		
		HttpSession coursSession = request.getSession();
		coursSession.setAttribute("listeCours", listeCours);
		request.setAttribute("listeEtudiant", listeEtudiant);
		request.setAttribute("listeCours", listeCours);
		
		request.getRequestDispatcher("ajouterEtudiantCours.jsp").forward(request, response);
			
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		DirectionService gestionService = new DirectionService();
		CoursService coursService = new CoursService();
		
		int idEtudiant = Integer.parseInt(request.getParameter("etudiant")); 
		int idCours = Integer.parseInt(request.getParameter("cours"));
		
		Etudiant listeEtudiant = gestionService.lireInfoEtudiant(idEtudiant);
				
		Cours listeCours = coursService.lireInfoCours(idCours);
		
		int ajoutEtudiantCours = gestionService.ajouterEtudiantCours(listeEtudiant, listeCours);
		
		if (ajoutEtudiantCours > 0) {
			System.out.println(ajoutEtudiantCours);
			RequestDispatcher rs = request.getRequestDispatcher("messageAjoutEtudiantCours.jsp");
			
			rs.forward(request, response);
		} else {
			
			RequestDispatcher rs = request.getRequestDispatcher("erreurAjoutEtudiantCours.jsp");
			rs.include(request, response);
		}
	}

}
