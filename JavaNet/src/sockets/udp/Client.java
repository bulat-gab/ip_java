package sockets.udp;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;

/**
 * Created by gab on 25.Jan.2018
 */
public class Client {
    public static void main(String[] args) throws IOException {
        DatagramSocket ds = new DatagramSocket();
        DatagramPacket packet = new DatagramPacket("hello".getBytes(), 0, "hello".getBytes().length);

        packet.setAddress(InetAddress.getLocalHost());
        packet.setPort(8099);
        ds.send(packet);
        ds.close();
    }
}
