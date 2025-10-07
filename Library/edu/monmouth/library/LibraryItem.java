package edu.monmouth.library;

public abstract interface LibraryItem {

	public String getTitle();
	public boolean isAvailible();
	public void borrowItem();
	public void returnItem();
	
}
