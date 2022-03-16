
public class testSudoku {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[][] grid = { { 0, 0, 0, 0, 2, 0, 0, 0, 0 }, { 4, 0, 0, 0, 0, 0, 1, 0, 0 }, { 0, 3, 0, 6, 0, 7, 0, 0, 9 },
				{ 0, 2, 0, 0, 9, 0, 0, 0, 0 }, { 0, 0, 0, 0, 8, 0, 0, 0, 5 }, { 3, 0, 0, 2, 0, 5, 0, 4, 0 },
				{ 0, 6, 0, 5, 0, 3, 0, 0, 7 }, { 0, 0, 0, 0, 0, 8, 0, 0, 0 }, { 0, 0, 7, 0, 0, 0, 0, 9, 0 } };
		boolean solution = Sudoku.solve(grid);
		System.out.println("Solution:");
		if(solution == true) {
			Sudoku.printSolution(grid);
		}
		else {
			System.out.println("There is no solution");
		}
	}
}
