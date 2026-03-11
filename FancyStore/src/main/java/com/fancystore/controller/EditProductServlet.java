package com.fancystore.controller;

import java.io.IOException;
import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

import com.fancystore.dao.ProductDAO;
import com.fancystore.model.Product;

@WebServlet("/EditProductServlet")
public class EditProductServlet extends HttpServlet {

    private static final long serialVersionUID = 1L;

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        int id = Integer.parseInt(request.getParameter("id"));

        ProductDAO dao = new ProductDAO();
        Product product = dao.getProductById(id);

        request.setAttribute("product", product);

        RequestDispatcher rd = request.getRequestDispatcher("editProduct.jsp");
        rd.forward(request, response);
    }
    
    protected void doPost(HttpServletRequest req, HttpServletResponse res)
            throws ServletException, IOException {
        doGet(req, res);  
    } 
}