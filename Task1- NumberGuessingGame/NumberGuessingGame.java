import java.util.Scanner;
import java.util.Random;

public class NumberGuessingGame {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();
        int totalRounds = 0;   
        int totalScore = 0;
        
        System.out.println("Welcome to the Number Guessing Game!");

        boolean playAgain;
        do {
            int targetNumber = random.nextInt(100) + 1;  
            int maxAttempts = 7;
            int attempts = 0;
            boolean guessedCorrectly = false;

            System.out.println("\nI have selected a number between 1 and 100.");
            System.out.println("You have " + maxAttempts + " attempts. Good luck!");

            while (attempts < maxAttempts) {
                System.out.print("Enter your guess: ");
                int guess = scanner.nextInt();
                attempts++;

                if (guess == targetNumber) {
                    System.out.println("Correct! You guessed the number in " + attempts + " attempts.");
                    totalScore += (maxAttempts - attempts + 1);  
                    guessedCorrectly = true;
                    break;
                } else if (guess < targetNumber) {
                    System.out.println("Too low!");
                } else {
                    System.out.println("Too high!");
                }
            }

            if (!guessedCorrectly) {
                System.out.println("You've used all attempts! The number was: " + targetNumber);
            }

            totalRounds++;

            System.out.print("\nDo you want to play another round? (yes/no): ");
            String response = scanner.next().toLowerCase();
            playAgain = response.equals("yes");

        } while (playAgain);

        System.out.println("\n Game Over!");
        System.out.println("Total rounds played: " + totalRounds);
        System.out.println("Your total score: " + totalScore);
        System.out.println("Thanks for playing!");

        scanner.close();
    }
}
