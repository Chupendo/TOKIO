package com.tokio.school.swing.progessbar;

import javax.swing.JLabel;
import javax.swing.JProgressBar;

public class ThreadCarga implements Runnable {
	private static short nTH = 0;
	protected Thread th;
	protected JProgressBar barra;
	protected JLabel label;
	protected Boolean isParar;
	private static final Integer min, max;
	static {
		min = 0;
		max = 100;
	}

	public ThreadCarga(String nameTh, JProgressBar barra, JLabel label) {
		this.th = new Thread(this, String.format(nameTh + " %d", nTH));
		this.barra = barra;
		this.label = label;
		this.isParar = Boolean.FALSE;
		nTH++;
	}

	public static ThreadCarga createAndStart(String nameTh, JProgressBar barra, JLabel label) {
		ThreadCarga loadTh = new ThreadCarga(nameTh, barra,label);
		barra.setMinimum(min);
		barra.setMaximum(max);
		loadTh.th.start();
		return loadTh;

	}

	public void initLoad() {
		if (!th.isAlive()) {
			this.isParar = Boolean.FALSE;
			th.start();
		}
	}

	public void stopLoad() {
		synchronized (barra) {
			if (th.isAlive()) {
				this.isParar = Boolean.TRUE;
				barra.notify();
			}
		}
	}

	@Override
	public void run() {		
			for (int i = min; i <= max; i++) {
				barra.setValue(i);
				synchronized (barra) {
				if (isParar) {
					break;
				}
				try {
					label.setText("Load " + barra.getValue() + " %");
					barra.wait(1000);
				} catch (InterruptedException e) {
					// Se ignoran las excepciones
				}
			}
		}
		stopLoad();
	}
}
