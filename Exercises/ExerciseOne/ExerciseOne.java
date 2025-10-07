package ExerciseOne;

import java.util.*;

public class ExerciseOne{

    public static void digitCalculator(){
        Scanner scnr = new Scanner(System.in);

        System.out.print("Enter an integer: ");

        int sum = 0;
        // make an catch here
        int number = scnr.nextInt();

        while (number !=0){
            sum += number % 10;
            number /= 10;
        }

        System.out.println(sum);
    }

    public static void main(String[] args) {
        digitCalculator();
    }
}