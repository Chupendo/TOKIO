package com.tokio.schoo.swign.layout.flowlayout;

import java.awt.FlowLayout;
import java.awt.LayoutManager;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.lang.reflect.InvocationTargetException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.SwingUtilities;

public class FlowLayoutW extends JFrame implements ActionListener {

	JButton boton1, boton2, boton3, boton4, boton5;
	LayoutManager miFlowLayout;

	public FlowLayoutW() {
		// Instancia un objeto FlowLayout object alineado al centro y con una separacion
		// de 3px en horizonal y vertical
		miFlowLayout = new FlowLayout(FlowLayout.CENTER, 3, 3);

		// Uso este FlowLayout para que sea el controlador de posicionamiento de mi
		// objeto JFrame
		setLayout(miFlowLayout);

		// Creo 5 botones y los añado a mi objeto JFrame
		boton1 = new JButton("Botón 1");
		boton2 = new JButton("Botón 2");
		boton3 = new JButton("Botón 3");
		boton4 = new JButton("Botón 4");
		boton5 = new JButton("Botón 5");
		add(boton1);
		add(boton2);
		add(boton3);
		add(boton4);
		add(boton5);

		// Añado los botones al ActionListener
		boton1.addActionListener(this);
		boton2.addActionListener(this);
		boton3.addActionListener(this);
		boton4.addActionListener(this);
		boton5.addActionListener(this);

		// Configurar y mostrar JFrame
		initPantalla();
	}

	private void initPantalla() {

		setTitle("Ejemplo 15"); // Título del JFrame
		setSize(250, 150); // Dimensiones del JFrame
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // Cerrar proceso al cerrar ventana
		setVisible(true); // Mostrar JFrame
	}

	public void actionPerformed(ActionEvent e) {

		// Al hacer clic en un botón, añado 5px de espacio horizontal y vertical entre
		// botones
		((FlowLayout) miFlowLayout).setHgap(((FlowLayout) miFlowLayout).getHgap() + 5);
		((FlowLayout) miFlowLayout).setVgap(((FlowLayout) miFlowLayout).getVgap() + 5);
		// Fijo el nuevo layout al formulario
		setLayout(miFlowLayout);
		// Valido el formulario para asegurarme de que se actualiza en pantalla
		validate();
	}

	public static void main(String[] args) throws InvocationTargetException, InterruptedException {
		SwingUtilities.invokeAndWait(() -> new FlowLayoutW());
	}
}
