/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package phatnh.servlet.staff;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.naming.NamingException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import phatnh.mobile.MobileDAO;
import phatnh.filter.DispatcherFilter;

/**
 *
 * @author nguyenhongphat0
 */
@WebServlet(name = "UpdateServlet", urlPatterns = {"/StaffUpdateServlet"})
public class StaffUpdateServlet extends HttpServlet {

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
        String url = DispatcherFilter.staffUpdateErrorPage;
        try {
            String priceS = request.getParameter("price");
            float price = Float.parseFloat(priceS);
            String description = request.getParameter("description");
            String quantityS = request.getParameter("quantity");
            int quantity = Integer.parseInt(quantityS);
            String notSaleS = request.getParameter("notSale");
            boolean notSale = false;
            if (notSaleS == null) {
                notSale = true;
            }
            String mobileId = request.getParameter("mobileId");
            String lastSearchId = request.getParameter("lastSearchId");
            String lastSearchName = request.getParameter("lastSearchName");
            MobileDAO dao = new MobileDAO();
            boolean res = dao.updateMobile(mobileId, price, description, quantity, notSale);
            if (res) {
                url = DispatcherFilter.staffSearchServlet
                        + "?mobileId=" + lastSearchId
                        + "&mobileName=" + lastSearchName;
            }
        } catch (NamingException ex) {
            Logger.getLogger(StaffUpdateServlet.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(StaffUpdateServlet.class.getName()).log(Level.SEVERE, null, ex);
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
