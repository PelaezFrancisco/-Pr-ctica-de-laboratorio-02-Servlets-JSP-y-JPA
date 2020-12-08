package ec.edu.ups.controllers;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ec.edu.ups.dao.DAOFactory;
import ec.edu.ups.dao.ProductoDAO;
import ec.edu.ups.entidad.Ges_Productos;
import ec.edu.ups.entidad.Persona;

/**
 * Servlet implementation class EliminarProductoController2
 */
@WebServlet("/EliminarProductoController2")
public class EliminarProductoController2 extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private ProductoDAO productoDao;
	private Ges_Productos productos;
	
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EliminarProductoController2() {
        productoDao= DAOFactory.getFactory().getProductoDAO();
        productos= new Ges_Productos();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String url = null;
		try {
		   productos = productoDao.read(Integer.valueOf(request.getParameter("idPro")));
		    productoDao.delete(productos);
		    url = "/index.html";
		} catch (Exception e) {
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
