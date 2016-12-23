package course07;
/**
 * 接口变量做参数
 * 
 * @author asuy
 *
 */
interface SpeakHello{
	public abstract void speak();
}
class Chinese implements SpeakHello{

	@Override
	public void speak() {
		System.out.println("中国人问候：你好，吃饭了没？");
		
	}
	
}
class English implements SpeakHello{

	@Override
	public void speak() {
		
		System.out.println("英国问候：你好，天气不错");
	}
	
}
//如果增加Chines 这些类，不需要更改KindHello类
class KindHello{
	public void lookHello(SpeakHello speakHello){
		speakHello.speak();
	}
}
public class ClassInterfaceDemo2 {

	public static void main(String[] args) {
	
        KindHello kindHello=new KindHello();
        kindHello.lookHello(new Chinese());
        kindHello.lookHello(new English()); 
	}

}
