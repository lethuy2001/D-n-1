/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package baitap1_2;

import java.sql.* ;

/**
 *
 * @author ASUS
 */
public class ConnectSQL {
    public static Connection OPenTheLink() throws Exception{
          Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
          String username = "sa" ;
          String password = "demo" ;      
          String url = "jdbc:sqlserver://localhost:1433;databasename=LT6C";
          Connection con =  DriverManager.getConnection(url, username, password);
          return con ;
    }
}
