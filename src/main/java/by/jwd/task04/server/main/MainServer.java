package by.jwd.task04.server.main;

import by.jwd.task04.server.service.connection.AcceptSocket;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class MainServer {

    private static ExecutorService executeSocket = Executors.newFixedThreadPool(2);

    public static final int PORT = 3345;

    public static void main(String[] args) {

        try {
            ServerSocket server = new ServerSocket(PORT);
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

            System.out.println("Server socket created, command console reader for listen to server commands");

            while (!server.isClosed()) {
                executeSocket.execute(new AcceptSocket(server));

                if (br.ready()) {
                    System.out.println("Main Server found any messages in channel, let's look at them.");

                    String serverCommand = br.readLine();
                    if (serverCommand.equalsIgnoreCase("quit")) {
                        System.out.println("Main Server initiate exiting...");
                        server.close();
                        break;
                    }
                }
            }

            executeSocket.shutdown();
        } catch (IOException e) {
            System.err.printf("IOException at Client level", e);
            e.printStackTrace();
        }
    }
}
