package web;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.Random;

import javax.imageio.ImageIO;
import javax.servlet.ServletException;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


/**
 * Servlet implementation class TestImage
 */
@WebServlet("/test")
public class TestImage extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public TestImage() {
        super();
        // TODO Auto-generated constructor stub
    }
    public static final char[] CHARS={'2','3','4','5','6','7','8','9','A','B','C',
		'D','E','F','G','H','K','M','L','N','L','X','Y','Z','Q'};
	public static Random random=new Random();
	
	public static String getRandomString(){
		StringBuffer buffer=new StringBuffer();
		//随即产生6位数
		for(int i=0;i<6;i++){
			buffer.append(CHARS[random.nextInt(CHARS.length)]);
		}
		return buffer.toString();
	}
	//获取随即的颜色
	public static Color getRandomColor(){
		return new Color(random.nextInt(255),random.nextInt(255),random.nextInt(255));
	}
	//返回某颜色的反色
	public static Color getReverseColor(Color c){
		return new Color(255-c.getRed(), 255-c.getGreen(),255-c.getBlue());
	}
	

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request,response);

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		response.setHeader("Pragma", "No-cache");
	    response.setHeader("Cache-Control", "no-cache");
	    response.setDateHeader("Expires", 0);
       response.setContentType("image/jpg");
		String randomString=getRandomString();
		int width=100;//图片宽度
		int height=30;//图片高度
		Color color=getRandomColor();	//随即颜色。用于背景颜色
		Color reverse=getReverseColor(color);//反色，用于前背景
		//创建一个彩色图片
		BufferedImage bi=new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
		//获取绘图对象
		Graphics2D g=bi.createGraphics();
		g.setFont(new Font(Font.SANS_SERIF, Font.BOLD, 16));//设置字体
		g.setColor(color);	//设置颜色
		g.fillRect(0, 0, width, height);//绘制背景
		g.setColor(reverse);//设置颜色
		g.drawString(randomString, 18, 20);
		for(int i=0;i<100;i++){
			g.drawRect(random.nextInt(width), random.nextInt(height),1, 1); //随即噪音点
		}
		request.getSession(true).setAttribute("randomString", randomString);
		 // 图象生效
        g.dispose();
		ImageIO.write(bi, "jpg", response.getOutputStream());	
	}

}
