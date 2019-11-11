
package servlet;

import database.DBAccount;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.User;

public class RegDBoutput extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, SQLException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet RegDBoutput</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet RegDBoutput at " + request.getContextPath() + "</h1>");

            out.print("username: " + request.getParameter("User") + "<br/>");
            out.print("password: " + request.getParameter("Pass") + "<br/>");
            out.print("radiogroup: " + request.getParameter("RadioGroup") + "<br/>");
            out.print("dropdown menu: " + Integer.parseInt(request.getParameter("city")) + "<br/>");
            
            out.print("register: " + request.getParameter("register") + "<br/>");
            out.print("login: " + request.getParameter("login") + "<br/>");
            out.print("logout: " + request.getParameter("logout") + "<br/>");

            String username = request.getParameter("User");
            String password = request.getParameter("Pass");
            char sex = request.getParameter("RadioGroup").charAt(0);
            int grad_id = Integer.parseInt(request.getParameter("city"));
            
            String register = request.getParameter("register");
            String login = request.getParameter("login");
            String logout  = request.getParameter("logout");
            
            User u = new User(username, password, sex, grad_id);
            
            if(register!=null){
                DBAccount.register(u);
            }else if(login!=null){
                DBAccount.login(u);
            }else if(logout!=null){
                DBAccount.logout();
            }

            RequestDispatcher requestDispatcher
                    = request.getRequestDispatcher("index.jsp");
            requestDispatcher.forward(request, response);
            
            out.println("</body>");
            out.println("</html>");
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            processRequest(request, response);
        } catch (SQLException ex) {
            Logger.getLogger(RegDBoutput.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            processRequest(request, response);
        } catch (SQLException ex) {
            Logger.getLogger(RegDBoutput.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
