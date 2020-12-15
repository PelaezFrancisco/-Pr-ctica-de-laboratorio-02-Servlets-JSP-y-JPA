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
import ec.edu.ups.dao.EmpresaDAO;
import ec.edu.ups.dao.PedidoCabeceraDAO;
import ec.edu.ups.dao.PersonaDAO;
import ec.edu.ups.entidad.Ges_Empresas;
import ec.edu.ups.entidad.Ges_Pedido_Cabeceras;
import ec.edu.ups.entidad.Persona;

/**
 * Servlet implementation class ListarPedidosController
 */
@WebServlet("/ListarPedidosController")
public class ListarPedidosController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private PedidoCabeceraDAO pedidoCabDao;
	private List<Ges_Pedido_Cabeceras> listaPedidoC;
	private PersonaDAO personaDao;
	private EmpresaDAO empresaDao;
	private Persona persona;
	private Ges_Empresas empresa;
	
	
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ListarPedidosController() {
        pedidoCabDao = DAOFactory.getFactory().gePedidoCabeceraDAO();
        personaDao= DAOFactory.getFactory().getPersonaDAO();
        empresaDao = DAOFactory.getFactory().getEmpresaDAO();
        persona= new Persona();
        empresa = new Ges_Empresas();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		String url= null;
		int codigo=0;
		ArrayList<Ges_Pedido_Cabeceras> listaPedC = new ArrayList<Ges_Pedido_Cabeceras>();
		try {
			codigo= Integer.valueOf(request.getParameter("id"));
			listaPedidoC = pedidoCabDao.findAll();
			System.out.println("Tamano d ela lista :" +listaPedidoC.size());
			
			for (int i = 0; i < listaPedidoC.size(); i++) {
				if (listaPedidoC.get(i).getPersona().getEmpresa().getEmp_id()==codigo) {
					listaPedC.add(listaPedidoC.get(i));
				}
				request.setAttribute("pedidos", listaPedC);
				url = "/private/admin/listar_pedidos.jsp";
				
			}
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
