package ec.edu.ups.controllers;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class CerrarSesionController
 */
@WebServlet("/CerrarSesionController")
public class CerrarSesionController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CerrarSesionController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		System.out.println("ENTRA A CERRAR SESION");
		HttpSession session = request.getSession(false);
		System.out.println("Sesion antes de cerrar"+session.getAttribute("mail"));
		if (session != null) {
			System.out.println("Se remueven los atributos");
			session.removeAttribute("mail");
			session.removeAttribute("password");
			session.setMaxInactiveInterval(1);
		}
		//System.out.println("Sesion despues de cerrar"+session.getAttribute("mail"));
		String url= "/index.html";
		getServletContext().getRequestDispatcher(url).forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		System.out.println("ENTRA A CERRAR SESION2");
		doGet(request, response);
	}

}
