package ec.edu.ups.jpa;

import ec.edu.ups.dao.CategoriaDAO;
import ec.edu.ups.entidad.Ges_Categorias;

public class JPADAOCategoria extends JPAGenericDAO<Ges_Categorias, Integer, String> implements CategoriaDAO{

	public JPADAOCategoria() {
		super(Ges_Categorias.class);
		// TODO Auto-generated constructor stub
	}

}
