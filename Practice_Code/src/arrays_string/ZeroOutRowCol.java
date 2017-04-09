package arrays_string;

import java.util.Random;

public class ZeroOutRowCol {
	// Set a row and column of a matrix to zero if
	// a cell in that row or column contain zero
	public void setZeros(int[][] matrix) {
		// first pass to mark all the rows and column that need to be zero out
		// use 2 arrays to store the result
		int rows = matrix.length;
		int cols = matrix[0].length;
		boolean[] row = new boolean[rows];
		boolean[] col = new boolean[cols];

		for (int i = 0; i < rows; ++i) {
			for (int j = 0; j < cols; ++j) {
				if (matrix[i][j] == 0) {
					row[i] = true;
					col[j] = true;
				}
			}
		}

		// second pass to zero out the row and column
		for (int i = 0; i < rows; ++i) {
			for (int j = 0; j < cols; ++j) {
				if (row[i] || col[j]) {
					matrix[i][j] = 0;
				}
			}
		}
	}

	public static void main(String[] args) {
		ZeroOutRowCol test = new ZeroOutRowCol();
		int[][] matrix = test.getMatrix(5, 9);
		test.print2DArray(matrix);
		System.out.println("======Zero======");
		test.setZeros(matrix);
		test.print2DArray(matrix);
	}

	public int[][] getMatrix(int row, int col) {
		int[][] matrix = new int[row][col];
		Random random = new Random();

		for (int i = 0; i < row; ++i) {
			for (int j = 0; j < col; ++j) {
				matrix[i][j] = random.nextInt(5);
			}
		}

		return matrix;
	}

	public void print2DArray(int[][] matrix) {
		int row = matrix.length;
		if (row == 0) {
			System.out.println("Empty Matrix");
		}
		int col = matrix[0].length;
		for (int i = 0; i < row; ++i) {
			for (int j = 0; j < col; ++j) {
				System.out.print(matrix[i][j]);
				if (j < (col - 1)) {
					System.out.print(" ");
				}
			}
			System.out.print("\n");
		}
	}

}
