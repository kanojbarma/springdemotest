package com.kanoj;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.kanoj.configuration.AppConfig;
import com.kanoj.geometry.Circle;
import com.kanoj.geometry.Shape;

public class App {

	public static void main(String[] args) {
		ApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
		Shape shape = (Shape) context.getBean(Circle.class);
		shape.createDeafultShape();
		shape.draw();
	}
}
