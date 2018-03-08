package phatnh.servlet.staff;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

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
@WebServlet(urlPatterns = {"/staff/StaffSearchServlet"})
public class StaffSearchServlet extends HttpServlet {

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
        try {
            String mobileId = request.getParameter("mobileId");
            String mobileName = request.getParameter("mobileName");
            if (mobileId != null && mobileId.trim().length() > 0) {
                MobileDAO dao = new MobileDAO();
                dao.searchById(mobileId);
                if (dao.getList() != null) {
                    request.setAttribute("RES", dao.getList());
                } else {
                    request.setAttribute("message", "No mobile found with that ID!");
                }
            } else if (mobileName != null && mobileName.trim().length() > 0) {
                MobileDAO dao = new MobileDAO();
                dao.searchByName(mobileName);
                if (dao.getList() != null) {
                    request.setAttribute("RES", dao.getList());
                } else {
                    request.setAttribute("message", "No mobile found with that name!");
                }
            }
        } catch (SQLException ex) {
            Logger.getLogger(StaffSearchServlet.class.getName()).log(Level.SEVERE, null, ex);
        } catch (NamingException ex) {
            Logger.getLogger(StaffSearchServlet.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            request.getRequestDispatcher(DispatcherFilter.staffPage)
                    .forward(request, response);
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
