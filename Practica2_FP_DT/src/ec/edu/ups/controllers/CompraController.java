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
import ec.edu.ups.entidad.Ges_Productos;

/**
 * Servlet implementation class CompraController
 */
@WebServlet("/CompraController")
public class CompraController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private ProductoDAO productoDao;
	private List<Ges_Productos> listaProducto = new ArrayList<Ges_Productos>();
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
			listaProducto = productoDao.findAll();
			
			ArrayList<Ges_Productos> prolist = new ArrayList();
			for (int i = 0; i < listaProducto.size(); i++) {
				if (listaProducto.get(i).getEmpresa().getEmp_id()==id) {
					prolist.add(listaProducto.get(i));
				}
			}
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
