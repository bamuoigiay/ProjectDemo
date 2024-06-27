/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servlets;

import Product.Cart;
import Product.ProductDAO;
import Product.ProductDTO;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author LENOVO
 */
public class AddToCartServlet extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    private String MENU_PAGE = "menu.jsp";

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        String url = MENU_PAGE;
        HashMap<String, Cart> itemsInCart = null;
        Cart item = null;
        String message = null;
        try {
            ProductDAO productDAO = new ProductDAO();
            HttpSession session = request.getSession(true);
            String food = request.getParameter("Food");
            ProductDTO selectedPro = productDAO.getProByName(food);
            itemsInCart = (HashMap<String, Cart>) session.getAttribute("CART");
            if (itemsInCart == null) {
                itemsInCart = new HashMap<String, Cart>();
                session.setAttribute("CART", itemsInCart);
            }
            item = itemsInCart.get(selectedPro.getProductName());
            if (item == null) {
                item = new Cart(selectedPro.getProductID(), selectedPro.getProductName(), 1, selectedPro.getPrice());
                itemsInCart.put(item.getProductName(), item);
                message = "The product " + item.getProductName() + " has been added to cart successfully.";
            } else {
                item.setQuantity(item.getQuantity() + 1);
                message = "The cart has been updated successfully.";
                url = "MainController?action=ViewProduct";
                request.setAttribute("Message", "<h4>" + message + "</h4>");
            }
        } finally {
            response.sendRedirect(url);
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
