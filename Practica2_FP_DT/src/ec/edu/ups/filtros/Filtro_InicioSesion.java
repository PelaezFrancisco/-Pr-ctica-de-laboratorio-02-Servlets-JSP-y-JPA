package ec.edu.ups.filtros;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.websocket.Session;

/**
 * Servlet Filter implementation class Filtro_InicioSesion
 */
@WebFilter({"/Filtro_InicioSesion", "/private/*"})
public class Filtro_InicioSesion implements Filter {

    /**
     * Default constructor. 
     */
    public Filtro_InicioSesion() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see Filter#destroy()
	 */
	public void destroy() {
		// TODO Auto-generated method stub
	}

	/**
	 * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
	 */
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		// TODO Auto-generated method stub
		// place your code here
		System.out.println("ENTRA A FILTRO");
		HttpSession sesion = ((HttpServletRequest)request).getSession();
		// pass the request along the filter chain
		if (sesion.getAttribute("mail")!=null) {
			//Esta iniciada la sesion
			System.out.println("Se ha iniciado la sesion");
			chain.doFilter(request, response);
		}else {
			System.out.println("No se ha iniciado sesion");
			((HttpServletResponse) response).sendRedirect("/Practica1_DT_FP/public/IniciarSesion.html");
		}
		
	}

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
		// TODO Auto-generated method stub
	}

}
