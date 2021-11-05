package Slide7;

import java.io.*;
import java.net.*;

public class TCPServer {

    public static void main(String[] args) throws IOException{
            ServerSocket serverSocket = new ServerSocket(6789);
            System.out.println("Listening..... ");        
        try {

            while (true) {
                Socket socket = serverSocket.accept();

                BufferedReader reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                PrintWriter pw = new PrintWriter(socket.getOutputStream());

                String line = reader.readLine();

                System.out.println("Received: " + line);
                System.out.println("Sent: " + line.toUpperCase());

                pw.println(line.toUpperCase());
                pw.flush();

                reader.close();
                pw.close();
                socket.close();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
