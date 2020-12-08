package ec.edu.ups.controllers;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ec.edu.ups.dao.DAOFactory;
import ec.edu.ups.dao.ProductoDAO;
import ec.edu.ups.entidad.Ges_Productos;

/**
 * Servlet implementation class ActualizarProductoController
 */
@WebServlet("/ActualizarProductoController")
public class ActualizarProductoController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private ProductoDAO productoDao;
	private Ges_Productos productos;
	private List<Ges_Productos>listaProductos;
	
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ActualizarProductoController() {
        productoDao = DAOFactory.getFactory().getProductoDAO();
        productos = new Ges_Productos();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String url = null;
		try {
			//int codigo =Integer.valueOf(request.getParameter("id"));
			//System.out.println("El codigo es: "+ codigo);
			
			listaProductos = productoDao.findAll();
			System.out.println("Tamaño de la Lista: " + listaProductos.size());
			request.setAttribute("productos", listaProductos);
			url = "/JSPs/actualizar_productos.jsp";
		} catch (Exception e) {
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
