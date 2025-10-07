package ChohanGame;

public class Chohan {

    public static boolean result;

    public static boolean playGame(String playerGuess){

        int diceOne = (int) (Math.random() * 6) + 1;
        System.out.println(diceOne);
        int diceTwo = (int) (Math.random() * 6) + 1;
        System.out.println(diceTwo);

        int sum = diceOne + diceTwo;
        System.out.println("Sum: " + sum);
        System.out.println("You guessed: " + playerGuess);

        result = (sum % 2) == 0 && playerGuess.equalsIgnoreCase("even") ||
                (sum % 2 == 1) && playerGuess.equalsIgnoreCase("odd");

        return result;
    }

    public static void main(String[] args) {

        if (args.length > 1 && args[2].equalsIgnoreCase("even") || args[2].equalsIgnoreCase("odd")){
            if (playGame(args[2])){
                System.out.println("You won!");
            }
            else{
                System.out.println("You lost.");
            }
        }
        else{
            System.out.println("Please supply 'odd' or 'even' in the cmd argument");
        }

        System.exit(0);
    }

}