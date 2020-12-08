package ec.edu.ups.controllers;

import java.io.IOException;

import javax.persistence.metamodel.SetAttribute;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ec.edu.ups.dao.DAOFactory;
import ec.edu.ups.dao.EmpresaDAO;
import ec.edu.ups.dao.ProductoDAO;
import ec.edu.ups.entidad.Ges_Empresas;
import ec.edu.ups.entidad.Ges_Productos;

/**
 * Servlet implementation class CrearProducto2
 */
@WebServlet("/CrearProducto2")
public class CrearProducto2 extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private EmpresaDAO empresaDao;
	private Ges_Empresas empresas;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CrearProducto2() {
        empresaDao= DAOFactory.getFactory().getEmpresaDAO();
        empresas = new Ges_Empresas();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		int idE=0;
		String url=null;
		try {
			idE= Integer.valueOf(request.getParameter("idE"));
			empresas= empresaDao.read(idE);
			request.setAttribute("empresa", empresas);
			url = "/private/admin/AgregarProducto.jsp";
			
		} catch (Exception e) {
			System.out.println("ERROR DE INICIO DE SESION");
			e.printStackTrace();
			url = "/JSPs/error.jsp";
		}
		getServletContext().getRequestDispatcher(url).forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
