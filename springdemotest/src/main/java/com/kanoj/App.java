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
		 * avoided. This will require importing the impementation classes
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
		Shape shape = context.getBean("circleShape", Shape.class); 
		shape.createDeafultShape();
		shape.draw();
		
		shape = context.getBean("newShape", Shape.class);
		shape.createDeafultShape();
		shape.draw();
		
		((AbstractApplicationContext) context).close();
		
		
	}
}
