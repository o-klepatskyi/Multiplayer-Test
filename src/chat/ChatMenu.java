package chat;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class ChatMenu extends JPanel {

    private JTextArea chatArea;
    private HintTextField textField;
    private JButton enterButton;

    ChatMenu() {
        setLayout(new BorderLayout());
        JScrollPane scrollPane = new JScrollPane(getChatArea());
        scrollPane.setPreferredSize(new Dimension(470,300));
        add(scrollPane, BorderLayout.CENTER);
        scrollPane.revalidate();
        JPanel bottomPanel = new JPanel();
        bottomPanel.setSize(new Dimension(470,35));
        bottomPanel.setLayout(new FlowLayout());
        bottomPanel.add(getTextField());
        bottomPanel.add(getEnterButton());
        add(bottomPanel, BorderLayout.SOUTH);
    }

    private JTextArea getChatArea() {
        if (chatArea == null) {
            chatArea = new JTextArea();
            chatArea.setEditable(false);
        }
        return chatArea;
    }

    private JTextField getTextField() {
        if (textField == null) {
            textField = new HintTextField("Enter your message");
            textField.setPreferredSize(new Dimension(390, 35));
        }
        return textField;
    }

    private JButton getEnterButton() {
        if (enterButton == null) {
            enterButton = new JButton("Enter");
            enterButton.setPreferredSize(new Dimension(70,35));
            enterButton.addMouseListener(new MouseAdapter() {
                @Override
                public void mouseClicked(MouseEvent e) {
                    showMessage(textField.removeText());
                }
            });
        }
        return enterButton;
    }

    public void showMessage(String msg) {
        chatArea.append(msg + "\n");
    }
}
