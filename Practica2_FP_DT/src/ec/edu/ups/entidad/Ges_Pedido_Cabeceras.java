package ec.edu.ups.entidad;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import javax.annotation.Generated;
import javax.persistence.*;

/**
 * Entity implementation class for Entity: Ges_Pedido_Cabeceras
 *
 */
@Entity

public class Ges_Pedido_Cabeceras implements Serializable {

	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int ped_numeroP;
	private String ped_fecha;
	private Double ped_subtotal;
	private Double ped_iva;
	private Double ped_descuento;
	private Double ped_total;
	private char ped_estado;
	
	@ManyToOne
	@JoinColumn(name = "per_id", unique = true, nullable = false)
	private Persona persona ;
	
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "pedidoCab")
	private Set<Ges_Pedido_Detalles> pedidoDet = new HashSet<Ges_Pedido_Detalles>();
	
	public Ges_Pedido_Cabeceras() {
		super();
	}

	public int getPed_numeroP() {
		return ped_numeroP;
	}

	public void setPed_numeroP(int ped_numeroP) {
		this.ped_numeroP = ped_numeroP;
	}

	public String getPed_fecha() {
		return ped_fecha;
	}

	public void setPed_fecha(String mysqlDateString) {
		this.ped_fecha = mysqlDateString;
	}

	public Set<Ges_Pedido_Detalles> getPedidoDet() {
		return pedidoDet;
	}

	public void setPedidoDet(Set<Ges_Pedido_Detalles> pedidoDet) {
		this.pedidoDet = pedidoDet;
	}

	public Double getPed_subtotal() {
		return ped_subtotal;
	}

	public void setPed_subtotal(Double ped_subtotal) {
		this.ped_subtotal = ped_subtotal;
	}

	public Double getPed_iva() {
		return ped_iva;
	}

	public void setPed_iva(Double ped_iva) {
		this.ped_iva = ped_iva;
	}

	public Double getPed_descuento() {
		return ped_descuento;
	}

	public void setPed_descuento(Double ped_descuento) {
		this.ped_descuento = ped_descuento;
	}

	public Double getPed_total() {
		return ped_total;
	}

	public void setPed_total(Double ped_total) {
		this.ped_total = ped_total;
	}

	public char getPed_estado() {
		return ped_estado;
	}

	public void setPed_estado(char ped_estado) {
		this.ped_estado = ped_estado;
	}

	public Persona getPersona() {
		return persona;
	}

	public void setPersona(Persona persona) {
		this.persona = persona;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((ped_descuento == null) ? 0 : ped_descuento.hashCode());
		result = prime * result + ped_estado;
		result = prime * result + ((ped_fecha == null) ? 0 : ped_fecha.hashCode());
		result = prime * result + ((ped_iva == null) ? 0 : ped_iva.hashCode());
		result = prime * result + ped_numeroP;
		result = prime * result + ((ped_subtotal == null) ? 0 : ped_subtotal.hashCode());
		result = prime * result + ((ped_total == null) ? 0 : ped_total.hashCode());
		result = prime * result + ((persona == null) ? 0 : persona.hashCode());
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
		Ges_Pedido_Cabeceras other = (Ges_Pedido_Cabeceras) obj;
		if (ped_descuento == null) {
			if (other.ped_descuento != null)
				return false;
		} else if (!ped_descuento.equals(other.ped_descuento))
			return false;
		if (ped_estado != other.ped_estado)
			return false;
		if (ped_fecha == null) {
			if (other.ped_fecha != null)
				return false;
		} else if (!ped_fecha.equals(other.ped_fecha))
			return false;
		if (ped_iva == null) {
			if (other.ped_iva != null)
				return false;
		} else if (!ped_iva.equals(other.ped_iva))
			return false;
		if (ped_numeroP != other.ped_numeroP)
			return false;
		if (ped_subtotal == null) {
			if (other.ped_subtotal != null)
				return false;
		} else if (!ped_subtotal.equals(other.ped_subtotal))
			return false;
		if (ped_total == null) {
			if (other.ped_total != null)
				return false;
		} else if (!ped_total.equals(other.ped_total))
			return false;
		if (persona == null) {
			if (other.persona != null)
				return false;
		} else if (!persona.equals(other.persona))
			return false;
		return true;
	}
	
   
}
