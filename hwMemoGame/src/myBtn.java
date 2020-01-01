import javax.swing.*;

public class myBtn extends JButton {

    public myBtn(String text, int hiddenValue) {
        super(text);
        this.hiddenValue = hiddenValue;
    }

    private int hiddenValue;
    public int getHiddenValue() {
        return hiddenValue;
    }

    public void setHiddenValue(int hiddenValue) {
        this.hiddenValue = hiddenValue;
    }
}
