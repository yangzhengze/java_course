package experiment.project04;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Rectangle;
import java.awt.Toolkit;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;
import javax.swing.JPanel;




enum KEY {  
    UP, RIGHT, DOWN, LEFT, RIGHT_UP, RIGHT_DOWN, LEFT_UP, LEFT_DOWN  
}  
enum HORIZION {  
    LEFT, RIGHT  
}  
enum VERTICAL {  
    UP, DOWN  
}  
public class GameCanvas extends JPanel implements KeyListener{
	
	private static final long serialVersionUID = 6412499729018604417L;
	
	private List<Enemy> enemies=new ArrayList<Enemy>();
	private List<Bullet> enmybullets=new ArrayList<Bullet>();
	private List<Bullet> herobullets=new ArrayList<Bullet>();
	private List<Collision> collisions=new ArrayList<Collision>();
	Image image1 = null;
    private Hero hero;
	    KEY key;
	    HORIZION hor;  
        VERTICAL ver;
	public GameCanvas()
	{
		 this.addKeyListener(this);
		 image1 = Toolkit.getDefaultToolkit().getImage(GameCanvas.class.getResource("bomb_1.gif"));
		 hero=new Hero(200,500);
		for(int i=0;i<10;i++)
		{
			Enemy e=new Enemy((int)(Math.random()*150),0);
			enemies.add(e);
		}
		Thread animate=new Thread(){
			public void run(){
				long time=0;
				while(true)
				{
					
					try {
						EnemyMove(time);
						for(Bullet e:enmybullets)
						{
							e.move(time);
						}
						for(Bullet h:herobullets)
						{
							h.move(time);
						}
						if(time%500==0)
						{
						for(Enemy e:enemies)
						{
							Bullet Ef=e.fire();
							enmybullets.add(Ef);
						}
						}
						addNewEnemy(time);
						collision();
						time+=40;
						Thread.sleep(40);
					
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
					repaint();
				}
			}

			private void collision() {
				for (int i = 0; i < enemies.size(); i++)
				{
					    Enemy e= enemies.get(i); 
					    Rectangle tankRectangle = new Rectangle(hero.x,hero.y,hero.height,hero.width);  
					    Rectangle stuffRectangle = new Rectangle(e.x, e.y,20,20);  
					    if (stuffRectangle.intersects(tankRectangle))
					    { 
					    	        e.Enemyislive=false;
					    	        Hero.Heroislive=false;
                                    Collision bom=new Collision(e.x,e.y);
                                    collisions.add(bom);
                                    JOptionPane.showMessageDialog(null, "你已经输了，");
                                    
					    }	  
			
		    	}
				
				for(Bullet e:enmybullets)
				{     
					  Rectangle tankRectangle = new Rectangle(hero.x,hero.y,hero.height,hero.width); 
					  Rectangle stuffRectangle = new Rectangle(e.x, e.y,5,20);
					  if (stuffRectangle.intersects(tankRectangle))
					  { 
			    	       Hero.Heroislive=false;
			    	      
			    	       Collision bom=new Collision(e.x,e.y);
                           collisions.add(bom);
                          
                    			JOptionPane.showMessageDialog(null, "你已经输了，");
                    		

			    	   }
				}
				
				for(Bullet h:herobullets)
				{   for (int i = 0; i < enemies.size(); i++)
				{
					   Enemy e= enemies.get(i);
					  Rectangle tankRectangle = new Rectangle(e.x,e.y,20,20); 
				
					  Rectangle stuffRectangle = new Rectangle(h.x, h.y,5,20);
					  if (stuffRectangle.intersects(tankRectangle))
					  { 
						  e.Enemyislive=false;
						 
						  Collision bom=new Collision(e.x,e.y);
                          collisions.add(bom);
			    	   }
				}
				}	
				
			}
		

			private void addNewEnemy(long time) {
				if(time%1000==0)
				{
					Enemy e=new Enemy((int)(Math.random()*400),0);
					enemies.add(e);
				}   
		
			}

			private void EnemyMove(long time) {
				for(Enemy e:enemies)
				{
					e.move(time);
				}
			}
		};
		animate.start();
	}


	public void paint(Graphics g)
	{
		super.paint(g);
		g.setColor(Color.gray);
		g.fillRect(0,0,400,600);
		for(Bullet e:enmybullets)
			e.draw(g);
		for(Bullet h:herobullets)
			h.draw(g);
		
		 for(int i=0;i<enemies.size();i++){
		      Enemy blast;
		      blast=enemies.get(i);
		      
		    if(blast.Enemyislive){
		    		blast.draw(g);
		      }else{
		    	
		    	  enemies.remove(i);
		      }
		    }
		 
		 
		    if(Hero.Heroislive){
		         hero.draw(g);
		      }
		  else{
			 // g.drawImage(Resources.heroPNGB, hero.x, hero.y, 40, 40, this); 
			     hero.height=hero.height-40;
			     hero.width=hero.width-40;
			  
		     }
		
//	        画出炸弹 
		    for(int i = 0;i<collisions.size();i++) {
		    	Collision bom = collisions.get(i); 
		    	if(bom.life==5)         
		    	{              
		    		g.drawImage(image1, bom.x, bom.y, 30, 30, this); 
		    	}
		    	 bom.lifedown(); 
		    	 
		         if(bom.life==0)            
		        {                 
		    	collisions.remove(bom);                 
		        }
		    
		    }
		    
	}
		 
		     
	
	
	@Override
	public void keyTyped(KeyEvent e) {
		
	}

	@Override
	public void keyPressed(KeyEvent e) {
          switch ( e.getKeyCode()) {  
          case KeyEvent.VK_UP:  
              ver = VERTICAL.UP; 
              break;  
          case KeyEvent.VK_DOWN:  
              ver = VERTICAL.DOWN;  
              break;  
          case KeyEvent.VK_RIGHT:  
              hor = HORIZION.RIGHT;  
              break;  
          case KeyEvent.VK_LEFT:  
              hor = HORIZION.LEFT;  
              break;  
          case KeyEvent.VK_SPACE:
  			 Bullet h=hero.fire();
  			 herobullets.add(h);
  			break;
          }  
          if (ver == null) {  
              if (hor == HORIZION.RIGHT) {  
                  key = KEY.RIGHT;  
              } else {  
                  key = KEY.LEFT; 
              }  

          } else if (hor == null) {  
              if (ver == VERTICAL.UP) {  
                  key = KEY.UP;
              } else {  
                  key = KEY.DOWN;    
              }  
          } else {  
              if (hor == HORIZION.RIGHT) {  
                  if (ver == VERTICAL.UP) {  
                      key = KEY.RIGHT_UP;
                  } else {  
                      key = KEY.RIGHT_DOWN;  
                  }  
              } else {  
                  if (ver == VERTICAL.UP) {  
                      key = KEY.LEFT_UP;  
                  } else {  
                      key = KEY.LEFT_DOWN;  
                  }  
              }  
          }  

     hero.move(key);
		
	}

	@Override
	public void keyReleased(KeyEvent e) {
		  
         switch (e.getKeyCode()) {  
         case KeyEvent.VK_UP:  
             ver = null;  
             break;  
         case KeyEvent.VK_DOWN:  
             ver = null;
             break;  
         case KeyEvent.VK_RIGHT:
             hor = null;  
             break;  
         case KeyEvent.VK_LEFT:
             hor = null;  
             break;  
         }  
     }  	
		
	}

