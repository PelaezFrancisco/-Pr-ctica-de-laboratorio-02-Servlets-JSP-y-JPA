package ec.edu.ups.controllers;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ec.edu.ups.dao.DAOFactory;
import ec.edu.ups.dao.PedidoDetalleDAO;
import ec.edu.ups.entidad.Ges_Pedido_Detalles;

/**
 * Servlet implementation class PedidoDetalleController
 */
@WebServlet("/PedidoDetalleController")
public class PedidoDetalleController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private PedidoDetalleDAO pedidoDetalleDao;
	private Ges_Pedido_Detalles pedidoD;
	private List<Ges_Pedido_Detalles>pedidoDetalle;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public PedidoDetalleController() {
        pedidoDetalleDao = DAOFactory.getFactory().getPedidoDetalleDAO();
        pedidoD= new Ges_Pedido_Detalles();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		String url = null;
		
		try {
			int idPedido = Integer.valueOf(request.getParameter("idPedido"));
			System.out.println("El numeor de pedido es :" + idPedido);
			pedidoDetalle=pedidoDetalleDao.pedidoDet(idPedido);
			request.setAttribute("pedidosD", pedidoDetalle);
			url= "/private/admin/listar_pedidosD.jsp";
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
