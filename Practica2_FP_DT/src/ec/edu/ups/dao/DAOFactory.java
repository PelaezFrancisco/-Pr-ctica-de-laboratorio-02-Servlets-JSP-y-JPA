package ec.edu.ups.dao;

import ec.edu.ups.jpa.JPADAOFactory;

public abstract class DAOFactory {
    // Sería mejor por inyección de objetos
    protected static DAOFactory factory = new JPADAOFactory();

    public static DAOFactory getFactory() {
	return factory;
    }

    public abstract PersonaDAO getPersonaDAO();
    
    public abstract EmpresaDAO getEmpresaDAO();

	public abstract ProductoDAO getProductoDAO() ;

	public abstract CategoriaDAO getCategoriaDAO();	
}
