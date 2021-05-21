package com.kanoj.geometry;

import java.util.ArrayList;
import java.util.List;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
//default scope is singleton which means one instance per IoC container
@Scope("prototype") 
public class Triangle implements Shape {
	
	List<Point> points = new ArrayList<Point>();
	
	String type;

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public void draw() {
		for(Point point:points) {
			System.out.println(point);
		}
		System.out.println("The triangle is of type: " + getType());
	}

	public void createDeafultShape() {
		points.add(new Point(0,0));
		points.add(new Point(3,5));
		points.add(new Point(-3,-5));
	}
}
