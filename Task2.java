// Java program for the above approach
import java.util.Scanner;

public class Task2{

	// Function that implements the
	// number guessing game
	public static void
	guessingNumberGame()
	{
		
		Scanner sc = new Scanner(System.in);
			// Generate the numbers
			int number = 1 + (int)(100
								* Math.random());

			// Given K trials
			int K = 5;

			int i, guess;

			System.out.println(
				"A number is chosen"
				+ " between 1 to 100."
				+ "Guess the number"
				+ " within 5 trials.");

			// Iterate over K Trials
			for (i = 0; i < K; i++) {

				System.out.println(
					"Guess the number:");

				// Take input for guessing
				guess = sc.nextInt();

				// If the number is guessed
				if (number == guess) {
					System.out.println(
						"Congratulations!"
						+ " You guessed the number.");
					break;
				}
				else if (number > guess
						&& i != K - 1) {
					System.out.println(
						"The number is "
						+ "greater than " + guess);
				}
				else if (number < guess
						&& i != K - 1) {
					System.out.println(
						"The number is"
						+ " less than " + guess);
				}
			}

			if (i == K) {
				System.out.println(
					"You have exhausted"
					+ " K trials."+"\nGame Over!!!");

				System.out.println(
					"The number was " + number);
			}
		}
	

	// Driver Code
	public static void
	main(String arg[])
	{
		int ch;
		Scanner sc = new Scanner(System.in);
			do{
			System.out.println("1.Start new game\n2.Quit the game\n");
			System.out.println("Enter your Choice:");
			ch= sc.nextInt();
			switch(ch){
			case 1:	guessingNumberGame();
					break;
			
			case 2:System.out.println("Exiting game...");
					break;
			}
}while(ch!=2);
		
	}
}
