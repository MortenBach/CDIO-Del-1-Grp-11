package dicerollpointsandsum;

public class Player {
	
	private String name;
	private int sum;
	
	
	public Player(String name) {
		this.name = name;
	}
	
	
	public String toString() {
		return name;
	}
	
	public String getName() {
		return this.name;
	}
	

	public int getSum() {
		return sum;
	}

	public void setSum(int sum) {
		//this.sum er en reference til klassens sum, som vi opdaterer løbende
		
		this.sum += sum;
		
		}
}