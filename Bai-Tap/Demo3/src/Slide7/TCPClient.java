package Slide7;

import java.io.*;
import java.net.*;
import java.util.Scanner;

public class TCPClient {

    public static void main(String[] args) {
        try {
            Socket socket = new Socket("127.0.0.1", 6789);

            BufferedReader reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            PrintWriter pw = new PrintWriter(socket.getOutputStream());

            Scanner sc = new Scanner(System.in);
            System.out.println("Enter a line: ");
            String st = sc.nextLine();
            System.out.println("Sent: " + st);
            pw.print(st);
            pw.flush();

            String line = reader.readLine();
            System.out.println("Received: " + line);

            reader.close();
            pw.close();
            socket.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
