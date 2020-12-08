package ec.edu.ups.controllers;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ec.edu.ups.dao.DAOFactory;
import ec.edu.ups.dao.EmpresaDAO;
import ec.edu.ups.dao.PedidoCabeceraDAO;
import ec.edu.ups.dao.PedidoDetalleDAO;
import ec.edu.ups.dao.PersonaDAO;
import ec.edu.ups.dao.ProductoDAO;
import ec.edu.ups.entidad.Ges_Pedido_Cabeceras;
import ec.edu.ups.entidad.Ges_Pedido_Detalles;
import ec.edu.ups.entidad.Ges_Productos;
import ec.edu.ups.entidad.Persona;


/**
 * Servlet implementation class CrearPedido
 */
@WebServlet("/CrearPedido")
public class CrearPedido extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private PedidoDetalleDAO detalleDAO;
    private PedidoCabeceraDAO cabeceraDAO;
    private EmpresaDAO empresaDAO;
    private PersonaDAO personaDAO;
    private ProductoDAO productoDAO;
    private Ges_Pedido_Cabeceras cabecera;
    private ArrayList<Ges_Pedido_Detalles> detalles;
    private List<Ges_Productos> listaproductos;
    private List<Persona> listaPersonas;
    
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CrearPedido() {
        cabeceraDAO = DAOFactory.getFactory().gePedidoCabeceraDAO();
        detalleDAO = DAOFactory.getFactory().getPedidoDetalleDAO();
        empresaDAO = DAOFactory.getFactory().getEmpresaDAO();
        personaDAO = DAOFactory.getFactory().getPersonaDAO();
        productoDAO = DAOFactory.getFactory().getProductoDAO();
        cabecera = new Ges_Pedido_Cabeceras();
        detalles = new ArrayList<Ges_Pedido_Detalles>();
        listaproductos = new ArrayList<Ges_Productos>();
        listaPersonas = new ArrayList<Persona>();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		Double subtotal=0.0;
		Double iva=1.2;
		Double descuento=1.0;
		ArrayList<Ges_Productos> prolist = new ArrayList<Ges_Productos>();
		/*
		 * TRAEMOS EL ID DE EMPRESA Y LA CANTIDAD DE VENTA DE PRODUCTOS
		 */
		//Id de empresa
		int idEmp=Integer.parseInt(request.getParameter("emp"));
		//Traemos lista de productos de la empresa
		listaproductos = productoDAO.findAll();
		
		for (int i = 0; i < listaproductos.size(); i++) {
			if (listaproductos.get(i).getEmpresa().getEmp_id()==idEmp) {
				prolist.add(listaproductos.get(i));
			}
		}
		
		//System.out.println("Lista de prudctos de empresa de compra= "+listaproductos.size());
		for (int i = 0; i < prolist.size(); i++) {
			try {
				//Recibimos la cantida de compra(cant) del producto (i)
				int cant = Integer.parseInt(request.getParameter("cant"+prolist.get(i).getPro_id()));
				//Creamos el objeto detalle
				Ges_Pedido_Detalles ped = new Ges_Pedido_Detalles();
				//ped.getPedidoCab(null);	//Id del pedido cabecera
				ped.setPde_cantidad(cant);
				ped.setPde_precioU(prolist.get(i).getPro_precioV());
				ped.setPde_subtotal(prolist.get(i).getPro_precioV()*cant);
				ped.setProduct(prolist.get(i));
				
				//Sumamos al subtotal de cabcera
				subtotal=subtotal+prolist.get(i).getPro_precioV()*cant;
				//Agregamos el objeto detalle a la lista
				detalles.add(ped);
				
				//Reducimos el stock
				int stock_aux = prolist.get(i).getPro_stock();
				prolist.get(i).setPro_stock(stock_aux-cant);
				
			} catch (Exception e) {
				e.printStackTrace();
				System.out.println(">>>Error recibiendo cantidades en CrearPedido");
			}
		}
		//System.out.println("Cantidad de detalles= "+detalles.size());
		/*
		 * TRAEMOS A LA PERSONA QUE HACE EL PEDIDO 
		 */
		listaPersonas= personaDAO.findAll();
		int perId = 0;
		//System.out.println("Tamaño de listarPersonas= "+listaPersonas.size());
		for (int i = 0; i < listaPersonas.size(); i++) {
			//System.out.println("per_emp_id= "+listaPersonas.get(i).getEmpresaId());
			//System.out.println("per_rol= "+listaPersonas.get(i).getRol());
			if (listaPersonas.get(i).getEmpresa().getEmp_id()==idEmp && Character.compare(listaPersonas.get(i).getPer_rol(), 'U')==0) {
				perId = listaPersonas.get(i).getPer_id();
				//System.out.println("La persona que hizo el pedido es= "+listaPersonas.get(i).getNombre());
			}
		}
		/*
		 * CREAMOS LA CABECERA
		 */
		//System.out.println("Id de persona a Cabecera= "+perId);
		Persona p = new Persona();
		p = personaDAO.read(perId);
		Date fecha = new Date();
		String pattern = "YYYY-MM-dd HH:mm:ss";
		SimpleDateFormat formatter = new SimpleDateFormat(pattern);
        String mysqlDateString = formatter.format(fecha);
		//System.out.println("Fecha creada= "+mysqlDateString);
		cabecera.setPed_fecha(mysqlDateString);
		cabecera.setPed_subtotal(subtotal);
		cabecera.setPed_iva(iva);
		cabecera.setPed_descuento(descuento);
		cabecera.setPed_total((subtotal/descuento)*iva);
		cabecera.setPed_estado('P');
		cabecera.setPersona(p);
		
		cabeceraDAO.create(cabecera);
		
		List<Ges_Pedido_Cabeceras> cab_aux = new ArrayList();
		cab_aux = cabeceraDAO.findAll();
		Ges_Pedido_Cabeceras cabId = cab_aux.get(cab_aux.size());	//Maybe error
		
		//int cabId = cab_aux.getPedidoCabeceraNumero();
		//System.out.println("Pedido de cabecera creado= "+cabId);
		/*
		 * AHORA CREAMOS EL DETALLE 
		 */
		//Antes que nada cambiamos los ped.setPed_id(0);
		for (int i = 0; i < detalles.size(); i++) {
			detalles.get(i).setPedidoCab(cabId);
			
			detalleDAO.create(detalles.get(i));
			//System.out.println("creacion de detalles");
		}
		/*
		 * YA HABIDO CREADO EL ENCABEZADO Y DETALLE, HACEMOS LA DISMINUCION DE INVENTARIO
		 */
		for (int i = 0; i < prolist.size(); i++) {
			productoDAO.update(prolist.get(i));
			System.out.println("Modificaciones Exitosas");
		}
		
		/*
		 * FINALIZACION
		 */
		List<Ges_Pedido_Cabeceras> cab_aux2 = new ArrayList();
		cab_aux2 = cabeceraDAO.findAll();
		Ges_Pedido_Cabeceras cabId2 = cab_aux2.get(cab_aux2.size());
		
		request.setAttribute("pedido", cabId2);
		
		String url= "/private/user/factura.jsp";
		//System.out.println("Empresa de Compra: "+idEmp);
		getServletContext().getRequestDispatcher(url).forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
