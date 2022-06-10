//mvn compile exec:java -Dexec.mainClass="vtp2022.day4.workshop.App"
//https://www.geeksforgeeks.org/java-net-serversocket-class-in-java/#:~:text=In%20java.rmi.Server%2C%20ServerSocket%20class%20is%20used%20to%20create,so%20as%20to%3A%20return%20an%20unbound%20server%20socket.
//Run this class first in one cmd terminal. Then open another terminal (with this one still running) and run Client.java.

package vtp2022.day4.workshop;

import java.net.ServerSocket;
import java.io.*;
import java.net.*;

/**
 * This is the Server file.
 *
 */
public class App 
{
    public static int port = 3333;
    public static String toClient = "";
    public static void main( String[] args ) {   
        String toClient = "";

        try {
            ServerSocket server = new ServerSocket(port);
            System.out.println("listening...please run Client.java...");
            Socket soc = server.accept();
            DataInputStream dis = new DataInputStream(soc.getInputStream());
            String msg = (String)dis.readUTF();
            
            while (!msg.equals("close")) {
                if (msg.equals("get cookie")){
                    Cookie c = new Cookie();
                    toClient = c.get_cookie();
                } 
    
                //other way (First was Client send to Server, now Server back to Client.)
                DataOutputStream d = new DataOutputStream(soc.getOutputStream());
                d.writeUTF("cookie-text " + toClient);
                d.flush();
    
                System.out.println("Message from client: " + msg);
            }
            
            server.close();

        } catch (Exception e) {
            System.out.println(e);
        }
        
        System.out.println( "Server: Working." );
    }

    // void runServer() {
    //     {   
    //         String toClient = "";
    
    //         try {
    //             ServerSocket server = new ServerSocket(port);
    //             System.out.println("listening...please run Client.java...");
    //             Socket soc = server.accept();
    //             DataInputStream dis = new DataInputStream(soc.getInputStream());
    //             String msg = (String)dis.readUTF();
                
    //             if (msg.equals("get cookie")){
    //                 Cookie c = new Cookie();
    //                 toClient = c.get_cookie();
    //             } 
    
    //             //other way (First was Client send to Server, now Server back to Client.)
    //             DataOutputStream d = new DataOutputStream(soc.getOutputStream());
    //             d.writeUTF("cookie-text " + toClient);
    //             d.flush();
    
    //             System.out.println("Message from client: " + msg);
    //             server.close();
    
    //         } catch (Exception e) {
    //             System.out.println(e);
    //         }
            
    //         System.out.println( "Server: Working." );
    //     }
    // }
}