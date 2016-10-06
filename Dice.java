package Spil;

import java.math.*;

public class Dice {

	public Dice() {

	}

	public int roll() {

		int MAX = 6;

		int diceEyes = (int) ((Math.random() * MAX) + 1);
		return diceEyes;

	}

}
