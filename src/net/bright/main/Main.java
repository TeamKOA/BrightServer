package net.bright.main;

import net.bright.debug.TCPSender;
import net.bright.tcp.TCPManager;

import java.io.DataInputStream;
import java.net.InetAddress;
import java.util.Scanner;


public class Main {


    public static final int port = 48521;


    public static void main(String[] args) {

        try {
            out("Server (s) or Client (c)?");
            int i = System.in.read();

            if(i == 115){ //Server
                TCPManager mng = new TCPManager();

                while(true)
                    mng.listen();

            } else if (i == 99){ // Client
                System.out.println("IP address of server entered cuz im wizard");
                TCPSender sender = new TCPSender(InetAddress.getByName("89.183.220.125"), port);

                sender.send("Sieg Hain!");
            } else {
                System.out.println("Fuck you!");
                main(new String[] {});
        }

        } catch (Exception e){
            System.out.println(e.getMessage() + "  " +  e.getLocalizedMessage() + "\r\n\n");
            for(StackTraceElement s : e.getStackTrace())
                System.out.println(s);
        }
    }

    static void out (String s){
        System.out.println(s);
    }
}
