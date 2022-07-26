package week3.day_0726_oop3;

import com.shape.Shape;

public class Circle extends Shape {
	
	double radius;
	
	public Circle() {}
	
	public Circle(double radius) {
		this.radius = radius;
	}

	@Override
	public void calcArea() {
		area = Math.PI * radius * radius;
	}
	
}
