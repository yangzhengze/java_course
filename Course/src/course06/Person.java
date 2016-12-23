package course06;
/**
 * 继承是所有OOP语言不可缺少的部分，在java中使用extends关键字来表示继承关系。
 * 当创建一个类时，总是在继承，如果没有明确指出要继承的类，就总是隐式地从根类Object进行继承。
 * 比如下面这段代码：
 *
 * @author asuy
 *
 */
public class Person {
	private String name;  
    private int age;  
    public void setAge(int age) {
		this.age = age;
	}
	public void setName(String name){  
    this.name = name;      
    }  
    public void setInt(int age){  
    this.age = age;      
    }  
    public String getName(){  
    return this.name;      
    }  
    public int getAge(){  
    return this.age;  
    }  
}  

class Student extends Person{
	//此处不添加任何代码
}
/**
 * 
 * 
 * 类Student继承于Person类，这样一来的话，Person类称为父类（基类），Student类称为子类（导出类）。
 * 如果两个类存在继承关系，则子类会自动继承父类的方法和变量，在子类中可以调用父类的方法和变量。
 * 在java中，只允许单继承，也就是说 一个类最多只能显示地继承于一个父类。但是一个类却可以被多个类继承，也就是说一个类可以拥有多个子类。

　　1.子类继承父类的成员变量

　　当子类继承了某个类之后，便可以使用父类中的成员变量，但是并不是完全继承父类的所有成员变量。具体的原则如下：

　　1）能够继承父类的public和protected成员变量；不能够继承父类的private成员变量；

　　2）对于父类的包访问权限成员变量，如果子类和父类在同一个包下，则子类能够继承；否则，子类不能够继承；

　　3）对于子类可以继承的父类成员变量，如果在子类中出现了同名称的成员变量，则会发生隐藏现象，即子类的成员变量会屏蔽掉父类的同名成员变量。如果要在子类中访问父类中同名成员变量，需要使用super关键字来进行引用。

　　2.子类继承父类的方法

　　同样地，子类也并不是完全继承父类的所有方法。

　　1）能够继承父类的public和protected成员方法；不能够继承父类的private成员方法；

　　2）对于父类的包访问权限成员方法，如果子类和父类在同一个包下，则子类能够继承；否则，子类不能够继承；

　　3）对于子类可以继承的父类成员方法，如果在子类中出现了同名称的成员方法，则称为覆盖，即子类的成员方法会覆盖掉父类的同名成员方法。如果要在子类中访问父类中同名成员方法，需要使用super关键字来进行引用。

　　注意：隐藏和覆盖是不同的。隐藏是针对成员变量和静态方法的，而覆盖是针对普通方法的。（后面会讲到）
 */
