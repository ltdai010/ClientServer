package w1;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;

public class Client {
    public static void main(String[] args) throws IOException {
        String serverIP = "127.0.0.1";
        int serverPort = 6789;


        System.out.print("Input :");

        BufferedReader userInput =
                new BufferedReader(new InputStreamReader(System.in));

        String sendMessage = userInput.readLine();

        System.out.println(sendMessage);

        Socket socket = new Socket(serverIP, serverPort);

        DataOutputStream outToServer =
                new DataOutputStream(socket.getOutputStream());

        BufferedReader inFromServer =
                new BufferedReader(new
                        InputStreamReader(socket.getInputStream()));

        outToServer.writeBytes(sendMessage + "\n");

        String fromServer = inFromServer.readLine();

        System.out.println("From server: " + fromServer);

        socket.close();
    }
}
