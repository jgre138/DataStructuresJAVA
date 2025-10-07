package edu.monmouth.shape;
public class ShapeList {
	private ShapeNode head;
	public ShapeList() {
		this.head = null;
	}
	public void insert(Shape shape) {
		ShapeNode newShape = new ShapeNode(shape);
		newShape.setNext(head);
		head = newShape;
	}
	@Override
	public String toString() {
		StringBuilder result = new StringBuilder();
		System.out.println("Shape List: ");
		
		for (ShapeNode current= head; current != null; current = current.getNext()) {
			result.append(current.toString() + ", ");
		}
		return result.toString();
	}

}
