package eu.ensup.gestionetudiant.presentation;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import eu.ensup.gestionetudiant.domaine.Direction;
import eu.ensup.gestionetudiant.service.LoginService;

/**
 * Servlet implementation class AuthentificationServlet
 */
@WebServlet("/login")
public class AuthentificationServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AuthentificationServlet() {
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
		String login = request.getParameter("login");
		String password = request.getParameter("password");
		
		Direction directionSession = new Direction(login, password);
		
		List<Direction> directionListe = new ArrayList<Direction>();
		LoginService loginService = new LoginService();
		directionListe = loginService.connection(login, password); 
		
		if (!(directionListe.isEmpty())) {
			request.setAttribute("id", directionListe.get(0).getId());
			RequestDispatcher rs = request.getRequestDispatcher("accueil.jsp");
			HttpSession maSession = request.getSession();
			maSession.setAttribute("directionSession", directionSession);
			rs.forward(request, response);
			
		} else {
			
			RequestDispatcher rs = request.getRequestDispatcher("error.jsp");
			rs.include(request, response);
		}
		doGet(request, response);
	}

}
