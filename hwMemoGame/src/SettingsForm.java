import javax.swing.*;
import java.awt.*;

public class SettingsForm extends JFrame {
    public SettingsForm() throws HeadlessException {
        setTitle("The memo game settings");
        setDefaultCloseOperation(WindowConstants.DO_NOTHING_ON_CLOSE);
        setBounds(300,300,300,300);
        setVisible(true);
    }
}
