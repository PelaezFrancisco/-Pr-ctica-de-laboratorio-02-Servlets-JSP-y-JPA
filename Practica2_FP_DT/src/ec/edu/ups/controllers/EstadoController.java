package ec.edu.ups.controllers;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ec.edu.ups.dao.DAOFactory;
import ec.edu.ups.dao.PedidoCabeceraDAO;
import ec.edu.ups.entidad.Ges_Pedido_Cabeceras;

/**
 * Servlet implementation class EstadoController
 */
@WebServlet("/EstadoController")
public class EstadoController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private PedidoCabeceraDAO pedidoCabDao;
	private Ges_Pedido_Cabeceras pedidoCab;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EstadoController() {
        pedidoCabDao= DAOFactory.getFactory().gePedidoCabeceraDAO();
        pedidoCab= new Ges_Pedido_Cabeceras();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		String url= null;
		int codigo =0;
		try {
			codigo = Integer.valueOf(request.getParameter("idPedido"));
			System.out.println("El pedio es "+ codigo);
			
			pedidoCab= pedidoCabDao.read(codigo);
			request.setAttribute("pedidoC", pedidoCab);
			url= "/private/admin/actualizar_estado.jsp";
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
