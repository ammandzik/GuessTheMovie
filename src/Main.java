
import java.util.ArrayList;
import java.util.Scanner;
import java.io.File;
import java.util.List;
import java.util.Random;


public class Main {
    public static void main(String[] args) {

        //create objects of class scanner and import the files with movies titles

        Scanner fileScanner = new Scanner(new File(home/amanda/moviesTitles.txt));
        Scanner userChoice = new Scanner(System.in);

        // create list of titles & adds titles from file to the array list

        List<String> titles = new ArrayList<>();
        while (fileScanner.hasNext()) {
            titles.add(fileScanner.nextLine());

        }

        // create object of a random class

        Random random = new Random();
        String title = titles.get(random.nextInt(titles.size()));

        System.out.println(title);

        List<Character> playerGuesses = new ArrayList<>();
        printWord(title, playerGuesses);

        while (true) {
            getPlayerGuesses(userChoice, title, playerGuesses);

            if (printWord(title, playerGuesses)) {
                System.out.println(("\nGame over. You have won"));
            }
        }

    }
        public static void getPlayerGuesses (Scanner userChoice, String title, List <Character> playerGuesses){

            System.out.println("\nPlease enter a letter");
            String letterGuess = userChoice.nextLine();
            playerGuesses.add(letterGuess.charAt(0));

        }

        public static boolean printWord (String title, List <Character> playerGuesses){
            int countGuesses = 0;
            int countBlanks = 0;
            int initialScore = 10;

            for (int i = 0; i < title.length(); i++) {

                if (playerGuesses.contains(title.charAt(i))) {
                    System.out.println(title.charAt(i));
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
