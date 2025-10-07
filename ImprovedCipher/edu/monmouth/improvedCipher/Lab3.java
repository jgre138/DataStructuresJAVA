package edu.monmouth.improvedCipher;

public class Lab3 {

	public static void main(String[] args) throws InvalidCipherException {
		String message = "welcome to data structures";
		String cipher = "qazwsxedcrfvbgtyhnmjuiklop";

		SubstitutionCipher subCipher = new SubstitutionCipher(message, cipher);
		String encodedMessage = subCipher.encode();
		
		System.out.println("Encoded message: " + encodedMessage);
	
	
	}

}
