package com.dale.calculator;

import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JFrame;

public class Buttons extends JButton{
	private int buttonWidht = 100;
	private int buttonheight = 100;

	public Buttons(String elements, int x, int y) {
		super(elements);
		this.setSize(buttonWidht,buttonheight);
	}
}
