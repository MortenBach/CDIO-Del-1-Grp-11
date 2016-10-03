
public class DoubleRoll 
{
	private int d1;
	
	DiceRoll diceRollChange = new DiceRoll();			//Object of type DiceRoll class named DiceRollChange//
	
	public DoubleRoll(int d1) 					//Constructor//
	{	
		this.d1 = d1;
	}
	
	public void resetSum(int d1) 					//Reset method//
	{
		if(d1==1)
		{
			diceRollChange.setSum(0);
		}	
	}
	public int[] exstraRoll() 					//ExtraRoll method//
	{
		diceRollChange.roll();
	}
	
	public boolean winConditionDouble6(int d1) 			//Check if Player 1 or 2 rolls a double pair of 6//
	{
		if (d1==6)
		{
			return true;
		}
		return false;
	}
	
	public boolean winCondition40plus(int d1) 			//Check if Player 1 or 2 is above 40 points//
	{
		if (d1>1)
		{
			if(diceRollChange.DiceSumTotal()>= 40)
			{
				return true;
			}
		}
		return false;
	}
}
