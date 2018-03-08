/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package phatnh.servlet;

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
import phatnh.filter.DispatcherFilter;
import phatnh.mobile.InsertMobileValidator;
import phatnh.mobile.MobileDAO;

/**
 *
 * @author nguyenhongphat0
 */
@WebServlet(name = "AddMobileServlet", urlPatterns = {"/AddMobileServlet"})
public class AddMobileServlet extends HttpServlet {

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
        String url = DispatcherFilter.staffPage;
        InsertMobileValidator validator = new InsertMobileValidator();
        try {
            String mobileId = request.getParameter("newMobileId");
            validator.checkLength(mobileId, 1, 10, "idLength", "Id 1-10 characters");
            String description = request.getParameter("description");
            validator.checkLength(description, 1, 250, "descriptionLength", "Description 1-250 characters");
            String priceS = request.getParameter("price");
            float price = validator.checkFloat(priceS, "priceFormat", "Price is a float");
            String mobileName = request.getParameter("newMobileName");
            validator.checkLength(mobileName, 1, 20, "nameLength", "Name 1-20 characters");
            String yearOfProductionS = request.getParameter("yearOfProduction");
            int yearOfProduction = validator.checkInt(yearOfProductionS, "yearFormat", "Year is a number");            
            String quantityS = request.getParameter("quantity");
            int quantity = validator.checkInt(quantityS, "quantityFormat", "Quantity is a number");
            String notSaleS = request.getParameter("notSale");
            boolean notSale = false;
            if (notSaleS == null) {
                notSale = true;
            }
            if (validator.getErrors().isEmpty()) {
                MobileDAO dao = new MobileDAO();
                boolean res = dao.addMobile(mobileId, description, price, mobileName, yearOfProduction, quantity, notSale);
                if (res) {
                    url = "SearchServlet"
                            + "?mobileId=" + mobileId;
                }
            }
        } catch (SQLException ex) {
            if (ex.getMessage().contains("duplicate")) {
                validator.setError("pk", "Mobile ID existed");
            } else {
                Logger.getLogger(AddMobileServlet.class.getName()).log(Level.SEVERE, null, ex);
            }
        } catch (NamingException ex) {
            Logger.getLogger(AddMobileServlet.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            request.setAttribute("errors", validator.getErrors());
            request.getRequestDispatcher(url).forward(request, response);
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
