package server;

import java.net.*;
import java.io.*;

public class GameServer {

    private int port = 8080;
    private ServerSocket server = null;


    public GameServer(int port) throws IOException {
        this.port = port;
        server = new ServerSocket(this.port);
    }

    public void startServer() throws IOException {
        while (true) {
            Socket client = null;
            try {
                client = server.accept();

                System.out.println("A new client is connected: " + client);

                final DataOutputStream outputStream = new DataOutputStream(client.getOutputStream());
                final DataInputStream inputStream = new DataInputStream(client.getInputStream());

                Thread t = ClientThread.CreateClientThread(client, inputStream, outputStream);

                t.start();

            } catch(Exception e) {
                client.close();
                e.printStackTrace();
            }

        }
    }
}
