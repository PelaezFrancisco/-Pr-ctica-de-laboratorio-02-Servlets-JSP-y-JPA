package ec.edu.ups.jpa;

import ec.edu.ups.dao.EmpresaDAO;
import ec.edu.ups.entidad.Ges_Empresas;

public class JPAEmpresaDAO extends JPAGenericDAO<Ges_Empresas, Integer, String> implements EmpresaDAO{

	public JPAEmpresaDAO() {
		super(Ges_Empresas.class);
		// TODO Auto-generated constructor stub
	}

}
