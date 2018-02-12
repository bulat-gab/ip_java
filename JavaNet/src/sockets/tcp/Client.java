package sockets.tcp;

import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;

public class Client {

    public static void main(String[] args) throws IOException {
        Socket s = new Socket("127.0.0.1", 9091);
        DataOutputStream data = new DataOutputStream(s.getOutputStream());
        Scanner sc = new Scanner(System.in);
        String mes = "";
        while (!"q".equals(mes)) {
            mes = sc.nextLine();
            data.writeUTF(mes);
            data.flush();
        }
    }

}