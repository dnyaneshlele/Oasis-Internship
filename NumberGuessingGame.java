import java.util.Scanner;

public class NumberGuessingGame {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int randomNumber = (int) (Math.random() * 100) + 1; // generate a random number between 1 and 100
        int guess;
        int numGuesses = 0;


        System.out.println("Welcome to the Number Guessing Game!");
        System.out.println("I'm thinking of a number between 1 and 100. Can you guess it?");

        while (!isCorrect)
        {
            System.out.print("Enter your guess: ");
            guess = input.nextInt();
            numGuesses++;

            if (guess == randomNumber)

            {
                System.out.println("Congratulations! You guessed the number in " + numGuesses + " guesses!");
                isCorrect = true;
            } else if (guess < randomNumber)

            {
                System.out.println("Too low. Try again.");
            } else

            {
                System.out.println("Too high. Try again.");
            }
        }

        input.close();
    }
}
