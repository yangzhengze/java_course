package experiment.project04;



public class Collision  {
      
	 int x;
    int y;

//  炸弹的生命周期
      int life = 7;
     boolean live = true;

	 public Collision(int x, int y) {
		 this.x =x;
		 this.y = y;
	
		}
	 public void lifedown()
	    {
	        if(life>0)
	        {
	            life--;
	        }
	        else
	        {
	            live = false;
	           
	        }
	    }



}
