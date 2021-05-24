package com.kanoj.geometry;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import com.kanoj.geometry.service.CalculatorService;

@Component
//default scope is singleton which means one instance per IoC container
@Scope("prototype") 
public class Triangle implements Shape {

	List<Point> points = new ArrayList<Point>();
	
	@Value("${shape2}")
	String shapeType;
	
	@Autowired
	@Qualifier("triangleCalculatorService")
	private CalculatorService calculatorService;
	
	public Triangle() {
		System.out.println("In default Triangle constructor");
	}
	
	/* Spring container annotation will automatically call this 
	 * constructor and find a CalculatorService implementation and inject.
	 * The application need not call the new key word to use constructor
	 * explicitly. Spring will do that */
	/*
	 * @Autowired public Triangle(CalculatorService calculatorService) {
	 * System.out.println("In overloaded Triangle constructor");
	 * this.calculatorService= calculatorService; }
	 */

	public String getShapeType() {
		return shapeType + "(returned from properties file)";
	}

	
	public CalculatorService getCalculatorService() {
		return calculatorService;
	}

	public void setCalculatorService(CalculatorService calculatorService) {
		this.calculatorService = calculatorService;
	}

	public void draw() {
		for(Point point:points) {
			System.out.println(point);
		}
		System.out.println("The triangle is of type: " + getShapeType());
	}

	public void createDeafultShape() {
		points.add(new Point(0,0));
		points.add(new Point(3,5));
		points.add(new Point(-3,-5));
	}

	public double computeArea () {
		System.out.println("Triangle calculator: " + calculatorService.getClass().getName());
		return calculatorService.calcualteArea();
	}

	public double computePerimeter() {
		System.out.println("Triangle calculator: " + calculatorService.getClass().getName());
		return calculatorService.calcualtePerimeter();
	}

	@PostConstruct
	public void startUpShape() {
		System.out.println("In Triangle startUpShape PostContruct Life Cycle method");
	}

	@PreDestroy
	public void cleanUpShape() {
		System.out.println("In Triangle cleanUpShape PreDestroy Life Cycle method");
	}
}
