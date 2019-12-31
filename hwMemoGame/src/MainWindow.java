import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Arrays;
import java.util.Date;
import java.util.Random;

public class MainWindow  extends JFrame {
    private int level;
    private int cols, rows;
    private Date levelStartTime;
    private JPanel gamePanel = new JPanel();
    private myBtn[] openedBtns = new myBtn[2];
    public MainWindow() throws HeadlessException {
        setTitle("The memo game");
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        drawMenu();
        add(gamePanel);
        setLevel(1);
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

    private void onButtonPress(myBtn btnPressed){
        if (openedBtns[0]!= btnPressed && openedBtns[1]!= btnPressed) {
            //no match - set placeholders back
            if (openedBtns[0] != null && openedBtns[1] != null) {
                if (openedBtns[0].getHiddenValue() != openedBtns[1].getHiddenValue()) {
                    openedBtns[0].setText("x");
                    openedBtns[1].setText("x");
                }
                openedBtns = new myBtn[2];
            }
            //change placeholder to hidden value
            if (openedBtns[0] == null) {
                openedBtns[0] = btnPressed;
                btnPressed.setText("" + openedBtns[0].getHiddenValue());
            } else if (openedBtns[1] == null) {
                openedBtns[1] = btnPressed;
                btnPressed.setText("" + openedBtns[1].getHiddenValue());
            }
            //match
            if (openedBtns[0] != null && openedBtns[1] != null) {
                if (openedBtns[0].getHiddenValue() == openedBtns[1].getHiddenValue()) {
                    openedBtns[0].setBackground(Color.green);
                    openedBtns[1].setBackground(Color.green);
                    openedBtns[0].setEnabled(false);
                    openedBtns[1].setEnabled(false);
                    checkWin();
                }

            }
        }
    }
    private void checkWin(){
        boolean win = true;
        for (Component jb : gamePanel.getComponents()){
            if(jb instanceof myBtn && ((myBtn) jb).getBackground()!= Color.green) {
                win = false;
                break;
            }
        }
        if (win == true){
            Date currDate = new Date();
            JOptionPane.showMessageDialog(null, "Победа! "
                    + ((currDate.getTime()-levelStartTime.getTime())/1000) + " секунды!");
        }
    }
    private void drawLevel(){

        gamePanel.removeAll();
        setBounds(100,100,this.cols * 100,this.rows * 100);
        gamePanel.setLayout(new GridLayout(this.rows,this.cols));

        int btnCount = this.cols * this.rows;
        int[] symArr = getNumbersArray(btnCount);
        for (int i = 0; i<btnCount; i++){

            myBtn jb = new myBtn("x", getRndElem(symArr));
            jb.addActionListener(actionEvent -> this.onButtonPress(jb));

            jb.setFont(new Font("Times", Font.BOLD,32));

            gamePanel.add(jb);
        }
        setVisible(false);
        setVisible(true);
        levelStartTime = new Date();
    }

     private int[] getNumbersArray(int arrLength){

        int symCount = arrLength / 2;

        int[] numArray = new int[arrLength];
        Arrays.fill(numArray, -1);
        for (int i = 1;i<=symCount;i++){
            for (int j = 0; j<arrLength;j++){
                if (numArray[j] == -1){
                    numArray[j] = numArray[j+1] = i;
                    break;
                }
            }
        }
        return numArray;
    };

    private int getRndElem(int[] dataArray){
        int elem2Return,idx;
        Random rnd = new Random();
        do{
            idx = rnd.nextInt(dataArray.length);
        }while (dataArray[idx] == -1);

        elem2Return = dataArray[idx];
        dataArray[idx] = -1;
        return elem2Return;
    }

    private void newGame(){
        drawLevel();
    }
    public void setLevel(int level) {
        this.level = level;
        switch (this.level){
            case (1):
                this.rows = 3;
                this.cols = 4;
                break;
            case (2):
                this.rows = 4;
                this.cols = 4;
                break;
            case (3):
                this.rows = 5;
                this.cols = 4;
                break;
            default:
                this.rows = 3;
                this.cols = 4;
                break;
        }

        drawLevel();
    }

}
