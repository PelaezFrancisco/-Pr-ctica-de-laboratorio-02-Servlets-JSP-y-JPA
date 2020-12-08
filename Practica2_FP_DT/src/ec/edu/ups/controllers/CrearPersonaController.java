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

@WebServlet("/CrearPersonaController")
public class CrearPersonaController extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private PersonaDAO personaDao;
    private Persona persona;

    public CrearPersonaController() {
	personaDao = DAOFactory.getFactory().getPersonaDAO();
	persona = new Persona();
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
	    throws ServletException, IOException {

	String url = null;
	try {
	    //persona.setCodigo(Integer.valueOf(request.getParameter("id")));
	    //persona.setCedula(request.getParameter("cedula"));
	    //persona.setNombre(request.getParameter("nombre"));
	    //persona.setApellido(request.getParameter("apellido"));
	    
	    //String fecha = request.getParameter("fechaNacimiento");
	   // Date date1 = new SimpleDateFormat("dd/MM/yyyy").parse(fecha);
	   // GregorianCalendar cal = new GregorianCalendar();
	   //cal.setTime(date1);
	 //   persona.setFechaNacimiento(cal);
	    personaDao.create(persona);

	    url = "/index.html";
	} catch (Exception e) {
	    e.printStackTrace();
	    url = "/JSPs/error.jsp";
	}
	getServletContext().getRequestDispatcher(url).forward(request, response);
    }

}
