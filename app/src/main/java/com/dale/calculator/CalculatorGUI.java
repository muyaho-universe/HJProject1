package com.dale.calculator;

import java.awt.*;

import javax.swing.JFrame;

public class CalculatorGUI extends JFrame{
	private static final long serialVersionUID = 1L;
	private int mainWidth = 400;
	private int mainHeight = 650;
	final private String TITLE = "Caculator";
	
	JFrame jFrame = new JFrame(TITLE);
	Buttons [] btn = new Buttons [16]; //16개 생성
	
	public void createFrame() {
		int x = 0, y =0;
		jFrame.setLayout(null);
		Container mainContainer = jFrame.getContentPane();
		Panel numberButtonsPanel =  new Panel();
		Panel resultPrintPanel =  new Panel();
		Panel additionalButtonsPanel = new Panel();
		Panel arithmeticOperationsButtonsPanel =  new Panel();
		
		
		
		
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
		
		for(int i = 0; i < 10; i++) {
			
			btn[i] = new Buttons(i+"", x, y);
			numberButtonsPanel.add(btn[i]);
			if((i+1) %3 ==0) {
				x = 0;
				y += 100;
			}
			x += 100;
		}
		
//		btn[11] = new Buttons("+");
//		btn[11].setBounds(0,40,width,height);
//		btn[12] = new Buttons("-");
//		btn[13] = new Buttons("*");
//		btn[14] = new Buttons("/");
//		btn[15] = new Buttons("=");
		
		
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
