/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import users.UsersDTO;

/**
 *
 * @author nguyenhongphat0
 */
@WebServlet(name = "SearchResultServlet", urlPatterns = {"/SearchResultServlet"})
public class SearchResultServlet extends HttpServlet {

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
        PrintWriter out = response.getWriter();
        try {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet SearchResultServlet</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Your Search Result</h1>");

            String searchValue = request.getParameter("txtSearchValue");
            List<UsersDTO> res = (List<UsersDTO>) request.getAttribute("SEARCHRESULT");

            if (res != null) {
                out.println("<table border='1'>");
                out.println("<thead>");
                out.println("<tr>");
                out.println("<th>No.</th>");
                out.println("<th>Username</th>");
                out.println("<th>Password</th>");
                out.println("<th>Lastname</th>");
                out.println("<th>Roles</th>");
                out.println("</tr>");
                out.println("</thead>");
                out.println("<tbody>");

                int count  = 0;
                for (UsersDTO dto : res) {
                    out.println("<tr>");
                    out.println("<td>"
                            + ++count
                            + "</td>");
                    out.println("<td>"
                            + dto.getUsername()
                            + "</td>");
                    out.println("<td>"
                            + dto.getPassword()
                            + "</td>");
                    out.println("<td>"
                            + dto.getLastname()
                            + "</td>");
                    out.println("<td>"
                            + dto.isRoles()
                            + "</td>");
                    out.println("</tr>");
                }

                out.println("</tbody>");
                out.println("</table>");
            } else {
                out.println("<h2>No record is match!!!!</h2>");
            }

            out.println("</body>");
            out.println("</html>");
        } finally {
            out.close();
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
