package chat.network;

import chat.MainFrame;

import java.io.*;
import java.net.*;

/**
 * This thread is responsible for reading user's input and send it
 * to the server.
 * It runs in an infinite loop until the user types 'bye' to quit.
 *
 * @author www.codejava.net
 */
public class WriteThread extends Thread {
    private PrintWriter writer;
    private Socket socket;
    private ChatClient client;

    public WriteThread(Socket socket, ChatClient client) {
        this.socket = socket;
        this.client = client;

        try {
            OutputStream output = socket.getOutputStream();
            writer = new PrintWriter(output, true);
            writer.println(client.getUserName());
        } catch (IOException ex) {
            System.out.println("Error getting output stream: " + ex.getMessage());
            ex.printStackTrace();
        }
    }

    public void run() {

    }

    public void sendMessage(String msg) {
        writer.println(msg);
        if (msg.equals("exit")) {
            try {
                socket.close();
            } catch (IOException ex) {
                MainFrame.showMessage("Error writing to server: " + ex.getMessage());
                System.out.println("Error writing to server: " + ex.getMessage());
            }
        };
    }
}
