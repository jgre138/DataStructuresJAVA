package edu.monmouth.StringOperations;

public class StringExercise {
	public static void main(String[] args) {
		StringOperations stringOps = new StringOperations("Four score and seven years ago our fathers"
				+ " brought forth on this continent, a new nation, conceived in Liberty, and dedicated"
				+ "to the proposition that all men are created equal.");

		System.out.println("Letters: " + stringOps.lettersOnly());

		System.out.println("Upper Case: " + stringOps.uppersOnly());

		System.out.println("Number of Vowels: " + stringOps.numberOfVowels());

		System.out.println("Number of Consonants: " + stringOps.numberOfConsonants());

		System.out.println("The reverse " + stringOps.reverseString());

		System.out.println("Vowels: " + stringOps.getVowels());

		System.out.println("Consonants: " + stringOps.getConsonants());

		stringOps = new StringOperations(""); // this would give an error, May need ot fix this for the code below.

		System.out.println("Letters: " + stringOps.lettersOnly());

		System.out.println("Upper Case: " + stringOps.uppersOnly());

		System.out.println("Number of Vowels: " + stringOps.numberOfVowels());

		System.out.println("Number of Consonants: " + stringOps.numberOfConsonants());

		System.out.println("The reverse " + stringOps.reverseString());

		System.out.println("Vowels: " + stringOps.getVowels());

		System.out.println("Consonants: " + stringOps.getConsonants());

	}

}

