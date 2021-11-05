/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lap7_class;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.net.Socket;
import java.util.Scanner;

/**
 *
 * @author ASUS
 */
public class TCPClient {
    public static void main(String[] args) {
        try {
            Scanner scanner = new Scanner(System.in);
            System.out.println("Client is connecting...");
            Socket socket = new Socket("localhost" , 9878);
            System.out.println("Client is connect");
            
            DataInputStream reader = new DataInputStream( socket.getInputStream());
            DataOutputStream writer = new DataOutputStream( socket.getOutputStream());
            
            while (true) {                
                System.out.println("Nhập số thứ 1: ");
                double a1 = Double.parseDouble(scanner.nextLine());
                writer.writeDouble(a1);
                writer.flush();
                
                System.out.println("Nhập số thứ 2: ");
                double a2 = Double.parseDouble(scanner.nextLine());
                writer.writeDouble(a2);
                writer.flush();
                
                double sum = reader.readDouble();
                System.out.println("Tông: " + sum );
                
                System.out.println("Bạn có muốn tiếp tục không Y/N");
                String s = scanner.nextLine();
                
                if( s.equalsIgnoreCase("N")){
                     break;
                }
            }
        } catch (Exception e) {
        }
    }
}
