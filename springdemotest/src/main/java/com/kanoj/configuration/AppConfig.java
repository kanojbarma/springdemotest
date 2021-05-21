package com.kanoj.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
//import org.springframework.context.annotation.Import;

import com.kanoj.geometry.Triangle;

/* This is the configuration class. This acts the spring XML configuration file.
 * Here we have to provide the base packages that it has to scan. All the beans under
 * the base packages folder will be initiated by spring (Singleton by default).
 * We can also import other configuration class as shown below with the import annotation.
 * Similar to the XML file, all the beans must be defined here or the imported configuration classes
 *  
 *  */
@Configuration
@ComponentScan(basePackages = "com.kanoj")
//@Import(GeometryConfiguration.class)
public class AppConfig {
	
	/*
	 * This is a method level annotation. This should be used 
	 * if you want the return bean based on specific condition.
	 * Or, if the Bean can be created even class 
	 * is outside the spring container such as 3rd party classes.
	 * This annotation works only in classes marked with 
	 * configuration annotation
	 *  
	 */	 
	@Bean("newShape") 
	 public Triangle getTriangle() { return new Triangle(); }
	 
}
