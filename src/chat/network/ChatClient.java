package chat.network;

import chat.MainFrame;
import java.net.*;
import java.io.*;

/**
 * This is the chat client program.
 *
 * @author www.codejava.net
 */
public class ChatClient {
    private String hostname;
    private int port;
    private String userName;
    private PrintWriter writer;
    private Socket socket;

    public ChatClient(String hostname, int port, String userName) {
        this.hostname = hostname;
        this.port = port;
        this.userName = userName;
    }

    public void execute() {
        try {
            socket = new Socket(hostname, port);

            try {
                OutputStream output = socket.getOutputStream();
                writer = new PrintWriter(output, true);
            } catch (IOException ex) {
                System.out.println("Error getting output stream: " + ex.getMessage());
                ex.printStackTrace();
            }

            writer.println(userName);

            new ReadThread(socket, this).start();
            MainFrame.showMessage("Connected to the chat server");
        } catch (UnknownHostException ex) {
            MainFrame.showMessage("Server not found: " + ex.getMessage());
        } catch (IOException ex) {
            MainFrame.showMessage("I/O Error: " + ex.getMessage());
        }

    }

    String getUserName() {
        return this.userName;
    }

    public void sendMessage(String msg) {
        System.out.println(userName + " sends message: " + msg);
        writer.println(msg);
        if (msg.equals(MainFrame.CLOSE_TEXT)) {
            close();
        }
    }

    public void close() {
        try {
            socket.close();
            MainFrame.setTextAreaClosed();
        } catch (IOException ex) {
            MainFrame.showMessage("Error writing to server: " + ex.getMessage());
            System.out.println("Error writing to server: " + ex.getMessage());
        }
    }
}
