package PathFInd;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JComponent;

public class Maze extends JComponent {

	// 1: Wall
	// 0: gap
	// -1: starting point
	// 9: target
	private int[][] maze = { 
			{ 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1 },
			{ 1, -1, 1, 0, 1, 0, 1, 0, 0, 0, 0, 0, 1 },
			{ 1, 0, 1, 0, 0, 0, 1, 0, 1, 1, 1, 0, 1 }, 
			{ 1, 0, 0, 0, 1, 1, 1, 0, 0, 0, 0, 0, 1 },
			{ 1, 1, 1, 0, 0, 0, 0, 0, 1, 1, 1, 0, 1 }, 
			{ 1, 0, 1, 1, 1, 1, 1, 0, 1, 0, 0, 0, 1 },
			{ 1, 0, 1, 0, 1, 0, 0, 0, 1, 1, 1, 0, 1 }, 
			{ 1, 0, 1, 0, 1, 1, 1, 0, 1, 0, 1, 0, 1 },
			{ 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 9, 1 }, 
			{ 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1 } };
	
//	private int [][] maze = 
//		{   {1,0,0,0,0,0,0,0,1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1},
//			{1,0,-1,0,0,0,0,0,1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1},
//			{1,0,0,0,0,0,0,0,0,1,0,0,0,0,0,0,0,0,0,0,0,0,0,1},
//			{1,0,0,0,0,0,0,0,0,1,0,0,0,0,0,0,0,0,0,0,0,0,0,1},
//			{1,0,0,0,0,0,0,0,0,1,0,0,0,0,0,0,0,0,0,0,0,0,0,1},
//			{1,0,0,0,0,0,0,0,0,1,0,0,0,0,0,0,0,0,0,0,0,0,0,1},
//			{1,0,0,0,0,0,0,0,0,1,0,0,0,0,0,0,0,0,0,0,0,0,0,1},
//			{1,0,0,0,0,0,0,0,0,1,0,0,0,0,0,0,0,0,0,0,0,0,0,1},
//			{1,0,0,0,0,0,0,0,0,1,0,0,0,0,0,0,0,0,0,0,0,0,0,1},
//			{1,0,1,1,1,0,0,0,0,1,0,0,0,0,0,0,0,0,0,0,0,0,0,1},
//			{1,0,0,0,1,0,1,1,1,1,0,0,0,0,0,0,0,0,9,0,0,0,0,1},
//			{1,0,0,0,0,0,0,0,0,1,1,1,1,1,1,1,1,1,1,1,1,1,0,1},
//			{1,0,0,0,0,0,0,0,0,1,0,1,0,0,0,0,0,0,0,0,0,0,0,1},
//			{1,0,0,0,0,0,0,0,0,1,0,1,0,0,0,0,0,0,0,0,0,0,0,1},
//			{1,0,0,0,0,0,0,0,0,1,0,1,0,0,0,0,0,0,0,0,0,0,0,1},
//			{1,0,0,0,0,0,0,0,0,0,0,1,0,0,0,0,0,0,0,0,0,0,0,1},
//			{1,0,0,0,0,0,0,0,0,1,0,1,0,0,0,0,0,0,0,0,0,0,0,1},
//			{1,0,0,0,0,0,0,0,0,1,0,0,0,0,0,0,0,0,0,0,0,0,0,1},
//			{1,0,0,0,0,0,0,0,0,1,0,0,0,0,0,0,0,0,0,0,0,0,0,1},
//	        };

	private int[][] indexMatrix;
	private Node[][] nodesMatrix;
	private Graph g;

	private int colNo;
	private int rowNo;
	private int blockSize;

	// Methods
	public Maze() {
		this.colNo = maze[0].length;
		this.rowNo = maze.length;
		this.blockSize = 40;
		this.nodesMatrix = new Node[this.rowNo][this.colNo];
		this.g = new Graph();

		int idx = 1;
		for (int i = 0; i < this.rowNo; i++) {
			for (int j = 0; j < this.colNo; j++) {
				this.nodesMatrix[i][j] = new Node(idx);
				idx++;
			}
		}

		createGraph();
	}

	@Override
	public void paintComponent(Graphics g) {
		Graphics2D g2 = (Graphics2D) g.create();

		for (int i = 0; i < this.rowNo; i++) {
			for (int j = 0; j < this.colNo; j++) {
				Color color = null;
				switch (this.maze[i][j]) {
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
				g2.fillRect(j * this.blockSize, i * this.blockSize, this.blockSize, this.blockSize);

				g2.setColor(Color.GREEN);
				g2.drawString(this.nodesMatrix[i][j].getElement() + "", (j) * this.blockSize + this.blockSize / 2,
						(i) * this.blockSize + this.blockSize / 2);
			}
		}
	}

	private void createGraph() {
		List<Node> allNodes = new ArrayList<>();

		for (int i = 0; i < this.rowNo; i++) {
			for (int j = 0; j < this.colNo; j++) {
				if (this.maze[i][j] == 1) {
					this.nodesMatrix[i][j].setVisited(true);
				}

				findAddNeighbours(i, j);
				allNodes.add(nodesMatrix[i][j]);
			}
		}
		
		this.g.setAllNodes(allNodes);

	}

	private void findAddNeighbours(int row, int col) {
		int colNum = col;
		int rowNum = row;
		
		if(withinGrid(rowNum, colNum +1, this.rowNo, this.colNo)) {
			this.nodesMatrix[row][col].addNeighbours(this.nodesMatrix[row][col + 1]);
		}
		
		if(withinGrid(rowNum, colNum - 1, this.rowNo, this.colNo)) {
			this.nodesMatrix[row][col].addNeighbours(this.nodesMatrix[row][col - 1]);	
		}

		if(withinGrid(rowNum +1, colNum, this.rowNo, this.colNo)) {
			this.nodesMatrix[row][col].addNeighbours(this.nodesMatrix[row +1 ][col]);
		}

		if(withinGrid(rowNum -1, colNum, this.rowNo, this.colNo)) {
			this.nodesMatrix[row][col].addNeighbours(this.nodesMatrix[row -1][col]);
		}
	}
	
	private boolean withinGrid(int rowNum, int colNum,  int maxRow, int maxCol) {
		if( colNum < 0 || rowNum < 0 ) {
			return false;
		}
		
		if( colNum >= maxCol || rowNum >= maxRow ) {
			return false;
		}
		
		return true;
	}
	
	public Graph getGraph() {
		return g;
	}

	public int[][] getMaze() {
		return maze;
	}

	public int[][] getIndexMatrix() {
		return indexMatrix;
	}

	public Node[][] getNodesMatrix() {
		return nodesMatrix;
	}

	public int getColNo() {
		return colNo;
	}

	public int getRowNo() {
		return rowNo;
	}

	public int getBlockSize() {
		return blockSize;
	}
	
	public int getStartingPoint() {
		int idx = 0;
		for (int i = 0; i < this.rowNo; i++) {
			for (int j = 0; j < this.colNo; j++) {
				if(this.maze[i][j] == -1) {
					return idx;
				}
				idx++;
			}
		}
		return 1;
	}
	
	public int getTargetPoint() {
		int idx = 1;
		for (int i = 0; i < this.rowNo; i++) {
			for (int j = 0; j < this.colNo; j++) {
				if(this.maze[i][j] == 9) {
					return idx;
				}
				idx++;
			}
		}
		return 1;
	}
	
	
	
	
	
}
