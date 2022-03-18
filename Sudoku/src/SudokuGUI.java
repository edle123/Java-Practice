import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.*;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import java.util.ArrayList;

public class SudokuGUI extends JFrame {

	// Two-dimensional array to store values
	int[][] board = new int[9][9];

	// ArrayList to store JTextField elements for iterating
	ArrayList<JTextField> fields = new ArrayList<JTextField>();

	// GUI components
	Container contents;
	public JButton solve, reset;
	public JPanel buttons, grid;
	public JTextField c1, c2, c3, c4, c5, c6, c7, c8, c9, c10, c11, c12, c13, c14, c15, c16, c17, c18, c19, c20, c21,
			c22, c23, c24, c25, c26, c27, c28, c29, c30, c31, c32, c33, c34, c35, c36, c37, c38, c39, c40, c41, c42,
			c43, c44, c45, c46, c47, c48, c49, c50, c51, c52, c53, c54, c55, c56, c57, c58, c59, c60, c61, c62, c63,
			c64, c65, c66, c67, c68, c69, c70, c71, c72, c73, c74, c75, c76, c77, c78, c79, c80, c81;

	// Constructor
	public SudokuGUI() {
		// JFrame constructor with title bar
		super("Sudoku Solver");

		// Get container for components
		contents = getContentPane();

		// Set layout manager
		contents.setLayout(new BorderLayout());

		// Initialize JTextField elements
		// Row 1
		c1 = new JTextField(1);
		c2 = new JTextField(1);
		c3 = new JTextField(1);
		c4 = new JTextField(1);
		c5 = new JTextField(1);
		c6 = new JTextField(1);
		c7 = new JTextField(1);
		c8 = new JTextField(1);
		c9 = new JTextField(1);
		// Row 2
		c10 = new JTextField(1);
		c11 = new JTextField(1);
		c12 = new JTextField(1);
		c13 = new JTextField(1);
		c14 = new JTextField(1);
		c15 = new JTextField(1);
		c16 = new JTextField(1);
		c17 = new JTextField(1);
		c18 = new JTextField(1);
		// Row 3
		c19 = new JTextField(1);
		c20 = new JTextField(1);
		c21 = new JTextField(1);
		c22 = new JTextField(1);
		c23 = new JTextField(1);
		c24 = new JTextField(1);
		c25 = new JTextField(1);
		c26 = new JTextField(1);
		c27 = new JTextField(1);
		// Row 4
		c28 = new JTextField(1);
		c29 = new JTextField(1);
		c30 = new JTextField(1);
		c31 = new JTextField(1);
		c32 = new JTextField(1);
		c33 = new JTextField(1);
		c34 = new JTextField(1);
		c35 = new JTextField(1);
		c36 = new JTextField(1);
		// Row 5
		c37 = new JTextField(1);
		c38 = new JTextField(1);
		c39 = new JTextField(1);
		c40 = new JTextField(1);
		c41 = new JTextField(1);
		c42 = new JTextField(1);
		c43 = new JTextField(1);
		c44 = new JTextField(1);
		c45 = new JTextField(1);
		// Row 6
		c46 = new JTextField(1);
		c47 = new JTextField(1);
		c48 = new JTextField(1);
		c49 = new JTextField(1);
		c50 = new JTextField(1);
		c51 = new JTextField(1);
		c52 = new JTextField(1);
		c53 = new JTextField(1);
		c54 = new JTextField(1);
		// Row 7
		c55 = new JTextField(1);
		c56 = new JTextField(1);
		c57 = new JTextField(1);
		c58 = new JTextField(1);
		c59 = new JTextField(1);
		c60 = new JTextField(1);
		c61 = new JTextField(1);
		c62 = new JTextField(1);
		c63 = new JTextField(1);
		// Row 8
		c64 = new JTextField(1);
		c65 = new JTextField(1);
		c66 = new JTextField(1);
		c67 = new JTextField(1);
		c68 = new JTextField(1);
		c69 = new JTextField(1);
		c70 = new JTextField(1);
		c71 = new JTextField(1);
		c72 = new JTextField(1);
		// Row 9
		c73 = new JTextField(1);
		c74 = new JTextField(1);
		c75 = new JTextField(1);
		c76 = new JTextField(1);
		c77 = new JTextField(1);
		c78 = new JTextField(1);
		c79 = new JTextField(1);
		c80 = new JTextField(1);
		c81 = new JTextField(1);

		// Adds all JTextFields into ArrayList for iterating
		// Row 1
		fields.add(c1);
		fields.add(c2);
		fields.add(c3);
		fields.add(c4);
		fields.add(c5);
		fields.add(c6);
		fields.add(c7);
		fields.add(c8);
		fields.add(c9);
		// Row 2
		fields.add(c10);
		fields.add(c11);
		fields.add(c12);
		fields.add(c13);
		fields.add(c14);
		fields.add(c15);
		fields.add(c16);
		fields.add(c17);
		fields.add(c18);
		// Row 3
		fields.add(c19);
		fields.add(c20);
		fields.add(c21);
		fields.add(c22);
		fields.add(c23);
		fields.add(c24);
		fields.add(c25);
		fields.add(c26);
		fields.add(c27);
		// Row 4
		fields.add(c28);
		fields.add(c29);
		fields.add(c30);
		fields.add(c31);
		fields.add(c32);
		fields.add(c33);
		fields.add(c34);
		fields.add(c35);
		fields.add(c36);
		// Row 5
		fields.add(c37);
		fields.add(c38);
		fields.add(c39);
		fields.add(c40);
		fields.add(c41);
		fields.add(c42);
		fields.add(c43);
		fields.add(c44);
		fields.add(c45);
		// Row 6
		fields.add(c46);
		fields.add(c47);
		fields.add(c48);
		fields.add(c49);
		fields.add(c50);
		fields.add(c51);
		fields.add(c52);
		fields.add(c53);
		fields.add(c54);
		// Row 7
		fields.add(c55);
		fields.add(c56);
		fields.add(c57);
		fields.add(c58);
		fields.add(c59);
		fields.add(c60);
		fields.add(c61);
		fields.add(c62);
		fields.add(c63);
		// Row 8
		fields.add(c64);
		fields.add(c65);
		fields.add(c66);
		fields.add(c67);
		fields.add(c68);
		fields.add(c69);
		fields.add(c70);
		fields.add(c71);
		fields.add(c72);
		// Row 9
		fields.add(c73);
		fields.add(c74);
		fields.add(c75);
		fields.add(c76);
		fields.add(c77);
		fields.add(c78);
		fields.add(c79);
		fields.add(c80);
		fields.add(c81);

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
