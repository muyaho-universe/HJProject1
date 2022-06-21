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
			
		}
		
		else if(elements.equals("%")) {
			
		}
		else if(elements.equals("AC")) {
			ActionListener listener =new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
					CalculatorGUI.calculateText = "";
					CalculatorGUI.textFieldForInput.setText("");
					CalculatorGUI.textFieldForTemporary.setText(CalculatorGUI.calculateText);
				}
			};
			this.addActionListener(listener);
		}
		else if (elements.equals("=")) {
			ActionListener listener =new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
					if((CalculatorGUI.calculateText.isEmpty())|| (!CalculatorGUI.textFieldForInput.getText().equals(""))) {
						CalculatorGUI.calculateText +=  CalculatorGUI.textFieldForInput.getText()+elements;
						CalculatorGUI.textFieldForInput.setText("");
						CalculatorGUI.textFieldForTemporary.setText(CalculatorGUI.calculateText);
					}
				}
			};
			this.addActionListener(listener);
		}
		else if(!elements.equals("0")) {
			ActionListener listener =new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
					if((CalculatorGUI.calculateText.isEmpty())|| (!CalculatorGUI.textFieldForInput.getText().equals(""))) {
						CalculatorGUI.calculateText +=  CalculatorGUI.textFieldForInput.getText()+elements;
						CalculatorGUI.textFieldForInput.setText("");
						CalculatorGUI.textFieldForTemporary.setText(CalculatorGUI.calculateText);
					}
				}
			};
			this.addActionListener(listener);
		}
		else {
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
		this.setBackground(Color.BLACK);
		ActionListener listener =new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				CalculatorGUI.textFieldForInput.append(String.valueOf(Integer.valueOf(elements)));
			}
		};
		this.addActionListener(listener);
	}
	

}
