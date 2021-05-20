package chat;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class ClientMenu extends JPanel {

    private HintTextField portField;
    private HintTextField ipField;

    ClientMenu() {
        setLayout(new GridLayout(0,1,15,30));
        add(new FillerButton(100,0));
        add(getIPField());
        add(getPortNumberField());
        add(getEnterButton());
        setVisible(true);
    }

    private JTextField getIPField() {
        if (ipField == null) {
            ipField = new HintTextField("Enter IP address");
            ipField.setSize(new Dimension(100,35));
        }
        return ipField;
    }

    private JButton getEnterButton() {
        JButton enterButton = new JButton("Connect");
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
            portField.setPreferredSize(new Dimension(100,35));
        }
        return portField;
    }
}
