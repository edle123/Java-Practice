Sudoku.java
This program solves a sudoku puzzle when passing through a grid with starting values. There is a method to check whether or not the starting values are valid. If not, the program will output "Invalid starting values." If the puzzle is solvable, then the program will output the solution. If no solution is found, then the statement "There is no solution" will be output.

SudokuGUI.java
Functions similarly to Sudoku.java. It differs in the fact that it utilizes Java GUI elements rather than requiring the user to manually input values into a two-dimensional array. The solve function calls the check() and solve() methods from Sudoku.Java when the "Solve" button is pressed. When the "Reset" button is pressed, the JFrame window is disposed of and a new one is called.
