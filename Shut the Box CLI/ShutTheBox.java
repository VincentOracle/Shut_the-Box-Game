//3456789A123456789A123456789A123456789A123456789A123456789A123456789A123456789A
//Note: Observe the request for time-records at the bottom of this file.
import java.util.Scanner;
import java.util.Random;

public class ShutTheBox {
  public static void main(String[] args) {
    //************************** Put Your Code Here. ***************************
    
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();

        int totalScore = 0;
        int totalWins = 0;
        int totalRounds = 0;

        while (true) {
            System.out.print("Enter a seed: ");
            long seed = scanner.nextLong();
            random.setSeed(seed);

            int roundScore = 0;
            boolean[] tiles = new boolean[9]; // Assuming there are 9 tiles

            while (true) {
                int roll = random.nextInt(12) + 1; // Assuming two dice, so the range is 2 to 12
                System.out.println("You rolled: " + roll);

                System.out.println("Available tiles:");
                for (int i = 0; i < tiles.length; i++) {
                    if (!tiles[i]) {
                        System.out.print((i + 1) + " ");
                    }
                }
                System.out.println();

                System.out.print("Do you want to continue playing? (yes/no): ");
                String input = scanner.next().toLowerCase();

                if (input.equals("no")) {
                    System.out.println("Game Over");
                    break;
                }

                boolean canContinue = ShutTheBox_HelperClass.continuePlaying(tiles, roll);
                if (!canContinue) {
                    System.out.println("You cannot continue. Game Over");
                    break;
                }

                System.out.print("Enter the numbers you want to flip or close (separated by spaces): ");
                scanner.nextLine(); // Consume the newline character
                String userInput = scanner.nextLine();
                String[] inputNumbers = userInput.split(" ");
                for (String number : inputNumbers) {
                    int tileNumber = Integer.parseInt(number);
                    if (tileNumber >= 1 && tileNumber <= 9) {
                        tiles[tileNumber - 1] = true;
                        roundScore += tileNumber;
                    } else {
                        System.out.println("Invalid input: " + tileNumber);
                    }
                }
            }

            totalScore += roundScore;
            totalRounds++;
            if (tiles[0] && tiles[1] && tiles[2] && tiles[3] && tiles[4] && tiles[5] && tiles[6] && tiles[7] && tiles[8]) {
                totalWins++;
                System.out.println("Congratulations, you won!");
            }

            System.out.print("Do you wish to play again? Enter “Yes” to play again or anything else to quit: ");
            String playAgain = scanner.next().toLowerCase();
            if (!playAgain.equals("yes")) {
                break;
            }
        }

        System.out.println("Thank you for playing \"Close the Box\"! The total score is " + totalScore + " with " + totalWins + " win(s) after " + totalRounds + " round(s).");  

    
    //Use this boolean static-method (class-method) to determine if some or all
    //of the available tiles ('tiles') could possibly be arranged to sum to the
    //dice roll ('roll'). The method outputs a boolean value (true or false).
    ??? = ShutTheBox_HelperClass.continuePlaying(boolean[] tiles, int roll);
    
    //**************************************************************************
  }
}

/*
1. (CRITICAL QUESTION) How much time was required to complete the:
   A) single-play portion of the project? 
   B) multi-play portion of the project?
   C) play with error detection portion of the project?
   Note: Since this project will require several days, students must record
         careful notes.
 
2. What was the hardest part of this lab?

3. What will you always remember (never forget) from this exercise?

*/