package by.jwd.task04.client.service;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;

public class Connect {
    private static DataOutputStream oos;
    private static DataInputStream ois;

    private static boolean connection = true;

    public Connect() {
        try {
            Socket socket = new Socket("localhost", 3345);
            Thread.sleep(1000);
            oos = new DataOutputStream(socket.getOutputStream());
            ois = new DataInputStream(socket.getInputStream());

            System.out.println("Server start");
        } catch (Exception e) {
            connection = false;
            System.err.println("Connect Exception");
        }
    }

    public static void send(String message) {
        try {
            oos.writeUTF(message);
            oos.flush();
            System.out.println("write task number: " + message);
        } catch (Exception e) {
            System.err.println("Send Exception");
        }
    }

    public static String get(){
        try {
            System.out.println("Принято сообщение: ");
            return ois.readUTF();
        } catch (NullPointerException e){
            System.err.println("NullPointerException at Client level");
        } catch (IOException e) {
            System.err.println("IOException at get level");
        }
        return null;
    }

    public boolean isWork(){
        return connection;
    }
}
