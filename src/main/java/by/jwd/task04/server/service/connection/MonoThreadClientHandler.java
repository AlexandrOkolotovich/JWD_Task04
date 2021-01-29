package by.jwd.task04.server.service.connection;

import by.jwd.task04.entity.Text;
import by.jwd.task04.server.parser.impl.TextParser;
import by.jwd.task04.server.reader.impl.TextFileReader;
import by.jwd.task04.server.service.ActionHandler;
import by.jwd.task04.server.service.TextService;
import by.jwd.task04.server.service.impl.TextActionHandler;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;

public class MonoThreadClientHandler implements Runnable {

    private static final String FILE = "resources/text.txt";

    private final Socket clientDialog;
    private DataOutputStream oos;
    private DataInputStream ois;

    public MonoThreadClientHandler(Socket client) throws IOException {
        clientDialog = client;
        oos = new DataOutputStream(clientDialog.getOutputStream());
        ois = new DataInputStream(clientDialog.getInputStream());
        System.out.println("New client connected");
    }

    public void send(String message) throws IOException {
        oos.writeUTF(message);
        oos.flush();
    }

    public String get(){
        try {
            return ois.readUTF();
        } catch (IOException e) {
            return null;
        }
    }

    @Override
    public void run() {
        try {
            String text = new TextFileReader().takeText(FILE);
            Text parsedText = new TextParser().parse(text);

            TextService textService = new TextService(parsedText);
            ActionHandler actionHandler = new TextActionHandler(textService);


            while (true) {
                String taskNumber = get();
                if(taskNumber == null || taskNumber.equals("exit")) break;
                System.out.println("Client message task number = " + taskNumber);

                Object result = actionHandler.getResult(taskNumber);

                send("this is server message: "+  result);
            }


            oos.close();
            ois.close();
            clientDialog.close();

            System.out.println("Closing connections & channels - DONE.");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
