package cn.asu.edu.test.test1;

import java.util.Scanner;

/**
 * 计算身体质量指数
 * @author stu
 *
 */
public class ComputerAndInerpertBMI {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		System.out.println("enter a number for weight: ");
		double weight = input.nextDouble();
		System.out.println("enter a number for height: ");
		double height = input.nextDouble();
		/**
		 * 常量
		 */
		final double KILOGRAMS_PER_POUND=0.45359237;
		final double METERS_PER_INCH=0.0254;
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
