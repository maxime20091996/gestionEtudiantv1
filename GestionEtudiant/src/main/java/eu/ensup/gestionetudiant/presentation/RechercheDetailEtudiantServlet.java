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
 * Servlet implementation class RechercheDetailEtudiantServlet
 */
@WebServlet("/recherche-detail-etudiant")
public class RechercheDetailEtudiantServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RechercheDetailEtudiantServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		RequestDispatcher rs = request.getRequestDispatcher("searchEtudiant.jsp");
		rs.forward(request, response);	
		}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		int idEtudiant = Integer.parseInt(request.getParameter("idEtudiant")); 
		DirectionService service = new DirectionService();
		Etudiant etudiant = new Etudiant();
		etudiant = service.lireInfoEtudiant(idEtudiant);
		
		if (etudiant != null) {
			System.out.println(etudiant);
			RequestDispatcher rs = request.getRequestDispatcher("detailEtudiant.jsp");
			HttpSession maSession = request.getSession();
			maSession.setAttribute("etudiant", etudiant);
//			getServletContext().setAttribute("idEtudiant", idEtudiant);
			rs.forward(request, response);
		} else {
			
			RequestDispatcher rs = request.getRequestDispatcher("searchEtudiant.jsp");
			rs.include(request, response);
		}
	}

}
