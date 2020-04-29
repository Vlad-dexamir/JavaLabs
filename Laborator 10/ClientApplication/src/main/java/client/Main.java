package client;

import java.io.IOException;

public class Main {
    public static void main(String args[]) throws IOException {
        final GameClient gameClient = new GameClient(8080);
        gameClient.Start();
    }
}
