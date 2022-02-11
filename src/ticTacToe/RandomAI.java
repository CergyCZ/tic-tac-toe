package ticTacToe;

import java.util.Random;
import java.util.Scanner;

public class RandomAI extends Player {
	int range;
	Random rand;
	
	public RandomAI(String name, char sign, int range) {
		super("Random AI " + name, sign);
		this.range = range;
		rand = new Random();
	}
	
	
	public Move move(Scanner input) {
		//scanner je k nicemu u AI
		int x = rand.nextInt(range);
		int y = rand.nextInt(range);
		
		System.out.println(this.getName() + " places " + this.getSign() + " to " + x + "x" + y);
		return new Move(x, y, this.sign);
	}
	
	

}
