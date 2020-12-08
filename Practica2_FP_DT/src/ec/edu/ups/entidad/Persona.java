package ec.edu.ups.entidad;

import java.io.Serializable;
import javax.persistence.*;

/**
 * Entity implementation class for Entity: Persona
 *
 */
@Entity
@Table(name="GES_Personas")
public class Persona implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Id
	@ GeneratedValue (strategy=GenerationType.IDENTITY)
	private int per_id;
	private String per_cedula;
	private String per_nombre;
	private String per_apellido;
	private char per_rol;
	private String per_telefono;
	private String per_direccion;
	private String per_email;
	private String per_contrasena;
	@ManyToOne
	@JoinColumn(name = "emp_id", unique = true, nullable = false)
	private Ges_Empresas empresas;
	
	private int emp_id;
	

	public Persona() {
		super();
		
	}
	
	public Persona(int per_id, String per_cedula, String per_nombre, String per_apellido, char per_rol, String per_telefono,
			String per_direccion, String per_email, String per_contrasena, int emp_id) {
		this.per_id=per_id;
		this.per_cedula= per_cedula;
		this.per_nombre = per_nombre;
		this.per_apellido = per_apellido;
		this.per_rol = per_rol;
		this.per_telefono = per_telefono;
		this.per_direccion = per_direccion;
		this.per_email = per_email;
		this.per_contrasena = per_contrasena;
		this.emp_id = emp_id;
	}
	
	@Override
	public String toString() {
		return "Persona [per_id=" + per_id + ", per_cedula=" + per_cedula + ", per_nombre=" + per_nombre
				+ ", per_apellido=" + per_apellido + ", per_rol=" + per_rol + ", per_telefono=" + per_telefono
				+ ", per_direccion=" + per_direccion + ", per_email=" + per_email + ", per_contrasena=" + per_contrasena
				+ ", emp_id=" + emp_id + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + emp_id;
		result = prime * result + ((per_apellido == null) ? 0 : per_apellido.hashCode());
		result = prime * result + ((per_cedula == null) ? 0 : per_cedula.hashCode());
		result = prime * result + ((per_contrasena == null) ? 0 : per_contrasena.hashCode());
		result = prime * result + ((per_direccion == null) ? 0 : per_direccion.hashCode());
		result = prime * result + ((per_email == null) ? 0 : per_email.hashCode());
		result = prime * result + per_id;
		result = prime * result + ((per_nombre == null) ? 0 : per_nombre.hashCode());
		result = prime * result + per_rol;
		result = prime * result + ((per_telefono == null) ? 0 : per_telefono.hashCode());
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
		Persona other = (Persona) obj;
		if (emp_id != other.emp_id)
			return false;
		if (per_apellido == null) {
			if (other.per_apellido != null)
				return false;
		} else if (!per_apellido.equals(other.per_apellido))
			return false;
		if (per_cedula == null) {
			if (other.per_cedula != null)
				return false;
		} else if (!per_cedula.equals(other.per_cedula))
			return false;
		if (per_contrasena == null) {
			if (other.per_contrasena != null)
				return false;
		} else if (!per_contrasena.equals(other.per_contrasena))
			return false;
		if (per_direccion == null) {
			if (other.per_direccion != null)
				return false;
		} else if (!per_direccion.equals(other.per_direccion))
			return false;
		if (per_email == null) {
			if (other.per_email != null)
				return false;
		} else if (!per_email.equals(other.per_email))
			return false;
		if (per_id != other.per_id)
			return false;
		if (per_nombre == null) {
			if (other.per_nombre != null)
				return false;
		} else if (!per_nombre.equals(other.per_nombre))
			return false;
		if (per_rol != other.per_rol)
			return false;
		if (per_telefono == null) {
			if (other.per_telefono != null)
				return false;
		} else if (!per_telefono.equals(other.per_telefono))
			return false;
		return true;
	}

	public int getPer_id() {
		return per_id;
	}

	public void setPer_id(int per_id) {
		this.per_id = per_id;
	}

	public String getPer_cedula() {
		return per_cedula;
	}

	public void setPer_cedula(String per_cedula) {
		this.per_cedula = per_cedula;
	}

	public String getPer_nombre() {
		return per_nombre;
	}

	public void setPer_nombre(String per_nombre) {
		this.per_nombre = per_nombre;
	}

	public String getPer_apellido() {
		return per_apellido;
	}

	public void setPer_apellido(String per_apellido) {
		this.per_apellido = per_apellido;
	}

	public char getPer_rol() {
		return per_rol;
	}

	public void setPer_rol(char per_rol) {
		this.per_rol = per_rol;
	}

	public String getPer_telefono() {
		return per_telefono;
	}

	public void setPer_telefono(String per_telefono) {
		this.per_telefono = per_telefono;
	}

	public String getPer_direccion() {
		return per_direccion;
	}

	public void setPer_direccion(String per_direccion) {
		this.per_direccion = per_direccion;
	}

	public String getPer_email() {
		return per_email;
	}

	public void setPer_email(String per_email) {
		this.per_email = per_email;
	}

	public String getPer_contrasena() {
		return per_contrasena;
	}

	public void setPer_contrasena(String per_contrasena) {
		this.per_contrasena = per_contrasena;
	}

	public int getEmp_id() {
		return emp_id;
	}

	public void setEmp_id(int emp_id) {
		this.emp_id = emp_id;
	}


	
	
   
}
