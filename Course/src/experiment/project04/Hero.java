package experiment.project04;




public class Hero extends FlyingObject {
	  static final int STEP = 10;  
	  static boolean Heroislive=true;
	public Hero(int x, int y) {
		super(x, y, 40, 40, Resources.heroPNG);
		
	}
	public Bullet fire()
	{    
		Bullet her=new Bullet(this.x,this.y,false);
		return her;
	}
	@Override
	public void move(long time) {
		
	}
	 
	 public void move(KEY key) {  
      
      
         switch (key) {  
         case UP://向上移动
             y -= STEP;  
             break;  
         case RIGHT:// 向右移动
           x += STEP;  
             break;  
         case DOWN:// 向下移动
           y += STEP;  
             break;  
         case LEFT://向左移动
             x -= STEP;  
             break;  
         case RIGHT_UP:// 右上移动
             x += STEP;  
             y -= STEP;  
             break;  
         case RIGHT_DOWN://右下移动  
             x += STEP;  
             y += STEP;  
             break;  
         case LEFT_UP:// 左上移动
             x -= STEP;  
             y -= STEP;  
             break; 
         case LEFT_DOWN:// 左下移动
             x -= STEP;  
             y += STEP;  
             break;  
         }  
        
        
     }  
	
}
