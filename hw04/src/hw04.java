import java.util.Random;
import java.util.Scanner;

public class hw04 {
    static final int SIZE_X = 5;
    static final int SIZE_Y = 5;

    static char[][] field = new char[SIZE_X][SIZE_X];
    static Scanner scanner = new Scanner(System.in);
    static Random random = new Random();

    static final char PLAYER_DOT = 'X';
    static final char AI_DOT = 'O';
    static final char EMPTY_DOT = '.';

    static void initField() {
        for (int i = 0; i < SIZE_Y; i++) {
            for (int j = 0; j < SIZE_X; j++) {
                field[i][j] = EMPTY_DOT;
            }
        }
    }

    static void printField() {
        for (int i = 0; i < SIZE_Y; i++) {
            if (i == 0) {
                System.out.print("\t" + (i + 1) + "\t");
            } else {
                System.out.print((i + 1) + "\t");
            }
        }
        System.out.println();
        for (int i = 0; i < SIZE_Y; i++) {
            System.out.print((i + 1) + "\t");
            for (int j = 0; j < SIZE_X; j++) {
                System.out.print(field[i][j] + "\t");
            }
            System.out.println();
        }
    }


    private static boolean valid(int y, int x) {
        if (x < 0 || y < 0 || x > SIZE_X - 1 || y > SIZE_Y - 1) {
            return false;
        }
        return field[y][x] == EMPTY_DOT;
    }

    static void Step(char pID) {
        int x, y;
        do {
            if (pID==PLAYER_DOT){
                System.out.println("Введите координаты X и Y:");
                x = scanner.nextInt() - 1;
                y = scanner.nextInt() - 1;
            }else {
                int[] aiMove = aiBestMove();
                x = aiMove[0];
                y = aiMove[1];
            }

        }
        while (!valid(y, x));

        setSymbol(y,x,pID);
    }

    static int[] aiBestMove(){
        //trying to find ai's win-move
        int[] moveCoord = move2Win(AI_DOT);

        if (moveCoord[0] != -1){
            return moveCoord;//found final ai move 2 win
        }
        //trying to find player's win move to block it
        moveCoord = move2Win(PLAYER_DOT);
        if (moveCoord[0] != -1){
            return moveCoord;
        }
        //if there's no win-moves make random move
        moveCoord[0] = random.nextInt(SIZE_X);
        moveCoord[1] = random.nextInt(SIZE_Y);

        return moveCoord;
    }

    static int[] move2Win(char testing_DOT){
        int[] winCoord = {-1,-1};
        for (int i = 0; i<SIZE_X; i++) {
            for (int j = 0; j < SIZE_Y; j++) {
                if(field[j][i] != EMPTY_DOT){
                    continue;
                }
                setSymbol(j,i,testing_DOT);
                if (checkWin(testing_DOT)){
                    winCoord[0] = i;
                    winCoord[1] = j;
                }
                setSymbol(j,i,EMPTY_DOT);
                if (winCoord[0]!=-1){
                    break;
                }
            }
            if (winCoord[0]!=-1){
                break;
            }
        }
        return winCoord;
    }

    private static void setSymbol(int y, int x, char symbol) {
        field[y][x] = symbol;
    }
    static boolean isFieldsFull() {
        for (int i = 0; i < SIZE_Y; i++) {
            for (int j = 0; j < SIZE_X; j++) {
                if (field[i][j] == EMPTY_DOT) return false;
            }
        }
        return true;
    }

    static boolean checkWin(char symbol) {
        int d1,d2;
        d1=d2=0;

        for (int i = 0,q = SIZE_Y-1; i<SIZE_X; i++, q--){
            int checkSum = 0;
            for (int j = 0; j<SIZE_Y; j++){
                if (field[i][j]==symbol){
                    checkSum++;
                    d1+=(i==j)?1:0;
                }
            }
            if (checkSum == SIZE_Y){
                return true;
            }
            d2 += (field[i][q] == symbol)?1:0;

        }
        if (d1 == SIZE_X || d2 == SIZE_X){
            return true;
        }
        for (int i = 0; i<SIZE_Y; i++){
            int checkSum = 0;
            for (int j = 0; j<SIZE_X; j++){
                checkSum += (field[j][i]==symbol)?1:0;
            }
            if (checkSum == SIZE_X){
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        initField();
        printField();

        char currentPlayer = PLAYER_DOT;
        while (true) {


            Step(currentPlayer);
            printField();

            if (checkWin(currentPlayer)) {
                System.out.println((currentPlayer==PLAYER_DOT)?"Player WIN":"SkyNet WIN");
                break;
            }
            if (isFieldsFull()) {
                System.out.println("DRAW!");
                break;
            }

            currentPlayer = (currentPlayer == PLAYER_DOT)?AI_DOT:PLAYER_DOT;
        }

    }
}
