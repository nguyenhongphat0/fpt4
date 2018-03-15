/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package phatnh.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import phatnh.book.BookDTO;
import phatnh.customer.CustomerDTO;
import phatnh.order.OrderDTO;
import phatnh.orderdetail.OrderDetailDTO;
import phatnh.session.CartObject;

/**
 *
 * @author nguyenhongphat0
 */
public class AddBookToCartServlet extends HttpServlet {

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
        String url = sc.getInitParameter("showAllBookServlet");
        try {
            String bookID = request.getParameter("bookID");
            String title = request.getParameter("title");
            String priceS = request.getParameter("price");
            float price = Float.parseFloat(priceS);
            HttpSession session = request.getSession();
            CartObject cart = (CartObject) session.getAttribute("CART");
            CustomerDTO custDTO = (CustomerDTO) session.getAttribute("CUST");
            if (cart == null) {
                cart = new CartObject(custDTO);
            }
            BookDTO bookDto = new BookDTO(bookID, title, price, 0);
            cart.addToCart(bookDto);
            session.setAttribute("CART", cart);
        } catch (NumberFormatException e) {
            log("AddBookToCartServlet - NumberFormatException: " + e.getMessage());
        } catch (NullPointerException e) {
            log("AddBookToCartServlet - NullPointerException: " + e.getMessage());
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
