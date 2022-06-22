package com.dale.calculator;

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JTextField;

import java.awt.event.*;
import java.math.BigDecimal;

public class Buttons extends JButton{
	static int buttonWidht = 100;
	static int buttonheight = 100;
	

	public Buttons(String elements) {
		super(elements);
		
		
		if(elements.equals("+/-")) {
			this.setBackground(new Color(224, 224, 224));
			ActionListener listener =new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
					if(CalculatorGUI.textFieldForInput.getText().contains("-")) {
						CalculatorGUI.textFieldForInput.setText(CalculatorGUI.textFieldForInput.getText().substring(1,CalculatorGUI.textFieldForInput.getText().length()));
					}
					else {
						CalculatorGUI.textFieldForInput.setText("-" + CalculatorGUI.textFieldForInput.getText());
					}
				}
			};
			this.addActionListener(listener);
		}
		
		else if(elements.equals("<-")) {
			this.setBackground(new Color(224, 224, 224));
			ActionListener listener =new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
					CalculatorGUI.temporaryTextForInput  = CalculatorGUI.temporaryTextForInput.substring(0, CalculatorGUI.temporaryTextForInput.length()-1);
					CalculatorGUI.textFieldForInput.setText(CalculatorGUI.temporaryTextForInput);
				}
			};
			this.addActionListener(listener);
		}
		else if(elements.equals("AC")) {
			this.setBackground(new Color(224, 224, 224));
			ActionListener listener =new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
					CalculatorGUI.calculateText = null;
					CalculatorGUI.calculateText = "";
					CalculatorGUI.temporaryTextForInput  = "";
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
						CalculatorGUI.temporaryTextForInput ="";
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
			
			ActionListener listener =new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
					String temp = CalculatorGUI.textFieldForInput.getText();
					if((CalculatorGUI.textFieldForInput.getText().length() == 0)) {
						String temp1 = "0" + elements;
						CalculatorGUI.temporaryTextForInput = temp;
						CalculatorGUI.textFieldForInput.setText(temp1);
					}
					
					else if (!temp.contains(".")){
						temp += ".";
						CalculatorGUI.temporaryTextForInput = temp;
						CalculatorGUI.textFieldForInput.setText(temp);
					}	
				}
			};
			this.addActionListener(listener);
			
			
			
			
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
						CalculatorGUI.temporaryTextForInput ="";
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
					if((!CalculatorGUI.textFieldForInput.getText().equals("0"))){
						CalculatorGUI.temporaryTextForInput += elements;
						CalculatorGUI.textFieldForInput.setText(CalculatorGUI.temporaryTextForInput);
					}
				}
			};
			this.addActionListener(listener);
		}
		this.setFont(new Font("Arial", Font.BOLD, 25));
	}
	
	public Buttons(String elements, int x, int y) {
		super(elements);
		this.setBounds(x, y, Buttons.buttonWidht, Buttons.buttonheight);
		this.setBackground(new Color(224, 224, 224));
		ActionListener listener =new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if(CalculatorGUI.textFieldForInput.getText().equals("0")) {
					CalculatorGUI.temporaryTextForInput = elements;
					CalculatorGUI.textFieldForInput.setText(elements);
				}
				else {
					CalculatorGUI.temporaryTextForInput += elements;
					CalculatorGUI.textFieldForInput.setText(CalculatorGUI.temporaryTextForInput);
				}
				
			}
		};
		this.addActionListener(listener);
		this.setFont(new Font("Arial", Font.BOLD, 25));
	}
	

}
