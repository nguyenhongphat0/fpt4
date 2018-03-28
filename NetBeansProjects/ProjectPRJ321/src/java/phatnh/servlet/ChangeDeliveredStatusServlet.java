/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package phatnh.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import javax.naming.NamingException;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import phatnh.order.OrderDAO;

/**
 *
 * @author nguyenhongphat0
 */
public class ChangeDeliveredStatusServlet extends HttpServlet {

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
        ServletContext sc = getServletContext();
        String url = sc.getInitParameter("searchOrderServlet");
        try {
            String fromdate = request.getParameter("fromdate");
            String todate = request.getParameter("todate");
            String[] ids = request.getParameterValues("orderID");
            String delivered = request.getParameter("delivered");
            boolean isDeliver = delivered != null;
            OrderDAO dao = new OrderDAO();
            boolean res = true;
            for (String id : ids) {
                String reason = request.getParameter(id + "reason");
                boolean ck = dao.changeStatus(id, !isDeliver, reason);
                if (!ck) {
                    res = false;
                }
            }
            if (!res) {
                request.setAttribute("msg", "Error changing status of these order!");
            }
            url += "?fromdate=" + fromdate
                    + "&todate=" + todate;
            if (isDeliver) {
                url += "&delivered=true";
            }
        } catch (SQLException e) {
            log("ChangeDeliveredStatusServlet - SQLException: " + e.getMessage());
        } catch (NamingException e) {
            log("ChangeDeliveredStatusServlet - NamingException: " + e.getMessage());
        } finally {
            response.sendRedirect(url);
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
