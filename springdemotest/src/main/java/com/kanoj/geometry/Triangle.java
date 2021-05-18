package com.kanoj.geometry;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

@Component
public class Triangle implements Shape {
	
	List<Point> points = new ArrayList<Point>();

	public void draw() {
		for(Point point:points) {
			System.out.println(point);
		}
	}

	public void createDeafultShape() {
		points.add(new Point(0,0));
		points.add(new Point(3,5));
		points.add(new Point(-3,-5));
	}
}
