package com.fancystore.controller;

import java.io.IOException;
import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

import com.fancystore.dao.ProductDAO;
import com.fancystore.model.Product;

@WebServlet("/UpdateProductServlet")
public class UpdateProductServlet extends HttpServlet {

    private static final long serialVersionUID = 1L;

    protected void doPost(HttpServletRequest req, HttpServletResponse res)
            throws ServletException, IOException {

        int id = Integer.parseInt(req.getParameter("id"));
        String name = req.getParameter("name");
        double price = Double.parseDouble(req.getParameter("price"));
        String category = req.getParameter("category");
        String image = req.getParameter("image");

        Product p = new Product();
        p.setId(id);
        p.setName(name);
        p.setPrice(price);
        p.setCategory(category);
        p.setImage(image);

        ProductDAO dao = new ProductDAO();
        dao.updateProduct(p);

        res.sendRedirect("products.jsp");
    }
}