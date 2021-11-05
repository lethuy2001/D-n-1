/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Check_box;

import java.awt.Checkbox;
import java.awt.FlowLayout;
import java.awt.Frame;
import java.awt.GridLayout;
import java.awt.Label;

/**
 *
 * @author ASUS
 */
public class check_box extends Frame{
    Checkbox cb1 , cb2 , cb3 ;
    Label  lb1 , lb2  ;
    
    public check_box(){
        setTitle("Ví Dụ Java Swing");
        setLayout(new GridLayout(3 , 1));
        
        lb1 = new Label("Control in Action: CheckBox");
        cb1 = new Checkbox("Apple");
        cb2 = new Checkbox("Mango");
        cb3 = new Checkbox("Peer");
        lb2 = new Label("");
        
        add(lb1);
        add(cb1);
        add(cb2);
        add(cb3) ;
        add(lb2);
        
        
    }
}
