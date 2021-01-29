package by.jwd.task04.client.main;

import by.jwd.task04.client.service.Connect;

public class MainClient {

    public static void main(String[] args) {

        Connect connect = new Connect();

        if(connect.isWork()) {
            ioMessage();
        }
    }

    private static void ioMessage(){
        for(int num = 1; num <= 16; num++) {
            Connect.send(String.valueOf(num));
            String answer = Connect.get();
            System.out.println("answer = " + answer);
        }
    }

}
