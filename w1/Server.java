package w1;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
    public static void main(String[] args) {
        ServerSocket incoming = null;
        try {
            incoming = new ServerSocket(6789);
        } catch (IOException e) {
            e.printStackTrace();
        }
        Socket client = null;

        while (true) {

            try {
                assert incoming != null;
                client = incoming.accept();
            } catch (IOException e) {
                e.printStackTrace();
            }

            new EchoThread(client).start();
        }

    }
}
