package ExerciseTwo;

import java.util.*;

public class ExerciseTwo {

    public static void reverseNumber(){
        Scanner scnr = new Scanner(System.in);
        boolean repeat = true;
        System.out.println("Enter an integer: ");

        int reverse=0;

        while (repeat){
            try{
                int number = scnr.nextInt();
                repeat = false;

                while (number != 0){
                    reverse = reverse * 10 + number % 10;
                    number /= 10;
                }
            }
            catch (InputMismatchException mismatch){
                System.out.println("Please enter an integer");
                scnr.next();
            }
        }

        System.out.println(reverse);
    }

    public static void main(String[] args) {
        reverseNumber();
    }
}
