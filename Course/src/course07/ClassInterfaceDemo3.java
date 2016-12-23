package course07;
/**
 * abstract 和 interface 的用法区别
 * @author asuy
 *门和警报的例子：门都有open( )和close( )两个动作，
 *此时我们可以定义通过抽象类和接口来定义这个抽象概念：
 */
abstract class DoorOne {
    public abstract void open();
    public abstract void close();
}
//interface DoorTwo {
//    public abstract void open();
//    public abstract void close();
//}
/**
 * 如果我要增加警报的功能，怎么实现？
 * @author asuy
 *　1）将这三个功能都放在抽象类里面，但是这样一来所有继承于这个抽象类的子类都具备了报警功能，但是有的门并不一定具备报警功能；

　　2）将这三个功能都放在接口里面，需要用到报警功能的类就需要实现这个接口中的open( )和close( )，也许这个类根本就不具备open( )和close( )这两个功能，比如火灾报警器。
 这里可以看出， Door的open() 、close()和alarm()根本就属于两个不同范畴内的行为，open()和close()属于门本身固有的行为特性，而alarm()属于延伸的附加行为。因此最好的解决办法是单独将报警设计为一个接口，包含alarm()行为,Door设计为单独的一个抽象类，包含open和close两种行为。再设计一个报警门继承Door类和实现Alarm接口。
 */
interface Alarm {
    void alarm();
}
class AlarmDoor extends DoorOne implements Alarm {
     @Override
	public void close() {
     System.out.println("门关闭");
    }
    public void alarm() {
   	 System.out.println("警报响了");
    }
	@Override
	public void open() {
		 System.out.println("门打开");	
	}
}
public class ClassInterfaceDemo3 {

	public static void main(String[] args) {
	
		AlarmDoor alarmDoor=new AlarmDoor();
		alarmDoor.open();
		alarmDoor.alarm();
		alarmDoor.close();
	}

}
