/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package slide1_class;

import java.awt.Button;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Label;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

/**
 *
 * @author ASUS
 */
public class Swing extends JFrame{
    JButton btnRed , btnBlue ;
    JLabel lbl ;
    
    public Swing(){
                setTitle("Siêu Nhân");
        setLayout(new FlowLayout());
        
        btnBlue = new JButton("Blue");
        btnRed = new JButton("Red");
        lbl = new JLabel("Result");
        
        add(btnBlue);
        add(btnRed);
        
        btnRed.addActionListener( new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                getContentPane().setBackground(Color.red);
                lbl.setText("Red");
            }
        } );
        
        btnBlue.addActionListener( new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                getContentPane().setBackground(Color.cyan);
                lbl.setText("CYAN");                
            }
        });
    }
}
