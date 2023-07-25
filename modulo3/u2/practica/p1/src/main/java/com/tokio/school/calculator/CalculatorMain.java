package com.tokio.school.calculator;

import javax.swing.SwingUtilities;

import com.tokio.school.calculator.frames.CalculatorFrame;

public class CalculatorMain {

	public static void main(String[] args) {
		SwingUtilities.invokeLater(()->new CalculatorFrame());

	}

}
