package ticTacToe;

import java.util.Random;
import java.util.Scanner;

public class RowAI extends Player{
	int range, winLength;
	Grid g;
	int x,y;
	Random rand;
	

	public RowAI(String name, char sign, int range, int winLength, Grid g) {
		super("Row AI " + name, sign);
		this.range = range;
		this.winLength = winLength;
		this.g = g;
		x = 0;
		y = 0;
	}
	
	public Move move(Scanner input) {
		
		for(int tempX = 0; tempX < range; tempX++) {
			for(int tempY = 0; tempY < range; tempY++) {
							
				if(g.getCharAtPosition(tempX, tempY) == 0) {
					x = tempX;
					y = tempY;
					
					return new Move(x,y,this.sign);
				}
				else if(g.getCharAtPosition(tempX, tempY) != sign) {
					if(tempY + winLength > range) {
						break;
					}
				}
				
			}
		}
		
		// last resort
		rand = new Random();
		x = rand.nextInt(range);
		y = rand.nextInt(range);
		
		return new Move(x,y,this.sign);
	}
	
	
	

}
