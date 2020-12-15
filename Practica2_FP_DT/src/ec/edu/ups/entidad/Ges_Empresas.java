package ec.edu.ups.entidad;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.*;





/**
 * Entity implementation class for Entity: Ges_Empresas
 *
 */
@Entity

public class Ges_Empresas implements Serializable {

	
	private static final long serialVersionUID = 1L;

	@Id 
	private int emp_id;
	private String emp_nombre;
	private String emp_ruc;
	private String emp_direccion;
	private String emp_telefono;
	private String emp_email;
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "empresa" )
	private Set<Ges_Productos> productos = new HashSet<Ges_Productos>();
	
	@OneToOne(cascade = CascadeType.ALL, mappedBy = "empresas")
	private Persona persona;
	
	
	
	public Ges_Empresas() {
		super();
	}
	public Ges_Empresas(int emp_id, String emp_nombre, String emp_ruc, String emp_direccion, String emp_telefono,
			String emp_email, Set<Ges_Productos> productos, Persona persona) {
		super();
		this.emp_id = emp_id;
		this.emp_nombre = emp_nombre;
		this.emp_ruc = emp_ruc;
		this.emp_direccion = emp_direccion;
		this.emp_telefono = emp_telefono;
		this.emp_email = emp_email;
		this.productos = productos;
		this.persona = persona;
	}


	
	public Persona getPersona() {
		return persona;
	}
	public void setPersona(Persona persona) {
		this.persona = persona;
	}
	public Set<Ges_Productos> getProductos() {
		return productos;
	}
	public void setProductos(Set<Ges_Productos> productos) {
		this.productos = productos;
	}
	public int getEmp_id() {
		return emp_id;
	}


	public void setEmp_id(int emp_id) {
		this.emp_id = emp_id;
	}


	public String getEmp_nombre() {
		return emp_nombre;
	}


	public void setEmp_nombre(String emp_nombre) {
		this.emp_nombre = emp_nombre;
	}


	public String getEmp_ruc() {
		return emp_ruc;
	}


	public void setEmp_ruc(String emp_ruc) {
		this.emp_ruc = emp_ruc;
	}


	public String getEmp_direccion() {
		return emp_direccion;
	}


	public void setEmp_direccion(String emp_direccion) {
		this.emp_direccion = emp_direccion;
	}


	public String getEmp_telefono() {
		return emp_telefono;
	}


	public void setEmp_telefono(String emp_telefono) {
		this.emp_telefono = emp_telefono;
	}


	public String getEmp_email() {
		return emp_email;
	}


	public void setEmp_email(String emp_email) {
		this.emp_email = emp_email;
	}


	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((emp_direccion == null) ? 0 : emp_direccion.hashCode());
		result = prime * result + ((emp_email == null) ? 0 : emp_email.hashCode());
		result = prime * result + emp_id;
		result = prime * result + ((emp_nombre == null) ? 0 : emp_nombre.hashCode());
		result = prime * result + ((emp_ruc == null) ? 0 : emp_ruc.hashCode());
		result = prime * result + ((emp_telefono == null) ? 0 : emp_telefono.hashCode());
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
		Ges_Empresas other = (Ges_Empresas) obj;
		if (emp_direccion == null) {
			if (other.emp_direccion != null)
				return false;
		} else if (!emp_direccion.equals(other.emp_direccion))
			return false;
		if (emp_email == null) {
			if (other.emp_email != null)
				return false;
		} else if (!emp_email.equals(other.emp_email))
			return false;
		if (emp_id != other.emp_id)
			return false;
		if (emp_nombre == null) {
			if (other.emp_nombre != null)
				return false;
		} else if (!emp_nombre.equals(other.emp_nombre))
			return false;
		if (emp_ruc == null) {
			if (other.emp_ruc != null)
				return false;
		} else if (!emp_ruc.equals(other.emp_ruc))
			return false;
		if (emp_telefono == null) {
			if (other.emp_telefono != null)
				return false;
		} else if (!emp_telefono.equals(other.emp_telefono))
			return false;
		return true;
	}

	

	
}
