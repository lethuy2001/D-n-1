/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package slide1_class;

import java.awt.Checkbox;
import java.awt.FlowLayout;
import java.awt.Frame;
import java.awt.Label;

/**
 *
 * @author ASUS
 */
public class check_box extends Frame{
    Checkbox cb1 , cb2 , cb3 ; 
    Label lb1 , lb2 ;
       
    public check_box(){
         setTitle("PT16302");
         setLayout( new FlowLayout());
         
         cb1 = new Checkbox("Foodball");
         cb2 = new Checkbox("Game");
         cb3 = new Checkbox("Swimming");
         
         add(cb1 );
         add(cb2) ;
         add(cb3) ;
     
    }
}
