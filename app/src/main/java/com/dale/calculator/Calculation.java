package com.dale.calculator;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Stack;

public class Calculation {
	public String[] temporary;
	private String formular = null;
	private String answer = null;
	private Stack<String> stack = new Stack<>();
	private int size;
	
	private double add(double x, double y) {
		BigDecimal bigDecimalX = BigDecimal.valueOf(x);
		BigDecimal bigDecimalY = BigDecimal.valueOf(y);
		BigDecimal bigDecimal = bigDecimalX.add(bigDecimalY);
		System.out.println("add: x "+ bigDecimalX + " y "+ bigDecimalY + " z " + bigDecimal);
		double double_bigNum = bigDecimal.doubleValue();
		
		return double_bigNum;
	}
	private double subtract(double x, double y) {
		BigDecimal bigDecimalX = BigDecimal.valueOf(x);
		BigDecimal bigDecimalY = BigDecimal.valueOf(y);
		
		BigDecimal bigDecimal = bigDecimalX.subtract(bigDecimalY);
		System.out.println("subtract: x "+ bigDecimalX + " y "+ bigDecimalY + " z " + bigDecimal);
		double double_bigNum = bigDecimal.doubleValue();
		return double_bigNum;
	}
	private double divide(double x, double y) throws ArithmeticException{
		BigDecimal bigDecimalX = BigDecimal.valueOf(x);
		BigDecimal bigDecimalY = BigDecimal.valueOf(y);
		
		BigDecimal bigDecimal = bigDecimalX.divide(bigDecimalY, RoundingMode.HALF_UP);
		System.out.println("divide: x "+ bigDecimalX + " y "+ bigDecimalY + " z " + bigDecimal);
		double double_bigNum = bigDecimal.doubleValue();
		
		return double_bigNum;
	}
	private double times(double x, double y) {
		BigDecimal bigDecimalX = BigDecimal.valueOf(x);
		BigDecimal bigDecimalY = BigDecimal.valueOf(y);
		
		BigDecimal bigDecimal = bigDecimalX.multiply(bigDecimalY);
		System.out.println("times: x "+ bigDecimalX + " y "+ bigDecimalY + " z " + bigDecimal);
		double double_bigNum = bigDecimal.doubleValue();
		return double_bigNum;
	}
	
	private boolean isNum(String t) {
		if((t.equals("+")) || (t.equals("-"))|| (t.equals("*"))|| (t.equals("/"))){
			return false;
		}
		return true;
	}
	
	private int getPrecedence(String op) {
		if(op.equals("$")){
	        return 0;
	    }
	    else if ((op.equals("+")) || (op.equals("-"))) {
	        return 1;
	    }
	    else if((op.equals("*")) || (op.equals("/")) ) {
	        return 2;
	    }
	    else
	        return -1;   
	}
	
	public Calculation(String calculate) {
		formular = calculate;
		size = calculate.length();
		temporary = new String[size];
		temporary = calculate.split("," );
		for(String t: temporary) {
//			System.out.println("t: "+t);
		}
		
	}
		
