package dicerollpointsandsum;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Controller {
	
	//Instance variabler skal være private
	
	private Dice die = new Dice();			// Laver et nyt objekt af klassen Dice
	private int roll1 = 0;	 				// Laver to lokale variable, der indeholder to separate værdier
	private int roll2 = 0;					// af die.roll();
	private int diceEyes;					// Laver en diceEyes variabel, vi bruger i game() metoden.
	
	private Player Player1;														
	private Player Player2;
	
	private int i = 0;												// Reserverer plads til int i og initialiserer til 0.			
	private List<Player> Players = new ArrayList<Player>(); 		//Laver en Arrayliste, der kan indeholde referencer til objekter af Player
	private Player tempPlayer;
	
	
	private boolean win = false;									//Laver et boolean udtryk, vi bruger i vores game conditions												
	
	public Controller() { 
	
		Player1 = new Player("Player 1"); 		// Laver et objekt af klassen layer og sætter Player 1/2 ind som string i constructoren
		Player2 = new Player("Player 2");
		Players.add(Player1);					// Tiføjer spillere til listen Players
		Players.add(Player2);
		
	}
	
	//Metoden, der kører spillet
		public void game() {
		Scanner scan = new Scanner(System.in);	// Laver en scanner

		while (! win) {							// Laver en while løkke, der kører forevigt da while (true)

			if (i < Players.size()) {													// Laver et if-statement til index i, i arraylisten Players
				tempPlayer = Players.get(i);											// Laver en reference til klassen Player, vi kalder for tempPlayer. tempPlayer refererer til index i, i arrayListen Players														
				System.out.println("It's " + tempPlayer + "'s turn to roll the dice"); 	// Printer
				scan.nextLine();														// Venter på nextLine for at komme videre
				
				roll1 = die.roll();														// Sætter roll1 og roll2 lig die.roll(), men på hver sin linie, så de får hver sin værdi
				roll2 = die.roll();
				diceEyes = roll1 + roll2;												// Initialiserer diceEyes til roll1 + roll2
				winDouble40();															// Benytter metoden winDouble40()
				
					if(win) {															// Hvis win er true, stopper den while loopet
						break;																	
					}
					
			tempPlayer.setSum(roll1 + roll2);											// Opdaterer summen
			
			System.out.println("Die 1: " + roll1 + "\nDie 2: " + roll2 + "\n" 			// Print statement
					+ tempPlayer + " rolled a total of " + diceEyes + "\n" + tempPlayer 
					+ " now has " + tempPlayer.getSum() + " points\n");

				i++;																	// Inkrementerer i, hvorved vi nu får fat i den næste spiller i ArrayListen via Players.get(i)
	
				}
			if (i == Players.size()) {													// if-statement, der resetter i når den bliver lig længden af Players listen
				i = 0;
			}
		}
		}
	
	
	// Metoden til vores ene win condition
	public void winDouble40() {			
		if (roll1 == roll2) {
			if (tempPlayer.getSum() >= 40) {
				System.out.println("Die 1: " + roll1 + "\nDie 2: " + roll2 + "\n" + tempPlayer
						+ " has rolled a pair and has won the game.");
				win = true;
			}
		}

	}
}