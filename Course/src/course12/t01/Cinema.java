package course12.t01;

class Cinema implements Runnable          
{  
	Thread zhang,sun,zhao; 
	TicketSeller seller;
   Cinema()
   {  
	   zhang=new Thread(this);
      sun=new Thread(this);
      zhao=new Thread(this);
      zhang.setName("张小有");
      sun.setName("孙大名");
      zhao.setName("赵中堂");
      seller=new TicketSeller();
   } 
   public void run()
   {  
	   if(zhang==Thread.currentThread())
       {  
		   seller.sellTicket(20);
       }
       else if(sun==Thread.currentThread())
       {  
    	   seller.sellTicket(10);
       }
       else if(zhao==Thread.currentThread())
       { 
    	   seller.sellTicket(5);
       }
   }
}
