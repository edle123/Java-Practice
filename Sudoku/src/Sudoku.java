
public class Sudoku {
	// This class will solve a Sudoku given a starting grid

	public static void main(String[] args) {
		// int[][] grid = new int[9][9];
		int[][] board = { { 8, 0, 0, 0, 0, 0, 0, 0, 0 }, { 0, 0, 3, 6, 0, 0, 0, 0, 0 }, { 0, 7, 0, 0, 9, 0, 2, 0, 0 },
				{ 0, 5, 0, 0, 0, 7, 0, 0, 0 }, { 0, 0, 0, 0, 4, 5, 7, 0, 0 }, { 0, 0, 0, 1, 0, 0, 0, 3, 0 },
				{ 0, 0, 1, 0, 0, 0, 0, 6, 8 }, { 0, 0, 8, 5, 0, 0, 0, 1, 0 }, { 0, 9, 0, 0, 0, 0, 4, 0, 0 } };
		int[][] board2 = { { 8, 8, 0, 0, 0, 0, 0, 0, 0 }, { 0, 0, 3, 6, 0, 0, 0, 0, 0 }, { 0, 7, 0, 0, 9, 0, 2, 0, 0 },
				{ 0, 5, 0, 0, 0, 7, 0, 0, 0 }, { 0, 0, 0, 0, 4, 5, 7, 0, 0 }, { 0, 0, 0, 1, 0, 0, 0, 3, 0 },
				{ 0, 0, 1, 0, 0, 0, 0, 6, 8 }, { 0, 0, 8, 5, 0, 0, 0, 1, 0 }, { 0, 9, 0, 0, 0, 0, 4, 0, 0 } };
		boolean solution = solve(board);
		System.out.println("Solution:");
		if(solution == true) {
			printSolution(board);
		}
		else {
			System.out.println("There is no solution");
		}
		boolean solution2 = solve(board2);
		System.out.println("Solution:");
		if(solution2 == true) {
			printSolution(board2);
		}
		else {
			System.out.println("There is no solution");
		}
		
	}

	/*
	 * This method will check whether a value is valid at a certain place on the
	 * grid by checking whether that value is found on the same row, column, or 3x3
	 * block
	 */
	public static boolean isValid(int[][] grid, int i, int j, int value) {

		// Sets value of row and column to the two int values taken in as parameters
		int row = i;
		int col = j;

		// Checks for value in same row
		for (int a = 0; a <= 8; a++) {
			if (a == col) {
				continue;
			}
			if (grid[row][a] == value) {
				return false;
			}
		}
		// Checks for value in same column
		for (int a = 0; a <= 8; a++) {
			if (a == row) {
				continue;
			}
			if (grid[a][col] == value) {
				return false;
			}
		}

		// Checking for value in same 3x3 block
		// Checks row from 0-2
		if (row <= 2) {
			// Checks column from 0-2
			if (col <= 2) {
				for (int a = 0; a <= 2; a++) {
					for (int b = 0; b <= 2; b++) {
						if (a == row && b == col) {
							continue;
						}
						if (grid[a][b] == value) {
							return false;
						}
					}
				}
			} // End of col 0-2 check
				// Checks column from 3-5
			else if (col > 2 && col <= 5) {
				for (int a = 0; a <= 2; a++) {
					for (int b = 3; b <= 5; b++) {
						if (a == row && b == col) {
							continue;
						}
						if (grid[a][b] == value) {
							return false;
						}
					}
				}
			} // End of col 3-5 check
				// Checks column from 6-8
			else {
				for (int a = 0; a <= 2; a++) {
					for (int b = 6; b <= 8; b++) {
						if (a == row && b == col) {
							continue;
						}
						if (grid[a][b] == value) {
							return false;
						}
					}
				}
			} // End of col 6-8 check
		} // End of row 0-2 check

		// Checks row from 3-5
		else if (row > 2 && row <= 5) {
			if (col <= 2) {
				for (int a = 3; a <= 5; a++) {
					for (int b = 0; b <= 2; b++) {
						if (a == row && b == col) {
							continue;
						}
						if (grid[a][b] == value) {
							return false;
						}
					}
				}
			} // End of col 0-2 check
				// Checks column from 3-5
			else if (col > 2 && col <= 5) {
				for (int a = 3; a <= 5; a++) {
					for (int b = 3; b <= 5; b++) {
						if (a == row && b == col) {
							continue;
						}
						if (grid[a][b] == value) {
							return false;
						}

					}
				}
			} // End of col 3-5 check
				// Checks column from 6-8
			else {
				for (int a = 3; a <= 5; a++) {
					for (int b = 6; b <= 8; b++) {
						if (a == row && b == col) {
							continue;
						}
						if (grid[a][b] == value) {
							return false;
						}
					}
				}
			} // End of col 6-8 check
		} // End of row 3-5 check
			// Checks row from 6-8
		else {
			if (col <= 2) {
				for (int a = 6; a <= 8; a++) {
					for (int b = 0; b <= 2; b++) {
						if (a == row && b == col) {
							continue;
						}
						if (grid[a][b] == value) {
							return false;
						}
					}
				}
			} // End of col 0-2 check
				// Checks column from 3-5
			else if (col > 2 && col <= 5) {
				for (int a = 6; a <= 8; a++) {
					for (int b = 3; b <= 5; b++) {
						if (a == row && b == col) {
							continue;
						}
						if (grid[a][b] == value) {
							return false;
						}
					}
				}
			} // End of col 3-5 check

			// Checks column from 6-8
			else {
				for (int a = 6; a <= 8; a++) {
					for (int b = 6; b <= 8; b++) {
						if (a == row && b == col) {
							continue;
						}
						if (grid[a][b] == value) {
							return false;
						}
					}
				}
			} // End of col 6-8 check
		} // End of row 6-8 check
		return true;
	} // End of isValid

	// Prints solved sudoku grid
	public static void printSolution(int[][] grid) {
		// Prints out row
		for (int i = 0; i <= 8; i++) {
			// Prints out column
			for (int j = 0; j <= 8; j++) {
				System.out.print(grid[i][j] + " ");
			}
			System.out.println();
		}
	} // End of printSolution()

	// Finds solution for sudoku puzzle
	public static boolean solve(int[][] grid) {
		boolean check = false;
		// Each row in column
		for (int i = 0; i <= 8; i++) {
			// Each column in row
			for (int j = 0; j <= 8; j++) {
				// If cell is blank, then fills cell with value from 1-9
				if (grid[i][j] == 0) {
					for (int a = 1; a <= 9; a++) {
						check = isValid(grid, i, j, a);
						if (check == true) {
							grid[i][j] = a;
							// Recursive backtracking
							if (solve(grid)) {
								return true;
							}
							// If there is no solution, empty the cell and continue
							else {
								grid[i][j] = 0;
							}
						}
					}
					return false;
				}
				// If cell is not empty, then skip
				else {
					continue;
				}
			} // End of column
		} // End of row
		return true;
	} // End of solve()
} // End of class
