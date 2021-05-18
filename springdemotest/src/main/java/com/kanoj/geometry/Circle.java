package com.kanoj.geometry;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Circle implements Shape {
	
	@Autowired
	Point center;
	
	int radius;
	
	public void createDeafultShape() {
		center = new Point();
		center.setX(0);
		center.setY(0);
		radius = 5;
		
	}

	public void draw() {
		System.out.println(center);
		System.out.println("Radius is " + radius);
	}
	
	

}