	public String calculation() {
		
		stack.push("$");
		for(String temp : temporary) {
			
			if(isNum(temp)) {
				System.out.println("num!" + temp);
				stack.push(temp);
			}
			
			else {
				if(getPrecedence(temp) == 1) {
					Stack<String> operatorStack = new Stack<>();
					Stack<String> operandStack = new Stack<>();
					String previousNum = null;
					String previousOperator = null;
					while(true) {
						previousNum = stack.pop();
						previousOperator = stack.pop();
						System.out.println("previousNum: "+previousNum + " previousOperator: " + previousOperator + " getPrecedence(previousOperator): " + getPrecedence(previousOperator));
						double value = Double.parseDouble(previousNum);
						if(getPrecedence(previousOperator) == 1 ) {
							while(!operatorStack.empty()) {
								
//								stack.push(previousOperator);
								String pppNum = operandStack.pop();
								String pppOperator = operatorStack.pop();
								switch(pppOperator) {
									case "*": value = times(value, Double.parseDouble(pppNum));
										break;
									default: value = divide(value, Double.parseDouble(pppNum));
										break;
								}
								
							}
							previousNum = value+"";
							System.out.println("previousOperator in getPrecedence(temp) == 1 : " + previousOperator);
							stack.push(previousOperator);
							stack.push(previousNum);
							break;
						}
						else if(getPrecedence(previousOperator) == 0 ) {
							while(!operatorStack.empty()) {
								System.out.println(previousOperator);
								stack.push(previousOperator);
								String pppNum = operandStack.pop();
								String pppOperator = operatorStack.pop();
								switch(pppOperator) {
									case "*": value = times(value, Double.parseDouble(pppNum));
										break;
									default: value = divide(value, Double.parseDouble(pppNum));
										break;
								}
								
							}
							previousNum = value+"";
							System.out.println("previousOperator in getPrecedence(temp) == 0 : " + previousOperator);
							stack.push(previousOperator);
							stack.push(previousNum);
							break;
						}
						else  if(getPrecedence(previousOperator) == 2 ){
							System.out.println("previousOperator in getPrecedence(temp) == 2 : " + previousOperator);
							operatorStack.push(previousOperator);
							operandStack.push(previousNum);
						}
					
					}
					stack.push(temp);
				}
				if(getPrecedence(temp) == 2) {
					stack.push(temp);
				}
			}
			System.out.println("size : " + stack.size() + " temp : " + temp);
		}
		Stack<String> otherStack = new Stack<>();
		otherStack.push("$");
		
		while(!stack.peek().equals("$")){
			String temp =stack.peek();
			
			System.out.println(temp);
			if(isNum(temp)) {
				System.out.println("num in peeking!" + temp);
				stack.pop();
				otherStack.push(temp);
			}
			
			else {
				if(getPrecedence(temp) == 1) {
					Stack<String> operatorStack = new Stack<>();
					Stack<String> operandStack = new Stack<>();
					String previousNum = null;
					String previousOperator = null;
					while(true) {
						previousNum = otherStack.pop();
						previousOperator = otherStack.pop();
						System.out.println("previousNum: "+previousNum + " previousOperator: " + previousOperator + " getPrecedence(previousOperator): " + getPrecedence(previousOperator));
						double value = Double.parseDouble(previousNum);
						if(getPrecedence(previousOperator) == 1 ) {
							while(!operatorStack.empty()) {
								
//								stack.push(previousOperator);
								String pppNum = operandStack.pop();
								String pppOperator = operatorStack.pop();
								switch(pppOperator) {
									case "*": value = times(Double.parseDouble(pppNum), value);
										break;
									default: value = divide(Double.parseDouble(pppNum), value);
										break;
								}
								
							}
							previousNum = value+"";
							System.out.println("previousOperator in getPrecedence(temp) == 1 : " + previousOperator);
							otherStack.push(previousOperator);
							otherStack.push(previousNum);
							break;
						}
						else if(getPrecedence(previousOperator) == 0 ) {
							while(!operatorStack.empty()) {
								System.out.println(previousOperator);
								otherStack.push(previousOperator);
								String pppNum = operandStack.pop();
								String pppOperator = operatorStack.pop();
								switch(pppOperator) {
									case "*": value = times(Double.parseDouble(pppNum), value );
										break;
									default: value = divide(Double.parseDouble(pppNum), value );
										break;
								}
								
							}
							previousNum = value+"";
							System.out.println("previousOperator in getPrecedence(temp) == 0 : " + previousOperator);
							otherStack.push(previousOperator);
							otherStack.push(previousNum);
							break;
						}
						else  if(getPrecedence(previousOperator) == 2 ){
							System.out.println("previousOperator in getPrecedence(temp) == 2 : " + previousOperator);
							operatorStack.push(previousOperator);
							operandStack.push(previousNum);
						}
					
					}
					
					
					otherStack.push(temp);
				}
				if(getPrecedence(temp) == 2) {
					
					otherStack.push(temp);
				}
				stack.pop();
			}
			
		}
		String previousNum = otherStack.pop();
		System.out.println("www" + previousNum);
		answer += previousNum;
		Double value = Double.parseDouble(previousNum);
		
		while(!otherStack.peek().equals("$")){
			String currentNum = null, currnetOpearator = null ;
			
			currnetOpearator = otherStack.pop();
			currentNum = otherStack.pop();
			System.out.println("currentNum " +currentNum + " currnetOpearator " + currnetOpearator);
			int i = getPrecedence(currnetOpearator);
			
			switch(currnetOpearator) {
				case "+": value = add(value, Double.parseDouble(currentNum));
					break;
				case "-": value = subtract(value, Double.parseDouble(currentNum));
					break;
				case "*": value = times(value, Double.parseDouble(currentNum));
					break;	
				case "/": value = divide(value, Double.parseDouble(currentNum));
					break;	
				default:
					break;
			}
		}
		answer = value +"";
		String[] t = answer.split("\\.");
		
		if(value - Integer.parseInt(t[0]) == 0.0) {
			int i = Integer.parseInt(t[0]);
			answer = i + "";
		}
		otherStack.clear();
		stack.clear();
		System.out.println("When Done : stack size " + stack.size() + " otherStack size " + otherStack.size());
		return answer;
	}
	
	
}
