import javax.swing.*;
import java.awt.*;

public class hwMemoGame extends JFrame {
    public hwMemoGame() throws HeadlessException {
        setTitle("The memo game");
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setBounds(300,300,300,300);


        setVisible(true);
    }
}


class AppStart{
    public static void main(String[] args) {
        hwMemoGame game = new hwMemoGame();
    }
}