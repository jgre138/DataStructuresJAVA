package edu.monmouth.shape;

public class ShapeNode {
	// add attributes & methods as described in assignment
	private Shape info;
	private ShapeNode next;
	
	public ShapeNode(Shape info) {
		setInfo(info);
	}
	
	public Shape getInfo() {
		return info;
	}
	public void setInfo(Shape info) {
		this.info = info;
	}
	public ShapeNode getNext() {
		return next;
		
	}
	public void setNext(ShapeNode next){
		this.next = next;
	}

	@Override //test this
	public String toString() {
		return "ShapeNode [info=" + info + ", area=" + info.area() + "]";
	}
	
	
	
	
	
}

