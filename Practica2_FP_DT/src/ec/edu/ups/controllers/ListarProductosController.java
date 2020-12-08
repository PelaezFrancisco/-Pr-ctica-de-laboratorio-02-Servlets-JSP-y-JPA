package ec.edu.ups.controllers;

import java.io.IOException;
import java.util.ArrayList;
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
 * Servlet implementation class ListarProductosController
 */
@WebServlet("/ListarProductosController")
public class ListarProductosController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private ProductoDAO productoDao;
	private List<Ges_Productos> listaProductos;
	private CategoriaDAO categoriaDao;
	private EmpresaDAO empresa;
	
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ListarProductosController() {
        productoDao = DAOFactory.getFactory().getProductoDAO();
        
        
        
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		String url= null;
		int idEmp=0;
		ArrayList<Ges_Productos> prolist = new ArrayList<Ges_Productos>();
		try {
        //Id de empresa
        idEmp=Integer.parseInt(request.getParameter("idE"));
        System.out.println("ID de la Empresa "+ idEmp);
        //Traemos lista de productos de la empresa
        listaProductos = productoDao.findAll();

        for (int i = 0; i < listaProductos.size(); i++) {
            if (listaProductos.get(i).getEmpresa().getEmp_id()==idEmp) {
            	System.out.println("Lista Productos "+ i);
                prolist.add(listaProductos.get(i));
            }
        }
			request.setAttribute("productos", prolist);
			url = "/private/admin/listar_productos.jsp";
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
