package course11.gui.event;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JTextField;

public class Button2 {
	JFrame frame =new JFrame("hello swing");
    
    private JButton
    b1=new JButton("Button1"),
    b2=new JButton("Button2");
    private JTextField text=new JTextField(10);
    private ActionListener bl=new ActionListener() {
		
		@Override
		public void actionPerformed(ActionEvent e) {
		   String name=((JButton)e.getSource()).getText();
		   text.setText(name);
			
		}
	};
    public Button2(){
  	frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    frame.setSize(300, 100);
    b1.addActionListener(bl);
    b2.addActionListener(bl);
  	frame.setLayout(new FlowLayout());
  	frame.add(b1);
  	frame.add(b2);
  	frame.add(text);
  	frame.setVisible(true);
    }

	public static void main(String[] args) {
		new Button2();
	}

}
