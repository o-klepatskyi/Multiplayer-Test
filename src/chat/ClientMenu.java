package chat;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class ClientMenu extends JPanel {

    private HintTextField portField;
    private HintTextField ipField;
    private HintTextField nameField;

    ClientMenu() {
        setLayout(new GridLayout(0,1,15,15));
        add(new FillerButton(100,0));
        add(getNameField());
        add(getIPField());
        add(getPortNumberField());
        add(getEnterButton());
        add(getBackButton());
        add(new FillerButton(100,0));
        setVisible(true);
    }

    private HintTextField getNameField() {
        if (nameField == null) {
            nameField = new HintTextField("Enter username");
            nameField.setSize(new Dimension(150,35));
        }
        return nameField;
    }

    private JTextField getIPField() {
        if (ipField == null) {
            ipField = new HintTextField("Enter IP address");
            ipField.setSize(new Dimension(150,35));
        }
        return ipField;
    }

    private JButton getEnterButton() {
        JButton enterButton = new JButton("Connect");
        enterButton.setSize(new Dimension(150,35));
        enterButton.setVisible(true);
        enterButton.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {

            }
        });
        return enterButton;
    }

    private JTextField getPortNumberField() {
        if (portField == null) {
            portField = new HintTextField("Enter port number");
            portField.setSize(new Dimension(100,35));
        }
        return portField;
    }

    private JButton getBackButton() {
        JButton backButton = new JButton("Back");
        backButton.setSize(new Dimension(100,35));
        backButton.setVisible(true);
        backButton.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                MainFrame.openMainMenu();
            }
        });
        return backButton;
    }
}
