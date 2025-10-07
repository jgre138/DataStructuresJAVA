package edu.monmouth.finallab;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintStream;
import java.util.Arrays;
import java.util.PriorityQueue;


public class FinalLab {
	static String logFileName = null;
	
	public static void initialize(String[] args) {
		
		if (args.length > FinalLabConstants.MINARGS && args.length <= FinalLabConstants.MAXARGS) {
			//Checks the value of the log file
			if (args[0].contains(FinalLabConstants.FILETYPE)) {
				logFileName = args[0];
			}
			else {
				System.err.println("Give a '.txt' file into the cmd arguemnt");
				System.exit(FinalLabConstants.BADNUMBEROFARGUMENTS);
			}
		}
		else {
			System.err.println(FinalLabConstants.MAXARGSMESSAGE);
			System.exit(FinalLabConstants.BADNUMBEROFARGUMENTS);
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
			System.exit(FinalLabConstants.BAD_EXIT_FNFE);
		}
	} 
	
	public static void main(String[] args) {
		final int SIZE = 10;
		final String FILENAME1 = "developer.txt", FILENAME2 = "sales.txt";
		
		// 1-2
		initialize(args);
		
		// 3
		EmployeeRating[] ratings = new EmployeeRating[SIZE];	
		
		// 4 (a-c)
		int i = 0;
		try {
			BufferedReader reader = new BufferedReader(new FileReader(FILENAME1));
			String lineRead = null;
			
			while ((lineRead = reader.readLine()) != null) { 
				System.out.println(lineRead);
				
				String[] result = lineRead.split(FinalLabConstants.SPLIT);
				for (String parts: result) {
					System.out.println(parts);
				}
				if (result.length == FinalLabConstants.MAXLENGTH) {
					
					try {
						EmployeeRating employee = new EmployeeRating(result[0], Integer.parseInt(result[1]));
						ratings[i] = employee;
						i = i+ 1;
					} catch (ArrayIndexOutOfBoundsException outOfBounds) {
						System.err.println("Missing data for entry");
						continue;
					} catch (NumberFormatException wrongNumber) {
						System.err.println("Incorrect format of data for rating");
					}
					
				}
				else {
					System.err.println("Too much data");
				}
				
			}
			System.out.println("End of file \n");
			reader.close();
			
		} catch (FileNotFoundException e) {
			System.err.println("Cannot open " + FILENAME1 + " " + e.getMessage());
			e.printStackTrace();
			System.exit(FinalLabConstants.BAD_EXIT_FNFE);
		} catch (IOException e) {
			System.err.println("Read failed " + e.getMessage());
			e.printStackTrace();
			System.exit(FinalLabConstants.BAD_EXIT_IOE);
		} 
		
		// 4 (d-e)
		ratings = Arrays.copyOf(ratings, i); // Removes any null in the array
		Arrays.sort(ratings);
		System.out.println(Arrays.toString(ratings));
		
		// 4 (f-h)
		PriorityQueue<EmployeeRating> developers = new PriorityQueue<EmployeeRating>();
		for(EmployeeRating rating: ratings) {
			developers.add(rating);
		}
		
		System.out.println("Lease Bugs: " + developers.poll() + "\n");
		
		// 5 (b-e)
		PriorityQueue<EmployeeRating> sales = new PriorityQueue<EmployeeRating>(new SalesComparator());
		
		try {
			BufferedReader reader = new BufferedReader(new FileReader(FILENAME2));
			String lineRead = null;
			
			while ((lineRead = reader.readLine()) != null) { 
				System.out.println(lineRead);
				
				String[] result = lineRead.split(FinalLabConstants.SPLIT);
				for (String parts: result) {
					System.out.println(parts);
				}
				if (result.length == FinalLabConstants.MAXLENGTH) {
					
					try {
						EmployeeRating employee = new EmployeeRating(result[0], Integer.parseInt(result[1]));
						sales.add(employee);
					} catch (ArrayIndexOutOfBoundsException outOfBounds) {
						System.err.println("Missing data for entry");
						continue;
					} catch (NumberFormatException wrongNumber) {
						System.err.println("Incorrect format of data for rating");
					}
					
				}
				else {
					System.err.println("Too much data");
				}
				
			}
			System.out.println("End of file \n");
			reader.close();
			
		} catch (FileNotFoundException e) {
			System.err.println("Cannot open " + FILENAME2 + " " + e.getMessage());
			e.printStackTrace();
			System.exit(FinalLabConstants.BAD_EXIT_FNFE);
		} catch (IOException e) {
			System.err.println("Read failed " + e.getMessage());
			e.printStackTrace();
			System.exit(FinalLabConstants.BAD_EXIT_IOE);
		} 
		
		// 5 (f-g)
		System.out.println("Highest Sales: " + sales.poll() + "\n");
		
		System.out.println("Rest of employees: ");
		while(!sales.isEmpty()) {
			System.out.println(sales.poll());
		}
		
	}
}
