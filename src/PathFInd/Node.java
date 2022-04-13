package PathFInd;

import java.util.ArrayList;
import java.util.List;

public class Node {

	private Object element;
	private boolean visited;
	private List<Node> neighbours;
	
	public Node(Object e) {
		this.neighbours = new ArrayList<>();
		this.element = e;
		this.visited = false;
	}
	
	public boolean isVisited() {
		return this.visited;
	}
	
	public void addNeighbours(Node n) {
		this.neighbours.add(n);
	}
	
	public Object getElement() {
		return this.element;
	}
	
	public void setElement(Object e) {
		this.element = e;
	}

	public List<Node> getNeighbours() {
		return neighbours;
	}

	public void setNeighbours(List<Node> neighbours) {
		this.neighbours = neighbours;
	}
	
	public void setVisited(boolean status) {
		this.visited = status;
	}
}
