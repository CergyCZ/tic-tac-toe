package ticTacToe;

public class Grid {
	private int size, winLength;
	private char[][] grid;
	private String winner;
	private boolean gameOver;
	private char winnerChar;
	
	
	
	public Grid (int size, int winLength) {
		this.size = size;
		this.winLength = winLength;
		grid = new char[size][size];
		gameOver = false;
		winner = new String("nobody");
	}
	
	public void drawGrid() {
		// vykresli celou mrizku i s vyplnenymi policky
		drawLine();
		
		for(char[] x: grid) {
			System.out.print("|");
			for(char y: x) {
				if(y == 0) {System.out.print(" ");}
				else {System.out.print(y);}
			}
			System.out.println("|");
		}
		
		drawLine();	
	}
	
	public boolean checkBox (int x, int y, char i){
		if(x > size || x < 0) {return false;}
		if(y > size || y < 0) {return false;}
		
		if(grid[x][y] == 0) {
			grid[x][y] = i;
			return true;
		}
		else return false;
	}
	
	public boolean checkBox (Move m){
		return this.checkBox(m.getX(), m.getY(), m.getSign());
	}
	
	private void drawLine() {
		System.out.print(" ");
		for(int i = 0; i < size; i++) {
			System.out.print("-");
		}
		System.out.println();
	}
	
	public void checkWinner() {
		char winningChar = 'a';
		int winningCount = 0;
		
		for(int y = 0; y < size; y++) {
			for(int x = 0; x < size; x++) {
				winningChar = getCharAtPosition(x, y);
				//System.out.println("Wchar: " + winningChar + " pos: " + x + "x" + y + " wcount: " + winningCount);
				if(winningChar == '|' || winningChar == 0) {winningChar = 'a';} //pokud je prazdny nebo out of bound
				
				// row
				winningCount = 1;
				while(getCharAtPosition(x, y + winningCount) == winningChar) { 
					winningCount++;
					//System.out.println("rows: " + x +"x" + (y + winningCount) + " wincount: " + winningCount);
					if(winningCount == winLength) {
						gameOver = true;
						winner = winningChar + ", victory in row.";
						winnerChar = winningChar;
						break; 
						}
				}
				
				// column
				winningCount = 1;
				while(getCharAtPosition(x + winningCount, y) == winningChar) {
					winningCount++;
					if(winningCount == winLength) {
						//System.out.println("columns: " + (x + winningCount) +"x" + y + " wincount: " + winningCount);
						gameOver = true;
						winner = winningChar + ", victory in column.";
						winnerChar = winningChar;
						break;
						}
				}
				
				// diagonal 1
				winningCount = 1;
				while(getCharAtPosition(x + winningCount, y + winningCount) == winningChar) {
					winningCount++;
					if(winningCount == winLength) {
						gameOver = true;
						winner = winningChar + ", victory in diagonal 1.";
						winnerChar = winningChar;
						break;
						}
				}
				
				
				// diagonal 1
				winningCount = 1;
				while(getCharAtPosition(x + winningCount, y - winningCount) == winningChar) {
					winningCount++;
					if(winningCount == winLength) {
						gameOver = true;
						winner = winningChar + ", victory in diagonal 2.";
						winnerChar = winningChar;
						break;
						}
				}
				
				
			}
			
		}
		
		
		
	}
	
	private boolean gridFull() {
		//kontroluje zaplneni gridu. Pri plnem konci hra.
		for(char[] x: grid) {
			for(char y: x) {
				if(y == 0) {return false;}

			}
		}
		gameOver = true;
		return true;
	}

	public int getSize() {
		return size;
	}

	public boolean over() {
		checkWinner();
		gridFull();
		return gameOver;
	}
	
	public char getCharAtPosition(int x, int y) { // | is invalid char, returned when out of bounds
		if(x >= size) {return '|';}
		if(y >= size) {return '|';}
		if(x < 0) {return '|';}
		if(y < 0) {return '|';}
		else return grid[x][y];
	}

	public String getWinner() {
		return winner;
	}

	
	public char getWinnerChar() {
		return winnerChar;
	}

	public void resetGame() {
		
		//empty grid
		for(int y = 0; y < size; y++) {
			for(int x = 0; x < size; x++) {
				grid[x][y] = 0;
			}
			
		}
		System.out.println("Grid emptied");
		
		gameOver = false;
		winner = new String("nobody");
		
	}
	
	
	

}
