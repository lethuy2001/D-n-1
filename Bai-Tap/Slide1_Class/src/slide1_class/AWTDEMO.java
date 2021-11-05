/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package slide1_class;

import java.awt.Button;
import java.awt.Color;
import java.awt.Desktop;
import java.awt.FlowLayout;
import java.awt.Frame;
import java.awt.Label;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 *
 * @author ASUS
 */
public class AWTDEMO extends Frame {
    Button btnRed , btnBlue ; 
    Label lblResult ;
    public AWTDEMO(){
        setTitle("Siêu Nhân");
        setLayout(new FlowLayout());
        
        btnBlue = new Button("Blue");
        btnRed = new Button("Red");
        lblResult = new Label("Result");
        
        add(btnBlue);
        add(btnRed);
        
        btnRed.addActionListener( new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setBackground(Color.RED);
                lblResult.setText("Red");
            }
        } );
        
        btnBlue.addActionListener( new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                setBackground(Color.cyan);
                lblResult.setText("CYAN");                
            }
        });
        
    }
}
