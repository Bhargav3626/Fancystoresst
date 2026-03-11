package com.fancystore.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

import com.fancystore.dao.ProductDAO;

@WebServlet("/DeleteProductServlet")


public class DeleteProductServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        int id = Integer.parseInt(request.getParameter("id"));

        ProductDAO dao = new ProductDAO();
        dao.deleteProduct(id);

        response.sendRedirect("products.jsp");
    }
}