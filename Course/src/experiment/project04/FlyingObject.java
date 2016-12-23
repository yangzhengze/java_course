/**
 * filename:     shoot 
 * function:     flying game   abstract class 
 * date    :     2015/11/5
 * @author yangzz
 */
package experiment.project04;

import java.awt.Graphics;
import java.awt.image.BufferedImage;

abstract public class FlyingObject {
	protected int x;
	protected int y;
	protected int width;
	protected int height;
	private BufferedImage image;
	
	public FlyingObject(int x, int y, int width, int height, BufferedImage image) {
		super();
		this.x = x;
		this.y = y;
		this.width = width;
		this.height = height;
		this.image = image;
	}
	abstract public void move(long time);
	
	public void draw(Graphics g)
	{
		g.drawImage(image, x, y, width, height, null);
	}
	public boolean collision(FlyingObject other)
	{
		return false;
	}
	
}
