import java.util.Random;
import java.util.Scanner;

public class hw04 {
    static final int SIZE_X = 3;
    static final int SIZE_Y = 3;

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
            }
            x = (pID==PLAYER_DOT)?scanner.nextInt() - 1:random.nextInt(SIZE_X);
            y = (pID==PLAYER_DOT)?scanner.nextInt() - 1:random.nextInt(SIZE_Y);
        }
        while (!valid(y, x));
        field[y][x] = pID;
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
