package edu.monmouth.lab2;

import java.io.FileNotFoundException;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

import edu.monmouth.coffeemaker.*;

public class Lab2 {
	public static final int NUMBER_ARGS = 3, GOOD_EXIT = 0;
	public static final int BAD_EXIT_IOE = 4, BADNUMBEROFARGUMENTS = 1, BAD_EXIT_FNFE = 2;
	public static final int MINARGS = 0, MAXARGS = 1;
	public static String logFileName;
	public static final String MAXARGSMESSAGE = "Please provide one and only one argument into the cmd argument";
	
	public static void initialize(String[] args) {
		
		if (args.length > MINARGS && args.length <= MAXARGS) {
			if (args[0].contains(".txt")) {
				logFileName = args[0];
			}
			else {
				System.err.println("Give a '.txt' file into the cmd arguemnt");
				System.exit(BADNUMBEROFARGUMENTS);
			}
			
		}
		else {
			System.err.println(MAXARGSMESSAGE);
			System.exit(BADNUMBEROFARGUMENTS);
		}
		
		try {
			PrintStream st = new PrintStream(logFileName);
			System.setOut(st);
			System.setErr(st);
		} catch(FileNotFoundException ioe) {
			System.err.println("Cannot redirect stderr and stdout " +
					ioe.getMessage());
			ioe.printStackTrace();
			System.exit(BAD_EXIT_FNFE);
		}
	}
	
	public static void main(String[] args) {
		initialize(args);
		
		//Testing equals() and compareTo()
		BasicCoffeeMaker bEqual = new BasicCoffeeMaker("Bob");
		BasicCoffeeMaker bNotEqual = new BasicCoffeeMaker("Not Bob");
		
		PremiumCoffeeMaker pEqual = new PremiumCoffeeMaker(true, 5);
		PremiumCoffeeMaker pNotEqual = new PremiumCoffeeMaker(false, 1);
		
		System.out.println("test Basic equals: ");
		System.out.println("True: " + bEqual.equals(new BasicCoffeeMaker("Bob"))  + " Compare: " + bEqual.compareTo(new BasicCoffeeMaker("Bob")));
		System.out.println("False: " + bEqual.equals(bNotEqual) + " Compare: " + bEqual.compareTo(bNotEqual));
		
		System.out.println("test Premium equals/compareTo: ");
		System.out.println("True: " + pEqual.equals(new PremiumCoffeeMaker(true, 5))  + " Compare: " + pEqual.compareTo(new PremiumCoffeeMaker(true, 5)));
		System.out.println("False: " + pEqual.equals(pNotEqual) + " Compare: " + pEqual.compareTo(pNotEqual));
		
		System.out.println();
		
		//Main stuff
		
		BasicCoffeeMaker bcm1 = new BasicCoffeeMaker("Cuisinart");
		BasicCoffeeMaker bcm2 = new BasicCoffeeMaker("Nespresso");
		BasicCoffeeMaker bcm3 = new BasicCoffeeMaker("CoffeeQueen");
		BasicCoffeeMaker bcm4 = new BasicCoffeeMaker("CoffeeKing");
		PremiumCoffeeMaker pcm1 = new PremiumCoffeeMaker(true, 64);
		PremiumCoffeeMaker pcm2 = new PremiumCoffeeMaker(false, 32);
		PremiumCoffeeMaker pcm3 = new PremiumCoffeeMaker(true, 8);
		PremiumCoffeeMaker pcm4 = new PremiumCoffeeMaker(false, 16);
		
		List<BasicCoffeeMaker> cafe1 = new ArrayList<>();
		
		cafe1.add(bcm1);
		cafe1.add(bcm2);
		cafe1.add(bcm3);
		cafe1.add(bcm4);
		
		for (CoffeeMaker maker : cafe1) {
			maker.brew();
		}
	
		System.out.println();
		for (CoffeeMaker maker : cafe1) {
			System.out.println(maker);
		}
		
		System.out.println();
		Iterator<BasicCoffeeMaker> iteratorB = cafe1.iterator();
		while(iteratorB.hasNext()) {
			System.out.println(iteratorB.next());
		}
		
		System.out.println();
		for (int i = 0; i < cafe1.size(); i++) {
			System.out.println(cafe1.get(i));
		}
		
		System.out.println();
		
		BasicCoffeeMaker notInList = new BasicCoffeeMaker("NotInList");
		BasicCoffeeMaker inList = new BasicCoffeeMaker("Cuisinart");
		
		System.out.println("Contains: " + cafe1.contains(notInList));
		System.out.println("Contains: " + cafe1.contains(inList));
		System.out.println();
		
		Collections.sort(cafe1); //Sorted to descending
		for (CoffeeMaker maker : cafe1) {
			System.out.println(maker);
		}
		
		Collections.binarySearch(cafe1, notInList);
		System.out.println("Binary Search: " + Collections.binarySearch(cafe1, notInList));
		System.out.println("Binary Search: " + Collections.binarySearch(cafe1, inList));
		
		System.out.println();
		
		List<PremiumCoffeeMaker> cafe2 = new LinkedList<>();
		
		cafe2.add(pcm1);
		cafe2.add(pcm2);
		cafe2.add(pcm3);
		cafe2.add(pcm4);
		
		for (CoffeeMaker maker : cafe2) {
			maker.brew();
		}
		
		System.out.println();
		for (CoffeeMaker maker : cafe2) {
			System.out.println(maker);
		}
		
		System.out.println();
		Iterator<PremiumCoffeeMaker> iteratorP = cafe2.iterator();
		while(iteratorP.hasNext()) {
			System.out.println(iteratorP.next());
		}
		
		System.out.println();
		for (int i = 0; i < cafe2.size(); i++) {
			System.out.println(cafe2.get(i));
		}
		
		System.out.println();
		
		Collections.sort(cafe2); //Sorted to descending
		for (CoffeeMaker maker : cafe2) {
			System.out.println(maker);
		}
	}

}
