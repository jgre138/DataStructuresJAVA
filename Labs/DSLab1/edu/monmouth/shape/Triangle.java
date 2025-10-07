package edu.monmouth.shape;

public class Triangle implements Shape {
	private int base, height;
	
	public Triangle(int base, int height) {
		this.base = base;
		this.height = height;
	}
	
	public double area() {
		return (.5) * (this.base * this.height);
	}
	
		@Override
	public String toString() {
		return "Triangle [base=" + base + ", height=" + height + "]";
	}
	
	@Override
	public boolean equals(Object otherShape) {
		if (otherShape == null) {
			return false;
		}
		if (!(otherShape instanceof Triangle)) {
		return false;
		}
		if (this == otherShape) {
			return true;
		}
		Triangle otherTriangle = (Triangle)otherShape;
		return otherTriangle.base==this.base &&
			otherTriangle.height == this.height;
	}

}
