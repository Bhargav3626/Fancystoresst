package com.fancystore.dao;

import java.sql.*;
import com.fancystore.util.DBConnection;

public class AdminDAO {

    public boolean validateAdmin(String username, String password) {
        boolean status = false;

        try {
            Connection con = DBConnection.getConnection();

            PreparedStatement ps = con.prepareStatement(
                "SELECT * FROM admin WHERE username=? AND password=?"
            );

            ps.setString(1, username);
            ps.setString(2, password);

            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                status = true;
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return status;
    }
}