package edu.monmouth.CaesarCipher;

public class Cipher {

    private final String message;

    private final short offset;

    public Cipher(String message, short offset) {
        this.message = message;
        this.offset = offset;
    }


    public String encode(){
        StringBuilder cipheredMessage = new StringBuilder();

        for (char c: message.toCharArray()){
            if (c >= 'a' && c <= 'z' ){
                char shiftChar = (char) ((c - 'a' + offset) % 26 + 'a');
                cipheredMessage.append(shiftChar);
            }
            else if (c == ' '){ // to preserve spaces
                cipheredMessage.append(c);
            }
        }
        return cipheredMessage.toString();
    }

    public String decode(String message){
        StringBuilder decodedMessage = new StringBuilder();

        for (char c: message.toCharArray()){
            if (c >= 'a' && c <= 'z') {
                char reversedChar = (char) ((c - 'a' - offset) % 26 + 'a');
                if (reversedChar < 'a'){
                    reversedChar += 26;
                }
                decodedMessage.append(reversedChar);
            }
            else if (c == ' '){ // To preserve spaces
                decodedMessage.append(c);
            }
        }
        return decodedMessage.toString();
    }
}