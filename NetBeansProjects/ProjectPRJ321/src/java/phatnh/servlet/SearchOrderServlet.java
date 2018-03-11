/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package phatnh.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Date;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.naming.NamingException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import phatnh.order.OrderDAO;
import phatnh.order.OrderDTO;

/**
 *
 * @author nguyenhongphat0
 */
public class SearchOrderServlet extends HttpServlet {

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
        String url = sc.getInitParameter("orderListPage");
        try {
            String fromDateString = request.getParameter("fromdate");
            String toDateString = request.getParameter("todate");
            if (fromDateString.trim().length() == 0 || toDateString.trim().length() == 0) {
                url = sc.getInitParameter("searchPage");
            } else {
                Date fromDate = Date.valueOf(fromDateString);
                Date toDate = Date.valueOf(toDateString);
                Timestamp from = new Timestamp(fromDate.getTime());
                Timestamp to = new Timestamp(toDate.getTime());
                OrderDAO dao = new OrderDAO();
                dao.searchBetween(from, to);
                List<OrderDTO> list = dao.getOrdersList();
                if (list != null) {
                    request.setAttribute("RES", list);
                } else {
                    request.setAttribute("msg", "No order found!!!");
                }
            }
        } catch (NamingException ex) {
            Logger.getLogger(SearchOrderServlet.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            if (ex.getMessage().contains("datetime")) {
                request.setAttribute("msg", "Invalid date format. Year must be above 1753");
            } else {
                Logger.getLogger(SearchOrderServlet.class.getName()).log(Level.SEVERE, null, ex);
            }
        } catch (IllegalArgumentException ex) {
            request.setAttribute("msg", "Invalid date format. Year must be smaller than 9999");
        } finally {
            RequestDispatcher rd = request.getRequestDispatcher(url);
            rd.forward(request, response);
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
