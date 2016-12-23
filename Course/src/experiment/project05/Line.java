package experiment.project05;

import java.io.Serializable;

public class Line implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int x1, x2,R,G,B;
	private int y1, y2,i,j,k;
	private String command;
	 
	public void setCommand(String command) {
		this.command = command;
	}
	public int getX1() {
		return x1;
	}
	public void setX1(int x1) {
		this.x1 = x1;
	}
	public int getX2() {
		return x2;
	}
	public void setX2(int x2) {
		this.x2 = x2;
	}
	public int getY1() {
		return y1;
	}
	public void setY1(int y1) {
		this.y1 = y1;
	}
	public int getY2() {
		return y2;
	}
	public void setY2(int y2) {
		this.y2 = y2;
	}
	public String getCommand() {
		
		return command;
	}
	public int getI() {
		return i;
	}
	public void setI(int i) {
		this.i = i;
	}
	public int getJ() {
		return j;
	}
	public void setJ(int j) {
		this.j = j;
	}
	public int getK() {
		return k;
	}
	public void setK(int k) {
		this.k = k;
	}
	public int getR() {
		return R;
	}
	public void setR(int r) {
		R = r;
	}
	public int getG() {
		return G;
	}
	public void setG(int g) {
		G = g;
	}
	public int getB() {
		return B;
	}
	public void setB(int b) {
		B = b;
	}
	
}
