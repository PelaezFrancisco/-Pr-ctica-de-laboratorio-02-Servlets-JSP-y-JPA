package ec.edu.ups.entidad;

import java.io.Serializable;
import javax.persistence.*;

import ec.edu.ups.entidad.*;

/**
 * Entity implementation class for Entity: Ges_Productos
 *
 */
@Entity


public class Ges_Productos implements Serializable {

	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int pro_id;
	private String pro_nombre;
	private String pro_descripcion;
	private int pro_stock;
	private double pro_precioV;
	private String pro_imagen;
	@ManyToOne
	@JoinColumn(name = "cat_id", unique = true, nullable = false)
	private Ges_Categorias categoria;
	@ManyToOne
	@JoinColumn(name = "emp_id", unique = true, nullable = false)
	private Ges_Empresas empresa;

	public Ges_Productos() {
		super();
	}
	public Ges_Productos(int pro_id, String pro_nombre, String pro_descripcion, int pro_stock, double pro_precioV,
			Ges_Categorias categoria, Ges_Empresas empresa) {
		super();
		this.pro_id = pro_id;
		this.pro_nombre = pro_nombre;
		this.pro_descripcion = pro_descripcion;
		this.pro_stock = pro_stock;
		this.pro_precioV = pro_precioV;
		this.categoria = categoria;
		this.empresa = empresa;
	}

	public int getPro_id() {
		return pro_id;
	}


	public void setPro_id(int pro_id) {
		this.pro_id = pro_id;
	}


	public String getPro_nombre() {
		return pro_nombre;
	}


	public void setPro_nombre(String pro_nombre) {
		this.pro_nombre = pro_nombre;
	}


	public String getPro_descripcion() {
		return pro_descripcion;
	}


	public void setPro_descripcion(String pro_descripcion) {
		this.pro_descripcion = pro_descripcion;
	}


	public int getPro_stock() {
		return pro_stock;
	}


	public void setPro_stock(int pro_stock) {
		this.pro_stock = pro_stock;
	}


	public double getPro_precioV() {
		return pro_precioV;
	}


	public void setPro_precioV(double pro_precioV) {
		this.pro_precioV = pro_precioV;
	}


	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	


	public Ges_Categorias getCategoria() {
		return categoria;
	}


	public void setCategoria(Ges_Categorias categoria) {
		this.categoria = categoria;
	}


	public Ges_Empresas getEmpresa() {
		return empresa;
	}


	public void setEmpresa(Ges_Empresas empresa) {
		this.empresa = empresa;
	}


	public String getPro_imagen() {
		return pro_imagen;
	}

	public void setPro_imagen(String pro_imagen) {
		this.pro_imagen = pro_imagen;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((categoria == null) ? 0 : categoria.hashCode());
		result = prime * result + ((empresa == null) ? 0 : empresa.hashCode());
		result = prime * result + ((pro_descripcion == null) ? 0 : pro_descripcion.hashCode());
		result = prime * result + pro_id;
		result = prime * result + ((pro_imagen == null) ? 0 : pro_imagen.hashCode());
		result = prime * result + ((pro_nombre == null) ? 0 : pro_nombre.hashCode());
		long temp;
		temp = Double.doubleToLongBits(pro_precioV);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result + pro_stock;
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
		Ges_Productos other = (Ges_Productos) obj;
		if (categoria == null) {
			if (other.categoria != null)
				return false;
		} else if (!categoria.equals(other.categoria))
			return false;
		if (empresa == null) {
			if (other.empresa != null)
				return false;
		} else if (!empresa.equals(other.empresa))
			return false;
		if (pro_descripcion == null) {
			if (other.pro_descripcion != null)
				return false;
		} else if (!pro_descripcion.equals(other.pro_descripcion))
			return false;
		if (pro_id != other.pro_id)
			return false;
		if (pro_imagen == null) {
			if (other.pro_imagen != null)
				return false;
		} else if (!pro_imagen.equals(other.pro_imagen))
			return false;
		if (pro_nombre == null) {
			if (other.pro_nombre != null)
				return false;
		} else if (!pro_nombre.equals(other.pro_nombre))
			return false;
		if (Double.doubleToLongBits(pro_precioV) != Double.doubleToLongBits(other.pro_precioV))
			return false;
		if (pro_stock != other.pro_stock)
			return false;
		return true;
	}
   
}
