package com.dale.calculator;

import java.awt.*;

import javax.swing.JFrame;

public class CalculatorGUI extends JFrame{
	private static final long serialVersionUID = 1L;
	private int mainWidth = 400;
	private int mainHeight = 600;
	final private String TITLE = "Caculator";
	
	JFrame jFrame = new JFrame(TITLE);
	Buttons [] btn = new Buttons [16]; //16개 생성
	
	public void createFrame() {
		jFrame.setLayout(null);
		Container mainContainer = jFrame.getContentPane();
		Container numberButtonsContainer =  jFrame.getContentPane();
		int x = 0;
		
		
		mainContainer.setLayout(new FlowLayout());
		mainContainer.add(numberButtonsContainer);
		numberButtonsContainer.setBounds( 0, 300, mainWidth/2, mainHeight/2);
		for(int y = 0; y < 10; y++) {
			
			btn[y] = new Buttons(y+"", x, y);
			numberButtonsContainer.add(btn[y]);
				
		}
		
		btn[11] = new Buttons("+");
		btn[11].setBounds(0,40,width,height);
		btn[12] = new Buttons("-");
		btn[13] = new Buttons("*");
		btn[14] = new Buttons("/");
		btn[15] = new Buttons("=");
		
		
		//프레임 크기 지정	
		jFrame.setSize(300, 600);

		//프레임 보이기
		jFrame.setVisible(true);

		//swing에만 있는 X버튼 클릭시 종료
		jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	
	public static void main(String[] args) {
		CalculatorGUI frameExam = new CalculatorGUI();
		frameExam.createFrame();
	}
}
