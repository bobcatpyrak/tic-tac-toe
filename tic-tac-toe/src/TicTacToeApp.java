//import Console;

public class TicTacToeApp 
{

	public static void main(String[] args) 
	{
		System.out.println("Welcome to the Tic Tac Toe App\n");
		
		boolean loop = true;
		boolean gameOver = false;
		boolean xTurn = true;
		boolean tie = false;
		int turns = 0;
		String[][] board = new String[3][3];
		
		while (loop)
		{
			tie = false;
			gameOver = false;
			turns = 0;
			board = newGame();
			while (!gameOver)
			{
				if(turns == 9)
				{
					tie = true;
					gameOver = true;
					break;
				}
				displayBoard(board);
				board = takeTurn(board, xTurn);
				gameOver = checkWin(board);
				xTurn = !xTurn;
				turns++;
			}
			displayBoard(board);
			System.out.println("Game Over!");
			if(!tie)
			{
				if(!xTurn)
					System.out.println("X wins!");
				else
					System.out.println("O wins!");
			}
			else
				System.out.println("It's a cat game!");

			loop = Console.getYesOrNo("Play again? (y/n): ");
		}
		
		System.out.println("\nBye");
		
	}

	public static void displayBoard(String[][] board)
	{
		System.out.println("+---+---+---+");
		System.out.println("| " + board[0][0] + " | " + board[0][1] + " | " + board[0][2] + " |");
		System.out.println("+---+---+---+");
		System.out.println("| " + board[1][0] + " | " + board[1][1] + " | " + board[1][2] + " |");
		System.out.println("+---+---+---+");
		System.out.println("| " + board[2][0] + " | " + board[2][1] + " | " + board[2][2] + " |");
		System.out.println("+---+---+---+");
	}
	
	public static String[][] newGame()
	{
		String[][] board = {{" ", " ", " "},
						   {" ", " ", " "},
						   {" ", " ", " "}};
		return board;
	}
	
	public static String[][] takeTurn(String[][] board, boolean xTurn)
	{
		int row = 0;
		int col = 0;
		
		if(xTurn)
		{
			System.out.println("X's turn");
			row = Console.getInt("Pick a row (1, 2, 3): ", 1, 3) - 1;
			col = Console.getInt("Pick a column (1, 2, 3): ", 1, 3) - 1;
			
			if(board[row][col].equals(" "))
				board[row][col] = "X";
			else
			{
				System.out.println("That space is already taken. Try again.");
				board = takeTurn(board, xTurn);
			}
		}
		else
		{
			System.out.println("O's turn");
			row = Console.getInt("Pick a row (1, 2, 3): ", 1, 3) - 1;
			col = Console.getInt("Pick a column (1, 2, 3): ", 1, 3) - 1;
			
			if(board[row][col].equals(" "))
				board[row][col] = "O";
			else
			{
				System.out.println("That space is already taken. Try again.");
				board = takeTurn(board, xTurn);
			}
		}
		
		return board;
	}
	
	private static boolean checkWin(String[][] board)
	{
		if (board[0][0].equals("X") &&
				board[0][1].equals("X") &&
				board[0][2].equals("X"))
			return true;
		else if (board[1][0].equals("X") &&
				board[1][1].equals("X") &&
				board[1][2].equals("X"))
			return true;
		else if (board[2][0].equals("X") &&
				board[2][1].equals("X") &&
				board[2][2].equals("X"))
			return true;
		else if (board[0][0].equals("X") &&
				board[1][0].equals("X") &&
				board[2][0].equals("X"))
			return true;
		else if (board[0][1].equals("X") &&
				board[1][1].equals("X") &&
				board[2][1].equals("X"))
			return true;
		else if (board[0][2].equals("X") &&
				board[1][2].equals("X") &&
				board[2][2].equals("X"))
			return true;
		else if (board[0][0].equals("X") &&
				board[1][1].equals("X") &&
				board[2][2].equals("X"))
			return true;
		else if (board[0][2].equals("X") &&
				board[1][1].equals("X") &&
				board[2][0].equals("X"))
			return true;
		if (board[0][0].equals("O") &&
				board[0][1].equals("O") &&
				board[0][2].equals("O"))
			return true;
		else if (board[1][0].equals("O") &&
				board[1][1].equals("O") &&
				board[1][2].equals("O"))
			return true;
		else if (board[2][0].equals("O") &&
				board[2][1].equals("O") &&
				board[2][2].equals("O"))
			return true;
		else if (board[0][0].equals("O") &&
				board[1][0].equals("O") &&
				board[2][0].equals("O"))
			return true;
		else if (board[0][1].equals("O") &&
				board[1][1].equals("O") &&
				board[2][1].equals("O"))
			return true;
		else if (board[0][2].equals("O") &&
				board[1][2].equals("O") &&
				board[2][2].equals("O"))
			return true;
		else if (board[0][0].equals("O") &&
				board[1][1].equals("O") &&
				board[2][2].equals("O"))
			return true;
		else if (board[0][2].equals("O") &&
				board[1][1].equals("O") &&
				board[2][0].equals("O"))
			return true;
		else
			return false;
	}
	
	
}
