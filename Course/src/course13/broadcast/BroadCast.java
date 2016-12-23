package course13.broadcast;

import java.net.*;
public class BroadCast  { 
   String s="国庆放假时间是9月30日"; 
   int port=5858;                                    //组播的端口 
   InetAddress group=null;                          //组播组的地址
   MulticastSocket socket=null;                     //多点广播套接字  
   BroadCast() { 
      try { 
         group=InetAddress.getByName("239.255.8.0");//设置广播组的地址为239.255.8.0
         socket=new MulticastSocket(port);         //多点广播套接字将在port端口广播
         /**
          * 多了一个setTimeToLive(int ttl)方法，
          * 该ttl参数用于设置数据报最多可以跨过多少个网络，
          * 当ttl的值为0时，指定数据报应停留在本地主机；
          * 当ttl的值为1时，指定数据报发送到本地局域网；
          * 当ttl的值为32时，意味着只能发送到本站点的网络上；
          * 当ttl的值为64时，意味着数据报应保留在本地区；
          * 当ttl的值为128时，意味着数据报应保留在本大洲；
          * 当ttl的值为255时，意味着数据报可发送到所有地方；
          * 在默认情况下，该ttl的值为1。
          */
         socket.setTimeToLive(1); //多点广播套接字发送数据报范围为本地网络
        
         socket.joinGroup(group); //加入group后,socket发送的数据报被group中的成员接收到
      }                                 
      catch(Exception e) {
         System.out.println("Error: "+ e);          
      }
   }
   public void play() {
      while(true) {
        try{  
        	   DatagramPacket packet=null;        //待广播的数据包
               byte data[]=s.getBytes(); 
               packet=new DatagramPacket(data,data.length,group,port); 
               System.out.println(new String(data)); 
               socket.send(packet);             //广播数据包
               Thread.sleep(2000);
        }
        catch(Exception e) {
               System.out.println("Error: "+ e);          
        }
      }
   }
   public static void main(String args[]) {
      new BroadCast().play();
   }
}

