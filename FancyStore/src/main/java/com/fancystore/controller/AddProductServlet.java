package com.fancystore.controller;

import java.io.File;
import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

import com.fancystore.dao.ProductDAO;
import com.fancystore.model.Product;

@WebServlet("/AddProductServlet")
@MultipartConfig
public class AddProductServlet extends HttpServlet {

private static final long serialVersionUID = 1L;

protected void doPost(HttpServletRequest req, HttpServletResponse res)
        throws ServletException, IOException {

    String name = req.getParameter("name");
    String price = req.getParameter("price");
    String category = req.getParameter("category");

    Part filePart = req.getPart("image");
    String fileName = filePart.getSubmittedFileName();

    String uploadPath = getServletContext().getRealPath("") + File.separator + "images";

    File uploadDir = new File(uploadPath);
    if (!uploadDir.exists()) {
        uploadDir.mkdir();
    }

    filePart.write(uploadPath + File.separator + fileName);

    try {

        Product p = new Product();
        p.setName(name);
        p.setPrice(Double.parseDouble(price));
        p.setCategory(category);
        p.setImage("images/" + fileName);

        ProductDAO dao = new ProductDAO();
        dao.addProduct(p);

        res.sendRedirect("adminDashboard.jsp");

    } catch (Exception e) {
        e.printStackTrace();
        res.sendRedirect("addProduct.jsp");
    }
}

}
