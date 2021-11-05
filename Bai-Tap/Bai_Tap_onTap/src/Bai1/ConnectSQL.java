/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Bai1;
import java.sql.* ; 
/**
 *
 * @author ASUS
 */
public class ConnectSQL {
    public static Connection OpenLink() throws Exception{
         Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
         String url = "jdbc:sqlserver://localhost:1433;databasename=TestAss1" ;
         String user = "sa" ;
         String password = "demo";
         Connection con = DriverManager.getConnection(url, user, password);
         return con ;
    }
}
