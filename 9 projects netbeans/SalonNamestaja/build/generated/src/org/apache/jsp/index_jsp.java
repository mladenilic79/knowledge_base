package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import java.util.Calendar;
import java.time.LocalDateTime;

public final class index_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      out.write("<!DOCTYPE html>\n");
      out.write("<html>\n");
      out.write("    <head>\n");
      out.write("        <meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\n");
      out.write("        <title>JSP Page</title>\n");
      out.write("    </head>\n");
      out.write("    <body>\n");
      out.write("        <a href=\"index.jsp\"><img src=\"slike\\logo.jpg\" alt=\"LOGO\"/></a>\n");
      out.write("        <h1>TITLE</h1>\n");
      out.write("        \n");
      out.write("        <table>\n");
      out.write("            <tr>\n");
      out.write("                <td><a href=\"index.jsp\">index</a></td>\n");
      out.write("                <td><a href=\"multiArray.jsp\">multi array</a></td>\n");
      out.write("                <td><a href=\"scriplett.jsp\">scriplet</a></td>\n");
      out.write("                <td><a href=\"expressionLanguage.jsp\">exp. lang.</a></td>\n");
      out.write("                <td><a href=\"javaStandardTagLibrary.jsp\">JSTL</a></td>\n");
      out.write("                <td><a href=\"javaStandardTagLibraryCustomTags.jsp\">JSTL-custom</a></td>\n");
      out.write("                <td><a href=\"regJSP.jsp\">reg. to jsp</a></td>\n");
      out.write("                <td><a href=\"regServlet.jsp\">reg. to servlet</a></td>\n");
      out.write("                <td><a href=\"regDB.jsp\">reg. to db</a></td>\n");
      out.write("                <td><a href=\"accessRegOnly.jsp\">acc. reg. only</a></td>\n");
      out.write("                <td><a href=\"xml/Lekari.xml\">XML</a></td>\n");
      out.write("                <td>\n");
      out.write("                    <!--calling servlet-->\n");
      out.write("                    <!--<div class=\"container\">-->\n");
      out.write("                    <form method=\"post\" class=\"form-signin\" role=\"form\" action=\"Servlett\">\n");
      out.write("                        <input type=\"submit\" \n");
      out.write("                               class=\"btn btn-lg btn-primary btn-block\" \n");
      out.write("                               value=\"servlett\">\n");
      out.write("                    </form>\n");
      out.write("                    <!--</div>-->\n");
      out.write("                </td>\n");
      out.write("            </tr>\n");
      out.write("        </table>\n");
      out.write("        \n");
      out.write("        ");
      out.write("\n");
      out.write("        \n");
      out.write("        <p>\n");
      out.write("            \"Sed ut perspiciatis unde omnis iste natus error sit voluptatem accu\n");
      out.write("        </p>\n");
      out.write("        \n");
      out.write("        ");
      out.write("\n");
      out.write("        Sum of ");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${param[\"a\"]}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write(" and ");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${param[\"b\"]}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write(" is: ");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${param[\"a\"]+param[\"b\"]}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("\n");
      out.write("\n");
      out.write("        <br/>\n");
      out.write("        \n");
      out.write("        ");
      out.write("\n");
      out.write("        <iframe width=\"600\" height=\"500\" src=\"https://maps.google.com/maps?q=Belgrade&t=&z=13&ie=UTF8&iwloc=&output=embed\" frameborder=\"0\" scrolling=\"no\" marginheight=\"0\" marginwidth=\"0\"></iframe>\n");
      out.write("\n");
      out.write("        <p>designed by m</p>\n");
      out.write("        ");
 out.println("current server time is " + LocalDateTime.now());
      out.write("\n");
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
