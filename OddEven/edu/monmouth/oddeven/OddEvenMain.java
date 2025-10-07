package edu.monmouth.oddeven;

public class OddEvenMain {

	public static void main(String[] args) {
		int data[] = {20,21,22,33,1,3,5,19,20,21,19,18,17,4,3,2,1};
		
		// construct an OddEven object passing in the array of ints
		OddEven oddEven = new OddEven(data);

		// given the requirements for class OddEven, will the following compile?
		// response: not unless you make a constructor that doesn't take any data in like the one above
		OddEven notSure = new OddEven();

		int numberOfEvens = oddEven.numberOfEvens();
		System.out.println("Number of even numbers: " + numberOfEvens);
		
		int numberOfOdds = oddEven.numberOfOdds();
		System.out.println("Number of odd numbers: " + numberOfOdds);

		int reverseData[] = oddEven.reverse();
		// how best to print reverseData?

		int numberOfOccurrences = oddEven.countOccurrences(19);
		System.out.println("Number of times 19 occurs: " + numberOfOccurrences);

		int newData[] = {100, 99, 98, 50, 60, 70 };
		int mergedData[] = oddEven.mergeArrays(newData);
		// how best to print mergedData?

		int numberOfDuplicates = oddEven.duplicates();
		System.out.println("Number of duplicates: " + numberOfDuplicates);

	}
}
