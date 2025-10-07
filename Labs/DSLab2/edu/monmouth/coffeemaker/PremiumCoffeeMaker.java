package edu.monmouth.coffeemaker;

public class PremiumCoffeeMaker implements CoffeeMaker, Comparable<PremiumCoffeeMaker> {
	
	private boolean hasGrinder;
	private int capacity;
	
	public PremiumCoffeeMaker(boolean hasGrinder, int capacity) {
		super();
		setHasGrinder(hasGrinder);
		setCapacity(capacity);
	}
	
	public boolean isHasGrinder() {
		return hasGrinder;
	}
	
	public void setHasGrinder(boolean hasGrinder) {
		this.hasGrinder = hasGrinder;
	}
	
	public int getCapacity() {
		return capacity;
	}
	
	public void setCapacity(int capacity) {
		this.capacity = capacity;
	}
	
	@Override
	public int compareTo(PremiumCoffeeMaker otherPremuimMaker) {
		final int BEFORE = -1, AFTER = 1, EQUAL = 0;
		System.out.println("Compare Premium");
		if(capacity == otherPremuimMaker.capacity) {
			return EQUAL;
		}
		if (capacity > otherPremuimMaker.capacity) {
			return BEFORE;
		}
		return AFTER;
	}
	
	@Override
	public void brew() {
		System.out.println("Premium Coffee Maker Brews....");
	}
	
	@Override
	public String toString() {
		return "PremiumCoffeeMaker [hasGrinder=" + hasGrinder + ", capacity=" + capacity + "]";
	}
	
	@Override
	public boolean equals(Object otherObject) {
		//System.out.println("equals in progress....");
		if (otherObject == null) {
		return false;
		}
		if (!(otherObject instanceof PremiumCoffeeMaker)) {
		return false;
		}
		if (this == otherObject) {
		return true;
		}
		PremiumCoffeeMaker otherPremiumMaker = (PremiumCoffeeMaker)otherObject;
		return this.hasGrinder ==  otherPremiumMaker.hasGrinder && this.capacity == otherPremiumMaker.capacity;
	}
	
	
	
	
}
