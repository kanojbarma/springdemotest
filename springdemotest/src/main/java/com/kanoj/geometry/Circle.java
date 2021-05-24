package com.kanoj.geometry;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import com.kanoj.geometry.service.CalculatorService;

@Component
public class Circle implements Shape {
	
	Point center;
	int radius;
	
	@Value("${shape1}")
	String shapeType;
	
	@Autowired
	@Qualifier("circleCalculatorService")
	private CalculatorService calculatorService;
	
	public Circle() {
		System.out.println("In default Circle constructor");
	}
	
	
	/* Spring container annotation will automatically call this 
	 * constructor and find a CalculatorService implementation and inject.
	 * The application need not call the new key word to use constructor
	 * explicitly. Spring will do that */
	/*
	 * @Autowired public Circle (CalculatorService calculatorService) {
	 * this.calculatorService=calculatorService; }
	 */
	
	public void createDeafultShape() {
		center = new Point();
		center.setX(0);
		center.setY(0);
		radius = 5;
		
	}
	
	public String getShapeType() {
		return shapeType + "(returned from properties file)";
	}

	public void draw() {
		System.out.println(center);
		System.out.println("Radius is " + radius);
		System.out.println("Shape Type is " + getShapeType());
	}

	public CalculatorService calculatorService() {
		return calculatorService;
	}

	public double computeArea () {
		System.out.println("Circle calculator: " + calculatorService.getClass().getName());
		return calculatorService.calcualteArea();
	}

	public double computePerimeter() {
		System.out.println("Circle calculator: " + calculatorService.getClass().getName());
		return calculatorService.calcualtePerimeter();
	}


	@PostConstruct
	public void startUpShape() {
		System.out.println("In Circle startUpShape PostContruct Life Cycle method");
	}

	@PreDestroy
	public void cleanUpShape() {
		System.out.println("In Circle cleanUpShape PreDestroy Life Cycle method");
	}

}
