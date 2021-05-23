package com.kanoj.geometry.service;

import org.springframework.context.annotation.Scope;

@Scope("prototype")
public interface CalculatorService {
	
	public double calcualteArea();
	public double calcualtePerimeter();
}
