package ec.edu.ups.jpa;

import java.util.ArrayList;
import java.util.List;

import ec.edu.ups.dao.ProductoDAO;
import ec.edu.ups.entidad.Ges_Productos;

public class JPAProductoDAO extends JPAGenericDAO<Ges_Productos, Integer> implements ProductoDAO {

	public JPAProductoDAO() {
		super(Ges_Productos.class);
	}


}
