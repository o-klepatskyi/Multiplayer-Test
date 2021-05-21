package chat;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class MainMenu extends JPanel {

    MainMenu() {
        setLayout(new GridLayout(3,1,0,30));
        add(new FillerButton(100,0));
        add(getServerButton());
        add(getClientButton());
        setVisible(true);
    }

    private JButton getClientButton() {
        JButton clientButton = new JButton("Connect");
        clientButton.setHorizontalAlignment(SwingConstants.CENTER);
        clientButton.setPreferredSize(new Dimension(150,35));
        clientButton.setVisible(true);
        clientButton.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                MainFrame.openClientMenu();
            }
        });
        return clientButton;
    }

    private JButton getServerButton() {
        JButton serverButton = new JButton("Set up server");
        serverButton.setHorizontalAlignment(SwingConstants.CENTER);
        serverButton.setPreferredSize(new Dimension(150,35));
        serverButton.setVisible(true);
        serverButton.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                MainFrame.openServerMenu();
            }
        });
        return serverButton;
    }

}
