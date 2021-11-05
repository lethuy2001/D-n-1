/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Heper;

import java.sql.* ;

/**
 *
 * @author ASUS
 */
public class ConnectSQL {
    public static Connection OpenLink() throws Exception{
         Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
         String url = "jdbc:sqlserver://localhost:1433;databasename=QLSV;";
         String username = "sa" ;
         String password = "demo" ;
         Connection con = DriverManager.getConnection(url, username, password);
         return con ;
    }
}
