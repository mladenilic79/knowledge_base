
package servlet.crudAdvanced;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.CrudBasicData;

public class ViewwAdv extends HttpServlet {

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
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet Vieww2</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet Vieww2 at " + request.getContextPath() + "</h1>");
            
            
            
            // not implemented
            
//            out.print("textForSearch: " + request.getParameter("textForSearch") + "<br/>");
//            String textForSearch = request.getParameter("textForSearch");
//            out.print("idForSearch: " + request.getParameter("idForSearch") + "<br/>");
//            String idForSearch = request.getParameter("idForSearch");
//            int idForSearch2 = Integer.parseInt(idForSearch);
//            out.print("search: " + request.getParameter("search") + "<br/>");
//            String search = request.getParameter("search");

//            List<CRUDbasicData> dataList;

//            if(textForSearch==null){
//                dataList = CRUDbasicQueries.basicGet();
//            }else{
//                dataList = CRUDbasicQueries.basicGet(textForSearch);
//            }
            
            
            
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
        processRequest(request, response);
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
        processRequest(request, response);
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
