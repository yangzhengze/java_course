package course05;
public class Circle { 
    double radius,area;
    Circle(){
    }
    Circle(double r) {
       radius = r;
    }
    void setRadius(double r) {
       if(r>0){
          radius=r;
       }
    } 
    double getRadius(){
       return radius;
    }
    double getArea(){
       area=3.14*radius*radius;
       return area;
    }
}