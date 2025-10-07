package edu.monmouth.improvedCipher;

public class SubstitutionCipher {

    private String message, cipher;
    private final int ROWS = SubstitutionCipherConstants.CHARACTERS_IN_ALPHABET, COLUMNS = 2;
    private char[][] cipherArray;
    private final int ASCII_NUM_OF_A = 97;
    private final String alphabet = "abcdefghijklmnopqrstuvwxyz";

    public SubstitutionCipher(String message, String cipher) throws InvalidCipherException {   
         //Verify
    	if (cipher.length() != ROWS) {
            throw new InvalidCipherException("Please enter exactly 26 characters for the cipher.");
        }
        
        if (!cipher.matches("[a-z]+")) {
            throw new InvalidCipherException("Cipher must contain only lowercase letters.");
        }
        
        for (char c : message.toCharArray()) {
            if (!Character.isLowerCase(c) && c != ' ') {
                throw new InvalidCipherException("Message must contain only lowercase letters and spaces.");
            }
        }
        
        this.message = message;
        this.cipher = cipher;
        cipherArray = new char[ROWS][COLUMNS];
		    		 		
		for (int i = 0; i < ROWS; i++) {
			char[] letters = alphabet.toCharArray();
			char[] encoder = this.cipher.toCharArray();

			cipherArray[i][SubstitutionCipherConstants.ALPHABET_COLUMN] = letters[i];
			cipherArray[i][SubstitutionCipherConstants.CIPHER_COLUMN] = encoder[i];
		} 
    }

    public String encode(){
        StringBuilder encodedMessage = new StringBuilder();
        char[] message = this.message.toCharArray();

        for (int i = 0; i < message.length; i++) {
            if (message[i] == ' '){
                encodedMessage.append(message[i]);
            }
            else {
                int find = message[i] % ASCII_NUM_OF_A;

                encodedMessage.append(cipherArray[find][1]);
            }
        }
        return encodedMessage.toString();
    }

}
