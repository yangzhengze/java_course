package course04;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class FirstJfram {

	public static void main(String[] args) {
	   JFrame frame=new JFrame();
		frame.setTitle("Hello World");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(400,400);
		frame.setVisible(true);
		String inputValue = JOptionPane.showInputDialog("请输入你的值"); 

	}

}
