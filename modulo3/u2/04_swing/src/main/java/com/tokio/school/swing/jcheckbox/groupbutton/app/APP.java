package com.tokio.school.swing.jcheckbox.groupbutton.app;

import java.awt.FlowLayout;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.lang.reflect.InvocationTargetException;
import java.text.MessageFormat;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingUtilities;

import com.tokio.school.swing.texts.Constans;

public class APP {

	JFrame jfrm;
	JLabel jlabSelected;
	JLabel jlabChanged;
	JCheckBox jcbAlpha, jcbBeta, jcbGamma;

	APP() {
		this.jfrm = new JFrame(Constans.APP_TITLE);
		// cerrar la apalicion al cerrar la ventana
		this.jfrm.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		// especifica FlowLayout como administrador de diseño
		this.jfrm.setLayout(new FlowLayout());
		// dimenisonaes del contenedor
		this.jfrm.setSize(Constans.APP_WIDTH, Constans.APP_LENGTH);

		// Crea etiqeutas vacias
		this.jlabChanged = new JLabel(Constans.APP_LABEL_CONTENTS_EMPTY);
		this.jlabSelected = new JLabel(Constans.APP_LABEL_CONTENTS_EMPTY);

		this.jcbAlpha = new JCheckBox(Constans.APP_TEXT_CHEK_BTN_ALPHA);
		this.jcbBeta = new JCheckBox(Constans.APP_TEXT_CHEK_BTN_BETTA);
		this.jcbGamma = new JCheckBox(Constans.APP_TEXT_CHEK_BTN_GAMMA);

		this.jfrm.add(jcbAlpha);
		this.jfrm.add(jcbBeta);
		this.jfrm.add(jcbGamma);

		this.jfrm.add(jlabSelected);
		this.jfrm.add(jlabChanged);
		
		ItemListener ie = new Event();
		this.jcbAlpha.addItemListener(ie);
		this.jcbBeta.addItemListener(ie);
		this.jcbGamma.addItemListener(ie);
		
		this.jfrm.setVisible(true);
	}

	public static void main(String[] args) throws InvocationTargetException, InterruptedException {
		SwingUtilities.invokeAndWait(() -> new APP());

	}

	public class Event implements ItemListener {
		@Override
		public void itemStateChanged(ItemEvent ie) {
			StringBuilder auxMsg = new StringBuilder("Your are selected:");
			int i=0;
			Set<Object> param = new HashSet<>(); 
			
			if(jcbAlpha.isSelected()) {
				auxMsg.append("{"+i+"}");
				param.add(jcbAlpha.getText());
				i++;
			}
			
			if(jcbBeta.isSelected()) {
				auxMsg.append(" {"+i+"} ");
				param.add(jcbBeta.getText());
				i++;
			}
			
			if(jcbGamma.isSelected()) {
				auxMsg.append("{"+i+"}");
				param.add(jcbGamma.getText());
				i++;
			}
			
			
			if(((JCheckBox)ie.getItem()).isSelected()) {
				jlabSelected.setText("Your has selected: "+ ((JCheckBox)ie.getItem()).getText());
			}else {
				jlabSelected.setText("Your has deselected: "+ ((JCheckBox)ie.getItem()).getText());
			}
			
			if(param.size()>0) {
				MessageFormat mf = new MessageFormat(auxMsg.toString().replaceAll("  ", " "));
				jlabChanged.setText(mf.format(param.toArray()));
			}else {
				jlabChanged.setText("");
			}
		}
	}

}
