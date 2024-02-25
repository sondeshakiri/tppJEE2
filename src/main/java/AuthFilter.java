

import java.io.IOException;

import java.io.PrintWriter;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

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
	// This method is called each time a client requests for a web resource i.e.
		// preprocessing request
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
	

		//transformer notre requet en HTtprequest pour ecrire sur notre page
		HttpServletResponse res = (HttpServletResponse) response;
		
		res.setContentType("text/html");//pour dire que l'affichage et en HTML
		PrintWriter out= res.getWriter();//permet l'ecriture sur la page
		
		//appel du request wrapper
		out.println("<b> <i>Filtering request and passing it to Wrapper class</i> </b> <br/>");

		//Calling the constructor of request wrapper class 
		RequestWrapper requestWrapper = new RequestWrapper (request);
		
		
		
		//appel response wrapper
		out.println("<b> <i>Filter is filtering the response and passing it to Wrapper class</i> </b> <br/>");
		//Calling the constructor of response wrapper class 
        ResponseWrapper responseWrapper = new ResponseWrapper (response);
		
        
        
        
		// pass the request along the filter chain
      //envoie de la requete & reponse apres le traitement du Request & Response wrappers
		
		chain.doFilter(requestWrapper, responseWrapper);
			
		
	}

	public void destroy() {
		// TODO Auto-generated method stub
	}


}
