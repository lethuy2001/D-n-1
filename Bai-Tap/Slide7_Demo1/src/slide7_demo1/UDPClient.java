/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package slide7_demo1;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;
import java.util.Scanner;

/**
 *
 * @author ASUS
 */
public class UDPClient {
    public static void main(String[] args) throws IOException {
        try {
            Scanner s = new Scanner(System.in);
            System.out.println("Enter a line: ");
            String st = s.nextLine();
            
            
            DatagramSocket datagramSocket = new DatagramSocket() ;
            byte[] readBuffer = new byte[1024];
            byte[] writeBuffer = null;
            
            InetAddress host = InetAddress.getByName("localhost");
            int port = 8079 ;            
            writeBuffer = st.getBytes();
            DatagramPacket sendPacker = new DatagramPacket( writeBuffer , writeBuffer.length , host , port );
            System.out.println("Send: "  + st );
            datagramSocket.send(sendPacker);            
    
            DatagramPacket datagramPacket = new DatagramPacket( readBuffer , readBuffer.length );
            datagramSocket.receive(datagramPacket);
                
            String line = new String( datagramPacket.getData());
            System.out.println("recived: " + line );
                
        } catch (SocketException ex) {
            ex.getStackTrace();
        }
        
    }
}
