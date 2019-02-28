/* SELF ASSESSMENT 
   1. clearBoard:
Did I use the correct method definition?
Mark out of 5: 5
Comment: yes i did
Did I use loops to set each position to the BLANK character?
Mark out of 5: 5
Comment: Yes i made them blank
   2. printBoard
Did I use the correct method definition?
Mark out of 5: 5
Comment: was correct
Did I loop through the array and prints out the board in a way that it looked like a board?
Mark out of 5: 5
Comment: looked as it should
   3. canMakeMove
Did I have the correct function definition and returned the correct item?
Mark out of 5: 5 
Comment: yes i did
Did I check if a specified location was BLANK?
Mark out of 5: 5
Comment:yes, checked if it was blank
   4. makeMove
Did I have the correct function definition?
Mark out of 5: 5
Comment:yes  i did
Did I set the  currentPlayerPiece in the specified location?
Mark out of 5: 5
Comment:    was in correct position
   5. isBoardFull
Did I have the correct function definition and returned the correct item?
Mark out of 5: 5
Comment: yes i did       
Did I loop through the board to check if there are any BLANK characters?
Mark out of 5: 5 
Comment: yes i checked
   6. winner
Did I have the correct function definition and returned the winning character
Mark out of 5: 5
Comment:     had it correct
Did I identify all possible horizontal, vertical and diagonal winners  
Mark out of 15: 15
Comment: cvhecks all possible winners
   7.main - sample e test

Did I create a board of size 3 by 3 and use the clearBoard method to set all the positions to the BLANK character ('  ')?
Mark out of 3: 3
Comments: it was correct
Did I loop asking the user for a location until wither the board was full or there was a winner?
Mark out of 5: 5
Comments: it looped correctly
Did I call all of the methods above?
Mark out of 5: 5
Comments: were all called
Did I handle incorrect locations provided by the user (either occupied or invalid locations)?
Mark out of 3: 3
Comments: correct error handling was used
Did I switch the current player piece from cross to nought and vice versa after every valid move?
Mark out of 3: 3
Comments: switched correctly
Did I display the winning player piece or a draw at the end of the game?
Mark out of 3: 2
Comments: Unable to determine if it was a draw 

   8. Overall
Is my code indented correctly?
Mark out of 3: 3
Comments: yes i did
Do my variable names and Constants (at least four of them) make sense?
Mark out of 3: 3
Comments: yes they made sense
Do my variable names, method names and class name follow the Java coding standard
Mark out of 2:2
Comments:yes they did
      Total Mark out of 100 (Add all the previous marks): 99
*/

import java.util.Scanner;

public class xandos {
	
	public static final char BLANK = ' ';
	public static final char NOUGHT = 'O';
	public static final char CROSS = 'X';
	public static final char NO_PIECE = ' ';
	public static final int BOARD_SIZE = 3;
	public static final int NUMBER_OF_SPACES = 9;
	public static void main(String[] args) {
	char[][] board = new char[BOARD_SIZE][BOARD_SIZE];
	clearBoard( board );
	char currentPlayerPiece = CROSS;
	 Scanner input = new Scanner(System.in);
	 boolean continued = true;
      while ((!isBoardFull(board)) && (winner(board) == BLANK))
	 {
	 printBoard(board, currentPlayerPiece);
	 int row=-1;
	 int column=-1;
	 do
	 {
	 System.out.print("Enter move for " + currentPlayerPiece +  " (e.g. B2 is the center piece on the board) : ");
	 char[] inputCharacters = input.next().toCharArray();
	 if ((inputCharacters.length >= 2) &&
	 (inputCharacters[0] >= 'A') && (inputCharacters[0] <= 'C') &&
	 (inputCharacters[1] >= '1') && (inputCharacters[1] <= '3'))
	 {
	 row = (int) (inputCharacters[0]-'A');
	 column = (int) (inputCharacters[1]-'1');
	 if (!canMakeMove(board,row,column))
	 System.out.println(" Invalid entry. This location is already occupied.");
	 }
	 else System.out.println(" Invalid entry. You must enter a row and column  (e.g. B2 is the center piece on the board).");
	 } while ((row == -1) || (!canMakeMove(board,row,column)));
	 makeMove(board,currentPlayerPiece,row,column);
	 currentPlayerPiece = (currentPlayerPiece==CROSS)?NOUGHT:CROSS;
	 }
	printBoard(board, currentPlayerPiece);
	if (winner(board) == BLANK)
	 System.out.println("It was a draw.");
	else System.out.println("The winner was " + winner(board));
	input.close();
	
	}


	
	
		public static void clearBoard(char[][]board)
		{
			for (int row = 0; (row < board.length); row++)
				for (int column = 0; (column < board[row].length); column++)
					board[row][column] = BLANK;
		}
		public static void printBoard(char[][]board, char currentPlayerPiece) {
		
			
		for (int i = 0; i < BOARD_SIZE; i++) {
			for (int x = 0; x < BOARD_SIZE; x++) {
				if (i > 0 && x == 0) {
					System.out.print("- + - + -\n");
				}
				System.out.print(board[i][x]);
				if (x < BOARD_SIZE-1) {
					System.out.print(" | ");
				}
				if (x == BOARD_SIZE-1) {
					System.out.print("\n");
				}
			}
		}	
	}

		
		
		public static boolean canMakeMove(char[][]board, int row, int column)
		{
			if(board[row][column] == BLANK )
			{ 
				return true;
			}
				else {
					return false;
			}
			
		}
		public static void makeMove(char[][] board, char currentPlayerPiece, int row, int column)
		{
			
			
			board[row][column] = currentPlayerPiece;
			
			
			
		}
		public static boolean isBoardFull( char[][] board) 
		{
			int count = 0;
			for(int row = 0; row < board.length ; row++ )
			{
				for(int column = 0; column < board[0].length; column++)
				{
					{
						count++;
					}
				}
			}
			if(count >= 1)
			{
				return false;
			}
			else 
				return true; 
			}    	
		
		public static char winner (char[][] board)
		{
			if(board[0][0] == board[0][1] && board[0][0] == board[0][2]){
				return board[0][0];
			}
			if(board[1][0] == board[1][1] && board[1][0] == board[1][2]){
				return board[1][0];
			}
			if(board[2][0] == board[2][1] && board[2][0] == board[2][2]){
				return board[2][0];
			}
			if(board[0][0] == board[1][0] && board[0][0] == board[2][0]){
				return board[0][0];
			}
			if(board[0][1] == board[1][1] && board[0][1] == board[2][1]){
				return board[0][1];
			}
			if(board[0][2] == board[1][2] && board[0][2] == board[2][2]){
				return board[0][2];
			}
			if(board[0][0] == board[1][1] && board[0][0] == board[2][2]){
				return board[0][0];
			}
			if(board[0][2] == board[1][1] && board[0][2] == board[2][0]){
				return board[0][2];
			}

			return ' ';
		}

		}
		
		
		
		
	
