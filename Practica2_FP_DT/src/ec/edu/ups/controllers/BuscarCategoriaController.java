package ec.edu.ups.controllers;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ec.edu.ups.dao.CategoriaDAO;
import ec.edu.ups.dao.DAOFactory;
import ec.edu.ups.entidad.Ges_Categorias;

/**
 * Servlet implementation class BuscarCategoriaController
 */
@WebServlet("/BuscarCategoriaController")
public class BuscarCategoriaController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private CategoriaDAO categoriaDao ;
	private Ges_Categorias categoria;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public BuscarCategoriaController() {
        categoriaDao= DAOFactory.getFactory().getCategoriaDAO();
        categoria = new Ges_Categorias();
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
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String url = null;
		try {
		    int codigo = Integer.valueOf(request.getParameter("id"));
		    System.out.println("El codigo de la catwgoria es: "+ codigo);
		    categoria= categoriaDao.read(codigo);
		    request.setAttribute("categoria", categoria);
		    url = "/JSPs/buscar_categoria.jsp";
		} catch (Exception e) {
		    url = "/JSPs/error.jsp";
		    e.printStackTrace();
		}
		getServletContext().getRequestDispatcher(url).forward(request, response);
	    }

}
