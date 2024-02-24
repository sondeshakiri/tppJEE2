import javax.servlet.*;
public class Wrapper extends ServletRequestWrapper
{
    public Wrapper (ServletRequest req)
    {
        //calls the ServletRequestWrapper superclass's constructor i.e. ServletRequest.
        super (req);
    }

    public String getParameter (String str)
    {
        //Calling the superclass method i.e. ServletRequest's getParameter(String) method.
        String name = super.getParameter (str);
       

        // Effectue des tests supplémentaires sur le nom.
        if (name == null || name.trim().isEmpty()) {
            name = "Please, enter a valid name in the form";
        } else if (name.length() < 3) {
            name = "Name should be at least 3 characters long";
        }
        return name;
    }
}