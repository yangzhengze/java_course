package cn.edu.asu.test;
/**
 * 学生类
 *   数据域的封装
 *   把权限改成私有的private
 * @author asu-student
 *
 */
public class Student {
	private int eye=2;
	private int zuiBa;
	private String xueXiao;
	/**
	 * 需要定义一个poublic 的方法，让别人访问
	 *   getter(获取值)
	 *   setter(设置值)
	 */
	
	
	
	
	public void xueXi() {
		
	}

	public int getEye() {
		return eye;
	}

	public void setEye(int eye) {
		this.eye = eye;
	}

	public int getZuiBa() {
		return zuiBa;
	}

	public void setZuiBa(int zuiBa) {
		this.zuiBa = zuiBa;
	}

	public String getXueXiao() {
		return xueXiao;
	}

	public void setXueXiao(String xueXiao) {
		this.xueXiao = xueXiao;
	}

	public static void main(String[] args) {
	    /**
	     * 对象的数组
	     *  数据类型 [] 变量； 
	     */
		
		Student [] students=new Student[20];
		for(int j=0;j< students.length;j++) {
			students[j]=new Student();
		}
		System.out.println(students[0].getEye());
		

	}

}
