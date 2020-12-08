package ec.edu.ups.controllers;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ec.edu.ups.dao.CategoriaDAO;
import ec.edu.ups.dao.DAOFactory;
import ec.edu.ups.dao.EmpresaDAO;
import ec.edu.ups.dao.ProductoDAO;
import ec.edu.ups.entidad.Ges_Productos;

/**
 * Servlet implementation class EliminarProductosController
 */
@WebServlet("/EliminarProductosController")
public class EliminarProductosController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private ProductoDAO productoDao;
	private List<Ges_Productos> listaProductos;
	private CategoriaDAO categoriaDao;
	private EmpresaDAO empresa;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EliminarProductosController() {
    	 productoDao = DAOFactory.getFactory().getProductoDAO();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String url= null;
		try {
			listaProductos= productoDao.findAll();
			System.out.println("Tamano d ela lista :" +listaProductos.size());
			request.setAttribute("productos", listaProductos);
			url = "/JSPs/eliminar_productos.jsp";
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
