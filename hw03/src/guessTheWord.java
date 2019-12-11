import java.util.Random;
import java.util.Scanner;

public class guessTheWord {
    private static Scanner sc = new Scanner(System.in);
    private static Random rnd = new Random();

    private static String[] words = {"apple", "orange", "lemon",
                                        "banana", "apricot", "avocado",
                                        "broccoli", "carrot", "cherry",
                                        "garlic", "grape", "melon", "leak",
                                        "kiwi", "mango", "mushroom", "nut",
                                        "olive", "pea", "peanut", "pear",
                                        "pepper", "pineapple", "pumpkin", "potato"};

    public static void main(String[] args) {
        playTheGame();
        sc.close();
    }
    public static String chooseTheWord(){
        int idx = rnd.nextInt(words.length);
        return words[idx].toLowerCase();
    }
    public static void playTheGame(){
        String word2Guess = chooseTheWord();
        System.out.println("Отгадайте слово из списка " + words.toString());
        boolean win = false;
        int i = 1;
        String userPrompt = "###############################";
        do {
            System.out.print("Попытка №" + (i++) + ": ");
            String userInput = sc.next();
            userInput = userInput.toLowerCase();
            if (userInput.equals(word2Guess)){
                System.out.println("Вы угадали слово!");
                break;
            };
            StringBuilder promptBuilder = new StringBuilder(userPrompt);
            int minLength = (userInput.length()>word2Guess.length())?word2Guess.length():userInput.length();
            for (int j = 0; j<minLength; j++){
                if (userInput.charAt(j) == word2Guess.charAt(j)){
                    promptBuilder.setCharAt(j,userInput.charAt(j));
                }
            }
            userPrompt = promptBuilder.toString();
            System.out.println(userPrompt);

        }while (!win);

    }
}
