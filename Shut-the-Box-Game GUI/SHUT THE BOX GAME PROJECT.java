import java.util.Scanner;
import java.util.Random;


public class ShutTheBox_HelperClass {
    public static boolean continuePlaying(boolean[] availableNumbers, int roll) {
        // Check if some or all of the available tiles could possibly be arranged to sum to the dice roll
        // You need to implement the logic for this method
        // For simplicity, let's assume it always returns true for now
        return true;
    }
}


public class ShutTheBox {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();
        boolean playAgain = true;
        int totalScore = 0;
        int totalWins = 0;

        while (playAgain) {
            System.out.println("\nWelcome to the 'Shut the Box' Game.\n");
            System.out.println("Enter a seed:");
            long seed = scanner.nextLong();
            random.setSeed(seed);

            // Game initialization
            int roundScore = 0;
            boolean[] availableNumbers = new boolean[10];
            for (int i = 1; i <= 9; i++) {
                availableNumbers[i] = true;
            }

            // Game loop
            while (true) {
                System.out.print("The available number(s) are: ");
                for (int i = 1; i <= 9; i++) {
                    if (availableNumbers[i]) {
                        System.out.print(i + " ");
                    }
                }
                System.out.println("\n");

                // Dice roll
                int dice1 = random.nextInt(6) + 1;
                int dice2 = random.nextInt(6) + 1;
                int sum = dice1 + dice2;
                System.out.println("The dice roll is " + dice1 + " and " + dice2 + " for a sum of " + sum + ".");

                // Player's turn
                System.out.println("Which tile(s) should be 'closed'? Separate multiple tiles with a space.");
                String input = scanner.nextLine(); // consume newline
                input = scanner.nextLine();
                String[] selectedTilesStr = input.split(" ");
                boolean[] selectedTiles = new boolean[10];
                int selectedSum = 0;
                boolean validInput = true;

                for (String tileStr : selectedTilesStr) {
                    int tile = Integer.parseInt(tileStr);
                    if (!availableNumbers[tile]) {
                        validInput = false;
                        break;
                    }
                    selectedTiles[tile] = true;
                    selectedSum += tile;
                }

                if (validInput && selectedSum == sum) {
                    for (int i = 1; i <= 9; i++) {
                        if (selectedTiles[i]) {
                            availableNumbers[i] = false;
                        }
                    }
                    roundScore += sum;
                    boolean continuePlaying = ShutTheBox_HelperClass.continuePlaying(availableNumbers, sum);
                    if (!continuePlaying) {
                        break;
                    }
                } else {
                    System.out.println("Error! Invalid input or selected tiles do not sum up to the dice roll.");
                }
            }

            totalScore += roundScore;
            totalWins++;

            System.out.println("\nCongratulations, you won!");
            System.out.println("\nDo you wish to play again? Enter 'Yes' to play again or anything else to quit.");
            String playAgainInput = scanner.nextLine();
            playAgain = playAgainInput.equalsIgnoreCase("Yes");
        }

        System.out.println("\nThank you for playing 'Close the Box'! The total score is " + totalScore + " with " + totalWins + " win(s) after " + totalWins + " round(s).");
    }
}
