package by.jwd.task04.server.service.connection;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class AcceptSocket implements Runnable{

    private ServerSocket server;
    private static ExecutorService executeIt = Executors.newFixedThreadPool(2);

    public AcceptSocket(ServerSocket server){
        this.server = server;
    }

    @Override
    public void run() {
        try {
            while (!server.isClosed()) {
                Socket client = server.accept();
                executeIt.execute(new MonoThreadClientHandler(client));
                System.out.println("Connection accepted.");
            }

            executeIt.shutdown();
        } catch (IOException ignored) {

        }

    }
}
