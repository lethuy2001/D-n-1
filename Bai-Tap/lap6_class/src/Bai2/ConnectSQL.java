/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Bai2;

import java.sql.Connection;
import java.sql.DriverManager;

/**
 *
 * @author ASUS
 */
public class ConnectSQL {
    public static Connection OpenLink() throws Exception {
        Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
        String url = "jdbc:sqlserver://localhost:1433;databasename=KidSchool;";
        String username = "sa";
        String password = "demo";
        Connection con = DriverManager.getConnection(url, username, password);
        return con;
    }   
}
