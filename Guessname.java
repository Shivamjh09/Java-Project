import java.util.Random;
		import java.util.Scanner;

public class Guessname {

	public static void main(String[] args) {
		
		        playGame();
		    }

		    private static void playGame() {
		        Scanner scanner = new Scanner(System.in);
		        Random random = new Random();
		        int lowerBound = 1;
		        int upperBound = 100;
		        int maxAttempts = 5;
		        int round = 1;
		        int score = 0;

		        System.out.println("Welcome to the Guess the Number Game!");

		        do {
		            int targetNumber = random.nextInt(upperBound - lowerBound + 1) + lowerBound;
		            int attempts = 0;
		            int guess;

		            System.out.println("\nRound " + round + ":");
		            System.out.println("Guess the number between " + lowerBound + " and " + upperBound);

		            while (attempts < maxAttempts) {
		                System.out.print("Attempt " + (attempts + 1) + ": Enter your guess: ");
		                guess = scanner.nextInt();
		                attempts++;

		                if (guess == targetNumber) {
		                    System.out.println("Congratulations! You guessed the correct number in " + attempts + " attempts.");
		                    score++;
		                    break;
		                } else if (guess < targetNumber) {
		                    System.out.println("Too low. Try again.");
		                } else {
		                    System.out.println("Too high. Try again.");
		                }
		            }

		            if (attempts == maxAttempts) {
		                System.out.println("Sorry, you've reached the maximum number of attempts. The correct number was: " + targetNumber);
		            }

		            System.out.print("Do you want to play again? (yes/no): ");
		            String playAgain = scanner.next();
		            if (playAgain.equalsIgnoreCase("no")) {
		                break;
		            }

		            round++;
		        } while (true);

		        System.out.println("Game Over!");
		        System.out.println("Your final score is: " + score);
		    }
		

	}


