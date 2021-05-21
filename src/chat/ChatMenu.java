package chat;

import javax.swing.*;
import javax.swing.text.DefaultCaret;
import java.awt.*;
import java.awt.event.*;

public class ChatMenu extends JPanel {

    private JTextArea chatArea;
    private HintTextField textField;
    private JButton enterButton;
    private JScrollPane scrollPane;

    ChatMenu() {
        setLayout(new BorderLayout());
        scrollPane = new JScrollPane(getChatArea());
        scrollPane.setPreferredSize(new Dimension(470,300));
        add(scrollPane, BorderLayout.CENTER);
        scrollPane.revalidate();
        DefaultCaret caret = (DefaultCaret) chatArea.getCaret();
        caret.setUpdatePolicy(DefaultCaret.ALWAYS_UPDATE);
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
            textField = new HintTextField("Type your message here. Type /exit to leave chat");
            textField.setPreferredSize(new Dimension(390, 35));
            textField.addKeyListener(new KeyAdapter() {
                @Override
                public void keyTyped(KeyEvent e) {
                    if (textField.isEditable() && e.getKeyChar() == KeyEvent.VK_ENTER) {
                        if (textField.getText().length() != 0) {
                            MainFrame.sendMessage(textField.removeText(true));
                        }
                    }
                }
            });
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
                    if (enterButton.isEnabled() && textField.getText().length() != 0) {
                        MainFrame.sendMessage(textField.removeText(false));
                    }
                }
            });
        }
        return enterButton;
    }

    public void showMessage(String msg) {
        chatArea.append(msg + "\n");
    }

    public void setTextAreaClosed() {
        textField.setText("You have quit the room. Reopen the app to reconnect.");
        textField.setEditable(false);
        enterButton.setEnabled(false);
    }
}
