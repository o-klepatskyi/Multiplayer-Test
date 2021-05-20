package chat;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class ServerMenu extends JPanel {

    private HintTextField portField;

    ServerMenu() {
        setLayout(new GridLayout(0,1,15,20));
        add(new FillerButton(100,0));
        add(getPortNumberField());
        add(getEnterButton());
        add(getBackButton());
        setVisible(true);
    }

    private JButton getEnterButton() {
        JButton enterButton = new JButton("Create server");
        enterButton.setSize(new Dimension(100,35));
        enterButton.setVisible(true);
        JPanel currentMenu = this;
        enterButton.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                MainFrame.openChatMenu();
            }
        });
        return enterButton;
    }

    private JTextField getPortNumberField() {
        if (portField == null) {
            portField = new HintTextField("Enter port number");
            portField.setSize(150,35);
        }
        return portField;
    }

    private JButton getBackButton() {
        JButton backButton = new JButton("Back");
        backButton.setSize(new Dimension(100,35));
        backButton.setVisible(true);
        JPanel currentMenu = this;
        backButton.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                getParent().remove(currentMenu);
                MainFrame.openMainMenu();
            }
        });
        return backButton;
    }
}
