/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlet;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author nguyenhongphat0
 */
@WebServlet(name = "FrontServlet", urlPatterns = {"/FrontServlet"})
public class FrontServlet extends HttpServlet {

    private final String loginPage = "login.html";
    private final String loginServlet = "LoginServlet";
    private final String searchServlet = "SearchServlet";
    private final String deleteServlet = "DeleteServlet";
    private final String updateServlet = "UpdateServlet";
    private final String nullServlet = "ProcessCookiesServlet";
    private final String addBookToCartServlet = "AddBookToCartServlet";
    private final String viewCartPage = "viewcart.jsp";
    private final String removeBookFromCartServlet = "RemoveBookFromCartServlet";
    private final String registerServlet = "RegisterServlet";
    private final String checkoutServlet = "CheckoutServlet";
    
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
        String url = loginPage;
        try {
            String button = request.getParameter("btnAction");
            if (button == null) {
                url = nullServlet;
            } else if (button.equals("Login")) {
                url = loginServlet;
            } else if (button.equals("Search")) {
                url = searchServlet;
            } else if (button.equals("Delete")) {
                url = deleteServlet;
            } else if (button.equals("Update")) {
                url = updateServlet;
            } else if (button.equals("Add to cart")) {
                url = addBookToCartServlet;
            } else if (button.equals("View cart")) {
                url = viewCartPage;
            } else if (button.equals("Remove")) {
                url = removeBookFromCartServlet;
            } else if (button.equals("Register")) {
                url = registerServlet;
            } else if (button.equals("Checkout")) {
                url = checkoutServlet;
            }
        } finally {
            RequestDispatcher rd = request.getRequestDispatcher(url);
            rd.forward(request, response);
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
