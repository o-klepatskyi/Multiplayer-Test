package chat;

import javax.swing.*;
import java.awt.*;

public class MainFrame {
    private static JFrame frame = new JFrame("My online chat");
    private static MainMenu mainMenu = new MainMenu();
    private static ServerMenu serverMenu = new ServerMenu();
    private static ClientMenu clientMenu = new ClientMenu();
    private static ChatMenu chatMenu = new ChatMenu();
    private static JPanel currentMenu;

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
}
