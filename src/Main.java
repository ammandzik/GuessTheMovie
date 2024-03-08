
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;
import java.io.File;
import java.util.List;
import java.util.Random;


public class Main {
    public static void main(String[] args) throws FileNotFoundException {

        //create objects of class scanner and import the files with movies titles

        Scanner fileScanner = new Scanner(new File("home/amanda/IdeaProjects/GuessTheMovie/src/moviesTitles.txt"));
        Scanner userChoice = new Scanner(System.in);

        // create list of titles & adds titles from file to the array list

        List<String> titles = new ArrayList<>();

//        while (fileScanner.hasNext()) {
//            titles.add(fileScanner.nextLine());
//        }

        // create object of a random class

        Random random = new Random();
//      String title = titles.get(random.nextInt(titles.size()));
        String title = "random title";

        System.out.println(title);

        List<Character> playerGuesses = new ArrayList<>();


        int initialScore = 10;

        while (true) {

            if (printWord(title, playerGuesses)) {
                System.out.println("\nYou have won");
                break;

            } else if (!getPlayerGuesses(userChoice, title, playerGuesses)) {
                initialScore--;
                System.out.println("You chances left: " + initialScore);
                if (initialScore == 0) {
                    System.out.println("Game over. You've lost all your points");
                    break;
                }
            }
        }

    }


        public static boolean getPlayerGuesses (Scanner userChoice, String title, List <Character> playerGuesses) {

            System.out.println("\nPlease enter a letter");
            String letterGuess = userChoice.nextLine();
            playerGuesses.add(letterGuess.charAt(0));

            return title.contains(letterGuess);


        }

        public static boolean printWord (String title, List <Character> playerGuesses){
            int countBlanks = 0;
            int correctCount = 0;


            for (int i = 0; i < title.length(); i++) {

                if (playerGuesses.contains(title.charAt(i))) {
                    System.out.print(title.charAt(i));
                    if (title.charAt(i) != '_') {
                        correctCount++;
                    }
                } else if (title.charAt(i) == ' ') {
                    System.out.print(' ');
                    countBlanks++;
                } else {
                    System.out.print("_");
                }

            }

            return correctCount == title.length() - countBlanks;

        }
    }
