/**
 * filename:     shoot 
 * function:     flying game
 * date    :     2015/11/5
 * @author yangzz
 * 
 */
package experiment.project04;

import java.awt.BorderLayout;
import javax.swing.JFrame;



public class GameFrame extends JFrame {
	 
	private static final long serialVersionUID = 4054739806889126858L;
	private GameCanvas canvas=new GameCanvas();

	public GameFrame()
	{   
		canvas.setFocusable(true);
		canvas.requestFocus();
		this.add(canvas,BorderLayout.CENTER);
	}
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		GameFrame frame=new GameFrame();
		
		frame.setTitle("雷电游戏");
		frame.setSize(400, 600);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
		
	
	}

}
