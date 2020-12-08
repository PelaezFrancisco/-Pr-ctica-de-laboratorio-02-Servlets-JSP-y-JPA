package ec.edu.ups.controllers;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ec.edu.ups.dao.DAOFactory;
import ec.edu.ups.dao.ProductoDAO;
import ec.edu.ups.modelo.Producto;

/**
 * Servlet implementation class CompraController
 */
@WebServlet("/CompraController")
public class CompraController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private ProductoDAO productoDao;
	private ArrayList<Producto>listaProducto = new ArrayList<Producto>();
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CompraController() {
    	 productoDao = DAOFactory.getFactory().getProductoDAO();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String url = null;
		
		int id = Integer.parseInt(request.getParameter("id"));
		//System.out.println("parametro recibido en CompraController= "+id);
		try {
			//System.out.println("El id que manda a PorEmpPer"+id);
			listaProducto = (ArrayList<Producto>) productoDao.ProEmpPer(id);
			//System.out.println("Tamaño de la Lista Productos: " + listaProducto.size());
			request.setAttribute("productos", listaProducto);
			url = "/private/user/compras.jsp";
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
