package vtp2022.day4.workshop;

import java.net.ServerSocket;
import java.io.*;
import java.net.*;

//This is the server file.

public class Client {
    

    // public static void main(String args[]) {
    //     System.out.println("Port: " + App.port);
    //     try {
    //         Socket soc = new Socket("localhost", App.port);
    //         DataOutputStream d = new DataOutputStream(soc.getOutputStream());
    //         String str = "get cookie";
    //         d.writeUTF(str);
    //         d.flush();

    //         //other way (First was Client send to Server, now Server back to Client.)
    //         DataInputStream dis = new DataInputStream(soc.getInputStream());
    //         String msg = (String)dis.readUTF();
    //         System.out.println(msg);

    //         dis.close();
    //         d.close();
    //         soc.close();

    //     } catch (Exception e) {
    //         System.out.println(e);
    //     }
    //     System.out.println("Client: Working.");
        
    // }

        void runClient(){
            System.out.println("Port: " + App.port);
            try {
                Socket soc = new Socket("localhost", App.port);
                DataOutputStream d = new DataOutputStream(soc.getOutputStream());
                String str = "get cookie";
                d.writeUTF(str);
                d.flush();
    
                //other way (First was Client send to Server, now Server back to Client.)
                DataInputStream dis = new DataInputStream(soc.getInputStream());
                String msg = (String)dis.readUTF();
                System.out.println(msg);
    
                dis.close();
                d.close();
                soc.close();
    
            } catch (Exception e) {
                System.out.println(e);
            }
            System.out.println("Client: Working.");
        }
}
