/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package slide5_demo;

import java.net.CacheRequest;
import java.sql.Connection;
import java.sql.*;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author ASUS
 */
public class getEmployessName {
    public static void main(String[] args) throws SQLException {
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            String url = "jdbc:sqlserver://localhost:1433;databasename=EMPDB;";
            String userName = "sa" ;
            String password = "demo";
            String sql = "{call GetEmployeesName ( ? ,?) }" ;
            
            try(    Connection con = DriverManager.getConnection(url, userName, password);
                    CallableStatement cstmt = con.prepareCall(sql);
                    ) {
                    cstmt.setInt(1, 3);
                    cstmt.registerOutParameter(2, Types.NVARCHAR);
                    cstmt.execute();
                    String fist = cstmt.getString(2);
                    System.out.println("First: " + fist);
            }
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(getEmployessName.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
