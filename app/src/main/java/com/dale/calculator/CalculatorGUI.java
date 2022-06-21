package com.dale.calculator;

import java.awt.*;

import javax.swing.JFrame;

public class CalculatorGUI extends JFrame{
	private static final long serialVersionUID = 1L;
	private int mainWidth = 400;
	private int mainHeight = 680;
	final private String TITLE = "Caculator";
	
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
				
		numberButtonsPanel.setLayout(null);
		resultPrintPanel.setLayout(null);
		additionalButtonsPanel.setLayout(null);
		arithmeticOperationsButtonsPanel.setLayout(null);
		
		btn[0] = new Buttons(0+"");
		btn[0].setBounds(0, 300, Buttons.buttonWidht*2, Buttons.buttonheight);
		numberButtonsPanel.add(btn[0]);
		for(int i = 9; i >= 1; i--) {
			btn[i] = new Buttons(i+"");
			
			numberButtonsPanel.add(btn[i]);
			btn[i].setBounds(x, y, Buttons.buttonWidht, Buttons.buttonheight);
			
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
		
		btn[11] = new Buttons("+");
		btn[11].setBounds(0,0, Buttons.buttonWidht, Buttons.buttonheight);
		arithmeticOperationsButtonsPanel.add(btn[11]);
//		btn[12] = new Buttons("-");
//		btn[13] = new Buttons("*");
//		btn[14] = new Buttons("/");
//		btn[15] = new Buttons("=");
		
		
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
		
		//프레임 크기 지정	
		jFrame.setSize(mainWidth, mainHeight);

		//프레임 보이기
		jFrame.setVisible(true);

		//swing에만 있는 X버튼 클릭시 종료
		jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		jFrame.setResizable(false);
	}

	
	public static void main(String[] args) {
		CalculatorGUI frameExam = new CalculatorGUI();
		frameExam.createFrame();
	}
}
