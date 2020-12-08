package ec.edu.ups.controllers;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.GregorianCalendar;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ec.edu.ups.dao.DAOFactory;
import ec.edu.ups.dao.PersonaDAO;
import ec.edu.ups.entidad.Persona;


/**
 * Servlet implementation class ActualizarPersonaController
 */
@WebServlet("/ActualizarPersonaController")
public class ActualizarPersonaController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private PersonaDAO personaDao;	

	public ActualizarPersonaController() {
	    personaDao = DAOFactory.getFactory().getPersonaDAO();		
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String url = null;
		try {
		    Persona persona = personaDao.read(Integer.valueOf(request.getParameter("codigo")));
		    //actualizar
		    //persona.setNombre(request.getParameter("nombre"));
		    //persona.setApellido(request.getParameter("apellido"));
		    String fecha = request.getParameter("fechaNacimiento");
		    //Date date1 = new SimpleDateFormat("dd/MM/yyyy").parse(fecha);
		   // GregorianCalendar cal = new GregorianCalendar();
		   // cal.setTime(date1);
		   // persona.setFechaNacimiento(cal);		    
		    personaDao.update(persona);

			url = "/index.html";
		} catch (Exception e) {
			url = "/JSPs/error.jsp";
		}
		getServletContext().getRequestDispatcher(url).forward(request, response);
	}

}
