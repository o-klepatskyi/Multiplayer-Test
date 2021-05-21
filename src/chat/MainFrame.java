package chat;

import chat.network.ChatClient;
import chat.network.ChatServer;

import javax.swing.*;
import java.awt.*;

public class MainFrame {
    private static JFrame frame = new JFrame("My online chat");
    private static MainMenu mainMenu = new MainMenu();
    private static ServerMenu serverMenu = new ServerMenu();
    private static ClientMenu clientMenu = new ClientMenu();
    private static ChatMenu chatMenu = new ChatMenu();
    private static JPanel currentMenu;
    private static ChatServer server;
    private static ChatClient client;
    public static final String CLOSE_TEXT = "/exit";


    private final static Dimension MENU_SIZE = new Dimension(300,300);
    public final static Dimension CHAT_SIZE = new Dimension(500,450);

    public static void init() {
        frame.setSize(MENU_SIZE);
        frame.setLayout(new FlowLayout());
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
        frame.add(mainMenu);
        currentMenu = mainMenu;
        frame.setResizable(false);
    }

    public static void openServerMenu() {
        frame.remove(currentMenu);
        currentMenu = serverMenu;
        frame.add(serverMenu);
        frame.pack();
        frame.setSize(MENU_SIZE);
    }

    public static void openClientMenu() {
        frame.remove(currentMenu);
        currentMenu = clientMenu;
        frame.add(clientMenu);
        frame.pack();
        frame.setSize(MENU_SIZE);
    }

    public static void openMainMenu() {
        frame.remove(currentMenu);
        currentMenu = mainMenu;
        frame.add(mainMenu);
        frame.pack();
        frame.setSize(MENU_SIZE);
    }

    public static void openChatMenu() {
        frame.remove(currentMenu);
        currentMenu = chatMenu;
        frame.add(chatMenu);
        frame.pack();
        frame.setSize(CHAT_SIZE);
    }

    public static void showMessage(String msg) {
        chatMenu.showMessage(msg);
    }

    public static void main(String[] args) {
        init();
    }

    public static void startServer(int portNumber, String userName) {
        openChatMenu();
        server = new ChatServer(portNumber);
        new Thread(() -> server.execute()).start();
        startClient("127.0.0.1", portNumber, userName);
    }

    public static void startClient(String ipAddress, int portNumber, String username) {
        openChatMenu();
        client = new ChatClient(ipAddress, portNumber, username);
        new Thread(() -> client.execute()).start();
    }

    public static void sendMessage(String msg) {
        client.sendMessage(msg);
    }

    public static void setTextAreaClosed() {
        chatMenu.setTextAreaClosed();
    }
}
