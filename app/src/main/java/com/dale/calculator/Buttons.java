package com.dale.calculator;

import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JFrame;

public class Buttons extends JButton{
	private int buttonWidht = 50;
	private int buttonheight = 50;

	public Buttons(String elements, int x, int y) {
		super(elements);
		this.setBounds(,30,buttonWidht,buttonheight);
	}
}
