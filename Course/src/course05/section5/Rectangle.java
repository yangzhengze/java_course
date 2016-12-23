package course05.section5;

//正方形类
public class Rectangle {
	
    double x,y,width,height;  //x,y 为左上角的坐标，width,height为宽和高     
    public void setX(double a) {
       x=a;
    }
    public double getX(){
      return x;
    }
    public void setY(double b) {
       y=b;
    }
    public double getY(){
      return y;
    }
    public void setWidth(double w) {
       if(w > 0)
         this.width=w;
    }
    public double getWidth(){
       return width;
    }
    public void setHeight(double h) {
       if(height > 0)
          height=h;
    }
    public double getHeight() {
       return height;
    }
}
