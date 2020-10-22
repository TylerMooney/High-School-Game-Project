
public class Model {
	//for security and bug avoidance reasons, we usually keep our class variables private
	private int stat1;
	private int stat2;
	
	public Model(){
		stat1 = 0;
		stat2 = 0;
	}
	
	//Because we made the class variables private, we need to make methods that can return those variable for use by other classes
	public int getStat1(){
		return stat1;
	}
	
	public int getStat2(){
		return stat2;
	}
	
	//Like the get methods above, these methods allow us to set the values of the variables from other classes
	public void setStat1(int newStat){
		stat1 = newStat;
		if (stat1 <= 0){
//			isDead = true
		}
		else{
//			isDead = false
		}
	}
	
	public void setStat2(int newStat){
		stat2 = newStat;
	}
}
