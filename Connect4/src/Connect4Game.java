/* SELF ASSESSMENT

Connect4Game class (35 marks)
My class creates references to the Connect 4 Grid and two Connect 4 Players. It asks the user whether he/she would like to play/quit inside a loop. If the user decides to play then: 1. Connect4Grid2DArray is created using the Connect4Grid interface, 2. the two players are initialised - must specify the type to be ConnectPlayer, and 3. the game starts. In the game, I ask the user where he/she would like to drop the piece. I perform checks by calling methods in the Connect4Grid interface. Finally a check is performed to determine a win. 
Comment: 35 - Asks what the user wants to do. Then proceds to take user input and keeps taking it until either the board is full or else there is a winner

Connect4Grid interface (10 marks)
I define all 7 methods within this interface.
Comment: 10 - defined all 7 methods within the interface

Connect4Grid2DArray class (25 marks) 
My class implements the Connect4Grid interface. It creates a grid using a 2D array Implementation of the method to check whether the column to drop the piece is valid. It provides as implementation of the method to check whether the column to drop the piece is full. It provides as implementation of the method to drop the piece.  It provides as implementation of the method to check whether there is a win.
Comment: 25 - creates the 2D array grid. it also implements the 7 methods which were defined within the interface with all methods working correctly. An extra method was also used to allow the player to place a piece on top of another piece.

ConnectPlayer abstract class (10 marks)
My class provides at lest one non-abstract method and at least one abstract method. 
Comment:10 - has one abstract method and one non-abstract method for collumn choice and get piece

C4HumanPlayer class (10 marks)
My class extends the ConnectPlayer claas and overrides the abstract method(s). It provides the Human player functionality.
Comment: 10 - it extends the ConnectPlayer class and provides human functionality 

C4RandomAIPlayer class (10 marks)
My class extends the ConnectPlayer claas and overrides the abstract method(s). It provides AI player functionality. 
Comment: 0 - I was unable to make AI player functionality

Total Marks out of 100: 90

*/

import java.util.Scanner;

public class Connect4Game {
	public static final char CROSSES = 'x';
	public static final char NOUGHTS = 'o';
	public static final char BLANK = ' ';
	static ConnectPlayer player1, player2;

	public static void main(String[] args) {
		Connect4Grid gameBoard = new Connect4Grid2DArray();
		player1 = new C4HumanPlayer(CROSSES);
		player2 = new C4HumanPlayer(NOUGHTS);
		Scanner userInput = new Scanner(System.in);
		System.out.print("Would you like to play or quit?");
		if (userInput.hasNext("quit")) {
			System.out.println("Ok goodbye");
		} else if (userInput.hasNext("play")) {
			System.out.println(gameBoard.toString());
			gameBoard.emptyGrid();
			ConnectPlayer winner = null;
			while (winner == null && !gameBoard.isGridFull()) {
				player1.collumnChoice(gameBoard);

				if (gameBoard.didLastPieceConnect4()) {
					winner = player1;
				}
				System.out.println(gameBoard.toString());
				player2.collumnChoice(gameBoard);
				if (gameBoard.didLastPieceConnect4()) {
					winner = player2;
				}

				System.out.println(gameBoard.toString());
			}
			System.out.println("Well done " + winner + " is the winner");
			if (winner == player1)
				System.out.print("X");
			else if (winner == player2)
				System.out.print("O");

		}
		else {
			System.out.println("Invalid answer");
		}

	}
}