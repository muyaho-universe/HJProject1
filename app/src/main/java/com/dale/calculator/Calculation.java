package com.dale.calculator;

import java.util.Stack;

public class Calculation {
	public String[] temporary;
	private String formular = null;
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
		double z = 0.0;
		try {
			z = x /y;
		} catch (ArithmeticException e) {
			e.printStackTrace();
		}
		return z;
	}
	private double times(double x, double y) {
		return x * y;
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
//				System.out.println("num!" + temp);
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
//						System.out.println("previousNum: "+previousNum + " previousOperator: " + previousOperator + " getPrecedence(previousOperator): " + getPrecedence(previousOperator));
						double value = Double.parseDouble(previousNum);
						if(getPrecedence(previousOperator) == 1 ) {
							while(!operatorStack.empty()) {
								
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
							
							stack.push(previousOperator);
							stack.push(previousNum);
							break;
						}
						else {
							
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
			System.out.println("size" + stack.size() + " temp " + temp);
		}
		
		String previousNum = stack.pop();
		answer += previousNum;
		Double value = Double.parseDouble(previousNum);
		
		while(!stack.peek().equals("$")){
			String currentNum = null, currnetOpearator = null ;
			currnetOpearator = stack.pop();
			currentNum = stack.pop();
			System.out.println(currentNum);
			
			switch(currnetOpearator) {
				case "+": value = add(Double.parseDouble(currentNum), value);
					break;
				case "-": value = subtract(Double.parseDouble(currentNum), value);
					break;
				case "*": value = times(Double.parseDouble(currentNum), value);
					break;
				case "/": value = divide(Double.parseDouble(currentNum), value);
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
		
		
		stack.clear();
		return answer;
	}
}
