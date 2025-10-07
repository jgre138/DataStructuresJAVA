package edu.monmouth.shape;

public class UseShapeList {

	public static void main(String[] args) {
		// create 5 or more instances of your concrete class
		Shape shape1 = new Triangle(3,8);
		Shape shape2 = new Triangle(16, 24);
		Shape shape3 = new Triangle(176, 205);
		Shape shape4 = new Triangle(1, 2);
		Shape shape5 = new Triangle(176,205);
		
		// verify equals
		// perform equals with 2 unequal objects
		System.out.println(shape1.equals(shape5));
		// perform equals with 2 equal objects
		System.out.println(shape3.equals(shape5));
		
		// create a Shape List
		ShapeList list = new ShapeList();
		list.insert(shape1);
		list.insert(shape2);
		list.insert(shape3);
		list.insert(shape4);
		list.insert(shape5);
		
		// add all objects created above to the list
		
		// print the entire list-must contain all attributes & area
		System.out.println(list);
	}

}
