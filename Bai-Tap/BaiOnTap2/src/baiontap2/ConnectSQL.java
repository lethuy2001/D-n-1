/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package baiontap2;
import java.sql.* ;

/**
 *
 * @author ASUS
 */
public class ConnectSQL {
    public static Connection OpenLinkSQL() throws Exception{
        Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
        String username = "sa";
        String password = "demo";
        String url = "jdbc:sqlserver://localhost:1433;databasename=TestAss1;";
        Connection con = DriverManager.getConnection(url, username, password);
        return con ;
    }
}
