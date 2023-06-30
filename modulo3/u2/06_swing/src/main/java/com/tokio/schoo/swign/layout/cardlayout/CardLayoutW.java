package com.tokio.schoo.swign.layout.cardlayout;

import java.awt.CardLayout;
import java.awt.FlowLayout;
import java.lang.reflect.InvocationTargetException;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

public class CardLayoutW extends JFrame {

	JComboBox<String> combox;
	JButton boton1, boton2, boton3;
	JPanel panel1;
	FlowLayout myFlowLayout;
	CardLayout myCardLayout;

	public CardLayoutW() {

		/// Instancia un objeto CardLayout con una separacion de 3px en horizonal y
		/// vertical
		myFlowLayout = new FlowLayout(0, 6, 6);
		myCardLayout = new CardLayout(3, 3);

		// Uso este BorderLayout para que sea el controlador de posicionamiento de mi
		// objeto JFrame
		setLayout(myFlowLayout);

		// Creo 5 botones y los añado a mi objeto JFrame
		boton1 = new JButton("Sur");
		boton2 = new JButton("Oeste");
		boton3 = new JButton("Norte");

		combox = new JComboBox<String>(new String[] {"Red","Blue","Rojo"});
		add(combox);
		
		panel1 = new JPanel();
		panel1.setLayout(myCardLayout);
		panel1.add(boton1);// este compoente se superponete
		panel1.add(boton2);
		add(panel1);
		
		
		add(boton3);
		
		// Configurar y mostrar JFrame
		initPantalla();
	}

	private void initPantalla() {

		setTitle("Ejemplo 15"); // Título del JFrame
		setSize(250, 150); // Dimensiones del JFrame
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // Cerrar proceso al cerrar ventana
		setVisible(true); // Mostrar JFrame
	}


	public static void main(String[] args) throws InvocationTargetException, InterruptedException {
		SwingUtilities.invokeAndWait(() -> new CardLayoutW());
	}
}
