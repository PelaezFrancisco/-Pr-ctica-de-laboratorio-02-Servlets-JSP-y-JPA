package ec.edu.ups.jpa;

import ec.edu.ups.dao.PedidoDetalleDAO;
import ec.edu.ups.entidad.Ges_Pedido_Detalles;

public class JPADAOPedidoDetalle extends JPAGenericDAO<Ges_Pedido_Detalles, Integer, String> implements PedidoDetalleDAO{

	public JPADAOPedidoDetalle() {
		super(Ges_Pedido_Detalles.class);
		// TODO Auto-generated constructor stub
	}

}
