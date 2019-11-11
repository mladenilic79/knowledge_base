package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class expressionLanguage_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {


            public class Person {

                private String name = "petar";

                public String getName() {
                    return this.name;
                }
            }
        
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
      out.write("\n");
      out.write("<!DOCTYPE html>\n");
      out.write("<html>\n");
      out.write("    <head>\n");
      out.write("        <meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\n");
      out.write("        <title>JSP Page</title>\n");
      out.write("    </head>\n");
      out.write("    <body>\n");
      out.write("        ");
      out.write(" \n");
      out.write("\n");
      out.write("        ");
      out.write("\n");
      out.write("        <form>\n");
      out.write("            Prvi broj:<input type=\"text\" name=\"a\" value=");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${param[\"a\"]}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("><br>\n");
      out.write("            Drugi broj:<input type=\"text\" name=\"b\" value=");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${param[\"b\"]}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("><br>\n");
      out.write("            <input type=\"submit\" name=\"zbir\" value=\"Zbir\"><br>\n");
      out.write("            <input type=\"submit\" name=\"razlika\" value=\"Razlika\"><br>\n");
      out.write("        </form>\n");
      out.write("        ");

            try {
                String zb = request.getParameter("zbir");
                String rz = request.getParameter("razlika");
                int aBr = Integer.parseInt(request.getParameter("a"));
                int bBr = Integer.parseInt(request.getParameter("b"));
                if (zb != null) {
                    int rezultat = aBr + bBr;
                    request.setAttribute("rez", "Zbir je " + rezultat);
                }
                if (rz != null) {
                    int rezultat = aBr - bBr;
                    request.setAttribute("rez", "Razlika je " + rezultat);
                }
            } catch (NumberFormatException e) {
                e.printStackTrace();
            }
        
      out.write("\n");
      out.write("        ");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${rez}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("\n");
      out.write("\n");
      out.write("        <br/>\n");
      out.write("\n");
      out.write("        ");
      out.write("\n");
      out.write("        ");

            int x = 10;
            // vezuje varijablu iz java koda za naziv iste van java koda
            request.setAttribute("x", x);
        
      out.write("\n");
      out.write("        ");
      out.write("\n");
      out.write("        number is: ");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${x}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("\n");
      out.write("        ");
      out.write("\n");
      out.write("        ");
      out.write("\n");
      out.write("\n");
      out.write("        <br/>\n");
      out.write("        \n");
      out.write("        ");
      out.write("\n");
      out.write("        ");
      out.write("\n");
      out.write("        ");

            Person p = new Person();
            // vezuje naziv objekta iz java koda za naziv iste van java koda
            request.setAttribute("p", p);
        
      out.write("\n");
      out.write("        Person is: ");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${p.name}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("\n");
      out.write("        ");
      out.write("\n");
      out.write("        Person is: ");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${p['name']}", java.lang.String.class, (PageContext)_jspx_page_context, null));
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
