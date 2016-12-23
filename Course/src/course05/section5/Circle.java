package course05.section5;

//为圆类
public class Circle {
	
    double x,y,radius;//x,y为圆心坐标 radius 为半径
    public void setX(double a) {
       x=a;
    }
    public double getX() {
       return x;
    }
    public void setY(double b){
       y=b;
    }
    public double getY() {
       return y;
    }
    public void setRadius(double r){
       if(r >0 )
         radius=r;
    }
    public double getRadius(){
       return radius;
    }
}