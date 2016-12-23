package experiment.project04;


public class Enemy extends FlyingObject {
	 boolean Enemyislive = true; // 代表没有撞到 
	 
	public Enemy(int x, int y) {
		super(x, y, 30,30, Resources.enemyPNG);
	
	}
	public Bullet fire()
	{
		int x=this.x;
		int y=this.y+this.height;
		Bullet enem=new Bullet(x,y,true);
		return enem;
	}
	@Override
	public void move(long time) {
	   if(time%160==0)
		{
			y+=4+Math.random()*2;
			x+=2-Math.cos(Math.random()*4);
		}
		
		
	}

}
