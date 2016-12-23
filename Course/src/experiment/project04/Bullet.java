package experiment.project04;

public class Bullet extends FlyingObject {

	public Bullet(int x, int y,boolean enemy) {
		super(x, y, 5, 20, Resources.bulletPNG);
		this.enemy=enemy;
	}
	private boolean enemy;
	public boolean isEnemy() {
		return enemy;
	}
	@Override
	public void move(long time) {
		if(time%40==0)
		{
			if(enemy)
			{
				y+=5;
			}else
			{
				y-=3;
			}
		}
		
	}
	
	
}
