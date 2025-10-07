package RPSGame;

import java.util.*;

public class RockPaperScissorsGame {

    public static void rockPaperScissors(){


        ///update to add some character to it/ intro
        int userChoice = -1; //assigned to not an option
        int computerChoice;
        String userInput;
        boolean repeat = true;
        boolean inputLoop = true;
        final int UPPER_VALUE = 3;

        while (repeat){

            Random random = new Random();
            computerChoice = random.nextInt(UPPER_VALUE);
            //System.out.println(computerChoice); // checking the value the computer gets

            Scanner scnr = new Scanner(System.in);
            System.out.print("Choose rock, paper, or scissors: ");


            while (inputLoop) {
                userInput = scnr.next().toLowerCase();
                switch (userInput) {
                    case "rock" -> {
                        userChoice = 0;
                        inputLoop = false;
                    }
                    case "paper" -> {
                        userChoice = 1;
                        inputLoop = false;
                    }
                    case "scissors" -> {
                        userChoice = 2;
                        inputLoop = false;
                    }
                    default -> System.out.print("Please choose rock, paper, or scissors: ");
                } //don't need check because this checks to see if the input matches the specific strings
            }


            System.out.println("You: " + userChoice + " vs. Computer: " + computerChoice);
            if (userChoice == computerChoice){
                System.out.println("Its a tie!");
            }
            else if ((userChoice == 0 && computerChoice == 1 ) || (userChoice == 1 && computerChoice == 2)
                    || (userChoice == 2 && computerChoice == 0)){
                System.out.println("Computer wins!");
            }
            else {
                System.out.println("You win!");
            }

            System.out.print("Play again?: ");
            userInput = scnr.next().toLowerCase();
                if (userInput.equals("no")){
                    repeat = false;
                    System.out.println("Thanks for Playing!");
                }
                else {
                    inputLoop = true;
                    scnr.close();
                }
        }
    }


    public static void main(String[] args) {
        rockPaperScissors();
    }
}