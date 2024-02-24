

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class AuthFilter implements Filter {
	
/**
 * initialisation de notre filtre 
 */
	public void init(FilterConfig config) throws ServletException
	{
		
		System.out.println(" init method is called in "
		        + this.getClass().getName());
		System.out
		        .println("------------------------------------------------------");
	}
	
	/**
	 * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
	 */
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
	

		//transformer notre requet en HTtprequest pour ecrire sur notre page
		HttpServletResponse res = (HttpServletResponse) response;
		
		res.setContentType("text/html");//pour dire que l'affichage et en HTML
		PrintWriter out= res.getWriter();//permet l'ecriture sur la page
		
		out.println("<b> <i>Filtering request and passing it to Wrapper class</i> </b> <br/>");


			 //Calling the constructor of request wrapper class 
		Wrapper requestWrapper = new Wrapper (request);
			// pass the request along the filter chain
		chain.doFilter(requestWrapper, response);
			
		
	}

	public void destroy() {
		// TODO Auto-generated method stub
	}


}
