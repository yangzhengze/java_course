package course05.section11;

public class A {
int x=100,y=200;

public int getX() {
	return x;
}

public void setX(int x) {
	x = x;
	 System.out.println("x="+x);
	 System.out.println("thisx="+this.x);
}

public int getY() {
	return y;
}

public void setY(int y) {
	this.y = y;
}
public int getXYSum(){
	return x+y;
}
}
