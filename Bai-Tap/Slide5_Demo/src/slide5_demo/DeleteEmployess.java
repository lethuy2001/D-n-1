/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package slide5_demo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author ASUS
 */
public class DeleteEmployess {
    public static void main(String[] args) throws SQLException {
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            String url = "jdbc:sqlserver://localhost:1433;databasename=EMPDB;";
            String userName = "sa" ;
            String password = "demo";
            
            Connection con = DriverManager.getConnection(url, userName, password);
            Statement stmt = con.createStatement();
            String sql = "delete from Employess where ID = 5 " ;
            stmt.executeUpdate(sql);
            
            String sql2 = "Update Employess set age += 10 where ID = 10" ;
            stmt.executeUpdate(sql2);
            
            stmt.close();
            con.close();
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(KetNoi.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
  
}
