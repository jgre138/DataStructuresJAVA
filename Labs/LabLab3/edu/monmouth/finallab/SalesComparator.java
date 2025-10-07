package edu.monmouth.finallab;

import java.util.Comparator;

public class SalesComparator implements Comparator<EmployeeRating> {

	@Override
	public int compare(EmployeeRating rating1, EmployeeRating rating2) {
		//System.out.println("Rating comparator: ");
		final int BEFORE = -1, AFTER = 1, EQUAL = 0;
		if(rating1.getRatingItem() == rating2.getRatingItem()) {
			return EQUAL;
		} else if (rating1.getRatingItem() < rating2.getRatingItem()) { 
			return AFTER;
		}
		return BEFORE;
	}


}
