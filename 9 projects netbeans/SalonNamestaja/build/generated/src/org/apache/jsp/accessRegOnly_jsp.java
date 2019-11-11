package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import database.CRUDbasicQueries;
import java.sql.ResultSet;
import servlet.CRUDbasicServlet;
import database.DBaccount;

public final class accessRegOnly_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final JspFactory _jspxFactory = JspFactory.getDefaultFactory();

  private static java.util.List<String> _jspx_dependants;

  private org.apache.jasper.runtime.TagHandlerPool _jspx_tagPool_c_if_test;

  private org.glassfish.jsp.api.ResourceInjector _jspx_resourceInjector;

  public java.util.List<String> getDependants() {
    return _jspx_dependants;
  }

  public void _jspInit() {
    _jspx_tagPool_c_if_test = org.apache.jasper.runtime.TagHandlerPool.getTagHandlerPool(getServletConfig());
  }

  public void _jspDestroy() {
    _jspx_tagPool_c_if_test.release();
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
      out.write("\n");
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
      out.write("\n");
      out.write("        ");
      out.write("\n");
      out.write("        \n");
      out.write("        ");
      out.write("\n");
      out.write("        ");
if (DBaccount.logon == 0) {
            {
      out.write("\n");
      out.write("                ");
      if (true) {
        _jspx_page_context.forward("regDB.jsp");
        return;
      }
      out.write(";\n");
      out.write("            ");
}
        }
      out.write("\n");
      out.write("        \n");
      out.write("        ");
      out.write("  \n");
      out.write("        ");

            request.setAttribute("logon", DBaccount.logon);
        
      out.write("\n");
      out.write("        ");
      if (_jspx_meth_c_if_0(_jspx_page_context))
        return;
      out.write("\n");
      out.write(" \n");
      out.write("        <h1>CONGRATULATIONS YOU ARE LOGGED IN</h1>\n");
      out.write("        \n");
      out.write("        ");
      out.write("\n");
      out.write("        \n");
      out.write("        ");
      out.write("\n");
      out.write("        <form name=\"c\" action=\"CRUDbasicServlet\" method=\"post\">\n");
      out.write("            text for insert: <input type=\"text\" name=\"textForInsert\"/>\n");
      out.write("            <input type=\"submit\" name=\"insert\" value=\"insert\">\n");
      out.write("        </form>\n");
      out.write("        \n");
      out.write("        ");
      out.write("\n");
      out.write("        \n");
      out.write("        ");
      out.write("\n");
      out.write("        ");

            CRUDbasicServlet.rs = CRUDbasicQueries.basicGet();
            CRUDbasicServlet.hm = CRUDbasicQueries.basicConvertMap(CRUDbasicServlet.rs);
            request.setAttribute("resultsetmap", CRUDbasicServlet.hm);
            
            while(CRUDbasicServlet.rs.next()){
                System.out.print(CRUDbasicServlet.rs.getInt(1) + " ");
                System.out.print(CRUDbasicServlet.rs.getString(2) + " ");
            }
        
      out.write("\n");
      out.write("        \n");
      out.write("        ");
      out.write("\n");
      out.write("        ");

            out.println("<table><tr><th>id</th><th>data</th></tr>");
            while(CRUDbasicServlet.rs.next()){
                out.println("<tr>");
                System.out.print("<td>" + CRUDbasicServlet.rs.getInt(1) + "</td>");
                System.out.print("<td>" + CRUDbasicServlet.rs.getString(2) + "</td>");
                out.println("</tr>");
            }
            out.println("</table>");
        
      out.write("\n");
      out.write("        ");
      out.write("\n");
      out.write("        ");
      out.write("\n");
      out.write("        <br/>\n");
      out.write("        ");
      out.write("\n");
      out.write("        ");
      out.write("\n");
      out.write("        \n");
      out.write("        ");
      out.write("\n");
      out.write("        \n");
      out.write("        ");
      out.write("\n");
      out.write("        ");
      out.write("\n");
      out.write("        \n");
      out.write("        ");
      out.write("\n");
      out.write("        \n");
      out.write("        ");
      out.write("\n");
      out.write("        ");
      out.write("\n");
      out.write("\n");
      out.write("        ");
      out.write("\n");
      out.write("</body>\n");
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

  private boolean _jspx_meth_c_if_0(PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  c:if
    org.apache.taglibs.standard.tag.rt.core.IfTag _jspx_th_c_if_0 = (org.apache.taglibs.standard.tag.rt.core.IfTag) _jspx_tagPool_c_if_test.get(org.apache.taglibs.standard.tag.rt.core.IfTag.class);
    _jspx_th_c_if_0.setPageContext(_jspx_page_context);
    _jspx_th_c_if_0.setParent(null);
    _jspx_th_c_if_0.setTest(((java.lang.Boolean) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${sessionScope.logon == 0}", java.lang.Boolean.class, (PageContext)_jspx_page_context, null)).booleanValue());
    int _jspx_eval_c_if_0 = _jspx_th_c_if_0.doStartTag();
    if (_jspx_eval_c_if_0 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
      do {
        out.write("\n");
        out.write("            ");
        if (true) {
          _jspx_page_context.forward("regDB.jsp");
          return true;
        }
        out.write(";\n");
        out.write("        ");
        int evalDoAfterBody = _jspx_th_c_if_0.doAfterBody();
        if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
          break;
      } while (true);
    }
    if (_jspx_th_c_if_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _jspx_tagPool_c_if_test.reuse(_jspx_th_c_if_0);
      return true;
    }
    _jspx_tagPool_c_if_test.reuse(_jspx_th_c_if_0);
    return false;
  }
}
