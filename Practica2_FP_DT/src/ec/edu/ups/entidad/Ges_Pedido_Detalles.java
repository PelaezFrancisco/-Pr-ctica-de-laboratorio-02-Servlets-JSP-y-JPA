package ec.edu.ups.entidad;

import java.io.Serializable;

import javax.annotation.Generated;
import javax.persistence.*;

/**
 * Entity implementation class for Entity: Ges_Pedido_Detalles
 *
 */
@Entity

public class Ges_Pedido_Detalles implements Serializable {

	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int pde_id;
	private int pde_cantidad;
	private Double pde_precioU;
	private Double pde_subtotal;
	
	@ManyToOne
	@JoinColumn(name = "pro_id")
	private Ges_Productos product;
	
	@ManyToOne
	@JoinColumn(name = "ped_numeroP")
	private Ges_Pedido_Cabeceras pedidoCab;
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + pde_cantidad;
		result = prime * result + pde_id;
		result = prime * result + ((pde_precioU == null) ? 0 : pde_precioU.hashCode());
		result = prime * result + ((pde_subtotal == null) ? 0 : pde_subtotal.hashCode());
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
		Ges_Pedido_Detalles other = (Ges_Pedido_Detalles) obj;
		if (pde_cantidad != other.pde_cantidad)
			return false;
		if (pde_id != other.pde_id)
			return false;
		if (pde_precioU == null) {
			if (other.pde_precioU != null)
				return false;
		} else if (!pde_precioU.equals(other.pde_precioU))
			return false;
		if (pde_subtotal == null) {
			if (other.pde_subtotal != null)
				return false;
		} else if (!pde_subtotal.equals(other.pde_subtotal))
			return false;
		return true;
	}


	public int getPde_id() {
		return pde_id;
	}


	public void setPde_id(int pde_id) {
		this.pde_id = pde_id;
	}


	public int getPde_cantidad() {
		return pde_cantidad;
	}


	public void setPde_cantidad(int pde_cantidad) {
		this.pde_cantidad = pde_cantidad;
	}


	public Double getPde_precioU() {
		return pde_precioU;
	}


	public void setPde_precioU(Double pde_precioU) {
		this.pde_precioU = pde_precioU;
	}


	public Double getPde_subtotal() {
		return pde_subtotal;
	}


	public void setPde_subtotal(Double pde_subtotal) {
		this.pde_subtotal = pde_subtotal;
	}


	public Ges_Productos getProduct() {
		return product;
	}


	public void setProduct(Ges_Productos product) {
		this.product = product;
	}


	public Ges_Pedido_Cabeceras getPedidoCab() {
		return pedidoCab;
	}


	public void setPedidoCab(Ges_Pedido_Cabeceras pedidoCab) {
		this.pedidoCab = pedidoCab;
	}

	public Ges_Pedido_Detalles() {
		super();
	}
	
   
}
