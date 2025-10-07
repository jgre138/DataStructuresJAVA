package edu.monmouth.coffeemaker;

public class BasicCoffeeMaker implements CoffeeMaker, Comparable<BasicCoffeeMaker> {
	
	private String name;

	public BasicCoffeeMaker(String name) {
		super();
		setName(name);
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public int compareTo(BasicCoffeeMaker otherBasicMaker) {
		final int BEFORE = -1, AFTER = 1, EQUAL = 0;
		System.out.println("Compare Basic");
		//System.out.println(name.compareTo(otherBasicMaker.name));
		if(name.equals(otherBasicMaker.name)) {
			return EQUAL;
		} else if(otherBasicMaker.name.compareTo(name) <= BEFORE) { 
			return BEFORE;
		} else {
		return AFTER;
		}
	}

	@Override
	public void brew() {
		System.out.println("Basic Coffee Maker Brews....");
	}

	@Override
	public String toString() {
		return "BasicCoffeeMaker [name=" + name + "]";
	}
	
	@Override
	public boolean equals(Object otherObject) {
		//System.out.println("equals in progress....");
		if (otherObject == null) {
		return false;
		}
		if (!(otherObject instanceof BasicCoffeeMaker)) {
		return false;
		}
		if (this == otherObject) {
		return true;
		}
		BasicCoffeeMaker otherBasicMaker = (BasicCoffeeMaker)otherObject;
		return this.name.equals(otherBasicMaker.name);
	}
	
	
}
