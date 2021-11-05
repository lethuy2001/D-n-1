/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Heper;

import java.sql.*;

/**
 *
 * @author ASUS
 */
public class NewClass {
    public static Connection OpenLink() throws ClassNotFoundException, SQLException{
        Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
        String user =  "sa" ;
        String password = "demo";
        String url = "jdbc:sqlserver://localhost:1433;databasename=EMPDB;";
        Connection con = DriverManager.getConnection( url , user , password);
        return con ;
    }
}
