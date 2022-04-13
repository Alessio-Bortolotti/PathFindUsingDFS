package PathFInd;

import java.util.ArrayList;
import java.util.List;

public class Graph {

	private List<Node> allNodes;
	
	public Graph() {
		this.allNodes = new ArrayList<>();
	}
	
	public List<Node> getAllNodes() {
		return allNodes;
	}
	
	public void setAllNodes(List<Node> allNodes) {
		this.allNodes = allNodes;
	}
}
