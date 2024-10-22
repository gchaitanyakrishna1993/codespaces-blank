import java.util.Random;
import java.util.Scanner;

//Add java code for Rock Paper Scissors game
//Capture user input for Rock, Paper, Scissors in number format
//Computer should be the opponent and it should generate random number for Rock, Paper, Scissors
//Player can only select Rock, Paper, Scissors and should be warned if they enter an invalid number
//At the end of each game, player should be asked if they want to play again
//display the final result of all games at the end of the game
//Minigame must handle user inputs, putting them in lowercase, and checking if they are valid
//Interaction with the user should be done through the console
//Winner of game should be determined by the rules of Rock Paper Scissors
//Rock beats Scissors, Scissors beats Paper, Paper beats Rock
public class RockPaperScissors {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();
        String[] rps = {"rock", "paper", "scissors"};
        int userWins = 0;
        int computerWins = 0;
        int ties = 0;
        boolean playAgain = true;

        while (playAgain) {
            System.out.println("Enter move (rock, paper, scissors). To exit the game, type \"exit\": ");
            String userMove = scanner.nextLine().toLowerCase();

            if (userMove.equals("exit")) {
                playAgain = false;
                break;
            }

            if (!userMove.equals("rock") && !userMove.equals("paper") && !userMove.equals("scissors")) {
                System.out.println("Invalid move, please try again.");
                continue;
            }

            int computerMoveIndex = random.nextInt(3);
            String computerMove = rps[computerMoveIndex];
            System.out.println("Computer move: " + computerMove);

            if (userMove.equals(computerMove)) {
                System.out.println("It's a tie!");
                ties++;
            } else if ((userMove.equals("rock") && computerMove.equals("scissors")) ||
                       (userMove.equals("scissors") && computerMove.equals("paper")) ||
                       (userMove.equals("paper") && computerMove.equals("rock"))) {
                System.out.println("You win!");
                userWins++;
            } else {
                System.out.println("You lose!");
                computerWins++;
            }

            System.out.println("Do you want to play again? (yes/no)");
            String response = scanner.nextLine().toLowerCase();
            if (!response.equals("yes")) {
                playAgain = false;
            }
        }

        System.out.println("Final Results:");
        System.out.println("User Wins: " + userWins);
        System.out.println("Computer Wins: " + computerWins);
        System.out.println("Ties: " + ties);
        scanner.close();
    }
}