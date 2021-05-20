package chat;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class ServerMenu extends JPanel {

    private HintTextField portField;

    ServerMenu() {
        setLayout(new GridLayout(3,1,15,30));
        add(new FillerButton(100,0));
        add(getPortNumberField());
        add(getEnterButton());
        setVisible(true);
    }

    private JButton getEnterButton() {
        JButton enterButton = new JButton("Create server");
        enterButton.setSize(new Dimension(100,35));
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
            //portField.setPreferredSize(new Dimension(100,35));
            portField.setSize(100,35);
        }
        return portField;
    }
}
