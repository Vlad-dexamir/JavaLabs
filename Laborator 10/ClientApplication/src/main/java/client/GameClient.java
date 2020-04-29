package client;

import java.io.*;
import java.net.*;
import java.util.Scanner;

public class GameClient {
    private Socket client;
    private InetAddress ip;
    private Scanner scanner;
    private int port = 8080;
    private DataInputStream inputStream;
    private DataOutputStream outputStream;

    public GameClient(int port) throws IOException {
        this.port = port;
        this.scanner = new Scanner(System.in);
        this.ip = InetAddress.getByName("localhost");
        this.client = new Socket(ip, this.port);
        this.inputStream = new DataInputStream(client.getInputStream());
        this.outputStream = new DataOutputStream(client.getOutputStream());
    }

    public void Start() throws IOException {
        while(true) {

            System.out.println(inputStream.readUTF());
            String toSend = scanner.nextLine();
            outputStream.writeUTF(toSend);

            if(toSend.equals("exit")) {
                System.out.println("Closing connection");
                client.close();
                System.out.println("Connection closed");
                break;
            }

            String received = inputStream.readUTF();
            System.out.println(received);
        }
    }
}
