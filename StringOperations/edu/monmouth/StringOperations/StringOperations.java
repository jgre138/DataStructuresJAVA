package edu.monmouth.StringOperations;

import java.util.*;

public class StringOperations {

    private String str;
    public Scanner scnr = new Scanner(System.in);
    private final String vowels = "AEIOUaeiou";

   //Constructor
    public StringOperations(String str) {
        str = checkString(str);
        this.str = str;
        System.out.println(this.str);
    }

    //Verification
    public String checkString(String string){ //checks the string and allows new sting input
        try {
            if (string == null || string.isEmpty()) {
                throw new IllegalArgumentException();
            }
        }
        catch (IllegalArgumentException illegalString){
            System.out.println("Please enter a sentence or word: ");
            string = scnr.nextLine(); // allows for a new string to be used while the initial input was empty
        }
        return string;
    }

    //Methods
    public String lettersOnly(){
        StringBuilder allLetters = new StringBuilder();

        for (char c : str.toCharArray() ){
            if(Character.isLetter(c)){
                allLetters.append(c);
            }
        }

        return allLetters.toString();
    }

    public String uppersOnly(){
        StringBuilder allUppers = new StringBuilder();

        for (char c : str.toCharArray()){
            if (Character.isUpperCase(c)){
                allUppers.append(c);
            }
        }

        return allUppers.toString();
    }

    public int numberOfVowels(){
        int vowelCount = 0;

        for (char c :str.toCharArray()){
            if (vowels.indexOf(c) != -1){
                vowelCount++;
            }
        }

        return vowelCount;
    }

    public int numberOfConsonants(){
        int conCount = 0;

        for (char c : str.toCharArray()){
            if(Character.isLetter(c) && vowels.indexOf(c) == -1){
                conCount++;

            }
        }
        return conCount;
    }

    public String reverseString(){
        StringBuilder reverse = new StringBuilder();

        for (int incr = str.length() -1; incr >= 0; incr--){
            reverse.append(str.charAt(incr));
        }

        return reverse.toString();
    }

    public String getVowels(){
        StringBuilder allVowels = new StringBuilder();

        for (char c : str.toCharArray()){
            if (vowels.indexOf(c) != -1){
                allVowels.append(c);
            }
        }

        return allVowels.toString();
    }

    public String getConsonants(){
        StringBuilder allConsonants = new StringBuilder();

        for (char c : str.toCharArray()){
            if(Character.isLetter(c) && vowels.indexOf(c) == -1){
                allConsonants.append(c);
            }
        }

        return allConsonants.toString();
    }

}