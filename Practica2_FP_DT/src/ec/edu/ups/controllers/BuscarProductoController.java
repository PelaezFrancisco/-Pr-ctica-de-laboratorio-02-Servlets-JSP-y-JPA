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
 * Servlet implementation class BuscarProductoController
 */
@WebServlet("/BuscarProductoController")
public class BuscarProductoController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private ProductoDAO productoDao;
	private List<Ges_Productos> listaP;
	
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public BuscarProductoController() {
        productoDao= DAOFactory.getFactory().getProductoDAO();
        
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		String url = null;
		int codigoE= 0;
		
		try {
			codigoE= Integer.valueOf(request.getParameter("idE"));
			System.out.println("El codigo de la empresa es: "+ codigoE);
			listaP= productoDao.listaP(codigoE);
			request.setAttribute("producto", listaP);
			url = "/private/admin/buscar.jsp";
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
