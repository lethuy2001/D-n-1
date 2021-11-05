/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package slide2_class;

import java.awt.Button;
import java.awt.Frame;
import java.awt.GridLayout;
import java.awt.Panel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 *
 * @author ASUS
 */
public class Demo extends Frame{
    public Demo(){
        setTitle("Hello World");
    
        Panel sp = new Panel( new GridLayout() ) ;
        Button p = null ;
        
        for( int i=0 ; i<9 ; i++ ){
            p = new Button("" + (i+1)) ;
            sp.add(p);
        }
        
        p.addActionListener( new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
               
            }
        });
    }
}
