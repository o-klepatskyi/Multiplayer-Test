package chat;

import javax.swing.*;
import java.awt.*;

public class MainFrame {
    private static JFrame frame = new JFrame("My online chat");
    private static MainMenu mainMenu = new MainMenu();
    private static ServerMenu serverMenu = new ServerMenu();
    private static ClientMenu clientMenu = new ClientMenu();

    public static void init() {
        frame.setSize(new Dimension(300,300));
        frame.setLayout(new FlowLayout());
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);

        frame.add(mainMenu);
        System.out.println(frame.getWidth() + " " + frame.getHeight());

    }

    public static void openServerMenu() {
        frame.add(serverMenu);
        frame.pack();
        frame.setSize(new Dimension(300,300));
    }

    public static void openClientMenu() {
        frame.add(clientMenu);
        frame.pack();
        frame.setSize(new Dimension(300,300));
    }

    public static void main(String[] args) {
        init();
    }


}
