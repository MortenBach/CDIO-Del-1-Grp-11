
public class DiceRoll {
	private int diceSumTotal, dices[] = new int[2], diceSum;
	
	public DiceRoll()
	{
	}
	public int[] roll()									// method roll dices
	{ 
		dices[0] = (int) (Math.random() * 6) + 1;
		dices[1] = (int) (Math.random() * 6) + 1;
		return dices;
	}
	public int addDiceSum()								// sum of the to dices
	{
		diceSum = dices[0] + dices[1];
		return diceSum;
	}
	public int sum()									// total sum of the dice rolls
	{
		diceSumTotal += diceSum;
		return diceSumTotal;
	}
	public void setSum(int reset)						// reset of the total sum (private instance value)
	{
		diceSumTotal = reset;
	}
	public int getSum()									// to get the sum method (private instance value)
	{
		return diceSumTotal;
	}
	public String toString()							
	{
		String pt;
		pt = "Dice1: " + dices[0] + " Dice2: " + dices[1] + " Sum: " + diceSumTotal + "";
		return pt;
	}
}
