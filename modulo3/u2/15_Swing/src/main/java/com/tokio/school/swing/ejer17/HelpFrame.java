package com.tokio.school.swing.ejer17;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.util.HashMap;
import java.util.Map;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextPane;
import javax.swing.ListSelectionModel;
import javax.swing.SwingUtilities;

public class HelpFrame extends JFrame {

	protected enum ITEM_HELP {
		IF, FOR, WHILE, DO_WHILE
	}

	protected JPanel menuPanel, leftPanel, centralPanel;
	protected JList<ITEM_HELP> itemList;
	protected JMenu menu;
	protected JMenuBar menuBar;
	protected JMenuItem itemMenu;
	protected JButton selectBtn;
	protected JTextPane helpText;
	protected JScrollPane scrollPane;
	
	protected Map<ITEM_HELP, String> mapData;

	public HelpFrame() {
		loadData();
		configFrame();
		initComponents();
		setVisible(Boolean.TRUE);
	}

	public void configFrame() {
		setLayout(new FlowLayout());
		setSize(new Dimension(350, 200));
		setResizable(Boolean.FALSE);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
	}

	public void loadData() {
		mapData = new HashMap<>();
		mapData.put(ITEM_HELP.IF,
				"<htm><b>if</b> solo podemos hacer que se ejecute un fragmento de código o no.<br>por lo que si queremos que se ejecute otra cosa cuando no se cumpla la condición solo con el if tenemos que hacer otro con la condición inversa provocando que se tenga que comprobar la condición 2 veces mientras que si usamos el else solo necesitamos hacer la comprobación una sola vez.</html>");
	}

	@SuppressWarnings("deprecation")
	public void initComponents() {

		menuPanel = new JPanel();
		menuPanel.setLayout(new BorderLayout(3, 3));
		add(menuPanel);

		itemMenu = new JMenuItem("Get");
		menu = new JMenu("File");
		menuBar = new JMenuBar();
		menu.add(itemMenu);
		menuBar.add(menu);
		menuPanel.add(menuBar, BorderLayout.NORTH);

		itemList = new JList<HelpFrame.ITEM_HELP>(ITEM_HELP.values());
		itemList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		menuPanel.add(itemList, BorderLayout.WEST);

		//helpText = new JTextArea(5, 20);
		helpText = new JTextPane();
		helpText.setEditable(Boolean.FALSE);
		helpText.setPreferredSize(new Dimension(200, 100));
		helpText.setMinimumSize(new Dimension(200, 100));
		helpText.setBounds(0, 0, 100, 100);
		helpText.setSelectedTextColor(Color.BLACK);
		helpText.setContentType("text/html");
		
		scrollPane = new JScrollPane(helpText);
		scrollPane.setViewportView(helpText);
		scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED); 
		
		menuPanel.add(scrollPane, BorderLayout.CENTER);

		itemMenu.addActionListener((ae) -> {
			ITEM_HELP item = itemList.getSelectedValue();
			if (item != null) {
				helpText.setText(mapData.get(item));
			}
		});

	}

	public static void main(String[] args) {
		SwingUtilities.invokeLater(() -> new HelpFrame());
	}
}
