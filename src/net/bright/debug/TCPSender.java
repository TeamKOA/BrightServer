package net.bright.debug;

import java.io.DataOutputStream;
import java.net.InetAddress;
import java.net.Socket;

public class TCPSender {

    Socket socket;

    public  TCPSender(InetAddress address, int port) throws Exception{

        socket = new Socket(address, port);
        socket.setSoTimeout(10000);
    }

    public void send(String msg) throws Exception{
        DataOutputStream out = new DataOutputStream(socket.getOutputStream());
        out.writeBytes(msg);
        socket.close();
    }
}
