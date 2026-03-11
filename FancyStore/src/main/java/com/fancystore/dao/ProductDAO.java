package com.fancystore.dao;

import java.sql.*;
import java.util.*;
import com.fancystore.model.Product;
import com.fancystore.util.DBConnection;

public class ProductDAO {

    public void addProduct(Product p) {
        try {
            Connection con = DBConnection.getConnection();
            String sql = "INSERT INTO products(name,price,category,image) VALUES(?,?,?,?)";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, p.getName());
            ps.setDouble(2, p.getPrice());
            ps.setString(3, p.getCategory());
            ps.setString(4, p.getImage());
            ps.executeUpdate();
        } catch(Exception e) {
            e.printStackTrace();
        }
    }

    public List<Product> getAllProducts() {
        List<Product> list = new ArrayList<>();
        try {
            Connection con = DBConnection.getConnection();
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery("SELECT * FROM products");

            while(rs.next()) {
                Product p = new Product();
                p.setId(rs.getInt("id"));
                p.setName(rs.getString("name"));
                p.setPrice(rs.getDouble("price"));
                p.setCategory(rs.getString("category"));
                p.setImage(rs.getString("image"));
                list.add(p);
            }
        } catch(Exception e) {
            e.printStackTrace();
        }
        return list;
    }
    
    
    public Product getProductById(int id) {

        Product p = null;

        try {
            Connection con = DBConnection.getConnection();

            PreparedStatement ps =
            con.prepareStatement("SELECT * FROM products WHERE id=?");

            ps.setInt(1, id);

            ResultSet rs = ps.executeQuery();

            if(rs.next()){

                p = new Product();

                p.setId(rs.getInt("id"));
                p.setName(rs.getString("name"));
                p.setPrice(rs.getDouble("price"));
                p.setCategory(rs.getString("category"));
                p.setImage(rs.getString("image"));
            }

        } catch(Exception e){
            e.printStackTrace();
        }

        return p;
    }
    
    
    public void updateProduct(Product p){

        try{

            Connection con = DBConnection.getConnection();

            PreparedStatement ps = con.prepareStatement(
            "UPDATE products SET name=?,price=?,category=?,image=? WHERE id=?");

            ps.setString(1,p.getName());
            ps.setDouble(2,p.getPrice());
            ps.setString(3,p.getCategory());
            ps.setString(4,p.getImage());
            ps.setInt(5,p.getId());

            ps.executeUpdate();

        }catch(Exception e){
            e.printStackTrace();
        }
    }
    
    public List<Product> searchProducts(String keyword){

        List<Product> list = new ArrayList<>();

        try{

            Connection con = DBConnection.getConnection();

            String sql = "SELECT * FROM products WHERE name LIKE ? OR category LIKE ?";

            PreparedStatement ps = con.prepareStatement(sql);

            ps.setString(1,"%"+keyword+"%");
            ps.setString(2,"%"+keyword+"%");

            ResultSet rs = ps.executeQuery();

            while(rs.next()){

                Product p = new Product();

                p.setId(rs.getInt("id"));
                p.setName(rs.getString("name"));
                p.setPrice(rs.getDouble("price"));
                p.setCategory(rs.getString("category"));
                p.setImage(rs.getString("image"));

                list.add(p);
            }

        }catch(Exception e){
            e.printStackTrace();
        }

        return list;
    }

    public void deleteProduct(int id) {
        try {
            Connection con = DBConnection.getConnection();
            PreparedStatement ps = con.prepareStatement("DELETE FROM products WHERE id=?");
            ps.setInt(1, id);
            ps.executeUpdate();
        } catch(Exception e) {
            e.printStackTrace();
        }
    }
}