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
		return x * y;
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
			System.out.println(t);
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
					while(true) {
						String previousNum = stack.pop();
						String previousOperator = stack.pop();
						if(getPrecedence(previousOperator) == 1 || getPrecedence(previousOperator) == 0) {
							stack.push(previousOperator);
							stack.push(previousNum);
							
							break;
						}
						else {
							String pppNum = stack.pop();
							double calculatedNumber;
							if(previousOperator.equals("*")) {
								calculatedNumber = times(Double.parseDouble(previousNum), Double.parseDouble(pppNum));
							}
							else {
								calculatedNumber = divide(Double.parseDouble(previousNum), Double.parseDouble(pppNum));
							}
							previousNum = calculatedNumber+"";
							stack.push(previousNum);
						}
					}
					stack.push(temp);
				}
				if(getPrecedence(temp) == 2) {
					stack.push(temp);
				}
			}
		}
		
		String previousNum = stack.pop();
		answer += previousNum;
		Double value = Double.parseDouble(previousNum);
		
		while(!stack.peek().equals("$")){
			String currentNum = null, currnetOpearator = null ;
			currnetOpearator = stack.pop();
			currentNum = stack.pop();
			
			
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
		answer = value+"";
		stack.clear();
		return answer;
	}
}
