package edu.monmouth.stackPalindrome;

import java.io.*;
import java.util.Properties;
import java.util.Stack;

public class Hw5 {
	static String properFileName = null, logFileName = null;
	static Properties property; //made this static so its loaded in the initialized, then used in main
	
	public static void initialize(String[] args) {
		
		if (args.length > HW5Constants.MINARGS && args.length <= HW5Constants.MAXARGS) {
			//Checks the value of the log file
			if (args[0].contains(HW5Constants.FILETYPE)) {
				properFileName = args[0];
			}
			else {
				System.err.println("Give a '.txt' file into the cmd arguemnt");
				System.exit(HW5Constants.BADNUMBEROFARGUMENTS);
			}
		}
		else {
			System.err.println(HW5Constants.MAXARGSMESSAGE);
			System.exit(HW5Constants.BADNUMBEROFARGUMENTS);
		}
		
		property = new Properties();
		try {
			property.load(new FileInputStream(properFileName));
			logFileName = property.getProperty("log_file_name");
		} catch (FileNotFoundException e) {
			System.err.println("Cannot find the file " + e.getMessage());
			e.printStackTrace();
			System.exit(HW5Constants.BAD_EXIT_FNFE);
		} catch (IOException e) {
			System.err.println("IOE failed with file" + e.getMessage());
			e.printStackTrace();
			System.exit(HW5Constants.BAD_EXIT_FNFE);
		}
		
		// get the name of the file
		try {
			PrintStream st = new PrintStream(logFileName);
			System.setOut(st);
			System.setErr(st);
		} catch(FileNotFoundException ioe) {
			System.err.println("Cannot redirect stderr and stdout " +
					ioe.getMessage());
			ioe.printStackTrace();
			System.exit(HW5Constants.BAD_EXIT_FNFE);
		}
	} 
	
	//Used a method to prevent duplicate code (works for both strings and integers)
	public static boolean isPalindrome(String inputWord) {
		Stack<Character> stack = new Stack<>();
		for (int i = 0; i < inputWord.length(); i++) {
			stack.push(inputWord.charAt(i));
		}
		StringBuilder reversedWord = new StringBuilder();
		while(!stack.isEmpty()) {
			reversedWord.append(stack.pop());
		}
		return inputWord.equals(reversedWord.toString());
	}

	public static void main(String[] args) {
		initialize(args);
		
		System.out.println("Properties Load: ");
		property.list(System.out);
		
		System.out.println();
		
		//Palindrome words
		String wordProp = property.getProperty("words");
		if (wordProp == null) {
			System.err.println("'words' property is missing!");
		} else {
			System.out.println("String Palindrome Check: ");
			
			String[] words = wordProp.split(HW5Constants.SPLIT);
			
			for (String word : words) {
				System.out.println("Is palindrome? " + word + ": " + isPalindrome(word));
			}
		}
		
		System.out.println();
		
		//Palindrome Numbers
		String integerRange = property.getProperty("number_range");
		if(integerRange == null) {
			System.err.println("'number_range' property is missing");
		} else {
			System.out.println("Integer Palindrome Check: ");
			String[] range = integerRange.split(HW5Constants.SPLIT); 
			if (range.length != HW5Constants.MAXRANGE) {
				System.err.println("invalid 'number_range' format");
			} else {
				try { 
					int start = Integer.parseInt(range[0].trim()), end = Integer.parseInt(range[1].trim()); // trim.() removes a space that causes an error with the end range.
					System.out.println("Integers that are palindromes: ");
					for(int i = start; i <= end; i++) {
						if(isPalindrome(Integer.toString(i))) {
							System.out.print(i + " ");
						}
					}
					System.out.println();
				} catch (NumberFormatException invalidNum) {
					System.err.println("Invalid range values" + invalidNum.getMessage());
				}
			}
		}
		
		System.exit(HW5Constants.GOODEXIT);
	}
	
}
