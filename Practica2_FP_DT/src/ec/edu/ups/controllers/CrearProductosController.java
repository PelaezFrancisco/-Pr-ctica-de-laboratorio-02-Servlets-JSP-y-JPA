package ec.edu.ups.controllers;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import ec.edu.ups.dao.CategoriaDAO;
import ec.edu.ups.dao.DAOFactory;
import ec.edu.ups.dao.EmpresaDAO;
import ec.edu.ups.dao.PersonaDAO;
import ec.edu.ups.dao.ProductoDAO;
import ec.edu.ups.entidad.Ges_Categorias;
import ec.edu.ups.entidad.Ges_Empresas;
import ec.edu.ups.entidad.Ges_Productos;
import ec.edu.ups.entidad.Persona;
import ec.edu.ups.jpa.JPADAOFactory;

/**
 * Servlet implementation class CrearProductosController
 */
@WebServlet("/CrearProductosController")
public class CrearProductosController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private ProductoDAO productoDao;
	private CategoriaDAO categoriaDao;
	private EmpresaDAO empresaDao;
	private PersonaDAO personaDao;
	private Ges_Productos producto;
	private Ges_Empresas empresa;
	private Ges_Categorias categoria;
	private Persona persona;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CrearProductosController() {
        productoDao = DAOFactory.getFactory().getProductoDAO();
        categoriaDao= DAOFactory.getFactory().getCategoriaDAO();
        empresaDao= DAOFactory.getFactory().getEmpresaDAO();
        personaDao = DAOFactory.getFactory().getPersonaDAO();
        producto= new Ges_Productos();
        categoria = new Ges_Categorias();
        empresa = new Ges_Empresas();
        persona = new Persona();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		categoriaDao= DAOFactory.getFactory().getCategoriaDAO();
		String url = null;
		int codigo = 0;
		int categoriaID=0;
		int empresaID=0;
		int idP=0;
		int idEmpresa=0;
		
		try {
			idEmpresa= Integer.valueOf(request.getParameter("empId"));
			System.out.println("Parametro Empresa Admin: "+ idEmpresa);
			producto.setPro_id(codigo);
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
			producto.setPro_imagen("images/"+request.getParameter("imagen"));
			if (empresaID == idEmpresa) {
				productoDao.create(producto);
				request.setAttribute("empresa", empresa);
				url = "/private/admin/inicio_admin.jsp";
			}else {
				url = "/JSPs/error.jsp";
			}
			
		} catch (Exception e) {
			e.printStackTrace();
			url = "/JSPs/error.jsp";
		}
		getServletContext().getRequestDispatcher(url).forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		
	}
	
	 private String getFileName(Part part) {
	        String contentDisp = part.getHeader("content-disposition");
	        //System.out.println("content-disposition header= "+contentDisp);
	        String[] tokens = contentDisp.split(";");
	        for (String token : tokens) {
	        	//System.out.println("Este es el famoso token="+token);
	        	
	        	String var = token.trim().substring(6);
	        	System.out.println("Token con trim= "+var);
	        	
	            if (var.startsWith("imagen")) {
	            	//System.out.println("Si esta como imagen");
	                return token.substring(token.indexOf("=") + 2, token.length()-1);
	            }
	        }
	        return "";
	    }

}
