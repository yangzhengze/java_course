package course11.gui;

import java.awt.EventQueue;
import java.util.concurrent.TimeUnit;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingUtilities;

public class SecondFrame {

	public static void main(String[] args) throws Exception {
		JFrame frame=new JFrame("SecondFrame");
	    JLabel label = new JLabel("A Label");//添加
	    frame.add(label);
		frame.setSize(300,100);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
		/**
		 * 不推荐这个去实现，这里还有main线程
		 */
		 TimeUnit.SECONDS.sleep(1);
		// label.setText("Hey! This is Different!");
		// EventQueue
		SwingUtilities.invokeAndWait(new Runnable() {
			
			@Override
			public void run() {
				label.setText("Hey! This is Different!");
			}
		});

	}

}
