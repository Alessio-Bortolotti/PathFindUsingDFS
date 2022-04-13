package PathFInd;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.util.List;

import javax.swing.JComponent;

public class FinalPath extends JComponent{
	private List<Node> nodeVisited;
	private Maze maze;
	
	public FinalPath(Maze maze, List<Node> nodeVisited) {
		this.nodeVisited = nodeVisited;
		this.maze = maze;
	}
	
	@Override
	public void paintComponent(Graphics g) {
		Graphics2D g2 = (Graphics2D) g.create();
		//visualize maze
		for (int i = 0; i < this.maze.getRowNo(); i++) {
			for (int j = 0; j < this.maze.getColNo(); j++) {
				Color color = null;
				switch (this.maze.getMaze()[i][j]) {
				case 1:
					color = Color.GRAY;
					break;
				case -1:
					color = Color.RED;
					break;
				case 9:
					color = Color.BLUE;
					break;
				default:
					color = Color.WHITE;
					break;
				}

				g2.setColor(color);
				g2.fillRect(j * this.maze.getBlockSize(), i * this.maze.getBlockSize(), this.maze.getBlockSize(), this.maze.getBlockSize());

			}
		}
		
		//visualize path
		
		int idx, i,j;
		int nodeOrder = 0;
		
		for(Node n: nodeVisited) {
			idx =(int) n.getElement();
			
			i = idx / this.maze.getColNo();
			j = idx % this.maze.getColNo()-1;
			
			g2.setColor(Color.ORANGE);
			g2.fillRect(j*this.maze.getBlockSize() , i*this.maze.getBlockSize(), this.maze.getBlockSize(), this.maze.getBlockSize());
		
			g2.setColor(Color.BLACK);
			g2.drawString(nodeOrder + "", j*this.maze.getBlockSize() + this.maze.getBlockSize()/2,
					i*this.maze.getBlockSize() + this.maze.getBlockSize()/2);
			nodeOrder++;
		}
		
		Node n = nodeVisited.get(0);
		idx =(int) n.getElement();
		i = idx / this.maze.getColNo();
		j = idx % this.maze.getColNo()-1;
		g2.setColor(Color.RED);
		g2.fillRect(j*this.maze.getBlockSize() , i*this.maze.getBlockSize(), this.maze.getBlockSize(), this.maze.getBlockSize());
	
		
		
	}
}
