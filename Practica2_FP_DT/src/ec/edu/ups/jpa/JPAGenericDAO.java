package ec.edu.ups.jpa;

import java.util.List;
import java.util.function.Predicate;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import ec.edu.ups.dao.GenericDAO;
import ec.edu.ups.entidad.Ges_Productos;

public class JPAGenericDAO<T, ID, EMAIL> implements GenericDAO<T, ID, EMAIL> {
    private Class<T> persistentClass;
    protected EntityManager em;

    public JPAGenericDAO(Class<T> persistentClass) {
	this.persistentClass = persistentClass;
	this.em = Persistence.createEntityManagerFactory("Practica2_FP_DT").createEntityManager();
    }

    @Override
    public void create(T entity) {
	em.getTransaction().begin();
	try {
	    em.persist(entity);
	    em.getTransaction().commit();
	} catch (Exception e) {
	    System.out.println(">>>> ERROR:JPAGenericDAO:create " + e);
	    if (em.getTransaction().isActive())
		em.getTransaction().rollback();
	    e.printStackTrace();
	}
    }

    @Override
    public T read(ID id) {
	return em.find(persistentClass, id);
    }

    @Override
    public void update(T entity) {
	em.getTransaction().begin();
	try {
	    em.merge(entity);
	    em.getTransaction().commit();
	} catch (Exception e) {
	    System.out.println(">>>> ERROR:JPAGenericDAO:update " + e);
	    if (em.getTransaction().isActive())
		em.getTransaction().rollback();
	}
    }

    // entity debe estar en estado de "Managed"
    @Override
    public void delete(T entity) {
	em.getTransaction().begin();
	try {
	    em.remove(entity);
	    em.getTransaction().commit();
	} catch (Exception e) {
	    System.out.println(">>>> ERROR:JPAGenericDAO:delete " + e);
	    if (em.getTransaction().isActive())
		em.getTransaction().rollback();
	}
    }

    @Override
    public void deleteByID(ID id) {
	T entity = this.read(id);
	if (entity != null)
	    this.delete(entity);
    }

    @SuppressWarnings({ "rawtypes", "unchecked" })
    @Override
    public List<T> findAll() {
	em.getTransaction().begin();
	List<T> lista = null;
	try {
	    javax.persistence.criteria.CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
	    cq.select(cq.from(persistentClass));
	    lista = em.createQuery(cq).getResultList();
	    em.getTransaction().commit();
	} catch (Exception e) {
	    e.printStackTrace();
	}
	return lista;

    }

	@Override
	public T find_email(EMAIL email) {
		
		//se crea el criterio de consulta
		CriteriaBuilder criteriabuldier = em.getCriteriaBuilder();
		CriteriaQuery<T> criteriaQuery = criteriabuldier.createQuery(this.persistentClass);
		
		//Se establece la clausula de from
		Root<T> root = criteriaQuery.from(this.persistentClass);
		
		//Se establece la clusula de select
		criteriaQuery.select(root);
		
		//Se configuran predicados
		javax.persistence.criteria.Predicate predicate = criteriabuldier.like(root.get("per_email").as(String.class), email.toString());
		
		//javax.persistence.criteria.Predicate sig = criteriabuldier.like(root.get("per_email").as(String.class), email.toString());
		
		//predicate=criteriabuldier.
		
		//Se crea el where
		criteriaQuery.where(predicate);
		
		//Se crea el resultado
		TypedQuery<T> tq = em.createQuery(criteriaQuery);
		
		
		return tq.getSingleResult();
	}
	
	@Override
	public List<Ges_Productos> listaP (int codigo){
		String jpql1 = "Select pro FROM Ges_Productos pro WHERE pro.empresa.emp_id="+codigo;
		List<Ges_Productos> productos = em.createQuery(jpql1).getResultList();
		return productos;	
	}
	
	@Override
	public T buscarP(String nombre) {
		String jpql1="Select pro FROM Ges_Productos pro WHERE pro.pro_nombre= '"+nombre+"'";
		Query query = em.createQuery(jpql1);
		Ges_Productos producto = (Ges_Productos)query.getSingleResult();
		return (T) producto;
		
	}

	 
}