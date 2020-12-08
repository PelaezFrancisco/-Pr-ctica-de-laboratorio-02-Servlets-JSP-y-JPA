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
	

	public Ges_Pedido_Detalles() {
		super();
	}
	
   
}
