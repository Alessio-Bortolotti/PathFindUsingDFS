package PathFInd;

import javax.swing.JFrame;

public class SolveMaze {

	public static void main(String[] args) {
		//Draw the Maze
		
		JFrame f = new JFrame("The lovely Maze");
		
		f.setSize(600, 500);
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Maze maze = new Maze();
		
		f.add(maze);
		f.setVisible(true);
	}

}
