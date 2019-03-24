package net.bright.tcp;

import net.bright.main.Main;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class TCPManager {

    private ServerSocket serverSocket;

    public TCPManager() throws Exception {

       // serverSocket = new ServerSocket(Main.port, 1, InetAddress.getByName("89.183.220.125"));
         serverSocket = new ServerSocket(Main.port);
         String s = "";
         for(byte b : serverSocket.getInetAddress().getAddress())
             s += b;
        System.out.println(s);
    }

    public void listen() throws IOException {

        List<String> data = new ArrayList<String>();

        //TODO: Make it in a list and then read them behind each other
        // Make one list to rule them all!!!
        Socket client = serverSocket.accept();
        System.out.println("\r\nNew connection with: " + client.getInetAddress().getHostAddress());

        BufferedReader in = new BufferedReader(new InputStreamReader(client.getInputStream()));
        String s = "";

        while((s = in.readLine()) != null){

            data.add(s);
            System.out.println(s);

        }
    }

}
