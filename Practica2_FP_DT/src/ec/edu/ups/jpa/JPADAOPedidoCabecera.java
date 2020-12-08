package ec.edu.ups.jpa;

import ec.edu.ups.dao.PedidoCabeceraDAO;
import ec.edu.ups.entidad.Ges_Pedido_Cabeceras;

public class JPADAOPedidoCabecera extends JPAGenericDAO<Ges_Pedido_Cabeceras, Integer, String> implements PedidoCabeceraDAO {

	public JPADAOPedidoCabecera() {
		super(Ges_Pedido_Cabeceras.class);
		// TODO Auto-generated constructor stub
	}

}
