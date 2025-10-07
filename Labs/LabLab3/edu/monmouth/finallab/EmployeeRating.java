package edu.monmouth.finallab;

public class EmployeeRating implements Comparable<EmployeeRating> {

	private String name;
	private int ratingItem;
	public EmployeeRating(String name, int ratingItem) {
		setName(name);
		setRatingItem(ratingItem);
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getRatingItem() {
		return ratingItem;
	}
	public void setRatingItem(int ratingItem) {
		this.ratingItem = ratingItem;
	}
	@Override
	public String toString() {
		return "EmployeeRating [name=" + name + ", ratingItem=" + ratingItem + "]";
	}
	
	@Override
	public boolean equals(Object otherObject) {
		if (otherObject == null) {
			return false;
		}
		if (!(otherObject instanceof EmployeeRating)) {
			return false;
		}
		
		if (this == otherObject) {
			return true;
		}
		EmployeeRating otherRating = (EmployeeRating)otherObject;
		return otherRating.getRatingItem() == ratingItem;
	}
	
	@Override
	public int compareTo(EmployeeRating otherRating) {
		//System.out.println("Rating compareTo: ");
		final int BEFORE = -1, AFTER = 1, EQUAL = 0;
		if(ratingItem == otherRating.ratingItem) {
			return EQUAL;
		} else if (ratingItem > otherRating.ratingItem) {
			return AFTER;
		}
		return BEFORE;
	}
}
