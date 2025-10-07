package edu.monmouth.lab1;

import java.io.*; //FileNotFoundException and PrintStream
import java.util.Arrays;

public class Lab1Spring2025 {
	final static int BAD_EXIT_FNFE = -2, NUMBER_ARGS = 1, BAD_EXIT_ARGS = -1, GOOD_EXIT = 0;
	
	public static void initialize(String[] args) {
		String logFileName = null; //Lab1Output.txt
		
		if(args.length != NUMBER_ARGS) {
			System.err.println("Give a name of a file for output. Ex. 'text.txt'");
			System.exit(BAD_EXIT_ARGS);
		}
		if (args[0].contains(".txt")) {
			logFileName = args[0];
		}
		else {
			System.err.println("Give a '.txt' file into the cmd arguemnt");
			System.exit(BAD_EXIT_ARGS);
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
		final int EXPECTED_ARGS = 1;  // number of cmd args required
		final int SIZE = 5;		// size of first array
		final int UPPER_AGE = 20;	// limit for age
		final int THREE_SIZE = 3;	// size of array to hold 3 students

		// validate there is 1 and only 1 cmd arg-terminate if not
		// redirect stderr & stdout to args[0]
		initialize(args); //The method does the validation inside of it
				

		Student student1 = new Student(100,18,"John"); 
		Student student2 = new Student(101,18,"Jane");
		Student student3 = new Student(102,20,"Larry");
		Student student4 = new Student(103,20,"Karen");
		Student student5 = new Student(104,21,"Karl");
		
		
		// declare an array of references to Student objects (use SIZE)
		// fill array with Student objects declared above
		Student students[] = new Student[SIZE];
		
		students[0] = student1;
		students[1] = student2;
		students[2] = student3;
		students[3] = student4;
		students[4] = student5;
		
	
		// print number of elements in students array
		System.out.println("Number of elements in students: " + students.length);
		

		// iterate through students array-print each object
		System.out.println("students list: ");
		for (Student student : students) {
			System.out.println("\t" + student.toString());
		}
		

		// iterate through students array-print only those with age < UPPER_AGE
		System.out.println("students list (Under 20 years old): ");
		for (Student student : students) {
			if (student.getAge() < UPPER_AGE) {
			System.out.println("\t" + student.toString());
			}
		}
		
		
		Student studentsToAdd[]= { new Student(200, 22, "Rolf"),
				new Student(201, 23, "Dan")};
		
		// invoke addStudents to add studentsToAdd to the existing array
		Student newStudentArray[]; 
		newStudentArray = addStudents(students, studentsToAdd);

		
		// iterate through newStudentsArray array-print each object
		System.out.println("newStudentArray list: ");
		for (Student student : newStudentArray) {
			System.out.println("\t" + student.toString());
		}
		

		// create threeStudents array-fill with 1st 3 objects from newStudents array
		Student[] threeStudents = Arrays.copyOf(newStudentArray, THREE_SIZE);
		// iterate through threeStudents array-print each object
		System.out.println("threeStudents list: ");
		for (Student student : threeStudents) {
			System.out.println("\t" + student.toString());
		}
		
		
		System.exit(GOOD_EXIT);
	}
	
	
	 public static Student[] addStudents(Student[] students, Student[] studentsToAdd) {		 
		 int newSize = students.length + studentsToAdd.length;
		 
		 Student[] newStudent = Arrays.copyOf(students, newSize);
		 
		 for (int i = students.length; i < newSize; i++) {
			 newStudent[i] = studentsToAdd[i - students.length];
		 }
		 
		 return newStudent;
	}
}
