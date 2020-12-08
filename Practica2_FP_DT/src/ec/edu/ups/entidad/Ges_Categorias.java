package ec.edu.ups.entidad;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.*;


/**
 * Entity implementation class for Entity: Ges_Categorias
 *
 */
@Entity

public class Ges_Categorias implements Serializable {

	
	private static final long serialVersionUID = 1L;
	
	@Id
	private int cat_id;
	private String cat_nombre;
	private String cat_descripcion;
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "categoria")
	private Set<Ges_Productos> productos = new HashSet<Ges_Productos>();
	

	public Ges_Categorias() {
		super();
	}
   
}
