import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MainWindow  extends JFrame {
    private int level;
    private JPanel gamePanel = new JPanel();
    public MainWindow() throws HeadlessException {
        setTitle("The memo game");
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        drawMenu();
        add(gamePanel);
        setLevel(1);
        setVisible(true);
    }
    private void drawMenu(){
        JMenuBar menuBar = new JMenuBar();

        JMenu mainMenu = new JMenu("Game");

        JMenuItem newGameMenu = new JMenuItem("New game");
        newGameMenu.addActionListener(e -> this.newGame());
        mainMenu.add(newGameMenu);

        JMenu levelMenu = new JMenu("Set level");
        mainMenu.add(levelMenu);
        for (int i = 1; i < 4; i++) {
            JMenuItem setLevelX = new JMenuItem("Level " + i);
            int lvl = i;
            setLevelX.addActionListener(actionEvent -> this.setLevel(lvl));
            levelMenu.add(setLevelX);
        }

        menuBar.add(mainMenu);
        setJMenuBar(menuBar);
    }


    private void drawLevel(){
        gamePanel.removeAll();
        int width = this.getLevel() * 300;
        int height = this.getLevel() * 300;
        setLayout(new GridLayout(width,height));
        setBounds(100,100,width,height);

        


        System.out.println("Level " + this.level + " is set.");
    }

    public int getLevel() {
        return level;
    }

    private void newGame(){
        drawLevel();
    }
    public void setLevel(int level) {
        this.level = level;
        drawLevel();
    }

}
