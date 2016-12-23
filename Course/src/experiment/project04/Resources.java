package experiment.project04;

import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;

public class Resources {
	static {
		try {
			enemyPNG=ImageIO.read(Resources.class.getResourceAsStream("this.png"));
			bulletPNG=ImageIO.read(Resources.class.getResourceAsStream("NOR1.png"));
			heroPNG=ImageIO.read(Resources.class.getResourceAsStream("hero.png"));
			heroPNGB=ImageIO.read(Resources.class.getResourceAsStream("heroB.png"));
			
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	public static BufferedImage enemyPNG;
	public static BufferedImage bulletPNG;
	public static BufferedImage heroPNG;
	public static BufferedImage heroPNGB;
	
	
}
