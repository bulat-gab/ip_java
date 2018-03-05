package sockets.tcp;

import java.io.DataInputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {

    public static void main(String[] args) throws IOException {
        ServerSocket sc = new ServerSocket(9099);
        Socket socket = sc.accept();
        DataInputStream data = new DataInputStream(socket.getInputStream());
        String mes = "";
        while (true) {
            mes = data.readUTF();
            if ("q".equals(mes)) {
                return;
            } else {
                System.out.println(mes);
            }
        }
    }
}