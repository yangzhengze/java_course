package course11.gui;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class FirstFrame {
	public  static void main(String args[])
	{
		JFrame frame=new JFrame("FirstFrame");
		frame.setSize(400,400);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLayout(null);
		JButton button=new JButton("ok");
		button.setLocation(200, 200);
		button.setSize(50, 30);
		frame.add(button);
		frame.setVisible(true);
		String inputValue = JOptionPane.showInputDialog("请输入你的值"); 
	}
}
