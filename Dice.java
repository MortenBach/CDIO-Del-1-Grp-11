import java.util.Scanner;

public class Dice {
	public static void main(String[] args) {

		int p1sum1 = 0, p2sum2 = 0, total = 0, p1roll;
		
		DiceRoll p1 = new DiceRoll();
		DiceRoll p2 = new DiceRoll();
		
		while (true) // infinite loop//
		{
			Scanner scanner = new Scanner(System.in);
			
			p1roll = p1.dice
//			p1sum1 += p1.dsum;
//			p2sum2 += p2.dsum;
			total += p1.GetSum();
			
			scanner.nextLine();
			System.out.println("Player1: " + p1);
			System.out.println("Player1 total points: " + p1.GetSum());
			scanner.nextLine();
			System.out.println("Player2: " + p2);
			System.out.println("Player2 total points: " + p2.GetSum());
			scanner.nextLine();
		}
	}
}
