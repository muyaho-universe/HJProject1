package com.dale.calculator;

import java.awt.Color;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JTextField;

import java.awt.event.*;

public class Buttons extends JButton{
	static int buttonWidht = 100;
	static int buttonheight = 100;
	

	public Buttons(String elements) {
		super(elements);
		
		
		if(elements.equals("+/-")) {
			this.setBackground(new Color(224, 224, 224));
		}
		
		else if(elements.equals("%")) {
			this.setBackground(new Color(224, 224, 224));
		}
		else if(elements.equals("AC")) {
			this.setBackground(new Color(224, 224, 224));
			ActionListener listener =new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
					CalculatorGUI.calculateText = null;
					CalculatorGUI.calculateText = "";
					CalculatorGUI.textFieldForInput.setText(CalculatorGUI.calculateText);
					CalculatorGUI.textFieldForTemporary.setText(CalculatorGUI.calculateText);
				}
			};
			this.addActionListener(listener);
		}
		else if (elements.equals("=")) {
			this.setBackground(new Color(233, 151, 72));
			ActionListener listener =new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
					if((CalculatorGUI.calculateText.isEmpty())|| (!CalculatorGUI.textFieldForInput.getText().equals(""))) {
						CalculatorGUI.calculateText +=  CalculatorGUI.textFieldForInput.getText();
						CalculatorGUI.analyzerText +=  CalculatorGUI.textFieldForInput.getText();
						Calculation calculation = new Calculation(CalculatorGUI.analyzerText);
						String temp = calculation.calculation();
						
						CalculatorGUI.calculateText += "=";
						CalculatorGUI.textFieldForInput.setText(temp);
						CalculatorGUI.textFieldForTemporary.setText(CalculatorGUI.calculateText);
						
						CalculatorGUI.calculateText =  "";
						CalculatorGUI.analyzerText =  "";
					}
				}
			};
			this.addActionListener(listener);
		}
		else if (elements.equals(".")) {
			this.setBackground(new Color(224, 224, 224));
			String temp = CalculatorGUI.textFieldForInput.getText();
			if((CalculatorGUI.textFieldForTemporary.getText().length() != 0)) {
				if((CalculatorGUI.textFieldForInput.getText().length() == 0)) {
					String temp1 = "0" + elements;
					CalculatorGUI.textFieldForInput.setText(temp1);
				}
				
				else if (!temp.contains(".")){
					temp += ".";
					CalculatorGUI.textFieldForInput.setText(temp);
				}
			}
			
			
		}
		else if(!elements.equals("0")) {
			this.setBackground(new Color(233, 151, 72));
			ActionListener listener =new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
					if((CalculatorGUI.calculateText.isEmpty())|| (!CalculatorGUI.textFieldForInput.getText().equals(""))) {
						CalculatorGUI.calculateText +=  CalculatorGUI.textFieldForInput.getText()+elements;
						CalculatorGUI.analyzerText +=  CalculatorGUI.textFieldForInput.getText()+","+elements+",";
						CalculatorGUI.textFieldForInput.setText("");
						CalculatorGUI.textFieldForTemporary.setText(CalculatorGUI.calculateText);
					}
				}
			};
			this.addActionListener(listener);
		}
		else {
			this.setBackground(new Color(224, 224, 224));
			ActionListener listener =new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
					if((!CalculatorGUI.textFieldForInput.getText().equals(""))){
						CalculatorGUI.textFieldForInput.append(String.valueOf(elements));
					}
				}
			};
			this.addActionListener(listener);
		}
		
	}
	
	public Buttons(String elements, int x, int y) {
		super(elements);
		this.setBounds(x, y, Buttons.buttonWidht, Buttons.buttonheight);
		this.setBackground(new Color(224, 224, 224));
		ActionListener listener =new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				CalculatorGUI.textFieldForInput.append(elements);
			}
		};
		this.addActionListener(listener);
	}
	

}
