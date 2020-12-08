package ec.edu.ups.controllers;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ec.edu.ups.dao.DAOFactory;
import ec.edu.ups.dao.PersonaDAO;
import ec.edu.ups.entidad.Persona;

/**
 * Servlet implementation class EliminarPersonaController
 */
@WebServlet("/EliminarPersonaController")
public class EliminarPersonaController extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private PersonaDAO personaDao;    

    public EliminarPersonaController() {
	personaDao = DAOFactory.getFactory().getPersonaDAO();	
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
	    throws ServletException, IOException {

	String url = null;
	try {
	    Persona persona = personaDao.read(Integer.valueOf(request.getParameter("codigo")));	    
	    personaDao.delete(persona);

	    url = "/index.html";
	} catch (Exception e) {
	    url = "/JSPs/error.jsp";
	}
	getServletContext().getRequestDispatcher(url).forward(request, response);
    }
}
