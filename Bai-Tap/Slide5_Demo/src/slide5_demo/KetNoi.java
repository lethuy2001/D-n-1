/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package slide5_demo;

import Heper.NewClass;
import java.util.concurrent.locks.Condition;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.sql.* ;
import javax.tools.StandardJavaFileManager;

/**
 *
 * @author ASUS
 */
public class KetNoi {
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws SQLException {
        try {
            try (  Connection con = NewClass.OpenLink();
                   Statement sp = con.createStatement();
                    ){
                   System.out.println("Kết nối thành công");
            }
            
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(KetNoi.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
