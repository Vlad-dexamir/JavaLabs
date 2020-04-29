package server;

import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        GameServer gameServer = new GameServer(808);

        gameServer.startServer();
    }
}
