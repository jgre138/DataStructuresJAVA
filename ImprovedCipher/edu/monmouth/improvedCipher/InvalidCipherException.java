package edu.monmouth.improvedCipher;

public class InvalidCipherException extends Exception {
	public InvalidCipherException() {
		super();
	}
	public InvalidCipherException(String message) {
		super(message);
	}
}
