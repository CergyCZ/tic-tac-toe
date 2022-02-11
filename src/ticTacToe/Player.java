package ticTacToe;

import java.util.Scanner;

public class Player {
	String name;
	char sign;
	
	public Player (String name, char sign) {
		this.name = name;
		this.sign = sign;
	}

	public String getName() {
		return name;
	}

	public char getSign() {
		return sign;
	}
	
	public Move move(Scanner input) {
		int x = -1;
		int y = -1;
		try {
			x = input.nextInt();
			y = input.nextInt();
			} catch (Exception e) {
				System.out.println("Error getting coordinates. Please give whole numbers X[space]Y in bounds.");
				e.printStackTrace();
			}
		return new Move(x,y, this.sign);
	}
	
	

}
