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
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import phatnh.customer.CustomerDAO;
import phatnh.customer.CustomerDTO;
import phatnh.utils.Validator;

/**
 *
 * @author nguyenhongphat0
 */
public class RegisterServlet extends HttpServlet {

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
        String url = sc.getInitParameter("registerPage");
        Validator valid = new Validator();
        try {
            String custID = request.getParameter("custID");
            String password = request.getParameter("password");
            String confirm = request.getParameter("confirm");
            String custName = request.getParameter("custName");
            String lastName = request.getParameter("lastName");
            String middleName = request.getParameter("middleName");
            String address = request.getParameter("address");
            String phone = request.getParameter("phone");
            valid.checkLength(custID, 1, 10, "idLength", "ID must be 1 - 10 characters")
                    .checkLength(password, 1, 30, "passwordLength", "Password must be 1 - 30 characters")
                    .checkLength(custName, 0, 15, "nameLength", "Name must be <= 15 characters")
                    .checkLength(lastName, 0, 15, "lastNameLength", "Last name must be <= 15 characters")
                    .checkLength(middleName, 0, 15, "middleNameLength", "Middle name must be <= 15 characters")
                    .checkLength(address, 0, 250, "addressLength", "Address must be <= 250 characters")
                    .checkLength(phone, 0, 11, "phoneLength", "Phone must be <= 11 characters")
                    .checkConfirm(password, confirm, "confirmNotMatch", "Password confirm not match")
                    .checkFormat(phone, "\\+?\\d+", "phoneFormat", "Invalid phone format. A valid phone must contains only numbers and +");
            if (valid.isValid()) {
                CustomerDTO dto = new CustomerDTO(custID, password, custName, lastName, middleName, address, phone, 0);
                CustomerDAO dao = new CustomerDAO();
                boolean res = dao.createCustomer(dto);
                if (res) {
                    url = sc.getInitParameter("loginPage");
                }
            }
        } catch (NamingException ex) {
            Logger.getLogger(RegisterServlet.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            if (ex.getMessage().contains("duplicate")) {
                valid.setError("duplicatePK", "Customer ID existed! Please try another");
            } else {
                Logger.getLogger(RegisterServlet.class.getName()).log(Level.SEVERE, null, ex);
            }
        } finally {
            request.setAttribute("ERRORS", valid.getErrors());
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
