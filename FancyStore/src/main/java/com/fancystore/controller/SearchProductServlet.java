package com.fancystore.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

import com.fancystore.dao.ProductDAO;
import com.fancystore.model.Product;

@WebServlet("/SearchProductServlet")
public class SearchProductServlet extends HttpServlet {

    private static final long serialVersionUID = 1L;

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String keyword = request.getParameter("keyword");
        String source = request.getParameter("source");

        ProductDAO dao = new ProductDAO();
        List<Product> list = dao.searchProducts(keyword);

        request.setAttribute("products", list);

        if("admin".equals(source)) {

            RequestDispatcher rd = request.getRequestDispatcher("products.jsp");
            rd.forward(request, response);

        } else {

            RequestDispatcher rd = request.getRequestDispatcher("index.jsp");
            rd.forward(request, response);

        }
    }

    protected void doPost(HttpServletRequest req, HttpServletResponse res)
            throws ServletException, IOException {

        doGet(req, res);
    }
}