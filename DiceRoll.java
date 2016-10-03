

public class DiceRoll 
{
	private int d1, d2, dsum;
	
	public DiceRoll() 
	{
		d1 = (int)(Math.random()*6)+1;
		d2 = (int)(Math.random()*6)+1;
		dsum = DiceSum(d1,d2);
	}
	
	public int DiceSum(int d1,int d2)
	{
		int dicesum = d1+d2;
		
		return dicesum;
	}
	
	public void setSum()
	{
		
	}
	
	public int getSum()
	{
		return dsum;
	}
	

	 public String toString() 
	{
			String pt;
			
			pt = "Dice1: "+d1+" Dice2: "+d2+" Sum: "+dsum+"";
			
			return pt;
	}
}
