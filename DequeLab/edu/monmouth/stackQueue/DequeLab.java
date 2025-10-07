package edu.monmouth.stackQueue;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Scanner;

public class DequeLab {
	static final int GOODEXIT = 0;

	public static void main(String[] args) {
		Scanner scnr = new Scanner(System.in);
		String userInput;
		
		
		System.out.println("Queue test: ");
		
		//Queue time!!!
		Deque<String> queue = new LinkedList<>();
		
		System.out.println("Comand Options:  enqueue:value, dequeue, list, quit");
		System.out.println("Note: when using enqueue:value, value is data you want to enter into the queue.");
		do {
			System.out.print("Enter a comand: ")  ;
			userInput = scnr.nextLine();
			String[] inputQueue = userInput.split(":");
			
			switch (inputQueue[0]){
				case "enqueue": 
					try {
						queue.addLast(inputQueue[1]);
						System.out.println(inputQueue[1] + " added! \n");
					} catch (ArrayIndexOutOfBoundsException outOfBounds) {
						System.err.println("Please enter a value to enter into the queue");
					}
					break;
					
				case "dequeue":
					System.out.println(queue.removeFirst() + " removed! \n");
					break;
					
				case "list":
					System.out.println(queue + "\n");
					break;
					
				case "quit":
					System.out.println("quitting loop.");
					break;
					
				default: 
					System.out.println("Please enter a valid comand. \n");
					break;
			}
			
		} while (!userInput.equals("quit"));
		
		System.out.println();
		
		System.out.println("Stack test: ");
		
		//Stack time!!
		Deque<String> stack = new LinkedList<>();
		
		System.out.println("Comand Options:  push:value, dequeue, ");
		System.out.println("Note: when using push:value, value is data you want to enter into the queue.");
		do {
			System.out.print("Enter a comand: ")  ;
			userInput = scnr.nextLine();
			String[] inputStack = userInput.split(":");
			
			switch (inputStack[0]){
				case "push": 
					try {
						stack.addFirst(inputStack[1]);
						System.out.println(inputStack[1] + " added! \n");
					} catch (ArrayIndexOutOfBoundsException outOfBounds) {
						System.err.println("Please enter a value to enter into the queue");
					}
					break;
					
				case "pop":
					System.out.println(stack.removeFirst() + " removed! \n");
					break;
					
				case "list":
					System.out.println(stack + "\n");
					break;
					
				case "quit":
					System.out.println("quitting loop.");
					break;
					
				default: 
					System.out.println("Please enter a valid comand. \n");
					break;
			}
			
		} while (!userInput.equals("quit"));
		
		scnr.close();
		System.exit(GOODEXIT);
	}
}
