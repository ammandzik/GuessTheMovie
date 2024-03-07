
import java.util.ArrayList;
import java.util.Scanner;
import java.io.File;
import java.util.List;
import java.util.Random;


public class Main {
    public static void main(String[] args) {

        //create objects of class scanner and import the files with movies titles

       //Scanner fileScanner = new Scanner(new File(/home/amanda/~Desktop/moviesTitles.plaintext/));
        Scanner userChoice = new Scanner(System.in);

        // create list of titles & adds titles from file to the array list

        List<String> titles = new ArrayList<>();


        // create object of a random class

        Random random = new Random();
        String title = "Dupa";

        System.out.println(title);

        List<Character> playerGuesses = new ArrayList<>();
        printWord(title, playerGuesses);

        int initialScore = 10;

        while (true) {
            printWord(title, playerGuesses);
            if (!getPlayerGuesses(userChoice, title, playerGuesses)) {
                initialScore--;
                System.out.println(initialScore);
                if (initialScore == 0) {
                    System.out.println("Game over. You've lost all your points");
                }
                break;
            }

            if (printWord(title, playerGuesses)) {
                System.out.println(("\nGame over. You have won"));
                break;
            }
            }
        }


        public static boolean getPlayerGuesses (Scanner userChoice, String title, List <Character> playerGuesses) {

            System.out.print("\nPlease enter a letter");
            String letterGuess = userChoice.nextLine();
            playerGuesses.add(letterGuess.charAt(0));

            return title.contains(letterGuess);


        }

        public static boolean printWord (String title, List <Character> playerGuesses){
            int countGuesses = 0;
            int countBlanks = 0;


            for (int i = 0; i < title.length(); i++) {

                if (playerGuesses.contains(title.charAt(i))) {
                    System.out.print(title.charAt(i));
                } else if (title.charAt(i) == ' ') {
                    System.out.print(' ');
                    countBlanks++;
                } else {
                    System.out.print("_");
                }

            }

            return title.length() - countBlanks == countGuesses;

        }
    }
