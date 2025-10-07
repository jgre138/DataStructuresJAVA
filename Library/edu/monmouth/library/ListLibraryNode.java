package edu.monmouth.library;

public class ListLibraryNode {
	/* add a reference to a LibraryNode named head */
	public ListLibraryNode() {
	}
	public LibraryNode removeFirst() {
	}
	public LibraryNode first() {
	}
  	public LibraryNode last() {
	}
	public void insert(LibraryItem element) {
		LibraryNode newNode = new LibraryNode(element);
		newNode.setNext(head);
		head = newNode;
	}
	public void insertEnd(LibraryItem element) {
	}
	public boolean isEmpty() { 
	}
	public int size() {
	}
	public void clear() {
		head = null;
	}
	@Override
  	public String toString() {
		StringBuilder result = new StringBuilder();
		// iterate thru list-append to result
		return result.toString();
	}
}
