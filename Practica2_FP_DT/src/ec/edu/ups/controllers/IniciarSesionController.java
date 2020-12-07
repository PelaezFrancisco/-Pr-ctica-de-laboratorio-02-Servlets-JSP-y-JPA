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

/**
 * Servlet implementation class IniciarSesionController
 */
@WebServlet("/IniciarSesionController")
public class IniciarSesionController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public IniciarSesionController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		String url = null;
		char rol = 'Z';
		String email=null;
		//try {
			//email = request.getParameter("email");
			//MD5 para contrasena
			//String contrasena = getMd5(request.getParameter("contra"));
			/*
			persona = personaDao.find_email(email);
			System.out.println("Email recibido = "+email);
			System.out.println("Email de Base = "+persona.getEmail());
			
			try {
				rol = persona.getRol();
				System.out.println("Rol de Persona = "+ rol );
			} catch (Exception e) {
				// TODO: handle exception
				e.printStackTrace();
				System.out.println("Problema Resolviendo el Rol");
			}
			
			
			//request.setAttribute("persona", persona);
			
			
			
			//If para control de contrasena
			System.out.println("Contrasena puesta= "+contrasena);
			System.out.println("Contrasena de base= "+persona.getContrasena());
			if (contrasena.equals(persona.getContrasena())) {
				
				//If para redireccion de rol
				if (rol=='A') {
					System.out.println("Se manda a Admin");
					url = "/private/admin/inicio_admin.jsp";
				}else {
					System.out.println("Se manda a user");
					url = "/private/user/inicio_user.jsp";
				}
			}else {
				url = "/public/IniciarSesion.html";
			}
			
			empresa = empresaDao.read(persona.getId());
			request.setAttribute("empresa", empresa);
			
		} catch (Exception e) {
			System.out.println("ERROR DE INICIO DE SESION");
			e.printStackTrace();
			url = "/JSPs/error.jsp";
		}
		
		getServletContext().getRequestDispatcher(url).forward(request, response);
		*/
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
