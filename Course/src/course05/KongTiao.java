package course05;

//设计一个空调

public class KongTiao {
  //空调属性
  String name;
  String pinpai;
  String pishu;
  int tempeture;
  
  //定义制冷行为
  void cool()
  {
      tempeture--;
  }
  
  //定义加热行为
  void hot()
  {
      tempeture+=7;
  }
  //主函数
  public static void main(String[] args){
      KongTiao kt = new KongTiao();
      kt.name = "美的";
      kt.pishu = "2匹";
      kt.tempeture = 20;
      kt.pinpai = "志高";
      /**
      kt.cool();
      System.out.println("空调的温度是"+kt.tempeture);
      */
      
      kt.hot();
      System.out.println("空调的温度是"+kt.tempeture);
      
      
  }
}