
public class Connect4Grid2DArray implements Connect4Grid
{
	private char[][] board;
	private static final int BOARD_WIDTH=7;
	private static final int BOARD_HEIGHT=6;
	public static final char BLANK=' ';
	Connect4Grid2DArray()
	{
		board=new char[BOARD_WIDTH][BOARD_HEIGHT];
	}

	public void emptyGrid() 
	{
		for(int column=0; column<board.length; column++)
			for(int row=0; row<board[column].length; row++)
				board[column][row]=BLANK;
	}
	public String toString()
	{
		String output="";


		for(int row=0;row<board[0].length; row++)
		{
			int column=0;
			output+=("| ");
			while(column<board.length)
			{
				output+=(board[column][row]+" | ");
				column++;
			}
			output+="\n";
		}



		output+=("-----------------------------"
				+ "\n| 0 | 1 | 2 | 3 | 4 | 5 | 6 |");
		return output;
	}
	public boolean isValidColumn(int column) {
		if(column>=0 && column<BOARD_WIDTH && !isColumnFull(column))
			return true;
		else
			return false;
	}


	public boolean isColumnFull(int column) 
	{
		for (char piece: board[column])
		{
			if(piece==BLANK)
				return false;
		}
		return true;
	}


	public void dropPiece(ConnectPlayer player, int column) 
	{
		if(isValidColumn(column))
		{
			int dropRow=placeOnTopOf(column);
			board[column][dropRow]=player.getPiece();
		}

	}
	private int placeOnTopOf(int column) // allows the next piece to be placed on top of a current piece
	{
		for(int row=0; row<board[column].length; row++)
		{
			if(board[column][row]!=BLANK)
				return row-1;
		}
		return board[column].length-1;
	}



	public boolean didLastPieceConnect4() 
	{
		char player;
		for(int column=board.length-1; column>0; column--)
		{
			for( int row=0; row<board[column].length ;row++)
			{
				player=board[column][row];
				if(player!=BLANK)
				{
					if(row < board[column].length-3)
					{
						if(player==board[column][row+1] && player==board[column][row+2]&&player==board[column][row+3])
							return true;//check vertical
					}

					else if (row<board[column].length-3 && column<board.length-3)
					{
						if(player==board[column+1][row+1]&player==board[column+2][row+2]&&player==board[column+3][row+3])
							return true;//check down diagonal
					}

					else if (column<2)
					{
						if(player==board[column+1][row-1]&player==board[column+2][row-2]&&player==board[column+3][row-3])
							return true;//check up diagonal
					}

					else if (column<board.length-3)
					{
						if(player==board[column+1][row]&&player==board[column+2][row]&&player==board[column+3][row])
							return true;//check horizontal
					}
				}
			}

		}
		return false;
	}


	public boolean isGridFull() {
		for(int column = 0; column<board[0].length;column++)
		{
			if(board[0][column]==BLANK)
			{
				return false;
			}
		}
		return true;
	}

}
