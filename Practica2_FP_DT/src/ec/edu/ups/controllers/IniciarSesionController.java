package ec.edu.ups.controllers;

import java.io.IOException;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import ec.edu.ups.dao.DAOFactory;
import ec.edu.ups.dao.EmpresaDAO;
import ec.edu.ups.dao.PersonaDAO;
import ec.edu.ups.entidad.Ges_Empresas;
import ec.edu.ups.entidad.Persona;


/**
 * Servlet implementation class IniciarSesionController
 */
@WebServlet("/IniciarSesionController")
public class IniciarSesionController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private EmpresaDAO empresaDAO;
	private PersonaDAO personaDAO;
	private Ges_Empresas empresa;
	private Persona persona;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public IniciarSesionController() {
        empresaDAO = DAOFactory.getFactory().getEmpresaDAO();
        personaDAO = DAOFactory.getFactory().getPersonaDAO();
        empresa = new Ges_Empresas();
        persona = new Persona();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		String url = null;
		char rol = 'Z';
		String email=null;
		try {
			email = request.getParameter("email");
			//MD5 para contrasena
			String contrasena = getMd5(request.getParameter("contra"));
			
			persona = personaDAO.find_email(email);
			System.out.println("Email recibido = "+email);
			System.out.println("Email de Base = "+persona.getPer_email());
			
			try {
				rol = persona.getPer_rol();
				System.out.println("Rol de Persona = "+ rol );
			} catch (Exception e) {
				// TODO: handle exception
				e.printStackTrace();
				System.out.println("Problema Resolviendo el Rol");
			}

			System.out.println("Contrasena puesta= "+contrasena);
			System.out.println("Contrasena de base= "+persona.getPer_contrasena());
			if (contrasena.equals(persona.getPer_contrasena())) {
				
				//Carga los datos del usuario dentro del HttpSession
				HttpSession  session=request.getSession(true);
		        session.setAttribute("mail", email);
		        session.setAttribute("password", persona.getPer_contrasena());
				
				//If para redireccion de rol
				if (rol=='A') {
					System.out.println("Se manda a Admin");
					url = "/private/admin/inicio_admin.jsp";
				}else {
					System.out.println("Se manda a user");
					url = "/private/user/inicio_user.jsp";
				}
			}else {
				System.out.println("No coincide la contrasena");
				url = "/public/IniciarSesion.html";
			}
			
			empresa = empresaDAO.read(persona.getPer_id());
			int per = persona.getPer_id();
			persona = personaDAO.read(per);
			request.setAttribute("persona", persona);
			
		} catch (Exception e) {
			System.out.println("ERROR DE INICIO DE SESION");
			e.printStackTrace();
			url = "/JSPs/error.jsp";
		}
		System.out.println("url que manda= "+url);
		System.out.println("objeto empresa="+persona.getEmpresa().getEmp_nombre());
		//System.out.println("Nombre del persona"+persona.getPer_nombre());
		
		getServletContext().getRequestDispatcher(url).forward(request, response);
		
		//response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}
	
	//MD5 hashing
		public static String getMd5(String input) 
	    { 
	        try { 
	  
	            // Static getInstance method is called with hashing MD5 
	            MessageDigest md = MessageDigest.getInstance("MD5"); 
	  
	            // digest() method is called to calculate message digest 
	            //  of an input digest() return array of byte 
	            byte[] messageDigest = md.digest(input.getBytes()); 
	  
	            // Convert byte array into signum representation 
	            BigInteger no = new BigInteger(1, messageDigest); 
	  
	            // Convert message digest into hex value 
	            String hashtext = no.toString(16); 
	            while (hashtext.length() < 32) { 
	                hashtext = "0" + hashtext; 
	            } 
	            return hashtext; 
	        }  
	  
	        // For specifying wrong message digest algorithms 
	        catch (NoSuchAlgorithmException e) { 
	            throw new RuntimeException(e); 
	        } 
	    } 

}
