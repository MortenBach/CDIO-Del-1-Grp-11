package Spil;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Controller {
	
	//Instance variabler skal være private
	
	private Dice die = new Dice();										// Laver et nyt objekt af klassen Dice.
	private int roll1;	 										// Reserverer plads til to integers, der senere skal indeholde to separate værdier af die.roll().
	private int roll2;												
	private int diceEyes;											// Reserver plads til en integer, vi kalder diceEyes variabel. Denne kommer senere til at indeholde roll1 + roll2.
	
	private Player Player1;											// Reserverer plads til to objekter af Player.
	private Player Player2;
	
	private int i = 0;											// Reserverer plads til int i og initialiserer til 0.			
	private List<Player> Players = new ArrayList<Player>(); 						// Laver en Arrayliste, der skal indeholde referencer til objekter af Player.
	private Player tempPlayer;										// Reserverer plads til et objekt af Player, vi kalder tempPlayer. Denne bruges senere som reference til både Player1 og Player2.
	
	private boolean checkSixes = false;									// Laver to boolean udtryk, vi bruger i vores game conditions.
	private boolean win = false;																					
	
	public Controller() { 
	
		Player1 = new Player("Player 1");						 		// Laver to objekter af Player.
		Player2 = new Player("Player 2");
		Players.add(Player1);										// Tilføjer objekterne til listen Players.
		Players.add(Player2);
		
	}
	
	//Metoden, der kører spillet
		public void game() {
		Scanner scan = new Scanner(System.in);								// Laver en scanner.

		while (! win) {											// Laver en while løkke, der kører så længe !win.

			if (i < Players.size()) {								// Laver et if-statement til index i, i arraylisten Players.
				tempPlayer = Players.get(i);							// Laver en reference til klassen Player. tempPlayer refererer til index i, i arrayListen Players.													
				System.out.println("It's " + tempPlayer + "'s turn to roll the dice"); 		// Printer.
				scan.nextLine();								// Venter på nextLine for at komme videre.
				roll1 = die.roll();								// Sætter roll1 og roll2 lig die.roll(), men på hver sin linie, så de får hver sin værdi.
				roll2 = die.roll();
				diceEyes = roll1 + roll2;							// Initialiserer diceEyes til roll1 + roll2.
				extraTurn();
				winDouble40();									// Benytter metoden winDouble40().
				sixes();
				
					if(win) {								// Hvis win er true, stopper den while loopet.
						break;	
					}
					
				tempPlayer.setSum(roll1 + roll2);						// Opdaterer summen.
				ones();
				System.out.println("Die 1: " + roll1 + "\nDie 2: " + roll2 + "\n" 		// Print statement.
					+ tempPlayer + " rolled a total of " + diceEyes + "\n" + tempPlayer 
					+ " now has " + tempPlayer.getSum() + " points\n");
				
				i++;										// Inkrementerer i, hvorved vi nu får fat i den næste spiller i ArrayListen via Players.get(i).
	
				}
			if (i == Players.size()) {								// if-statement, der resetter i når den bliver lig længden af Players listen.
				i = 0;
			}
		}
		scan.close();											// Lukker scanneren.
		}
	
	
	// Metoden til vores ene win condition
	public void winDouble40() {																
			if (tempPlayer.getSum() >= 40 && roll1 != 1) {						// if-statement, der evaluerer om spilleren har 40 point eller mere og om der er slået en etter (to ettere nulstiller point).
				if(roll1 == roll2) {								// if-statement, der evaluerer om roll1 = roll2.											
				System.out.println("Die 1: " + roll1 + "\nDie 2: " + roll2 			// Print.
								+ "\n" + tempPlayer + " has won the game.");
				win = true;									// win sættes til true og spillet slutter.
				}
			}
	}

	// Metode til ekstra-tur
	public void extraTurn() {
		if (roll1 == roll2) {										// if-statement, der evaluerer om roll1 == roll2.
			i--;																			// Hvis roll1 == roll2 dekrementeres i, og spilleren får en tur til.
		}
	}
	
	// Metode til anden win condition
	public void sixes() {																	
		if (roll1 == 6 && roll2 == 6) {									// if-statement, der evaluerer om der er slået to seksere.
			if (checkSixes == true) {								// if-statement, der evaluerer om checkSixes == true.
				System.out.println(tempPlayer + " has won the game.");				// Print.
				win = true;									// win = true og spillet slutter.

			} else {
				checkSixes = true;								// ellers sættes checkSixes til true.
			}
		} else {
			checkSixes = false;									// Hvis der ikke er slået to seksere sættes checkSixes til false.
		}
	}

	// Metode til point nulstilling
	public void ones() {
		if (roll1 == 1 && roll2 == 1) {									// if-statement, der evaluerer om der er slået to ettere.
			tempPlayer.setSum(-tempPlayer.getSum());						// Sætter summen til -tempPlayer.getSum() og summen nulstilles.
		}
	}
}
