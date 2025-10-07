package edu.monmouth.library;

public class ListLibraryNode {
	/* add a reference to a LibraryNode named head */
	private LibraryNode head;
	
	public ListLibraryNode() {
		this.head = null;
	}
	
	public LibraryNode removeFirst() {
		if (head == null) {
			return null;
		}
		LibraryNode removedNode = head;
		head = head.getNext();
		return removedNode;
	}
	
	public LibraryNode first() {
		return head;
	}
	
  	public LibraryNode last() {
  		for(LibraryNode current = head; current != null; current = current.getNext()) {
			if(current.getNext() == null) {
				return current;
			}
		}
  		return null;
	}
  	
	public void insert(LibraryItem element) {
		LibraryNode newNode = new LibraryNode(element);
		newNode.setNext(head);
		head = newNode;
	}
	
	public void insertEnd(LibraryItem element) {
		LibraryNode newNode = new LibraryNode(element);
		if (head == null) {
			head = newNode;
		}
		else {
			for(LibraryNode current = head; current != null; current = current.getNext()) {
				if (current.getNext() == null) {
					current.setNext(newNode);
;					newNode.setNext(null);
				}
			}
		}
	}
	
	public boolean isEmpty() { 
		if (head == null) {
			return true;
		}
		else {
			return false;
		}
	}
	
	public int size() {
		int count=0;
		for(LibraryNode current = head; current != null; current = current.getNext()) {
			count ++;
		}
		return count;
	}
	
	public void clear() {
		head = null;
	}
	
	@Override
  	public String toString() {
		StringBuilder result = new StringBuilder();
		for(LibraryNode current = head; current != null; current = current.getNext()) {
			result.append(current.toString() + "\n");
		}
		return result.toString();
	}
}
