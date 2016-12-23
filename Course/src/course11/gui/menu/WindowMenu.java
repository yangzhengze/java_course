package course11.gui.menu;

import java.awt.event.InputEvent;
import java.awt.event.KeyEvent;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.KeyStroke;

public class WindowMenu extends JFrame {
	   JMenuBar menubar;
	    JMenu menu,subMenu;
	    JMenuItem  item1,item2;
	    public WindowMenu(){} 
	    public WindowMenu(String s,int x,int y,int w,int h) {
	       init(s);
	       setLocation(x,y);
	       setSize(w,h);
	       setVisible(true);
	       setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE); 
	    }
	    void init(String s){
	       setTitle(s);        
	       menubar=new JMenuBar(); 
	       menu=new JMenu("菜单"); 
	       subMenu=new JMenu("软件项目");  
	       item1=new JMenuItem("Java话题",new ImageIcon("img/a.gif"));
	       item2=new JMenuItem("动画话题",new ImageIcon("img/b.gif"));
	       item1.setAccelerator(KeyStroke.getKeyStroke('A')); 
	       item2.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_S,InputEvent.CTRL_MASK)); 
	       menu.add(item1); 
	       menu.addSeparator();
	       menu.add(item2); 
	       menu.add(subMenu);  //把subMenu菜单做为menu的一个菜单项
	       subMenu.add(new JMenuItem("汽车销售系统",new ImageIcon("img/c.gif"))); 
	       subMenu.add(new JMenuItem("农场信息系统",new ImageIcon("img/d.gif")));
	       menubar.add(menu); 
	       setJMenuBar(menubar);
	    } 
}
