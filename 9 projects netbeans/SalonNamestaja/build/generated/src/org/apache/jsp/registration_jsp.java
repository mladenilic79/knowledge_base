package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import database.DBQueries;
import java.util.ArrayList;
import model.City;

public final class registration_jsp extends org.apache.jasper.runtime.HttpJspBase
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

      out.write('\n');
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
 ArrayList<City> cities = DBQueries.getAllCities(); 
      out.write("\n");
      out.write("\n");
      out.write("<!DOCTYPE html>\n");
      out.write("<html>\n");
      out.write("    <head>\n");
      out.write("        <meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\n");
      out.write("        <title>JSP Page</title>\n");
      out.write("    </head>\n");
      out.write("    <body>\n");
      out.write("        <a href=\"index.jsp\"><img src=\"slike\\logo.jpg\" alt=\"pera\"/></a>\n");
      out.write("        <h1>salon namestaja</h1>\n");
      out.write("        <div>\n");
      out.write("            <table>\n");
      out.write("                <tr>\n");
      out.write("                    <td><a href=\"index.jsp\">index</a></td>\n");
      out.write("                    <td><a href=\"o_nama\">o nama</a></td>\n");
      out.write("                    <td><a href=\"proizvodi.jsp\">proizvodi</a></td>\n");
      out.write("                    <td><a href=\"registration.jsp\">registracija</a></td>\n");
      out.write("                    <td>\n");
      out.write("                        <!--calling servlet-->\n");
      out.write("                        <!--<div class=\"container\">-->\n");
      out.write("                        <form method=\"post\" class=\"form-signin\" role=\"form\" action=\"Kontakt\">\n");
      out.write("                            <input type=\"submit\" \n");
      out.write("                                   class=\"btn btn-lg btn-primary btn-block\" \n");
      out.write("                                   value=\"kontakt\">\n");
      out.write("                        </form>\n");
      out.write("                        <!--</div>-->\n");
      out.write("                    </td>\n");
      out.write("                </tr>\n");
      out.write("            </table>\n");
      out.write("        </div>\n");
      out.write("        <p>\n");
      out.write("            \"Sed ut perspiciatis unde omnis iste natus error sit voluptatem accusantium doloremque laudantium, totam rem aperiam, eaque ipsa quae ab illo inventore veritatis et quasi architecto beatae vitae dicta sunt explicabo. Nemo enim ipsam voluptatem quia voluptas sit aspernatur aut odit aut fugit, sed quia consequuntur magni dolores eos qui ratione voluptatem sequi nesciunt. Neque porro quisquam est, qui dolorem ipsum quia dolor sit amet, consectetur, adipisci velit, sed quia non numquam eius modi tempora incidunt ut labore et dolore magnam aliquam quaerat voluptatem. Ut enim ad minima veniam, quis nostrum exercitationem ullam corporis suscipit laboriosam, nisi ut aliquid ex ea commodi consequatur? Quis autem vel eum iure reprehenderit qui in ea voluptate velit esse quam nihil molestiae consequatur, vel illum qui dolorem eum fugiat quo voluptas nulla pariatur?\"\n");
      out.write("        </p>\n");
      out.write("        \n");
      out.write("        ");
      out.write("\n");
      out.write("\n");
      out.write("        <form name=\"b\" action=\"Kontrola2\" method=\"post\">\n");
      out.write("            First Name: <input type=\"text\" name=\"Fname\"/><br/>\n");
      out.write("            Message: <textarea name=\"Message\" cols=\"30\" rows=\"5\"></textarea><br/>\n");
      out.write("            Checkbox: <input id=\"iagree\" type=\"checkbox\" name=\"checkbox1\"/><br/>\n");
      out.write("            Username: <input type=\"text\" name=\"User\"/><br/>\n");
      out.write("            Password: <input type=\"password\" name=\"Pass\"/><br/>\n");
      out.write("            ");
      out.write("\n");
      out.write("            <select multiple name=\"preferedCars\">\n");
      out.write("                <option>mercedes</option>\n");
      out.write("                <option>audi</option>\n");
      out.write("                <option>bmw</option>\n");
      out.write("            </select><br/>\n");
      out.write("            ");
      out.write("\n");
      out.write("            ");
      out.write("\n");
      out.write("            <fieldset id=\"radioGroup\">\n");
      out.write("                <input checked type=\"radio\" value=\"male\" name=\"radioGroup\">\n");
      out.write("                <input type=\"radio\" value=\"female\" name=\"radioGroup\">\n");
      out.write("            </fieldset>\n");
      out.write("            Submit: <input type=\"submit\" name=\"submit\" value=\"Submit\" id=\"submit\" disabled>\n");
      out.write("        </form>\n");
      out.write("        <script src=\"js/js.js\" type=\"text/javascript\"></script>\n");
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
