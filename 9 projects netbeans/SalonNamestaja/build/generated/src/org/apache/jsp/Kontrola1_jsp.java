package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class Kontrola1_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final JspFactory _jspxFactory = JspFactory.getDefaultFactory();

  private static java.util.List<String> _jspx_dependants;

  private org.glassfish.jsp.api.ResourceInjector _jspx_resourceInjector;

  public java.util.List<String> getDependants() {
    return _jspx_dependants;
  }

  public void _jspService(HttpServletRequest request, HttpServletResponse response)
        throws java.io.IOException, ServletException {

    PageContext pageContext = null;
    HttpSession session = null;
    ServletContext application = null;
    ServletConfig config = null;
    JspWriter out = null;
    Object page = this;
    JspWriter _jspx_out = null;
    PageContext _jspx_page_context = null;

    try {
      response.setContentType("text/html;charset=UTF-8");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;
      _jspx_resourceInjector = (org.glassfish.jsp.api.ResourceInjector) application.getAttribute("com.sun.appserv.jsp.resource.injector");

      out.write("\n");
      out.write("\n");
      out.write("<!DOCTYPE html>\n");
      out.write("<html>\n");
      out.write("    <head>\n");
      out.write("        <meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\n");
      out.write("        <title>JSP Page</title>\n");
      out.write("    </head>\n");
      out.write("    <body>\n");
      out.write("        ");
 
            out.print("Vase ime je: " + request.getParameter("Fname") + "<br/>");
            out.print("Vasi komentar i poruka su: " + request.getParameter("Message") + "<br/>");
            out.print("Vase user je: " + request.getParameter("User") + "<br/>");
            out.print("Vase pass je: " + request.getParameter("Pass") + "<br/>");
            out.print("Checkbox je: " + request.getParameter("checkbox1") + "<br/>");
            
            String username = request.getParameter("User");
            String password = request.getParameter("Pass");
            
            String[] selectedValues = request.getParameterValues("preferedCars");
            out.println("you selected: ");
            for(String item : selectedValues){
                out.println(item);
            }
            
            if(request.getParameter("guitar")!=null){
                out.println("you choose " + request.getParameter("guitar"));
            }
        
      out.write("\n");
      out.write("        \n");
      out.write("        ");
      out.write("\n");
      out.write("        <div>\n");
      out.write("            ");

                out.println("<table>");
                out.println("<tr>");
                out.println("<td>" + sevrlet.Kontakt.proizvod1 + "</td>");
                out.println("<td><img alt=\"kera\" src=" + sevrlet.Kontakt.link1 + "/></td>");
                out.println("<td>" + sevrlet.Kontakt.cena1 + "</td>");
                out.println("</tr>");
                out.println("</table>");
            
      out.write("\n");
      out.write("        </div>\n");
      out.write("    </body>\n");
      out.write("</html>\n");
    } catch (Throwable t) {
      if (!(t instanceof SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          out.clearBuffer();
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}
