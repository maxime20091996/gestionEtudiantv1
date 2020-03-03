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
 * Servlet implementation class DetailEtudiantServlet
 */
@WebServlet("/detail-etudiant")
public class DetailEtudiantServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DetailEtudiantServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
		// TODO Auto-generated method stub
				response.getWriter().append("Served at: ").append(request.getContextPath());
				
				
				
				int idEtudiant = Integer.parseInt(request.getParameter("idEtudiant")); 
				DirectionService service = new DirectionService();
				Etudiant etudiant = new Etudiant();
				
				if (idEtudiant > 0) {
					etudiant = service.lireInfoEtudiant(idEtudiant);
					RequestDispatcher rs = request.getRequestDispatcher("detailEtudiant.jsp");
					HttpSession maSession = request.getSession();
					maSession.setAttribute("etudiant", etudiant);
					rs.forward(request, response);
				} else {
					
					RequestDispatcher rs = request.getRequestDispatcher("searchEtudiant.jsp");
					rs.include(request, response);
				}
	}

}
