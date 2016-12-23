package course13.udp;
import java.net.*;
public class ReceiveLetterForZhang implements Runnable {
   public void run() {
      DatagramPacket pack=null;
      DatagramSocket postman=null;
      byte data[]=new byte[8192];//是8192字节是NFS默认的读取用户数据大小
      try{  pack=new DatagramPacket(data,data.length);
            postman = new DatagramSocket(8888);
      }
      catch(Exception e){} 
      while(true) {  
        if(postman==null){
        	break;	
        }	
        else{
        	try{ 
        		postman.receive(pack); 
            String message=new String(pack.getData(),0,pack.getLength());
            System.out.printf("%25s\n","收到:"+message);
       }
       catch(Exception e){}
        }
          
      } 
   }
}
