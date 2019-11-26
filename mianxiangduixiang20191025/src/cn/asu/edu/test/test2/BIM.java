package cn.asu.edu.test.test2;
/**
 * 计算身体质量指数
 * @author stu
 *
 */
public class BIM {

	  private int age;
	  private double weight;
	  private double height;
	  private String name;
	  protected String address;
	  
	  
	  /**
		 * 常量
		 */
		final double KILOGRAMS_PER_POUND=0.45359237;
		final double METERS_PER_INCH=0.0254;
		
		
		
	  
	  public double getWeight() {
			return weight;
		}


		public void setWeight(double weight) {
			this.weight = weight;
		}


	public int getAge() {
		return age;
	}


	public void setAge(int age) {
		this.age = age;
	}


	public double getHeight() {
		return height;
	}


	public void setHeight(double height) {
		this.height = height;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}




	public  void getBMI() {
		/**
		 * 计算BMI
		 */
		double weightInKilogram = weight*KILOGRAMS_PER_POUND;
		double heightInMeters = height*METERS_PER_INCH;
		double bmi = weightInKilogram/(heightInMeters*heightInMeters);
		System.out.println("BMI is : "+bmi);
		if(bmi<18.5) {
			System.out.println("偏瘦");
		}else if(bmi<25) {
			System.out.println("正常");
		}else if(bmi<30) {
			System.out.println("超重");
		}else {
			System.out.println("过胖");
		}
		  
	  }
	 
	
}
