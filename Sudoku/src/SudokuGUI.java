import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.*;

import javax.swing.BorderFactory;
import javax.swing.border.Border;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import java.util.ArrayList;

public class SudokuGUI extends JFrame {

	private static final long serialVersionUID = 1L;

	// Two-dimensional array to store values
	int[][] board = new int[9][9];

	// ArrayList to store JTextField elements for iterating
	ArrayList<JTextField> fields = new ArrayList<JTextField>();

	// GUI components
	Container contents;
	public JButton solve, reset;
	public JPanel buttons, grid;
	public JTextField cell;
	Border blackline = BorderFactory.createLineBorder(Color.black);

	// Constructor
	public SudokuGUI() {
		// JFrame constructor with title bar
		super("Sudoku Solver");

		// Get container for components
		contents = getContentPane();

		// Set layout manager
		contents.setLayout(new BorderLayout());

		// Adds JTextFields into ArrayList for iterating
		for (int i = 1; i <= 81; i++) {
			
			// Initializes JTextField
			cell = new JTextField(1);
			cell.setHorizontalAlignment(JTextField.CENTER);
			cell.setBorder(blackline);
			cell.setFont(cell.getFont().deriveFont(Font.BOLD, 14f));
			// Adds JTextField into ArrayList
			fields.add(cell);
		}

		// Create JPanel grid to fill in contents
		grid = new JPanel(new GridLayout(9, 9));

		// Adds all JTextField elements into JPanel grid
		for (int i = 0; i < fields.size(); i++) {
			grid.add(fields.get(i));
		}

		// Create panel for buttons
		solve = new JButton("Solve");
		reset = new JButton("Reset");
		buttons = new JPanel(new GridLayout(2, 1, 0, 150));
		buttons.add(solve);
		buttons.add(reset);

		// Add both panels to content pane
		contents.add(grid, BorderLayout.CENTER);
		contents.add(buttons, BorderLayout.EAST);

		// Button handler
		ButtonHandler bh = new ButtonHandler();

		solve.addActionListener(bh);
		reset.addActionListener(bh);

		// Set original size of window
		setSize(new Dimension(450, 450));

		// Make window visible
		setVisible(true);

		// Action when window closes
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	} // End of constructor()

	// Event handler for button clicks
	private class ButtonHandler implements ActionListener {
		public void actionPerformed(ActionEvent ae) {
			if (ae.getSource() == solve) {
				solve();
			} else {
				reset();
			}
		} // End actionPerformed
	} // End ButtonHandler

	// Implements the solve button
	public void solve() {

		// Variables to represents the rows and columns in a sudoku grid
		int a = 0;
		int b = 0;

		// Variable to check if starting values are valid
		boolean check = true;

		/*
		 * Checks value of every JTextField element. Throws exception if there is an
		 * invalid value. Otherwise, solves the puzzle.
		 */
		for (int i = 0; i < fields.size(); i++) {
			String value = fields.get(i).getText();
			int fieldValue = 0;
			if (value.equals("")) {
				fieldValue = 0;
			} else if (value.length() != 1) {
				JFrame error = new JFrame();
				JOptionPane.showMessageDialog(error, "Values must be between 1 and 9");
				error.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				return;
			} else {
				try {
					fieldValue = Integer.parseInt(value);
				} catch (NumberFormatException e) {
					JFrame error = new JFrame();
					JOptionPane.showMessageDialog(error, "Values must be between 1 and 9");
					error.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
					return;
				}
			}
			if (i % 9 == 0 && i != 0) {
				a++;
			}
			if (b % 9 == 0) {
				b = 0;
			}
			board[a][b] = fieldValue;
			b++;
		}
		check = Sudoku.check(board);
		if (check == false) {
			JFrame error = new JFrame();
			JOptionPane.showMessageDialog(error, "Starting values are invalid");
			error.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			return;
		} else {
			Sudoku.solve(board);
			a = 0;
			b = 0;
			for (int i = 0; i < fields.size(); i++) {
				if (i % 9 == 0 && i != 0) {
					a++;
				}
				if (b % 9 == 0) {
					b = 0;
				}
				String stringValue = Integer.toString(board[a][b]);
				fields.get(i).setText(stringValue);
				b++;
			}
		}
	}

	public void reset() {
		dispose();
		revalidate();
		SudokuGUI puzzle = new SudokuGUI();
	}

	public static void main(String[] args) {
		SudokuGUI puzzle = new SudokuGUI();
	}

}
