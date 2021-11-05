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
import java.util.logging.Level;
import java.util.logging.Logger;
import jdk.jfr.DataAmount;

/**
 *
 * @author ASUS
 */
public class UDPServer {
    public static void main(String[] args) throws IOException {
        try {
            DatagramSocket datagramSocket = new DatagramSocket(8079) ;
            byte[] readBuffer = new byte[1024];
            byte[] writeBuffer = null;
            System.out.println("Listening ..");
            while (true) {                
                DatagramPacket datagramPacket = new DatagramPacket( readBuffer , readBuffer.length );
                datagramSocket.receive(datagramPacket);
                
                String line = new String( datagramPacket.getData());
                System.out.println("recived: " + line );
                
                writeBuffer = line.toUpperCase().getBytes();
                
                InetAddress host = datagramPacket.getAddress();
                int port = datagramPacket.getPort();
                
                DatagramPacket sendPacker = new DatagramPacket( writeBuffer , writeBuffer.length , host , port );
                System.out.println("Send: "  + line.toUpperCase());
                datagramSocket.send(sendPacker);
                       
            }
            
        } catch (SocketException ex) {
            ex.getStackTrace();
        }
        
    }
}
