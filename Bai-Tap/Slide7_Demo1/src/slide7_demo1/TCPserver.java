/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package slide7_demo1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

/**
 *
 * @author ASUS
 */
public class TCPserver {
        public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = new ServerSocket(6789) ;
        System.out.println("Listening ...");
        
        try {
            while ( true) {
                   Socket socket = serverSocket.accept();
                   BufferedReader reder = new BufferedReader( new InputStreamReader(socket.getInputStream()));
                   PrintWriter out = new PrintWriter(socket.getOutputStream());     
                   
                   String line =  reder.readLine();
                   
                   System.out.println("Reciesved: " + line );
                   System.out.println("Sent: " + line.toUpperCase());
                   
                   out.println(line.toUpperCase());
                   out.flush();
                   
                   reder.close();
                   socket.close();
                   out.close();
                   
             }        
        } catch (Exception e) {
            e.getStackTrace();
        }
    }
}
