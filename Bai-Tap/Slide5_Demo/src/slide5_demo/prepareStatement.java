/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package slide5_demo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author ASUS
 */
public class prepareStatement {
    public static void main(String[] args) throws SQLException {
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            String url = "jdbc:sqlserver://localhost:1433;databasename=EMPDB;";
            String userName = "sa" ;
            String password = "demo";
            
            Connection con = DriverManager.getConnection(url, userName, password);
            String sql = "Update Employess set age =? where ID = 10" ;
            PreparedStatement pstm = con.prepareStatement(sql);
            pstm.setInt(1, 10);
            pstm.executeUpdate();
            
            String sql2 = "Insert into Employess values ( ? , ? , ? , ? )";
            PreparedStatement psv = con.prepareStatement(sql2);
            psv.setInt(1, 11);
            psv.setString(2, "Thụy");
            psv.setString(3, "Lê Minh");
            psv.setInt(4, 20);
            psv.executeUpdate();
            
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(prepareStatement.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
