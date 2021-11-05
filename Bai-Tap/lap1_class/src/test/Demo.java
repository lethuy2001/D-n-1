/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test;

import java.util.ArrayList;

/**
 *
 * @author ASUS
 */
public class Demo {
   
    
    public static void main(String[] args) {
         ArrayList<StudentUD> list = new ArrayList<>();
        StudentUD sv1 = new StudentUD();
        StudentUD sv2 = new StudentUD( 9 , 9 ,"PT15" , "Lê Minh Thụy" , "158" );
        
        sv2.Output();
        
        list.add( sv2 );
        list.add(sv1) ;
        
        for( StudentUD x : list ){
             x.Output();
        }
        
    }
}
