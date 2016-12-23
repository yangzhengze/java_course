package course06;
/**
 * 建立一个Shape抽象类，代表形状，求面积和周长两个方法

建立一个正方形类， 长方形 ，圆类 作为抽象类的子类，

通过抽象类来求面积和周长

 * @author asuy
 *
 */
public class TestAbstract {
    Shape s;
    TestAbstract(Shape s){
            this.s = s;
    }
    public double getTwo(Shape h){
            double area = h.getArea();
            return 2*area;
    }
    public static void main(String [] args){
    	    //Shape shape=new Shape();//抽象类不能创建对象
            System.out.println("下面是各个图形面积和周长：");
            Shape s1 =new Square(1);
            System.out.println("正方形的面积"+s1.getArea());
            System.out.println("正方形的周长"+s1.getPan());
            
            Shape s2 = new Rectangle(1,2);
            System.out.println("长方形的面积"+s2.getArea());
            System.out.println("长方形的周长"+s2.getPan());
            
            Shape s3 = new Circle(1);
            System.out.println("圆的面积"+s3.getArea());
            System.out.println("圆的周长"+s3.getPan());
            
            TestAbstract t = new TestAbstract(s1);
            System.out.println("正方形面积的两倍"+t.getTwo(s1));	
            
    }
}
abstract class Shape{//抽象类
    public abstract double getArea();//抽象方法
    public abstract double getPan();
}

class Square extends Shape{
    protected double len;
    Square(double len){
            this.len = len;
    }
    @Override
    public double getArea(){
            return len*len;
    }
    @Override
    public double getPan(){
            return 4*len;
    }
}
class Rectangle extends Square{
    private double wid;
    Rectangle(double len,double wid){
            super(len);
            this.wid = wid;
    }
    @Override
    public double getArea(){
            return wid*len;
    }
    @Override
    public double getPan(){
            return (wid+len)*2;
    }
}
class Circle extends Shape{
    private double r;
    Circle (double r){
            this.r = r;
    }
    @Override
    public double getArea(){
            return Math.PI*r*r;
    }
    @Override
    public double getPan(){
            return Math.PI*r*2;
    }
}

