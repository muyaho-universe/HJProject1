package com.dale.calculator;

import java.util.Stack;

public class Calculation {
	private String[] temporary;
	private String answer = null;
	private Stack<String> stack = new Stack<>();
	private int size;
	
	private double add(double x, double y) {
		return x + y;
	}
	private double subtract(double x, double y) {
		return x - y;
	}
	private double divide(double x, double y) {
		return x * y;
	}
	private double times(double x, double y) {
		return x * y;
	}
	
	public Calculation(String calculate) {
		size = calculate.length();
		temporary = new String[size];
		temporary = calculate.split("*|-|+|/" );
	}
	
	public String calculation() {
		
		
		return answer;
	}
}
