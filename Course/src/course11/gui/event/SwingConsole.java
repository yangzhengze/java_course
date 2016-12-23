package course11.gui.event;

import java.awt.EventQueue;

import javax.swing.JFrame;

public class SwingConsole {
   public static  void run(final JFrame f,final int width,final int height){
	   EventQueue.invokeLater(new  Runnable() {
		public void run() {
			f.setTitle(f.getClass().getSimpleName());
			f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			f.setSize(width, height);
			f.setVisible(true);
		}
	});
   }
}
