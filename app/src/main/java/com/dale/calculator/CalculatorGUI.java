package com.dale.calculator;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.Border;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;

public class CalculatorGUI extends JFrame{
	private static final long serialVersionUID = 1L;
	private int mainWidth = 400;
	private int mainHeight = 680;
	final private String TITLE = "Caculator";
	static JTextArea textFieldForInput = new JTextArea();
	static String calculateText = new String ();
	static String analyzerText = new String ();
	static JTextField textFieldForTemporary =new JTextField();
	
	JFrame jFrame = new JFrame(TITLE);
	Buttons [] btn = new Buttons [20];
	
	public void createFrame() {
		int x = 200, y =0;
		jFrame.setLayout(null);
		Container mainContainer = jFrame.getContentPane();
		Panel numberButtonsPanel =  new Panel();
		Panel resultPrintPanel =  new Panel();
		Panel additionalButtonsPanel = new Panel();
		Panel arithmeticOperationsButtonsPanel =  new Panel();
		TitledBorder border = new TitledBorder(new LineBorder(Color.black));

		numberButtonsPanel.setLayout(null);
		resultPrintPanel.setLayout(null);
		additionalButtonsPanel.setLayout(null);
		arithmeticOperationsButtonsPanel.setLayout(null);
		
		
		
		textFieldForInput.setBounds(0, 50, mainWidth, 100);
		Font font = new Font("", Font.BOLD, 30);
		textFieldForInput.setFont(font);
		textFieldForInput.setBorder(border);
		textFieldForInput.setEnabled(false);

		textFieldForTemporary.setBounds(0,0, mainWidth, 50);
		textFieldForTemporary.setEnabled(false);
		
		
		btn[0] = new Buttons(0+"");
		btn[0].setBounds(0, 300, Buttons.buttonWidht*2, Buttons.buttonheight);
		numberButtonsPanel.add(btn[0]);
		for(int i = 9; i >= 1; i--) {
			btn[i] = new Buttons(i+"", x, y);
			numberButtonsPanel.add(btn[i]);
			
			if((i-1) %3 ==0) {
				x = 200;
				y += 100;
			}
			else {
				x -= 100;
			}
		}
		
		
		btn[10] = new Buttons(".");
		btn[10].setBounds(200, 300, Buttons.buttonWidht, Buttons.buttonheight);
		numberButtonsPanel.add(btn[10]);
		//Number Buttons 

		btn[11] = new Buttons("+");
		btn[11].setBounds(0,0, Buttons.buttonWidht, Buttons.buttonheight);
		arithmeticOperationsButtonsPanel.add(btn[11]);
		btn[12] = new Buttons("-");
		btn[12].setBounds(0,100, Buttons.buttonWidht, Buttons.buttonheight);
		arithmeticOperationsButtonsPanel.add(btn[12]);
		btn[13] = new Buttons("*");
		btn[13].setBounds(0,200, Buttons.buttonWidht, Buttons.buttonheight);
		arithmeticOperationsButtonsPanel.add(btn[13]);
		btn[14] = new Buttons("/");
		btn[14].setBounds(0,300, Buttons.buttonWidht, Buttons.buttonheight);
		arithmeticOperationsButtonsPanel.add(btn[14]);
		btn[15] = new Buttons("=");
		btn[15].setBounds(0,400, Buttons.buttonWidht, Buttons.buttonheight);
		arithmeticOperationsButtonsPanel.add(btn[15]);
		//Arithmetic Operations Buttons
		
		btn[16] = new Buttons("AC");
		btn[16].setBounds(0,0, Buttons.buttonWidht, Buttons.buttonheight);
		additionalButtonsPanel.add(btn[16]);
		btn[17] = new Buttons("+/-");
		btn[17].setBounds(100,0, Buttons.buttonWidht, Buttons.buttonheight);
		additionalButtonsPanel.add(btn[17]);
		btn[18] = new Buttons("%");
		btn[18].setBounds(200,0, Buttons.buttonWidht, Buttons.buttonheight);
		additionalButtonsPanel.add(btn[18]);
		//Additional buttons 
		
		
		
		numberButtonsPanel.setBounds( 0, 250, mainWidth/4*3, 400);
		numberButtonsPanel.setBackground(Color.green);
		
		resultPrintPanel.setBounds( 0, 0, mainWidth, 150);
		resultPrintPanel.setBackground(Color.red);
		
		additionalButtonsPanel.setBounds( 0, 150, mainWidth/4*3, 100);
		additionalButtonsPanel.setBackground(Color.pink);
		
		arithmeticOperationsButtonsPanel.setBounds( 300, 150, mainWidth/4, mainHeight -150);
		arithmeticOperationsButtonsPanel.setBackground(Color.blue);
		
		mainContainer.setLayout(null);
		mainContainer.add(numberButtonsPanel);
		mainContainer.add(resultPrintPanel);
		mainContainer.add(additionalButtonsPanel);
		mainContainer.add(arithmeticOperationsButtonsPanel);
		resultPrintPanel.add(textFieldForInput);
		resultPrintPanel.add(textFieldForTemporary);
		
		
		jFrame.setSize(mainWidth, mainHeight);

		jFrame.setVisible(true);

		jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		jFrame.setResizable(false);
	}

	
	public static void main(String[] args) {
		CalculatorGUI frameExam = new CalculatorGUI();
		frameExam.createFrame();
	}
}
