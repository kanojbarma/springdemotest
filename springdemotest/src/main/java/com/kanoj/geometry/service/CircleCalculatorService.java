package com.kanoj.geometry.service;

import org.springframework.stereotype.Component;

@Component
public class CircleCalculatorService implements CalculatorService {

	public double calcualteArea() {
		System.out.println("Calculating area of a circle");
		return 0;
	}

	public double calcualtePerimeter() {
		System.out.println("Calculating perimeter of a circle");
		return 0;
	}

}
