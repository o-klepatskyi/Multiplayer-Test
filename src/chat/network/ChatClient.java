package chat.network;

import chat.MainFrame;

import java.net.*;
import java.io.*;

/**
 * This is the chat client program.
 * Type 'bye' to terminte the program.
 *
 * @author www.codejava.net
 */
public class ChatClient {
    private String hostname;
    private int port;
    private String userName;
    public WriteThread write;

    public ChatClient(String hostname, int port, String userName) {
        this.hostname = hostname;
        this.port = port;
        this.userName = userName;
    };

    public void execute() {
        try {
            Socket socket = new Socket(hostname, port);

            MainFrame.showMessage("Connected to the chat server");

            new ReadThread(socket, this).start();
            write = new WriteThread(socket, this);
            write.start();

        } catch (UnknownHostException ex) {
            MainFrame.showMessage("Server not found: " + ex.getMessage());
        } catch (IOException ex) {
            MainFrame.showMessage("I/O Error: " + ex.getMessage());
        }

    }

    void setUserName(String userName) {
        this.userName = userName;
    }

    String getUserName() {
        return this.userName;
    }

    public void sendMessage(String msg) {
        write.sendMessage(msg);
    }
}
