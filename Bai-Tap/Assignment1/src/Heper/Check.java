/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Heper;

/**
 *
 * @author ASUS
 */
public class Check {
    public static boolean CheckDiem( String diem){
        try {
             double a = Double.valueOf(diem);
             if( a >= 0 && a <= 10 ){
             return true ;
        }
        
        } catch (Exception e) {
            return false ;
        }
        return false ;
    }
    
    public static boolean CheckDoDaiMa( String ma){
       if( ma.length() >= 7 ){
           return true ;
       }
       return false ;
    }
    
    public static boolean CheckMa( String ma ){
       String ranger = "PH\\d{5,6}" ;
       if( ma.matches(ranger) ){
          return true ;
       }
       return false ;
    }
    
    public static boolean CheckSDT( String sdt ){
       String ranger = "0[3,9](\\d){8}";
       if( sdt.matches(ranger) ){
          return true; 
       }
       return false ;
    }
    
    public static boolean CheckTen( String Ten){
       String ranger = "@\\d" ;
       if( !Ten.matches(ranger) ){
          return true; 
       }
       return false ;       
    }

    public static boolean CheckEmail( String email ){
       String ranger = "\\w+@fpt.edu.vn" ;
       if( email.matches(ranger) ){
          return true; 
       }
       return false ;       
    }    
}
