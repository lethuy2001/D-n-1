/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Bai1;

import java.util.logging.Level;
import java.util.logging.Logger;
import java.sql.*;

/**
 *
 * @author ASUS
 */
public class Bai1 {

    public static void main(String[] args) throws SQLException {
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            String usl = "jdbc:sqlserver://localhost:1433;databasename = QLSV1";
            String username = "sa" ;
            String password = "demo" ;
            Connection con =  DriverManager.getConnection(usl, username, password);
            String spl = "select * from STUDENTS" ;
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery(spl);
            
            while( rs.next()){
                System.out.print("MaSV: " + rs.getString("MaSV"));
                System.out.print(" Họ Tên: " + rs.getString("HoTen"));
                System.out.print(" Email: " + rs.getString("Email"));
                System.out.print(" SoDT: " + rs.getString("SoDT"));
                System.out.println(" DiaChi: " + rs.getString("DiaChi"));
            }
            
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Bai1.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
}
