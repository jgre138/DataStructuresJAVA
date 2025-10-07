package edu.monmouth.lab2;

public class Airport {
	private String name, code;
	private int runways;
	public Airport(String name, String code, int runways) {
		super();
		setName(name);
		setCode(code);
		setRunways(runways);
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public int getRunways() {
		return runways;
	}
	public void setRunways(int runways) {
		this.runways = runways;
	}
	
	@Override
	public int hashCode() {
		return (name.hashCode() + code.hashCode()) / runways;
	}
	
	@Override
	public boolean equals(Object otherObject) {
		if (otherObject == null) {
			return false;
		}
		if (!(otherObject instanceof Airport)) {
			return false;
		}
		
		if (this == otherObject) {
			return true;
		}
		Airport otherAirport = (Airport)otherObject;
		return otherAirport.getName().equals(name) &&
				otherAirport.getCode().equals(code) && otherAirport.getRunways() == runways ;
	}
	@Override
	public String toString() {
		return "Airport [name=" + name + ", code=" + code + ", runways=" + runways + "]";
	}
	
	
}
