package edu.monmouth.lab2;

public class City {
	private String name, state, postalCode;

	public City(String name, String state, String postalCode) {
		super();
		setName(name);
		setState(state);
		setPostalCode(postalCode);
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getPostalCode() {
		return postalCode;
	}

	public void setPostalCode(String postalCode) {
		this.postalCode = postalCode;
	}

	@Override
	public int hashCode() {
		return (name.hashCode() + state.hashCode()) / postalCode.hashCode();
	}

	@Override
	public boolean equals(Object otherObject) {
		if (otherObject == null) {
			return false;
		}
		if (!(otherObject instanceof City)) {
			return false;
		}
		
		if (this == otherObject) {
			return true;
		}
		City otherCity = (City)otherObject;
		return otherCity.getName().equals(name) &&
				otherCity.getState().equals(state) && otherCity.getPostalCode().equals(postalCode) ;
	}

	@Override
	public String toString() {
		return "City [name=" + name + ", state=" + state + ", postalCode=" + postalCode + "]";
	}
	
	
}
