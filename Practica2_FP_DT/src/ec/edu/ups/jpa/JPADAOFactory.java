 package ec.edu.ups.jpa;

import ec.edu.ups.dao.PersonaDAO;
import ec.edu.ups.dao.ProductoDAO;
import ec.edu.ups.dao.CategoriaDAO;
import ec.edu.ups.dao.DAOFactory;
import ec.edu.ups.dao.EmpresaDAO;

public class JPADAOFactory extends DAOFactory {

	@Override
	public PersonaDAO getPersonaDAO() {
		return new JPAPersonaDAO();
	}

	@Override
	public EmpresaDAO getEmpresaDAO() {
		// TODO Auto-generated method stub
		return new JPAEmpresaDAO();
	}
	@Override
	public ProductoDAO getProductoDAO() {
		// TODO Auto-generated method stub
		return new JPAProductoDAO();
	}

	@Override
	public CategoriaDAO getCategoriaDAO() {
		// TODO Auto-generated method stub
		return new JPADAOCategoria();
	}

}
