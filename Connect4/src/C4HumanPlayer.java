import java.util.Scanner;
public class C4HumanPlayer extends ConnectPlayer
{
	C4HumanPlayer(char playerPiece)
	{
		this.piece=playerPiece;
	}
	public void collumnChoice(Connect4Grid gameBoard)
	{
		int column;
	Scanner userInput = new Scanner(System.in);
	System.out.println("Choose Column (0-6), to quit the game press ESC");
	column = userInput.nextInt();
	if(column > 6)
	{
		System.out.println("That value is outside of scope, please enter a number between 0 and 6");
	}else {
	gameBoard.dropPiece(this, column);
	}
	}
}