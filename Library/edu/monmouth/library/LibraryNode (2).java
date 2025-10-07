package edu.monmouth.library;

public class LibraryNode {
	/* add a reference to a LibraryItem and a reference to a LibraryNode */
	private LibraryItem info;
	private LibraryNode nextNode;
	
	public LibraryNode(LibraryItem info) {
		setInfo(info);
	}
	public void setInfo(LibraryItem info) {
		this.info = info;
	}
	public LibraryItem getInfo() {
		return info;
	}
	public void setNext(LibraryNode link) {
		this.nextNode = link;
	}
	public LibraryNode getNext() {
		return nextNode;
	}
	@Override 
	public String toString() {
		return "LibraryNode [info =" + getInfo() + "]";
	}
	
}