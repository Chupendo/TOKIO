package com.tokio.schoo.swign.layout.layouts;

import java.lang.reflect.InvocationTargetException;

import javax.swing.SwingUtilities;

import com.tokio.schoo.swign.layout.layouts.borderlayout.JFrameBorderLayout;
import com.tokio.schoo.swign.layout.layouts.boxlayout.JFrameBoxLayoutH;
import com.tokio.schoo.swign.layout.layouts.boxlayout.JFrameBoxLayoutV;

public class AppLayous {

	public static void main(String[] args) {
		try {
			SwingUtilities.invokeAndWait(()->{
				/* BoxLayout */
				//new JFrameBoxLayoutV();
				//new JFrameBoxLayoutH();
				/* BorderLayout */
				new JFrameBorderLayout();
			});
		} catch (InvocationTargetException | InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
