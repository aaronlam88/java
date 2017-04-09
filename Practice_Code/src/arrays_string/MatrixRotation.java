package arrays_string;

public class MatrixRotation {
	// rotate n x n matrix 90 degree clockwise
	public void rotate(int[][] matrix, int n) {
		for (int layer = 0; layer < n / 2; ++layer) {
			int first = layer;
			int last = n - 1 - layer;

			for (int i = first; i < last; ++i) {
				int offset = i - first;

				// save top
				int top = matrix[first][i];

				// left -> top
				matrix[first][i] = matrix[last - offset][first];

				// bottom -> left
				matrix[last - offset][first] = matrix[last][last - offset];

				// right -> bottom
				matrix[last][last - offset] = matrix[i][last];

				// top ->right
				matrix[i][last] = top;
			}
		}
	}

	public void print2DArray(int[][] matrix, int n) {
		for (int i = 0; i < n; ++i) {
			for (int j = 0; j < n; ++j) {
				System.out.print(matrix[i][j]);
				if (j < (n - 1)) {
					System.out.print(" ");
				}
			}
			System.out.print("\n");
		}
	}

	public static void main(String[] args) {
		MatrixRotation test = new MatrixRotation();

		int n = 8;
		int[][] matrix = new int[n][n];

		for (int i = 0; i < n; ++i) {
			for (int j = 0; j < n; ++j) {
				matrix[i][j] = (i + 1) * 10 + j + 1;
			}
		}

		test.print2DArray(matrix, n);

		System.out.println("=======rotate=======");
		test.rotate(matrix, n);

		test.print2DArray(matrix, n);
	}

}
