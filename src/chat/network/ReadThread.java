package chat.network;

import chat.MainFrame;

import java.io.*;
import java.net.*;

/**
 * This thread is responsible for reading server's input and printing it
 * to the console.
 * It runs in an infinite loop until the client disconnects from the server.
 *
 * @author www.codejava.net
 */
public class ReadThread extends Thread {
    private BufferedReader reader;
    private Socket socket;
    private ChatClient client;

    public ReadThread(Socket socket, ChatClient client) {
        this.socket = socket;
        this.client = client;

        try {
            InputStream input = socket.getInputStream();
            reader = new BufferedReader(new InputStreamReader(input));
        } catch (IOException ex) {
            MainFrame.showMessage("Error getting input stream: " + ex.getMessage());
            //ex.printStackTrace();
        }
    }

    public void run() {
        int first_response = -1;
        try {
            first_response = Integer.parseInt(reader.readLine());
        } catch (IOException exception) {
            exception.printStackTrace();
        }
        if (first_response == ChatServer.NAME_ERROR) {
            MainFrame.showMessage("Name " + client.getUserName() + " is already occupied");
            client.close();
        } else if (first_response != ChatServer.OK) {
            MainFrame.showMessage("Error occurred while connecting to the room.");
            client.close();
        } else {
            while (true) {
                try {
                    System.out.println("Client waiting for message...");
                    String response = reader.readLine();
                    System.out.println("\n" + response);

                    // prints the username after displaying the server's message
                    if (client.getUserName() != null) {
                        System.out.print(response);
                        MainFrame.showMessage(response);
                    }
                } catch (IOException ex) {
                    System.out.println("Error reading from server: " + ex.getMessage());
                    ex.printStackTrace();
                    break;
                }
            }
        }
    }
}
