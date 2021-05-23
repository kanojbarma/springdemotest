package com.kanoj;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;

import com.kanoj.configuration.AppConfig;
import com.kanoj.geometry.Shape;

public class App {

	public static void main(String[] args) {
		ApplicationContext context = 
				new AnnotationConfigApplicationContext(AppConfig.class);
		
		/* This commented code works but your code get dependent on 
		 * the implementation classes of Shape interface which should be 
		 * avoided. This will require importing the implementation classes
		 * Shape shape = (Shape) context.getBean(Circle.class); 
		 * Shape shape = (Shape) context.getBean(Triangle.class);
		 */
		
		/* Instead use the following code. 
		 * No dependency on the implementation.
		 * No import required for the implementation classes.
		 * You can change the implementation at any point of time.
		 * The bean factory context uses the default name for the beans
		 * which is camel case name of the class
		 */
//		Shape shape = (Shape) context.getBean("triangle"); // Works
		//Shape shape = (Shape) context.getBean("circle"); // Works
		// This also works bust does not require casting
//		Shape shape = context.getBean("circle", Shape.class); 
		Shape shapeCircle = context.getBean("circle", Shape.class);
		shapeCircle.createDeafultShape();
		shapeCircle.draw();
		shapeCircle.computeArea();
		shapeCircle.computePerimeter();
		
		/*
		 * Shape shapeTriangleDefConstructor = context.getBean("newShape", Shape.class);
		 * shapeTriangleDefConstructor.createDeafultShape();
		 * shapeTriangleDefConstructor.draw();
		 */
		
		Shape shapeTriangleOverLoadedConstructor = 
				context.getBean("triangle",Shape.class);
		shapeTriangleOverLoadedConstructor.computeArea();
		shapeTriangleOverLoadedConstructor.computePerimeter();
		((AbstractApplicationContext) context).close();
		
	}
}
