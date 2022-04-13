package PathFInd;

import java.util.ArrayList;
import java.util.List;

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
		
		Graph g = maze.getGraph();
		
		DFS searchEngine = new DFS();
		
		List<Node> nodeVisited = new ArrayList<>();
		nodeVisited = searchEngine.dfs(g, maze.getStartingPoint(), maze.getTargetPoint());
		
		System.out.println("Search is done");
		
		//Draw the path obtained by DFS
		
		JFrame f2 = new JFrame("The lovely Maze 2");
		
		f2.setSize(600, 500);
		f2.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		FinalPath p1 = new FinalPath(maze, nodeVisited);
		f2.add(p1);
		f2.setVisible(true);
	}

}
