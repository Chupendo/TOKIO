package com.tokio.swing.nimbus.app;

import java.lang.reflect.InvocationTargetException;

import javax.swing.SwingUtilities;
import javax.swing.UIManager;
import javax.swing.UIManager.LookAndFeelInfo;
import javax.swing.UnsupportedLookAndFeelException;

import com.tokio.swing.nimbus.windows.CasillaVerificacionW;
import com.tokio.swing.nimbus.windows.TexFieldAndButtonW;
import com.tokio.swing.nimbus.windows.TexFieldW;
import com.tokio.swing.nimbus.windows.Windows;

public class App {

	public static void main(String[] args) {
		try {
			SwingUtilities.invokeAndWait(()->{
				
				for(LookAndFeelInfo info : UIManager.getInstalledLookAndFeels()) {
					try {
						System.out.println(info.getClassName());
						UIManager.setLookAndFeel(info.getClassName());
						//UIManager.setLookAndFeel("javax.swing.plaf.nimbus.NimbusLookAndFeel");
					} catch (ClassNotFoundException | InstantiationException | IllegalAccessException
							| UnsupportedLookAndFeelException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
				
				//new Windows();		// exmaple lab
				//new TexFieldW();		// example textfiel
				//new TexFieldAndButtonW(); // example action listener in textfield (pulsar intro) and bto
				new CasillaVerificacionW(); // example jcheckbox
			});			
		} catch (InvocationTargetException | InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
