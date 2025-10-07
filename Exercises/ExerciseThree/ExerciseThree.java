package ExerciseThree;

import java.util.*;

public class ExerciseThree {

    public static void ageDetector(){

        String city;
        String state;
        String cityState = "placeholder";
        int age;
        final int MINOR_AGE = 18;
        final int LOW_AGE = 0;
        final int HIGH_AGE = 150;
        boolean repeatOne = true;
        boolean repeatTwo = true;
        Scanner input = new Scanner(System.in);

        while(repeatOne) { // fix this check and do some research
            try {
                System.out.print("Enter your city: ");
                city = input.next();
                System.out.print("Enter your state: ");
                state = input.next();
                cityState = city.concat(", " + state);

                repeatOne = false;
            } catch (InputMismatchException mismatch) {
                System.out.println("Please enter a valid location");
                input.next();
            }
        }


        while (repeatTwo) {
            try {

                age = input.nextInt();

                if (age >= MINOR_AGE && age < HIGH_AGE) {
                    System.out.println("You are an adult in " + cityState);
                    repeatTwo = false;
                } else if (age <= LOW_AGE || age >= HIGH_AGE) {
                    System.out.println("Please enter a vaild age.");
                    input.next();
                } else {
                    System.out.println("You are a minor in " + cityState);
                    repeatTwo = false;
                }

            } catch (InputMismatchException wrongInput) { //fix this
                System.out.println("Please enter a whole number.");
                input.next();
            }
        }

    }

    public static void main(String[] args) {
        ageDetector();
    }
}
