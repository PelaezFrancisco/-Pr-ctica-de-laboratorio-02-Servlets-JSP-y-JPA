package ec.edu.ups.controllers;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ec.edu.ups.dao.DAOFactory;
import ec.edu.ups.dao.EmpresaDAO;
import ec.edu.ups.entidad.Ges_Empresas;

/**
 * Servlet implementation class CrearEmpresaController
 */
@WebServlet("/CrearEmpresaController")
public class CrearEmpresaController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private EmpresaDAO empresaDao;
	private Ges_Empresas empresa ;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CrearEmpresaController() {
    	empresaDao = DAOFactory.getFactory().getEmpresaDAO();
    	empresa= new Ges_Empresas();
    	
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
	protected void doPost(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		String url = null;
		try {
			empresa.setEmp_id(Integer.valueOf(request.getParameter("id")));
			empresa.setEmp_nombre(request.getParameter("nombre"));
			empresa.setEmp_ruc(request.getParameter("ruc"));
			empresa.setEmp_direccion(request.getParameter("direccion"));
			empresa.setEmp_telefono(request.getParameter("telefono"));
			empresa.setEmp_email(request.getParameter("email"));
			empresaDao.create(empresa);
			url = "/index.html";
		} catch (Exception e) {
			e.printStackTrace();
			url = "/JSPs/error.jsp";
		}
		getServletContext().getRequestDispatcher(url).forward(request, response);
		
	}

}
