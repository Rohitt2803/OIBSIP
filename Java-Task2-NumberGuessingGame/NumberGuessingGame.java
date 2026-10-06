import java.util.Random;
import java.util.Scanner;

public class NumberGuessingGame {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();
        boolean playAgain = true;
        int roundCount = 0;

        System.out.println("==========================================");
        System.out.println("   WELCOME TO THE NUMBER GUESSING GAME    ");
        System.out.println("==========================================");

        while (playAgain) {
            roundCount++;
            System.out.println("\n--- Round " + roundCount + " ---");
            System.out.println("Select Difficulty Level:");
            System.out.println("1. Easy   (Range: 1-50, Attempts: 10)");
            System.out.println("2. Medium (Range: 1-100, Attempts: 7)");
            System.out.println("3. Hard   (Range: 1-200, Attempts: 5)");
            System.out.print("Enter choice (1-3): ");

            int choice = scanner.hasNextInt() ? scanner.nextInt() : 2;
            int maxRange = 100;
            int maxAttempts = 7;

            if (choice == 1) {
                maxRange = 50;
                maxAttempts = 10;
            } else if (choice == 3) {
                maxRange = 200;
                maxAttempts = 5;
            }

            int targetNumber = random.nextInt(maxRange) + 1;
            int attemptsUsed = 0;
            boolean guessedCorrectly = false;

            System.out.println("\nI have picked a number between 1 and " + maxRange + ".");
            System.out.println("You have " + maxAttempts + " attempts. Good luck!");

            while (attemptsUsed < maxAttempts) {
                attemptsUsed++;
                System.out.print("Attempt " + attemptsUsed + "/" + maxAttempts + " - Enter your guess: ");
                
                if (!scanner.hasNextInt()) {
                    System.out.println("Invalid input. Please enter an integer.");
                    scanner.next();
                    attemptsUsed--;
                    continue;
                }

                int userGuess = scanner.nextInt();

                if (userGuess == targetNumber) {
                    System.out.println(">> Correct! You guessed the number in " + attemptsUsed + " attempts!");
                    guessedCorrectly = true;
                    break;
                } else if (userGuess < targetNumber) {
                    System.out.println(">> Too Low!");
                } else {
                    System.out.println(">> Too High!");
                }
            }

            if (!guessedCorrectly) {
                System.out.println("\nYou Lost! Maximum attempts reached.");
                System.out.println("The secret number was: " + targetNumber);
            }

            System.out.println("\nSummary: Round " + roundCount + " finished in " + (guessedCorrectly ? attemptsUsed : maxAttempts) + " attempts.");
            System.out.print("Do you want to play another round? (yes/no): ");
            String response = scanner.next().trim().toLowerCase();
            playAgain = response.equals("yes") || response.equals("y");
        }

        System.out.println("\nThank you for playing! Exiting...");
        scanner.close();
    }
}
