package sockets.udp;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;

/**
 * Created by gab on 25.Jan.2018
 */
public class Server {
    public static void main(String[] args) throws IOException {
        DatagramSocket ds = new DatagramSocket(8089);

        byte[] bytes = new byte[1024];
        DatagramPacket packet = new DatagramPacket(bytes, 1024);

        String message;
        while (true){
            ds.receive(packet);
            message = new String(packet.getData());
            System.out.println(message);
            if("q".equals(message))
                return;
        }
    }
}
