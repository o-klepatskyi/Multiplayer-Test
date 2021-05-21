package chat;

import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import javax.swing.*;


/**
 * @author https://stackoverflow.com/a/1739037
 */
class HintTextField extends JTextField implements FocusListener {

    private final String hint;
    private boolean showingHint;

    public HintTextField(final String hint) {
        super(hint);
        this.hint = hint;
        this.showingHint = true;
        super.addFocusListener(this);
    }

    @Override
    public void focusGained(FocusEvent e) {
        if(this.getText().isEmpty()) {
            super.setText("");
            showingHint = false;
        }
    }
    @Override
    public void focusLost(FocusEvent e) {
        if(this.getText().isEmpty()) {
            super.setText(hint);
            showingHint = true;
        }
    }

    public String removeText(boolean isStayingFocused) {
        String text = getText();
        if (isStayingFocused) {
            setText("");
        } else {
            setText(hint);
            showingHint = true;
        }
        return text;
    }

    @Override
    public String getText() {
        return showingHint ? "" : super.getText();
    }

    public void close() {
        setText("You have quit the room. Reopen the app to reconnect.");
        setEditable(false);
        setFocusable(false);
        showingHint = false;
    }
}
