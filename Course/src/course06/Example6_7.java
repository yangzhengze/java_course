package course06;

/**
 * 多态的例子
 * @author asuy
 *
 */
 class PersonO { //人类

    String name;

    int age;

   

    public void eat()

    {

        System.out.println("人们在吃饭!");

    }

}

 

class Chinese extends PersonO{

    //重写父类方法

    public void eat()

    {

        System.out.println("中国人在吃饭!");

    }

   

    //子类特有方法,当父类引用指向子类对象时无法调用该方法

    public void shadowBoxing()

    {

        System.out.println("练习太极拳!");

    }

}

 

class English extends PersonO{

    //重写父类方法

    public void eat()

    {

        System.out.println("英国人在吃饭!");

    }

}
public class Example6_7 {
	//使用父类作为方法的形参,实现多态

    public void showEat(PersonO person)

    {

        //传入的是哪具对象就调用哪个对象的eat()方法

        person.eat();

    }
	public static void main(String[] args) {
	
		Example6_7 test= new Example6_7();

	       

	        //引用指向中国人,创建中国人类对象

	        PersonO person1 = new Chinese();

	       

	        //此时调用的是Chinese的eat()方法

	        test.showEat(person1);

	       

	        PersonO person2 = new English();

	       

	        //此时调用的是English的eat()方法

	        test.showEat(person2);

	 

	        //强制类型转换(向下转型)

	        Chinese chinese = (Chinese)person1;

	       

	        //向下转型后,调用子类的特有方法

	        chinese.shadowBoxing();
	}

}
