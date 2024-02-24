

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.GenericServlet;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

;
public class Servlet1 extends GenericServlet
{
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public void service (ServletRequest request, ServletResponse response) throws ServletException, IOException
    {
		//definir que l'affichage est en html
        response.setContentType ("text/html");
        //get name from request
        String name = request.getParameter ("name");
        PrintWriter out = response.getWriter ();
        //affichage
        out.println("hello from servlet");
        out.println (name);
    }
}
