package course12.t01;

class TicketSeller    //负责卖票的类。
{ 
	int fiveNumber=3,tenNumber=0,twentyNumber=0; 
   public synchronized void  sellTicket(int receiveMoney)
   {  
	   if(5==receiveMoney)
       {  
		   fiveNumber=fiveNumber+1; 
           System.out.println(Thread.currentThread().getName()+
        		  "给我5元钱，这是您的1张入场卷"); 
       }
       else if(10==receiveMoney)           
        { 
    	   while(fiveNumber<1)
            {   try {  
            	System.out.println(Thread.currentThread().getName()+"靠边等");     
            	wait();         
            	System.out.println(Thread.currentThread().getName()+"结束等待");
                    }
               catch(InterruptedException e) {}
            }
           fiveNumber=fiveNumber-1;
           tenNumber=tenNumber+1;
           System.out.println(Thread.currentThread().getName()+
         "给我10元钱,找您5元,这是您的1张入场卷");  
         }
       else if(20==receiveMoney)           
        { 
    	   while(fiveNumber<1||tenNumber<1)
            {   
    		   try {  
    			   System.out.println(Thread.currentThread().getName()+"靠边等");
                       
    			   wait();   
                      
    			   System.out.println(Thread.currentThread().getName()+"结束等待");
                    }
               catch(InterruptedException e) {}
            }
           fiveNumber=fiveNumber-1;
           tenNumber=tenNumber-1;
           twentyNumber=twentyNumber+1;   
           System.out.println(Thread.currentThread().getName()+
             "给20元钱，找您一张5元和一张10元，这是您的1张入场卷");                    
        }
       notifyAll();
   }
}
