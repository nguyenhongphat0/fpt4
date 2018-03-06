/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.naming.NamingException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import users.RegistrationInsertError;
import users.UsersDAO;

/**
 *
 * @author nguyenhongphat0
 */
@WebServlet(name = "RegisterServlet", urlPatterns = {"/RegisterServlet"})
public class RegisterServlet extends HttpServlet {
    private final String loginPage = "login.html";
    private final String errorPage = "register.jsp";

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
        String username = request.getParameter("txtUsername");
        String password = request.getParameter("txtPassword");
        String confirm = request.getParameter("txtConfirm");
        String fullname = request.getParameter("txtFullname");
        boolean isError = false;
        RegistrationInsertError errors = new RegistrationInsertError();
        String url = errorPage;
        try {
            // 1. Kiem tra cac loi nguoi su dung
            if (username.trim().length() < 6 || username.trim().length() > 30) {
                isError = true;
                errors.setUsernameLengthError("Username length requires 6 - 30 chars");
            }
            if (password.trim().length() < 6 || password.trim().length() > 30) {
                isError = true;
                errors.setPasswordLengthError("Password length requires 6 - 30 chars");
            } else if (!confirm.equals(password)) {
                isError = true;
                errors.setConfirmPasswordNotMatch("Confirm not match password");
            }
            if (fullname.trim().length() < 2 || fullname.trim().length() > 50) {
                isError = true;
                errors.setFullnameLengthError("Fullname length requires 6 - 50 chars");
            }
            
            // 2. Xu ly loi
            if (isError) {
                request.setAttribute("INSERTERROR", errors);
            } else {
                UsersDAO dao = new UsersDAO();
                boolean res = dao.createNewAccount(username, password, fullname, false);
                if (res) {
                    url = loginPage;
                }
            }
        } catch (SQLException ex) {
            log("RegisterServlet _ SQLException: " + ex.getMessage());
            if (ex.getMessage().contains("duplicate")) {
                errors.setUsernameIsExisted("Username is dupplicated");
                request.setAttribute("INSERTERROR", errors);
            }
        } catch (NamingException ex) {
            Logger.getLogger(RegisterServlet.class.getName()).log(Level.SEVERE, null, ex);
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
