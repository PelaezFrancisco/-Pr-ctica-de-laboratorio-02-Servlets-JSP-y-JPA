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

	

	public Ges_Categorias(int cat_id, String cat_nombre, String cat_descripcion, Set<Ges_Productos> productos) {
		super();
		this.cat_id = cat_id;
		this.cat_nombre = cat_nombre;
		this.cat_descripcion = cat_descripcion;
		this.productos = productos;
	}



	public int getCat_id() {
		return cat_id;
	}


	public void setCat_id(int cat_id) {
		this.cat_id = cat_id;
	}


	public String getCat_nombre() {
		return cat_nombre;
	}


	public void setCat_nombre(String cat_nombre) {
		this.cat_nombre = cat_nombre;
	}


	public String getCat_descripcion() {
		return cat_descripcion;
	}


	public void setCat_descripcion(String cat_descripcion) {
		this.cat_descripcion = cat_descripcion;
	}


	public Set<Ges_Productos> getProductos() {
		return productos;
	}


	public void setProductos(Set<Ges_Productos> productos) {
		this.productos = productos;
	}


	public static long getSerialversionuid() {
		return serialVersionUID;
	}



	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((cat_descripcion == null) ? 0 : cat_descripcion.hashCode());
		result = prime * result + cat_id;
		result = prime * result + ((cat_nombre == null) ? 0 : cat_nombre.hashCode());
		return result;
	}



	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Ges_Categorias other = (Ges_Categorias) obj;
		if (cat_descripcion == null) {
			if (other.cat_descripcion != null)
				return false;
		} else if (!cat_descripcion.equals(other.cat_descripcion))
			return false;
		if (cat_id != other.cat_id)
			return false;
		if (cat_nombre == null) {
			if (other.cat_nombre != null)
				return false;
		} else if (!cat_nombre.equals(other.cat_nombre))
			return false;
		return true;
	}



	
	
	
   
}
