package ec.edu.ups.jpa;

import ec.edu.ups.dao.PersonaDAO;
import ec.edu.ups.entidad.Persona;

public class JPAPersonaDAO extends JPAGenericDAO<Persona, Integer, String> implements PersonaDAO {
    
    public JPAPersonaDAO() {
	super(Persona.class);
    }
    
}

