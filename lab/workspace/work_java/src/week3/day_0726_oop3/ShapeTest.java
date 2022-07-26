package week3.day_0726_oop3;

import com.shape.ShapeCalculator;

public class ShapeTest {

	public static void main(String[] args) {

		Circle c = new Circle(2.0);
		ShapeCalculator util = new ShapeCalculator();
		util.calcArea(c);
	}

}
