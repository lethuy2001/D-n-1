/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lap7_class;

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import jdk.jfr.DataAmount;

/**
 *
 * @author ASUS
 */
public class TCPServer {
    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = new ServerSocket(9878) ;
        System.out.println("Listening ...");
        System.out.println("Connect...");
        try {
            while (true) {                
                 Socket socket = serverSocket.accept();
                 DataInputStream reader = new DataInputStream( socket.getInputStream());
                 DataOutputStream writer = new DataOutputStream( socket.getOutputStream());        
                 
                 double a1 = reader.readDouble();
                 double a2 = reader.readDouble();
                 
                 System.out.println("2 số nhận đc từ client \na1: " + a1 + "\na2: " + a2 );
                 double sum = a1 + a2 ;
                 
                 writer.writeDouble(sum);
                 writer.flush();
                 System.out.println("Tổng: " + sum);
            }   
        } catch (Exception e) {
        }
    }
}
