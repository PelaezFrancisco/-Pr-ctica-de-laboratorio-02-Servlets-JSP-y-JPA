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

/**
 * Servlet implementation class BuscarProductoController2
 */
@WebServlet("/BuscarProductoController2")
public class BuscarProductoController2 extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private ProductoDAO productoDao;
	private Ges_Productos productos;
	
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public BuscarProductoController2() {
        super();
        productoDao= DAOFactory.getFactory().getProductoDAO();
        productos = new Ges_Productos();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		String url = null;
		String pro = null;
		try {
			pro = request.getParameter("product");
			System.out.println("Producto: "+ pro);
			productos = productoDao.buscarP(pro);
			request.setAttribute("producto", productos);
			
			url="/private/admin/buscar_producto.jsp";
		} catch (Exception e) {
			e.printStackTrace();
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
