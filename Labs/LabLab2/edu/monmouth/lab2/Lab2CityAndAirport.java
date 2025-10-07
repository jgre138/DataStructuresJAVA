package edu.monmouth.lab2;

import java.io.FileNotFoundException;
import java.io.PrintStream;
import java.util.*;

public class Lab2CityAndAirport {
	static final int MINARGS = 0, MAXARGS = 1;
	static final int BADNUMBEROFARGUMENTS = -1, BAD_EXIT_FNFE = -2;
	static final String REQUIREDARGSMESSAGE = "Please provide one and only only arguments into the cmd argument";
	static String logFileName;
	
	public static void initialize(String[] args) {
		
		if (args.length > MINARGS && args.length <= MAXARGS) {
			//Checks the value of the log file
			if (args[0].contains(".txt")) {
				logFileName = args[0];
			}
			else {
				System.err.println("Give a '.txt' file into the cmd arguemnt");
				System.exit(BADNUMBEROFARGUMENTS);
			}
		}
		else {
			System.err.println(REQUIREDARGSMESSAGE);
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

		City atlanticCity = new City("Atlantic City", "New Jersey", "08401");
		City newark = new City("Newark", "New Jersey", "07104");
		City trenton = new City("Trenton", "New Jersey", "08625");
		City morristown = new City("Morristown", "New Jersey", "07960");
		City teterboro = new City("Teteboro", "New Jersey", "07604");
		City boston = new City("Boston", "Massachusetts", "02115");
		City orlando = new City("Orlando", "Florida", "32801");
	
		
		Airport atlanticCityAirport = new Airport("Atlantic City International Airport", "ACY", 2);
		Airport newarkAirport = new Airport("Newark Liberty International Airport", "EWR", 3);
		Airport trentonAirport = new Airport("Trenton Mercer Airport", "TTN", 2);
		Airport morristownAirport = new Airport("Morristown Municipal Airport", "MMU", 2);
		Airport teterboroAirport = new Airport("Teterboro Airport", "TEB", 2);
		Airport bostonAirport = new Airport("Logan International Airport", "BOS", 6);
		Airport orlandoAirport = new Airport("Orlando International Airport", "MCO", 4);
		
		
		// verify City hashCode and equals methods are consistent
		
		City equalCity = new City("Atlantic City", "New Jersey", "08401");
		City notCity = new City("GamblingLand", "New Jersey III", "77777");
		
		System.out.println("Equals(City) true test: " + atlanticCity.equals(equalCity) + ", HashCodes: atlanticCity=" + atlanticCity.hashCode() + ", equalCity=" + equalCity.hashCode());
		System.out.println("Equals(City) false test: " + atlanticCity.equals(notCity) + ", HashCodes: atlanticCity=" + atlanticCity.hashCode() + ", differentBook=" + notCity.hashCode());
		
		// verify Airport hashCode and equals methods are consistent
		Airport equalAirport = new Airport("Atlantic City International Airport", "ACY", 2);
		Airport notAirport = new Airport("actually a boat", "BOAT", 100);
		
		System.out.println("Equals(Airport) true test: " + atlanticCityAirport.equals(equalAirport) + ", HashCodes: atlanticCityAirport=" + atlanticCityAirport.hashCode() + ", equalAirport=" + equalAirport.hashCode());
		System.out.println("Equals(Airport) false test: " + atlanticCityAirport.equals(notAirport) + ", HashCodes: atlanticCityAirport=" + atlanticCityAirport.hashCode() + ", notAirport=" + notAirport.hashCode());
		
		// create a HashSet that can only house City objects
		Set<City> citySet = new HashSet<>();
		
		// attempt to insert all provided City objects to the HashSet
		// print whether or not the object was added or not
		System.out.println("Add: " + citySet.add(atlanticCity));
		System.out.println("Add: " + citySet.add(newark));
		System.out.println("Add: " + citySet.add(trenton));
		System.out.println("Add: " + citySet.add(morristown));
		System.out.println("Add: " + citySet.add(teterboro));
		System.out.println("Add: " + citySet.add(boston));
		System.out.println("Add: " + citySet.add(orlando));
	
		// iterate through the HashSet for each City-print each
		Iterator<City> iterator = citySet.iterator();
		while(iterator.hasNext()) {
			System.out.println(iterator.next());
		}
		
		// create a HashMap associating City and Airport objects
		Map<City, Airport> airMap = new HashMap<>();
		
		// insert City (key) and Airport (value)objects 
		airMap.put(atlanticCity, atlanticCityAirport);
		airMap.put(newark, newarkAirport);
		airMap.put(trenton, trentonAirport);
		airMap.put(morristown, morristownAirport);
		airMap.put(teterboro, teterboroAirport);
		airMap.put(boston, bostonAirport);
		airMap.put(orlando, orlandoAirport);
		
		// print the number of elements in the HashMap
		System.out.println("HashMap number of elements: " + airMap.size());
	
		// print all elements in the HashMap
		for(Map.Entry<City, Airport> set: airMap.entrySet() ) {
        	System.out.println(set.getKey() + " = " + set.getValue());
        }
		
		// print the Airport for Newark City object 
		System.out.println("Newark: " + airMap.get(newark));
		
		// print the Airport for Orlando object - from paper instructions
		System.out.println("Orlando, Florida: " + airMap.get(orlando));
		
		City westLongBranch = new City("West Long Branch", "New Jersey", "07764");
		// determine if the City object westLongBranch exists as a key in the HashSet containing cities
		System.out.println("Does " + westLongBranch + " exsist in the HashSet? " + airMap.containsKey(westLongBranch));
		

    }

}
