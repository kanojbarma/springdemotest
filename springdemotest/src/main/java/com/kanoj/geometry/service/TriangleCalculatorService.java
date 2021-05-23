package com.kanoj.geometry.service;

import org.springframework.stereotype.Component;

@Component
public class TriangleCalculatorService implements CalculatorService {

	public double calcualteArea() {
		System.out.println("Calculating area of a triangle");
		return 0;
	}

	public double calcualtePerimeter() {
		System.out.println("Calculating perimeter of a triangle");
		return 0;
	}

}
