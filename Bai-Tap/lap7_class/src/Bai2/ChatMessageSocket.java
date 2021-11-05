/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Bai2;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.lang.reflect.InaccessibleObjectException;
import java.net.Socket;
import javax.swing.JTextField;
import javax.swing.JTextPane;

/**
 *
 * @author ASUS
 */
public class ChatMessageSocket {
    private Socket socket ;
    private JTextPane textMessage ;
    private PrintWriter printWriter ;
    private BufferedReader bufferedReader ;
    
    public ChatMessageSocket( Socket socket , JTextPane textMessage ) throws Exception{
         this.socket = socket ;
         this.textMessage = textMessage;
         
         printWriter = new PrintWriter( socket.getOutputStream());
         bufferedReader = new BufferedReader( new InputStreamReader( socket.getInputStream()));
         
         receive();
    }
    
    private void receive(){
        Thread th = new Thread(){
             public void run(){
                 while (true) {     
                     try {
                         String line =  bufferedReader.readLine();
                         if( line != null ){
                         textMessage.setText( textMessage.getText() + "\n " + line );
                         }                        
                     } catch (Exception e) {
                     }
                 }
             }
        };
        th.start();
    }
    
    public void Send( String msg ){
        String current = textMessage.getText();
        textMessage.setText( current + "\n" + msg );
        printWriter.println(msg);
        printWriter.flush();
    }
    
    public void Close(){
        try {
            printWriter.close();
            socket.close();
            bufferedReader.close();
        } catch (Exception e) {
        }
    }
}
