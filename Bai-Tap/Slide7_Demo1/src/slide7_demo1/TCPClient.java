/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package slide7_demo1;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;
import javax.crypto.SealedObject;

/**
 *
 * @author ASUS
 */
public class TCPClient {
    public static void main(String[] args){
        
        try {
            while ( true) {
                   Socket socket = new Socket("127.0.0.1" , 6789 );
                   BufferedReader reder = new BufferedReader( new InputStreamReader(socket.getInputStream()));
                   PrintWriter out = new PrintWriter(socket.getOutputStream());     
                   
                   Scanner s = new Scanner(System.in);
                   System.out.println("Enter a line: ");
                   String st  = s.nextLine();
                   System.out.println("Sent: " + st);
                   out.println(st);
                   out.flush();
                   
                   String line =  reder.readLine();
                   System.out.println("Reciesved: " + line );
                   
                   reder.close();
                   socket.close();
                   out.close();
                   
             }        
        } catch (Exception e) {
            e.getStackTrace();
        }
    }
}
