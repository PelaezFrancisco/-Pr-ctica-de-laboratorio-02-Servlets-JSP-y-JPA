package ec.edu.ups.controllers;

import java.io.IOException;
import java.util.List;

import javax.security.auth.message.callback.PrivateKeyCallback.Request;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ec.edu.ups.dao.DAOFactory;
import ec.edu.ups.dao.PedidoCabeceraDAO;
import ec.edu.ups.entidad.Ges_Pedido_Cabeceras;

/**
 * Servlet implementation class CambiarEstado
 */
@WebServlet("/CambiarEstado")
public class CambiarEstado extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private PedidoCabeceraDAO pedidoCabeceraDao ;
	private Ges_Pedido_Cabeceras pedidoC;
    
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CambiarEstado() {
        pedidoCabeceraDao = DAOFactory.getFactory().gePedidoCabeceraDAO();
        pedidoC = new Ges_Pedido_Cabeceras();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		String url = null;
		int idC= 0;
		
		try {
			idC = Integer.valueOf(request.getParameter("pedCab"));
			
			System.out.println("Pedi oCabecera:"+ idC);
			pedidoC= pedidoCabeceraDao.read(idC);
			
			String estado = request.getParameter("estado");
			System.out.println("El estado es "+ estado);
			
		    //actualizar
		   pedidoC.setPed_estado(request.getParameter("estado").charAt(0));
		   pedidoCabeceraDao.update(pedidoC);
		   
		  url = "/private/admin/listar_pedidos.jsp";
		  
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
