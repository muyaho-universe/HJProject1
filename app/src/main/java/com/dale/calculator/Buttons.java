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
	}
	
	public Buttons(String elements, int x, int y) {
		super(elements);
		this.setBounds(x, y, Buttons.buttonWidht, Buttons.buttonheight);
		this.setBackground(Color.BLACK);
		ActionListener listener =new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				CalculatorGUI.textFieldForInput.append(String.valueOf(Integer.valueOf(elements)));
//				CalculatorGUI.textFieldForTemporary.append(CalculatorGUI.textFieldForInput.getText() + " ");
			}
		};
		this.addActionListener(listener);
	}
	

}
