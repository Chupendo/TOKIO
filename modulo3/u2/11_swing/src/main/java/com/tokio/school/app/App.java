package com.tokio.school.app;

import javax.swing.SwingUtilities;

import com.tokio.school.frames.FrameMain;

public class App {

	public static void main(String[] args) {
			SwingUtilities.invokeLater(()->new FrameMain());

	}

}
