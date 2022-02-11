package ticTacToe;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.HashMap;

public class Game {

	public static void main(String[] args) {
		int size = 3; //Grid Size
		int winLength = 3; // Win condition
		Grid g = new Grid(size, winLength);
		
		
		// New players here
		Player p1 = new RandomAI("Franta", 'X', size);
		//Player p1 = new Player("Franta", 'X');
		Player p2 = new RowAI("Pepa", 'O', size, winLength, g);
		//Player p3 = new RandomAI("Lojza", '8', size);
		//Player p4 = new RandomAI("Tonda", '*', size);
		Scanner input = new Scanner(System.in);
		

		//Add every player to the pool
		ArrayList<Player> playerPool = new ArrayList<Player>();
		playerPool.add(p1);
		playerPool.add(p2);
		//playerPool.add(p3);
		//playerPool.add(p4);
		int playerCount = 0;
		
				
		
		
		// multiple games loop
		HashMap<Character, Integer> victoryScore = new HashMap<Character, Integer>();
		for(Player p: playerPool) {
			victoryScore.put(p.sign, 0);
		}
		
		//gameloop
		for(int games = 0; games < 100; games++) { //number of games in row
			while(!g.over()) {
			
				clearScreen();
				g.drawGrid();
			
				System.out.println(" Player " + playerPool.get(playerCount).getName() + ", it's Your turn. Give x and y coordinates:");
			
			
				if(g.checkBox(playerPool.get(playerCount).move(input)) == false) {
					playerCount--; //znovu hraje ten samy hrac
					System.out.println("Wrong coordinates. Please give coordinates to not taken field thats in bounds of the grid");
				
				}
			
				playerCount++;
				if (playerCount == playerPool.size()) {playerCount = 0;}
			
			}// end while
		
			g.drawGrid();
			System.out.println("Game Over. Winner is: " + g.getWinner());
			g.resetGame();
			
			victoryScore.put(g.getWinnerChar(), victoryScore.get(g.getWinnerChar()) + 1);
		
		}// end for
		
		for (Character i : victoryScore.keySet()) {
			  System.out.println("player: " + i + " wins: " + victoryScore.get(i));
			}
		
		
		input.close();

	}
	
	private static void clearScreen() {
		//clear screen, zjistit jak.
	}

}
