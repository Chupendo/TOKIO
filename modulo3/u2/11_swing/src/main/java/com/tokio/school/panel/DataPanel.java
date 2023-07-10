package com.tokio.school.panel;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.TrayIcon.MessageType;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JFileChooser;
import javax.swing.JMenuBar;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.filechooser.FileNameExtensionFilter;

import com.tokio.school.app.menubar.MenuBar;
import com.tokio.school.app.menubar.menuedit.MenuEdit;
import com.tokio.school.app.menubar.menufile.MenuFile;
import com.tokio.school.app.menubar.menufile.menuitem.OpenMenuItem;

public class DataPanel extends JPanel {

	protected JMenuBar menu;
	protected JTextArea txta;

	public DataPanel() {
		super();
		configPanel();
		initComponent();
	}

	protected void configPanel() {
		setLayout(new BorderLayout(3, 3));
	}

	protected void initComponent() {
		menu = new MenuBar();
		((OpenMenuItem) ((MenuFile) ((MenuBar) menu).getFile()).getmItOpen()).clearAllListener();
		((MenuFile) ((MenuBar) menu).getFile()).getmItOpen().addActionListener((ae) -> eventOpenFile());
		((MenuFile) ((MenuBar) menu).getFile()).getmISave().addActionListener((ae) -> eventSaveFile());

		((MenuEdit) ((MenuBar) menu).getEdit()).itmEdit.addActionListener((ae)->evetEditarTextArea());

		add(menu, BorderLayout.NORTH);

		txta = new JTextArea();
		txta.setEditable(Boolean.FALSE);
		((MenuEdit)((MenuBar) menu).getEdit()).itmEdit.setText("Activar");
		add(txta, BorderLayout.CENTER);
	}

	public JMenuBar getMenu() {
		return menu;
	}

	public void setMenu(JMenuBar menu) {
		this.menu = menu;
	}

	protected void eventOpenFile() {
		txta.setEditable(Boolean.FALSE);
		((MenuEdit)((MenuBar) menu).getEdit()).itmEdit.setText("Activar");
		
		
		JFileChooser fileChooser = new JFileChooser();
		fileChooser.setCurrentDirectory(new java.io.File("./src/main/resources/files"));
		fileChooser.setFileSelectionMode(JFileChooser.FILES_ONLY);
		fileChooser.setDialogTitle("LOAD DATA....");
		// FileNameExtensionFilter filter = new FileNameExtensionFilter("JPG & GIF",
		// "jpg", "gif");
		FileNameExtensionFilter filter = new FileNameExtensionFilter("CSV File", "csv");
		fileChooser.setFileFilter(filter);

		int retVal = fileChooser.showOpenDialog(this);

		if (retVal == JFileChooser.CANCEL_OPTION || retVal == -1) {
			JOptionPane.showMessageDialog(null, "No se ha leido ningun archivo");
		}

		File f;
		FileReader fr = null;
		List<String> lines = new ArrayList<>();
		BufferedReader br = null;
		if (retVal == JFileChooser.APPROVE_OPTION) {
			try {
				f = fileChooser.getSelectedFile();
				fr = new FileReader(f);
				br = new BufferedReader(fr);
				if (!(f == null) && !(f.getName().isBlank())) {
					lines = br.lines().toList();
					lines.forEach(line -> {
						if (txta.getText().isBlank()) {
							txta.setText(line);
						} else {
							txta.setText(txta.getText() + "\n" + line);
						}
					});
				}

				FileInputStream fis = new FileInputStream(f);
				InputStreamReader isr = new InputStreamReader(fis);

			} catch (Exception ex) {
				ex.printStackTrace();
				JOptionPane.showMessageDialog(null, "Error " + ex.getMessage(), "error", JOptionPane.ERROR, null);
			} finally {
				try {
					if (br != null)
						br.close();
					if (fr != null)
						fr.close();
				} catch (Exception ex) {
					System.err.println("Error al cargar datos");
					JOptionPane.showMessageDialog(null, "Error al cerrar los conectores", "error", JOptionPane.ERROR,
							null);
				}
			}

		}
	}

	protected void eventSaveFile() {
		txta.setEditable(Boolean.FALSE);
		((MenuEdit)((MenuBar) menu).getEdit()).itmEdit.setText("Activar");
		
		JFileChooser fileChooser = new JFileChooser();

		fileChooser.setDialogTitle("Specify a file to save");
		fileChooser.setCurrentDirectory(new java.io.File("./src/main/resources/files"));
		fileChooser.setFileSelectionMode(JFileChooser.FILES_ONLY);
		fileChooser.setDialogTitle("SAVE DATA....");

		FileNameExtensionFilter filter = new FileNameExtensionFilter("CSV File", "csv");
		fileChooser.setFileFilter(filter);

		int userSelection = fileChooser.showSaveDialog(this);

		if (userSelection == JFileChooser.APPROVE_OPTION) {
			File fileToSave = fileChooser.getSelectedFile();
			// System.out.println("Save as file: " + fileToSave.getAbsolutePath());
			System.out.println(txta.getText());
			FileWriter fw;
			BufferedWriter bw;
			try {
				fw = new FileWriter(fileToSave);
				bw = new BufferedWriter(fw);
				bw.write(txta.getText());

				if (bw != null)
					bw.close();
				if (fw != null)
					fw.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}
	}

	protected void evetEditarTextArea() {
		if(txta.isEditable()) {
			txta.setEditable(Boolean.FALSE);
			((MenuEdit)((MenuBar) menu).getEdit()).itmEdit.setText("Activar");
		}else {
			txta.setEditable(Boolean.TRUE);
			((MenuEdit)((MenuBar) menu).getEdit()).itmEdit.setText("Desactivar");
		}
	}

}
