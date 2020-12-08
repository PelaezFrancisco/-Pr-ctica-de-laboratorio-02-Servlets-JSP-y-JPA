package ec.edu.ups.controllers;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ec.edu.ups.dao.CategoriaDAO;
import ec.edu.ups.dao.DAOFactory;
import ec.edu.ups.dao.EmpresaDAO;
import ec.edu.ups.dao.ProductoDAO;
import ec.edu.ups.entidad.Ges_Categorias;
import ec.edu.ups.entidad.Ges_Empresas;
import ec.edu.ups.entidad.Ges_Productos;

/**
 * Servlet implementation class ModificarProductosController
 */
@WebServlet("/ModificarProductosController")
public class ModificarProductosController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private ProductoDAO productoDao;
	private CategoriaDAO categoriaDao;
	private EmpresaDAO empresaDao;
	private Ges_Productos producto;
	private Ges_Empresas empresa;
	private Ges_Categorias categoria;
	
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ModificarProductosController() {
    	productoDao = DAOFactory.getFactory().getProductoDAO();
        categoriaDao= DAOFactory.getFactory().getCategoriaDAO();
        empresaDao= DAOFactory.getFactory().getEmpresaDAO();
        producto= new Ges_Productos();
        categoria = new Ges_Categorias();
        empresa = new Ges_Empresas();
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
	protected void doPost(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		
		categoriaDao= DAOFactory.getFactory().getCategoriaDAO();
		String url = null;
		int codigo = 0;
		int categoriaID=0;
		int empresaID=0;
		try {
			producto.setPro_id(Integer.valueOf(request.getParameter("id")));
			producto.setPro_nombre(request.getParameter("nombre"));
			producto.setPro_descripcion(request.getParameter("descrip"));
			producto.setPro_stock(Integer.valueOf(request.getParameter("stock")));
			producto.setPro_precioV(Double.parseDouble(request.getParameter("precioV")));
			//Agregar Categoria
			
			categoriaID=Integer.valueOf(request.getParameter("categ"));
			System.out.println("La categoria es "+ categoriaID);
			categoria = categoriaDao.read(categoriaID);
			producto.setCategoria(categoria);
			
			//Agregar Empresa 
			empresaID= Integer.valueOf(request.getParameter("emp"));
			System.out.println("La empresa es : "+ empresaID);
					
			empresa = empresaDao.read(empresaID);
			producto.setEmpresa(empresa);
			
			producto.setPro_imagen("imagenes/"+request.getParameter("imagen"));
			productoDao.update(producto);
			url = "/index.html";
		} catch (Exception e) {
			e.printStackTrace();
			url = "/JSPs/error.jsp";
		}
		getServletContext().getRequestDispatcher(url).forward(request, response);
	}

}
