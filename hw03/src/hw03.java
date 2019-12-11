import java.util.Random;
import java.util.Scanner;

public class hw03 {

    private static int level = 10;
    private static int attemptsCount = 3;
    private static int number2Guess = new Random().nextInt(level);
    private static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        boolean win = false;
        for (int i = 0; i < attemptsCount; i++) {
            int userAnswer = getNumberFromScanner("Угадайте число от 0 до " + (level - 1), 0, 9);
            if (number2Guess == userAnswer){
                System.out.println("Поздравляем, Вы угадали число: " + number2Guess);
                win = true;
                break;
            }else if (number2Guess > userAnswer){
                System.out.println("Загаданное число больше " + userAnswer);
            }else if (number2Guess < userAnswer){
                System.out.println("Загаданное число меньше " + userAnswer);
            }
        }
        if(!win){
            System.out.println("Вы так и не угадали число " + number2Guess + "\nВ следующий раз Вам точно повезет!");
        }
        sc.close();
    }

    public static int getNumberFromScanner(String message, int min, int max) {
        int x;
        do {
            System.out.println(message);
            x = sc.nextInt();
        } while (x <= min || x >= max);

        return x;
    }

}
