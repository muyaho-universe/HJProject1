package com.dale.calculator;

import java.awt.BorderLayout;
import java.awt.Container;
import javax.swing.JButton;
import javax.swing.JFrame;

public class CalculatorGUI extends JFrame{
	private int width = 100;
	private int height = 100;
	static private String title = null;
	
	JFrame frame = new JFrame("Caculator");
	JButton [] btn = new JButton [6]; //6개 생성
	
	public void createFrame() {
		
		
		//프레임 크기 지정	
		frame.setSize(300, 600);

		//프레임 보이기
		frame.setVisible(true);

		//swing에만 있는 X버튼 클릭시 종료
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	
	public static void main(String[] args) {
		CalculatorGUI frameExam = new CalculatorGUI();
		frameExam.createFrame();
	}
}
