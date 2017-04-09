package moderate;

public class Tic_Tac_Toe {
	// board set up:
	// 0 for empty
	// 1 for blue
	// 2 for red

	public boolean hasWon(int[][] board, int winCondition) {
		int winCount = 0;

		int rows = board.length;
		if (rows == 0) {
			System.out.println("Wrong board size (row = 0)!");
			return false;
		}

		int cols = board[0].length;

		for (int row = 0; row < rows; ++row) {
			for (int col = 1; col < cols; ++col) {
				// if cell not empty
				if (board[row][col] != 0) {
					// check the next winCondition cells
					for (winCount = 0; col < cols && winCount < winCondition; ++winCount, ++col) {
						if (board[row][col] != board[row][col - 1])
							break;
					}
					if (winCount >= winCondition)
						return true;
				}
			}
		}

		for (int col = 0; col < cols; ++col) {
			for (int row = 1; row < rows; ++row) {
				if (board[row][col] != 0) {
					for (winCount = 0; row < rows && winCount < winCondition; ++winCount, ++rows) {

					}
				}
			}
		}

		return false;
	}

	public static void main(String[] args) {

	}

}
