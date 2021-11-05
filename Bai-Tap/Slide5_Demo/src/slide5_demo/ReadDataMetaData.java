/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package slide5_demo;

import java.util.logging.Level;
import java.util.logging.Logger;
import java.sql.* ;

/**
 *
 * @author ASUS
 */
public class ReadDataMetaData {
    public static void main(String[] args) throws SQLException {
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            String url = "jdbc:sqlserver://localhost:1433;databasename=EMPDB;";
            String userName = "sa" ;
            String password = "demo";
            Connection con = DriverManager.getConnection(url, userName, password) ;
            
            DatabaseMetaData dmd = con.getMetaData();
            
            System.out.println("" + dmd.getDriverName());
            System.out.println("" + dmd.getDatabaseProductName());
            System.out.println("" + dmd.getDatabaseProductVersion());
            System.out.println("" + dmd.getURL());
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ReadDataMetaData.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
