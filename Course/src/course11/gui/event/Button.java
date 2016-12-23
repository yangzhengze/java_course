package course11.gui.event;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class Button  extends  JFrame {
    
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
      
	private  JButton 
	b1=new JButton("button1"),
	b2=new JButton("button2");
	
	private JTextField txt=new JTextField(10);
	private ActionListener be=new ActionListener() {
		
		@Override
		public void actionPerformed(ActionEvent e) {
			String name=((JButton)e.getSource()).getText();
			txt.setText(name);
			
		}
	};
	public Button(){
		b1.addActionListener(be);
		b2.addActionListener(be);
		setLayout(new FlowLayout());
		add(b1);
		add(b2);
		add(txt);
	}
	public static void main(String[] args) {
		
		SwingConsole.run(new Button(), 200, 150);
	}

}
