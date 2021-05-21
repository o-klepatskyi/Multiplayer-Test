package chat.network;

import chat.MainFrame;
import java.io.*;
import java.net.*;

/**
 * This thread handles connection for each connected client, so the server
 * can handle multiple clients at the same time.
 *
 * @author www.codejava.net
 */
public class UserThread extends Thread {
    private Socket socket;
    private ChatServer server;
    private PrintWriter writer;

    public UserThread(Socket socket, ChatServer server) {
        this.socket = socket;
        this.server = server;
    }

    public void run() {
        try {
            InputStream input = socket.getInputStream();
            BufferedReader reader = new BufferedReader(new InputStreamReader(input));

            OutputStream output = socket.getOutputStream();
            writer = new PrintWriter(output, true);

            String userName = reader.readLine();
            if (server.hasUser(userName)) {
                sendMessage(ChatServer.NAME_ERROR + "");
            } else {
                sendMessage(ChatServer.OK + "");
                printUsers();
                server.addUserName(userName);
                String serverMessage = "New user connected: " + userName;
                server.broadcast(serverMessage, this);

                String clientMessage;

                do {
                    System.out.println(userName + " thread listening...");
                    clientMessage = reader.readLine();
                    serverMessage = "[" + userName + "]: " + clientMessage;
                    server.broadcast(serverMessage, null);

                } while (!clientMessage.equals(MainFrame.CLOSE_TEXT));

                server.removeUser(userName, this);
                socket.close();

                serverMessage = userName + " has quit.";
                server.broadcast(serverMessage, this);
            }
        } catch (IOException ex) {
            System.out.println("Error in UserThread: " + ex.getMessage());
            ex.printStackTrace();
        }
    }

    /**
     * Sends a list of online users to the newly connected user.
     */
    void printUsers() {
        if (server.hasUsers()) {
            writer.println("Connected users: " + server.getUserNames());
        } else {
            writer.println("No other users connected");
        }
    }

    /**
     * Sends a message to the client.
     */
    void sendMessage(String message) {
        writer.println(message);
    }
}
