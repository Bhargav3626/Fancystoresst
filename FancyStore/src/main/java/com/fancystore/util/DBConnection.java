package com.fancystore.util;

import java.sql.Connection;
import java.sql.DriverManager;

public class DBConnection {

    private static Connection con;

    public static Connection getConnection() {

        try {

            Class.forName("com.mysql.cj.jdbc.Driver");

            String url = "jdbc:mysql://centerbeam.proxy.rlwy.net:19596/railway";
            String username = "root";
            String password = "IQASTRoHaWdcsvGdnBSEupGQlnWYEKRz";

            con = DriverManager.getConnection(url, username, password);

        } 
        catch (Exception e) {
            e.printStackTrace();
        }

        return con;
    }
}
