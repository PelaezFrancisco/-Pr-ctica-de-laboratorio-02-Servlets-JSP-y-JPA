package ec.edu.ups.dao;

import java.util.List;

import ec.edu.ups.entidad.Ges_Productos;

public interface GenericDAO<T, ID, EMAIL> {

    public void create(T entity);

    public T read(ID id);

    public void update(T entity);

    public void delete(T entity);

    public void deleteByID(ID id);
    
    public List<T> findAll();
    
    public T find_email(EMAIL email);

	public List<Ges_Productos> listaP(int codigo);
}

