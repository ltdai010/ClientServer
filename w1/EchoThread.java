package w1;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;

public class EchoThread extends Thread {
    protected Socket socket;

    public EchoThread(Socket clientSocket) {
        this.socket = clientSocket;
    }

    public void run() {
        System.out.println("client connected");

        BufferedReader inFromClient =
                null;
        try {
            inFromClient = new BufferedReader(new InputStreamReader(this.socket.getInputStream()));
        } catch (IOException e) {
            e.printStackTrace();
        }

        DataOutputStream outToClient =
                null;
        try {
            outToClient = new DataOutputStream(this.socket.getOutputStream());
        } catch (IOException e) {
            e.printStackTrace();
        }


        String input = null;
        try {
            assert inFromClient != null;
            input = inFromClient.readLine();
        } catch (IOException e) {
            e.printStackTrace();
        }

        System.out.println("Received message :" + input);


        try {
            assert outToClient != null;
            outToClient.writeBytes("Server received message : " + input + "\n");
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
