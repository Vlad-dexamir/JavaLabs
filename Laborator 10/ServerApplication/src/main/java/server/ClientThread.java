package server;

import java.net.*;
import java.io.*;

public class ClientThread extends Thread {

    static public ClientThread CreateClientThread(Socket socket, DataInputStream inputStream, DataOutputStream outputStream) {
        return new ClientThread(socket, inputStream, outputStream);
    }

    public void run() {
        String received;
        String toSend;

        while (true) {

            try {
                outputStream.writeUTF("Enter a command: ");

                received = inputStream.readUTF();

                if (received.equals("exit")) {

                    System.out.println("Client " + this.socket + "requested to close the connection");
                    System.out.println("Closing this connection");
                    this.socket.close();
                    System.out.println("Connection closed");
                    break;
                }

                switch (received) {
                    case "Create game":
                        toSend = "Server received the request. Game created";
                        outputStream.writeUTF(toSend);
                        break;

                    case "Join the gane":
                        toSend = "Server received the request. You joined the Game";
                        outputStream.writeUTF(toSend);
                        break;

                    case "Submit move":
                        toSend = "Server received the request. You moved the piece";
                        outputStream.writeUTF(toSend);
                        break;

                    default:
                        outputStream.writeUTF("Invalid request");
                }


            } catch (IOException e) {
                e.printStackTrace();
            }

        }
        try {
            outputStream.close();
            inputStream.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    private Socket socket;
    private DataInputStream inputStream;
    private DataOutputStream outputStream;

    private ClientThread(Socket socket, DataInputStream inputStream, DataOutputStream outputStream) {
        this.socket = socket;
        this.inputStream = inputStream;
        this.outputStream = outputStream;
    }


}


